package springboot.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import springboot.model.Website;

import java.util.List;

@Repository
public class WebsiteRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Website> findAll() {
        return mongoTemplate.findAll(Website.class);
    }
}
