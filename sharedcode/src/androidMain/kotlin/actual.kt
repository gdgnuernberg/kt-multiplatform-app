package io.github.gdgnbgandroid.mpp.mobile

import java.security.MessageDigest

actual fun String.toHash(): String {
    val md = MessageDigest.getInstance("SHA-256")
    val digest = md.digest(this.toByteArray())
    return digest.fold("", { str, it -> str + "%02x".format(it) })
}