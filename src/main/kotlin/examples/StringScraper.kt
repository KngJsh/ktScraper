package examples

import org.jsoup.Jsoup
import java.io.File
import java.nio.charset.StandardCharsets

object StringScraper {

    @JvmStatic
    fun main(args: Array<String>) {
        val htmlString = ("<html><head><title>My title</title></head>"
                + "<body>Body content</body></html>")
        val doc = Jsoup.parse(htmlString)
        val title = doc.title()
        val body = doc.body().text()

        println("Title: $title")
        println("Body: $body")

        println(doc.allElements);
    }
}