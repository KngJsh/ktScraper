package examples

import org.jsoup.Jsoup

object WebpageScaper {
    @JvmStatic
    fun main(args: Array<String>) {
        val url = "https://www.jsoup.org";

        var doc = Jsoup.connect(url).get()
        println(doc.title())
//        println(doc.html())

        val descr = doc.select("meta[name=description]").first().attr("content")
        print(descr)
        val keywords = doc.select("meta[name=keywords]").first().attr("content")
        print(keywords)

        // select all links
        var links = doc.select("a[href]")
        for (link in links) {
            println("text ${link.text()}")
            println("link ${link.attr("href")}")
        }

    }

}