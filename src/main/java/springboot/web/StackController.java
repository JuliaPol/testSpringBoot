package springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import springboot.model.Website;
import springboot.service.WebsitesService;

import java.util.List;

@RestController
//@Controller
@RequestMapping("/api/websites")
public class StackController {
    @Autowired
    private WebsitesService websitesService;

    //@ResponseBody
    @RequestMapping
    public List<Website> getListOfProviders() {
        websitesService = new WebsitesService();
        return websitesService.findAll();
    }
}
