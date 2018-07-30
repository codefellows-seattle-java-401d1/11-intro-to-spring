package server;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String homePage () {
        return "index";
    }
    @RequestMapping("/search")
    public String searchTemplate(
            @RequestParam(name="q", defaultValue="Black Dice") String query,
            Model model
    ) {
        String src = AlbumSoup.fetchAlbum(query);
        model.addAttribute("query", query);
        model.addAttribute("src", src);
        return "album";
    }

    @RequestMapping("*")
    public String getFallback() {
        return "404";
    }
}