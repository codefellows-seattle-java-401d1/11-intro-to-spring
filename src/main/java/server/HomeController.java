package server;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String homePageIndex(){
        return "index.html";
    }

    //from lecture and lecture repo slides
    //https://github.com/codefellows/seattle-java-401d1/blob/master/class-11-intro-to-spring/intro-to-spring.pdf
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchTemplate(
            @RequestParam(name="q", defaultValue = "Beastie Boys") String query,
            Model model
    ){
        String src = AlbumScraper.getAlbumArt(query);
        model.addAttribute("query", query);
        model.addAttribute("src", src);

        return "cover.html";
    }

    @RequestMapping("*")
    public String getFallback(){
        return "not-found.html";
    }
}
