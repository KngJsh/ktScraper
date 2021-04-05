package examples

import org.jsoup.Jsoup

object DuckDuckGoSearchScraper {

    @JvmStatic
    fun main(args: Array<String>) {
        val query = "Devoxx Krakow"
        val url = "https://www.duckduckgo.com/html/?q=" + query

        val doc = Jsoup.connect(url).userAgent("Jsoup client").timeout(5000).get();

        val results = doc.select(".result__body")
        for (result in results) {
            println("TITLE: ${result.select(".result__title").text()}")
            println("URL: ${result.select(".result__url").text()}")
            println("SNIPPET: ${result.select(".result__snippet").text()}")
            println("------------------------")
        }

    }
}