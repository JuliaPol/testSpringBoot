package springboot.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import springboot.model.Website;

import java.util.List;

@Repository
public interface WebsiteRepository extends MongoRepository<Website, String> {
    List<Website> findByWebsite (String website);
}
