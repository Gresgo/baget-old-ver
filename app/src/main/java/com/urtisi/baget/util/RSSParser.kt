package com.urtisi.baget.util

import android.os.AsyncTask
import android.util.Xml
import com.urtisi.baget.feed.FeedViewModel
import org.xmlpull.v1.XmlPullParser
import java.io.InputStream
import java.net.URL

class RSSParser(private val caller: FeedViewModel) : AsyncTask<Void, Void, ArrayList<RSSModel>>() {

    private val URllink = "http://uisi.ru/uisi/general/news.php?rss=y"

    override fun doInBackground(vararg params: Void?): ArrayList<RSSModel> {
        var feed = ArrayList<RSSModel>()
        try{
            val url = URL(URllink)
            val inputStream = url.openConnection().getInputStream()
            feed = parseRSS(inputStream)
        } catch (e: Error){

        }

        return feed
    }

    private fun parseRSS(inp: InputStream) : ArrayList<RSSModel> {

        var isItem = false
        var title: String ?= null
        var link: String ?= null
        var description: String ?= null
        var pubDate: String ?= null
        val rss = ArrayList<RSSModel>()

        try{
            val parser = Xml.newPullParser()
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false)
            parser.setInput(inp, null)

            parser.nextTag()

            while (parser.next() != XmlPullParser.END_DOCUMENT){

                val eventType = parser.eventType
                val name = parser.name
                name ?: continue

                if (eventType == XmlPullParser.END_TAG){
                    if (name.equals("item", true)){
                        isItem = false
                    }
                    continue
                }

                if (eventType == XmlPullParser.START_TAG){
                    if (name.equals("item", true)){
                        isItem = true
                        continue
                    }
                }

                var result = ""
                if (parser.next() == XmlPullParser.TEXT){
                    result = parser.text
                    parser.nextTag()
                }

                if (name.equals("title", true)){
                    title = result
                } else if (name.equals("link", true)){
                    link = result
                } else if (name.equals("description", true)){
                    description = result
                } else if (name.equals("pubDate", true)){
                    pubDate = result
                }

                if (title != null && link != null && description != null && pubDate != null){
                    if (isItem){
                        rss.add(RSSModel(title, description, pubDate, link))
                    }

                    title = null
                    link = null
                    description = null
                    pubDate = null
                    isItem = false
                }

            }

        } catch (e: Error){

        } finally {
            inp.close()
        }

        return rss
    }

    override fun onPostExecute(result: ArrayList<RSSModel>?) {
            caller.onDataReady(result!!)
    }
}