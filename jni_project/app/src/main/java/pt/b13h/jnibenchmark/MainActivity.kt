package pt.b13h.jnibenchmark

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import java.time.Instant

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sample_text.text = "Click on the button to measure the time to call"

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->

            val t0 : Long = System.currentTimeMillis()

            repeat( 1024) {
                val unusedButUsedToAvoidOptimizations = intFromJNI()
            }

            val t1 : Long = System.currentTimeMillis();

            sample_text.text = "Call took " + (t1 - t0) + " milliseconds"
        }
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    external fun intFromJNI(): Int

    companion object {
        // Used to load the 'native-lib' library on application startup.
        init {
            System.loadLibrary("native-lib")
        }
    }
}
