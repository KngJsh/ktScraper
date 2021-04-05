package examples

import org.jsoup.Jsoup
import org.jsoup.safety.Cleaner
import org.jsoup.safety.Whitelist

object SanitizeScraper {

    @JvmStatic
    fun main(args: Array<String>) {
        val htmlString = "<html><head><title>My title</title></head><body><center>Body content</center></body></html>";

        val valid = Jsoup.isValid(htmlString, Whitelist.basic())

        if (valid) {
            print("document is valid, do nothing")
        } else {
            print("document is not valid, do cleaning")

            var invalidDoc = Jsoup.parse(htmlString)
            val validDoc = Cleaner(Whitelist.basic()).clean(invalidDoc)

            print(validDoc.html())
        }
    }
}