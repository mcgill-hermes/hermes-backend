package ecse428.hermes.controller;

import ecse428.hermes.dto.ArticleDto;
import ecse428.hermes.dto.CategoryDto;
import ecse428.hermes.dto.SummaryDto;
import ecse428.hermes.dto.WebsiteDto;
import ecse428.hermes.model.Article;
import ecse428.hermes.model.Category;
import ecse428.hermes.model.Summary;
import ecse428.hermes.model.Website;
import ecse428.hermes.service.ArticleService;
import ecse428.hermes.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     * Create a new website
     *
     * @return a WebsiteDto with specified information.
     * @throws Exception
     * @author Jiatong Niu
     */
    @PostMapping(value = {"/website/create", "/website/create/"})
    public WebsiteDto createWebsite(@RequestParam String websiteName, @RequestParam String  websiteURL) throws Exception {
        try {
            Website newWebsite = articleService.createWebsite(websiteName,websiteURL);
            return ControllerHelper.convertToDto(newWebsite);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    /**
     * Create a new article
     *
     * @return a ArticleDto with specified information.
     * @throws Exception
     * @author Jiatong Niu
     */
    @PostMapping(value = {"/article/create", "/article/create/"})
    public ArticleDto createArticle( @RequestParam String newsID, @RequestParam String url,
                                    @RequestParam String content, @RequestParam String title, @RequestParam String websiteName, @RequestParam String type) throws Exception {
        try {
            //@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE,pattern = "yyyy-mm-dd") Date publishDate, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME,pattern = "hh:mm:ss")Time publishTime,
            long now = System.currentTimeMillis();
            Date publishDate = new Date(now);
            Time publishTime = new Time(now);
            int newsid = Integer.parseInt(newsID);
            Article newArticle = articleService.createArticle(publishDate,publishTime,newsid,url,content,title,websiteName,type);
            return ControllerHelper.convertToDto(newArticle);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * Return all website in the db.
     * @return
     * @throws Exception
     * @author Jiatong Niu
     */
    @GetMapping(value = {"/website/get", "/website/get/"})
    public List<WebsiteDto> getwebsites() throws Exception {
        try {
            List<Website> websites = articleService.getAllWebsites();
            return websites.stream().map(a -> ControllerHelper.convertToDto(a)).collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e.getMessage());
        }
    }



    @GetMapping(value = {"/article/getAt", "/article/getAt/"})
    public ArticleDto getarticles(@RequestParam int newsID) throws Exception {
        try {
            Article article = articleService.getArticlebyId(newsID);
            return ControllerHelper.convertToDto(article);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping(value = {"/summary", "/summary/"})
    public List<SummaryDto> getSummaries()throws Exception {
        try {
            List<Summary> summaries = articleService.getAllSummary();
            return summaries.stream().map(a -> ControllerHelper.convertToDto(a)).collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /** chenkua
     * Change the summary under a News/Article. Can change the nlpResult only. An example of SummaryDto JSON is given
     * Cannot
     * @param newsID
     * @param newSummary
     * @return the updated ArticleDto
     */

    /*
        newsID = 1

        and

        JSON body
        {
            "summaryId": 1,
 	        "nlprResult": "update summary"
        }

     */

    @PutMapping(value = {"/updateSummaryForNews", "/updateSummaryForNews/"})
    public ArticleDto updateSummaryForArticle(@RequestParam int newsID, @RequestBody SummaryDto newSummary){
        try {
            Article article = articleService.updateSummary(newsID,newSummary);
            return ControllerHelper.convertToDto(article);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
