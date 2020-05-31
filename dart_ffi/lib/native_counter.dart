import 'dart:ffi'; // For FFI
import 'dart:io'; // For Platform.isX

final DynamicLibrary nativeCounterLib = Platform.isAndroid
    ? DynamicLibrary.open("libnative_counter.so")
    : DynamicLibrary.process();

final DynamicLibrary nativeCounterOtherLib = Platform.isAndroid
    ? DynamicLibrary.open("libother_native_counter.so")
    : DynamicLibrary.process();


final int Function() nativeCounter = nativeCounterLib
    .lookup<NativeFunction<Int32 Function()>>("native_counter")
    .asFunction();

final int Function() nativeCounterAlternative = nativeCounterLib
    .lookup<NativeFunction<Int32 Function()>>("native_counter_alternative")
    .asFunction();

final int Function() nativeCounterYetAnother = nativeCounterLib
    .lookup<NativeFunction<Int32 Function()>>("native_counter_yet_another")
    .asFunction();

final int Function() nativeCounterFromOtherLib = nativeCounterOtherLib
    .lookup<NativeFunction<Int32 Function()>>("native_counter")
    .asFunction();
