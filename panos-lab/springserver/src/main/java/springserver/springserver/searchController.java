package springserver.springserver;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
public class searchController {
    @RequestMapping("search")
    public String searchPage(HttpServletRequest request, Model model, @RequestParam String name) {
        try {
            name.replace(" ", "+");
            name.replace("%20", "+");
            Document file = Jsoup.connect("https://discogs.com/search/?q=" + name + "&type=all").get();
            System.out.println((file).title());
            Elements images = file.select("div a span img");
            String imgUrl = images.first().attributes().get("data-src");
            System.out.println(imgUrl);
            model.addAttribute("albumArt", imgUrl);
            return "results";
        } catch (IOException e) {
            System.out.println("Bad query");
            return "";
        }

    }
}
