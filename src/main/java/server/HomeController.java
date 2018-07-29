package server;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String searchForm () {
        return "index";
    }

    @RequestMapping("/search")
    public String searchResults(
        @RequestParam(name="query", defaultValue = "Tom Petty") String query,
        Model model
    ) {
        String src = AlbumScraper.getAlbumArtUrl(query);
        model.addAttribute("query", query);
        model.addAttribute("src", src);
        return "result";
    }

    @RequestMapping("*")
    public String notFound() {
        return "404";
    }

}