/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_guiness_bot_external_NativeAPI */

#ifndef _Included_com_guiness_bot_external_NativeAPI
#define _Included_com_guiness_bot_external_NativeAPI
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_guiness_bot_external_NativeAPI
 * Method:    availableProcesses
 * Signature: (Ljava/lang/String;)[Ljava/lang/Integer;
 */
JNIEXPORT jintArray JNICALL Java_com_guiness_bot_external_NativeAPI_availableProcesses
        (JNIEnv *, jobject, jstring);

/*
 * Class:     com_guiness_bot_external_NativeAPI
 * Method:    inject
 * Signature: (ILjava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_com_guiness_bot_external_NativeAPI_inject
        (JNIEnv *, jobject, jint, jstring);

/*
 * Class:     com_guiness_bot_external_NativeAPI
 * Method:    login
 * Signature: (ILjava/lang/String;Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_com_guiness_bot_external_NativeAPI_login
        (JNIEnv *, jobject, jint, jstring, jstring);

/*
 * Class:     com_guiness_bot_external_NativeAPI
 * Method:    reLogin
 * Signature: (ILjava/lang/String;Ljava/lang/String;)V
 */
JNIEXPORT void JNICALL Java_com_guiness_bot_external_NativeAPI_reLogin
        (JNIEnv *, jobject, jint, jstring, jstring);

#ifdef __cplusplus
}
#endif
#endif
