package examples

import org.jsoup.Jsoup

object ImageScraper {

    @JvmStatic
    fun main(args: Array<String>) {

        println("------------------------------------------------------")
        val nflUrl = "https://www.nfl.com/teams/"
        val doc = Jsoup.connect(nflUrl).get()

//        val images = doc.select("img")
        val images = doc.select("img[data-src~=(?i)\\.(png|jpe?g|gif|svg)]")
//        doc.select("img[alt*=Panther]") // alt containing %Panther%
        println("found ${images.size} images on $nflUrl:")
        println("------------------------------------------------------")
        for (img in images) {
            println("data-src: ${img.attr("data-src")}")
            println("src: ${img.attr("src")}")
            println("alt: ${img.attr("alt")}")
//            println("width : ${img.attr("width")}")
//            println("height : ${img.attr("height")}")
            println("------------------------------------------------------")
            println("------------------------------------------------------")
        }


        println("Vogelsang example")
        println("------------------------------------------------------")

        val vogelsangUrl = "https://gwg.ch/vogelsang/"
        val docVogelsang = Jsoup.connect(vogelsangUrl).get()
        val imageDivs = docVogelsang.select("div.image-container[style]")
        println("found ${imageDivs.size} images on $vogelsangUrl:")
        println("------------------------------------------------------")
        for (imageDiv in imageDivs) {
            println(imageDiv.attr("style").removePrefix("background-image: url('").removeSuffix("')"))
        }


    }
}