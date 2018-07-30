package server;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String homePageIndex(){
        return "index";
    }

    //from lecture and lecture repo slides
    //https://github.com/codefellows/seattle-java-401d1/blob/master/class-11-intro-to-spring/intro-to-spring.pdf
    @RequestMapping("/search")
    public String searchTemplate(
            @RequestParam(name="query", defaultValue = "Beastie Boys") String query,
            Model model
    ){
        String src = AlbumScraper.getAlbumArt(query);
        model.addAttribute("query", query);
        model.addAttribute("src", src);
        if (src == "/Users/sooz/codefellows/401Java/Labs/11-intro-to-spring/src/main/resources/public/images/not-found.png") {
            return "not-found";
        }
        return "cover";
    }

    @RequestMapping("*")
    public String getFallback(){
        return "not-found";
    }
}
