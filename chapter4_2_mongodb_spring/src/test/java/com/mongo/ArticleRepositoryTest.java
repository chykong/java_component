package com.mongo;

import com.critc.mongo.model.Article;
import com.critc.mongo.repository.ArticleRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 使用Repositor操作数据
 *
 * @author 孔垂云
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext-mongo.xml"})
public class ArticleRepositoryTest {

    @Autowired
    private ArticleRepository articleRepository;

    /**
     * 新增记录
     */
    @Test
    public void add() {
        //增加一条记录
        Article article = new Article();
        article.setId("1");
        article.setTitle("MongoTemplate的基本使用");
        article.setAuthor("kcy");
        article.setUrl("http://jianshu.com/");
        article.setTags(Arrays.asList("java", "mongodb", "spring"));
        article.setVisitCount(0L);
        article.setAddTime(new Date());
        articleRepository.save(article);

        //批量添加
        List<Article> articles = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            Article article2 = new Article();
            article2.setId(String.valueOf(i + 1));
            article2.setTitle("MongoTemplate的基本使用");
            article2.setAuthor("kcy");
            article2.setUrl("http://jianshu.com" + i);
            article2.setTags(Arrays.asList("java", "mongodb", "spring"));
            article2.setVisitCount(0L);
            article2.setAddTime(new Date());
            articles.add(article2);
        }
        articleRepository.save(articles);
    }

    /**
     * 修改记录，修改id为1的访问次数+1
     */
    @Test
    public void update() {
        Article article = articleRepository.findOne("1");
        article.setVisitCount(article.getVisitCount() + 1);
        articleRepository.save(article);
    }

    /**
     * 批量修改,查看author为kcy的统一修改为kcy2
     */
    @Test
    public void batchUpdate() {
        List<Article> articles = articleRepository.findByAuthor("kcy");
        articles.forEach(article -> {
            article.setAuthor("kcy2");
        });
        articleRepository.save(articles);
    }

    /**
     * 删除记录,删除id为10的
     */
    @Test
    public void delete() {
        Article article = articleRepository.findOne("10");
        articleRepository.delete(article);
    }

    @Test
    public void batchDelete() {
        List<Article> articles = articleRepository.findByAuthor("kcy2");
        articleRepository.delete(articles);
    }

    /**
     * 查询所有
     *
     * @author 孔垂云
     */
    @Test
    public void findAll() {
        Iterable<Article> articles = articleRepository.findAll();
        articles.forEach(article -> {
            System.out.println(article.toString());
        });
    }

    /**
     * 根据author查询
     *
     * @author 孔垂云
     */
    @Test
    public void findByAuthor() {
        List<Article> articles = articleRepository.findByAuthor("kcy");
        articles.forEach(article -> {
            System.out.println(article.toString());
        });
    }

    /**
     * 按照author和title查询
     *
     * @author 孔垂云
     */
    @Test
    public void findByAuthorAndTitle() {
        List<Article> articles = articleRepository.findByAuthorAndTitle("kcy", "MongoTemplate的基本使用");
        articles.forEach(article -> {
            System.out.println(article.toString());
        });
    }

    /**
     * 根据作者查询，忽略大小写
     *
     * @author 孔垂云
     */
    @Test
    public void findByAuthorIgnoreCase() {
        List<Article> articles = articleRepository.findByAuthorIgnoreCase("JASON");
        articles.forEach(article -> {
            System.out.println(article.getId());
        });
    }

    /**
     * 忽略所有参数的大小写
     *
     * @author 孔垂云
     */
    @Test
    public void findByAuthorAndTitleAllIgnoreCase() {
        List<Article> articles = articleRepository.findByAuthorAndTitleAllIgnoreCase("KCY", "MONGOTEMPLATE的基本使用");
        articles.forEach(article -> {
            System.out.println(article.toString());
        });
    }

    /**
     * 根据author查询，并且以访问次数降序排序显示
     *
     * @author 孔垂云
     */
    @Test
    public void findByAuthorOrderByVisitCountDesc() {
        List<Article> articles = articleRepository.findByAuthorOrderByVisitCountDesc("kcy");
        articles.forEach(article -> {
            System.out.println(article.toString());
        });
    }


    /**
     * 根据作者查询，并且以访问次数升序排序显示
     *
     * @author 孔垂云
     */
    @Test
    public void findByAuthorOrderByVisitCountAsc() {
        List<Article> articles = articleRepository.findByAuthorOrderByVisitCountAsc("kcy");
        articles.forEach(article -> {
            System.out.println(article.toString());
        });
    }

    /**
     * 自带排序条件
     *
     * @author 孔垂云
     */
    @Test
    public void findByAuthorBySort() {
        List<Article> articles = articleRepository.findByAuthor("kcy", new Sort(Direction.ASC, "VisitCount"));
        articles.forEach(article -> {
            System.out.println(article.toString());
        });
    }

    /**
     * 分页查询所有，并且排序
     */
    @Test
    public void findByPage() {
        int page = 1;
        int size = 2;
        Pageable pageable = new PageRequest(page, size, new Sort(Direction.ASC, "VisitCount"));
        Page<Article> pageInfo = articleRepository.findAll(pageable);
        //总数量
        System.out.println(pageInfo.getTotalElements());
        //总页数
        System.out.println(pageInfo.getTotalPages());
        for (Article article : pageInfo.getContent()) {
            System.out.println(article.toString());
        }
    }
}
