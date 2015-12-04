package com.markwryan.advent.util

import java.io.FileInputStream
import java.io.InputStreamReader

/**
 * Created by mark on 12/3/15.
 */
public class InputUtils {
    public fun getText(input: String): InputStreamReader {
        val stream = FileInputStream(input).buffered()
        return InputStreamReader(stream, "UTF-8")
    }
}
