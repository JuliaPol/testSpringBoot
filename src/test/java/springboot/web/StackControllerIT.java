package springboot.web;

import com.google.common.collect.ImmutableList;
import com.mongodb.Mongo;
import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodProcess;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;
import springboot.Application;
import springboot.model.Website;

import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StackControllerIT {
    TestRestTemplate restTemplate = new TestRestTemplate();

    @Autowired
    private MongoTemplate mongoTemplate;

    @Before
    public void before() {

        mongoTemplate.dropCollection(Website.class);
        mongoTemplate.save(new Website("web1", "dddd", "ddddd", "cccc", "sss"));
        mongoTemplate.save(new Website("web2", "dddd", "ddddd", "cccc", "sss"));
    }

    @Test
    public void getListOfProviders() throws Exception {
        ResponseEntity<List<Website>> responseEntity = restTemplate.exchange("http://localhost:8090/api/websites",
                HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Website>>() {
                });
        List<Website> actualList = responseEntity.getBody();
        //validate
        assertThat(actualList.size(), is(2));
        List<String> actualIDs = actualList.stream()
                .map(website -> website.getId())
                //return immutable list
                .collect(collectingAndThen(toList(), ImmutableList::copyOf));
        assertThat(actualIDs, containsInAnyOrder("web1", "web2"));
    }

}