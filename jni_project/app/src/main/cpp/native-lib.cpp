#include <jni.h>

#include <stdint.h>

int32_t counter = 0;


extern "C" JNIEXPORT jint JNICALL
Java_pt_b13h_jnibenchmark_MainActivity_intFromJNI(
        JNIEnv* env,
        jobject /* this */) {

    counter += 3;
    return counter;
}
