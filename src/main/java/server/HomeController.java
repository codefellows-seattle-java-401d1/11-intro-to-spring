package server;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String homePage () {
        return "index";
    }
//https://www.discogs.com/search/?q=thrice+vheissu&type=all

//    @RequestMapping("search/?/q=/{query}")
//    @ResponseBody
//    public String querySearch (
//      @PathVariable("query") String query
//    ) {
//        return query;
//    }

    @RequestMapping("/search")
    public String search(
            @RequestParam("query") String query,
            Model model
    ) {
        model.addAttribute("artQuery", query);
        return "cover";
    }

    //pulled from Steve's slides
    @RequestMapping("*")
    public String getFallback() {
        return "my404";
    }


}
