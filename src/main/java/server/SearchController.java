package server;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class SearchController {
    @RequestMapping(value="/ui")
    public String searchTemplate(
            @RequestParam(name="query", defaultValue="The Beatles") String query,
            Model model
    ) {
        String src = AlbumScraper.getAlbumArtUrl(query);
        model.addAttribute("query", query);
        model.addAttribute("src", src);
        return "result";
    }
}