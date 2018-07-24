package server;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


public class AlbumScraper {
    public static void main(String[] args) {
        getAlbumArtURL("spice girls");
    }

    public static String getAlbumArtURL(String query) {
        String defaultPicture = "https://www.google.com/url?sa=i&source=images&cd=&cad=rja&uact=8&ved=2ahUKEwjjjq3MrrjcAhWlPH0KHRU-C7MQjRx6BAgBEAU&url=http%3A%2F%2Fwww.vhnsnc.edu.in%2Fspdf.php%3Ffid%3DSCIT8&psig=AOvVaw3OM8YPt0DzHlRGBuouFaB_&ust=1532543235935447";
        try {
            String url = " https://www.discogs.com/search/?q=" + query + "&type=all";
            Document doc = Jsoup.connect(url).get();

            Elements albumCovers = doc.select(".thumbnail_center");
            Element span = albumCovers.get(0);
            Element img = span.child(0);
            String src = img.attr("data-src");
            System.out.println(src);
            return src;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            return defaultPicture;
        }
        return defaultPicture;

        /*
        Yes, I am using hotlinking here. I cannot find a source that tells me how to convert and image into an HTTP file so the source will read correctly. I chose a picture from an educational institution to hopefully avoid nasty images popping up.  I would love some more instruction in this area. Just adding the full path to an actual image did not work here.

        EDIT: Hotlinking didn't work either.
         */
    }
}
