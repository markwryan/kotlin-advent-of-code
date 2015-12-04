package com.markwryan.advent.day4

import com.markwryan.advent.util.InputUtils
import org.apache.commons.codec.binary.Hex
import sun.security.util.ManifestDigester
import java.security.MessageDigest

/**
 * Created by mark on 12/4/15.
 */
fun main(args: Array<String>) {
    val input = "ckczppom"
    println(mine(input, 5))
    println(mine(input, 6))
}

fun mine(key: String, zeros: Int): Int{
    val md = MessageDigest.getInstance("MD5")
    var pair = 1
    while(true) {
        val test = key + pair
        md.update(test.toByteArray())
        val digest = md.digest()
        //Using Apache here, Kotlin Byte and bitwise operations are iffy in this release
        val hex = Hex.encodeHex(digest)

        var match = true
        for(i in 0..(zeros-1)) {
            if(hex.get(i) != '0') match = false
        }

        if(match) return pair

        pair++
    }
}
