package examples

import org.jsoup.Jsoup
import java.io.File
import java.nio.charset.StandardCharsets

object LocalFileScraper {

    @JvmStatic
    fun main(args: Array<String>) {
        var fileUrl = ClassLoader.getSystemResource("localFile.html").file
        val doc = Jsoup.parse(File(fileUrl), StandardCharsets.UTF_8.name())

        val mydiv = doc.getElementById("mydiv")
        println(mydiv.text())
        println(mydiv.tag())
        println(mydiv.tagName())
        println(mydiv.attributes())
        println(mydiv.siblingNodes())
    }
}