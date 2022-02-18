package ecse428.hermes.dao;
import ecse428.hermes.model.Summary;
import ecse428.hermes.model.Website;
import org.springframework.data.repository.CrudRepository;
import ecse428.hermes.model.Article;

public interface WebsiteRepository extends CrudRepository<Website, String> {

    Website findWebsiteByWebsiteName(String name);
    Website findWebsiteByWebsiteURL(String url);

}
