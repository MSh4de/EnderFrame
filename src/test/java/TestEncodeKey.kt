fun main() {

    val encodedKey = encodeKey("makey12")
    println(encodedKey)

    val decodedKey = decodeKey(encodedKey)
    println(decodedKey)

}


fun encodeKey(key: String): Long {
    val bytes = key.toByteArray()
    if (bytes.size > 7) {
        throw IllegalArgumentException("Key is too long")
    }
    var result = bytes.size.toLong() shl 56
    for (i in bytes.indices) {
        result = result or (bytes[i].toLong() shl i * 8)
    }


    return result
}

fun decodeKey(key: Long): String {
    val size = (key shr 56).toInt()
    val bytes = ByteArray(size)

    println(size)


    for(i in 0 until size) {
        bytes[i] = (key shr i * 8).toByte()
    }

    return String(bytes)
}