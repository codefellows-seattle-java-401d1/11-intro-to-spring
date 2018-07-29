package server;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class AlbumScraper {

    public static void main(String[] args) {
        getAlbum("bassnectar");
    }

    public static String getAlbum (String queryParams) {

        try {
            String url = "https://www.discogs.com/search/?q=" + queryParams + "&type=all";
            Document doc = Jsoup.connect(url).get();
            Elements albumArt = doc.select(".thumbnail_center");
            Element span = albumArt.get(0);
            Element image = span.child(0);
            String src = image.attr("data-src");
            System.out.println("Query result: " + src);
            return src;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "default";
    }
}
