package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.model.Website;
import springboot.persistence.WebsiteRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class WebsitesService {
    @Autowired
    private WebsiteRepository websiteRepository;

    private static List<Website> items = new ArrayList<>();

    //Создание данных для базы
//    static {
//        items.add(new Website("stackoverflow", "http://stackoverflow.com",
//                "http://cdn.sstatic.net/Sites/stackoverflow/img/favicon.ico",
//                "Stack Overflow (StackExchange)", "for professional"));
//        items.add(new Website("serverfault", "http://serverfault.com",
//                "http://cdn.sstatic.net/Sites/serverfault/img/favicon.ico",
//                "Server Fault (StackExchange)", "for system admin"));
//        items.add(new Website("superuser", "http://superuser.com",
//                "http://cdn.sstatic.net/Sites/superuser/img/favicon.ico",
//                "Super User (StackExchange)", "for power user"));
//    }

    //Загрузка данных из коллекции в базу. Выполняется один раз при запуске программы. !!!Обязательно выполнить прежче чем проверять пустую базу
//    @PostConstruct
//    public void init() {
//        websiteRepository.save(items);
//    }

    public List<Website> findAll() {
        return websiteRepository.findAll();
    }
}
