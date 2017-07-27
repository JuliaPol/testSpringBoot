package springboot.service;

import org.springframework.stereotype.Service;
import springboot.model.Website;

import java.util.ArrayList;
import java.util.List;

@Service
public class WebsitesService {
    private static List<Website> items;

    public WebsitesService() {
        items = new ArrayList<>();
        items.add(new Website("stackoverflow", "http://stackoverflow.com",
                "http://cdn.sstatic.net/Sites/stackoverflow/img/favicon.ico",
                "Stack Overflow (StackExchange)", "for professional"));
        items.add(new Website("serverfault", "http://serverfault.com",
                "http://cdn.sstatic.net/Sites/serverfault/img/favicon.ico",
                "Server Fault (StackExchange)", "for system admin"));
        items.add(new Website("superuser", "http://superuser.com",
                "http://cdn.sstatic.net/Sites/superuser/img/favicon.ico",
                "Super User (StackExchange)", "for power user"));
    }

    public List<Website> findAll() {
        return items;
    }
}
