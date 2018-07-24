package server;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String homePage () {
        return "index";
    }

//    @RequestMapping("search/?/q=/{query}&type=all")
//    public String querySearch (
//      @PathVariable("query") String query
//    ) {
//        return "cover";
//    }


    /*
    ======================================================
    WHERE I NEED TO SEARCH:
    https://www.discogs.com/search/?q=andrew+lloyd+webber&type=all

    IMG SRC NEEDED:
    https://img.discogs.com/40VgAD5aipkblycrQSI0-w07IE4=/300x300/smart/filters:strip_icc():format(jpeg):mode_rgb():quality(40)/discogs-images/A-84839-1473273545-9408.jpeg.jpg

    ======================================================

    WHAT I'M GETTING BACK:  *search*
    http://localhost:8080/search?q=andrew+lloyd+webber

    WHAT I'M GETTING BACK: *querySearch*
    http://localhost:8080/search?%2Fq=andrew+lloyed+webber
    ======================================================
    */

    //From Steve's slides
    @RequestMapping("/search")
    public String searchTemplate(
            @RequestParam(name="q", defaultValue="Queen") String query,
            Model model
    ) {
        String src = AlbumScraper.getAlbumArtURL(query);
        model.addAttribute("query", query);
        model.addAttribute("src", src);
        return "cover";
    }

//    @RequestMapping("/search")
//    public String search(
//            @RequestParam("q") String query,
////            @RequestParam("src") String src,
//            Model model
//    ) {
//        model.addAttribute("query", query);
////        model.addAttribute("src", src);
//        return "cover";
//    }

    //pulled from Steve's slides
    @RequestMapping("*")
    public String getFallback() {
        return "my404";
    }


}
