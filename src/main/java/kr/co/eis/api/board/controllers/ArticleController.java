package kr.co.eis.api.board.controllers;

import kr.co.eis.api.board.domains.Article;
import kr.co.eis.api.board.services.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * packageName: kr.co.eis.api.controllers
 * fileName   : BoardController
 * author     : Jangwonjong
 * date       : 2022-05-04
 * desc       :
 * ======================================
 * DATE          AUTHOR            NOTE
 * ======================================
 * 2022-05-04     Jangwonjong       최초 생성
 */
@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService service;

    // Embeded Methods
    @GetMapping("/findAll")
    public List<Article> findAll() {
        return service.findAll();
    }
    @GetMapping("/findAll/sort")
    public List<Article> findAll(Sort sort) {
        return service.findAll(sort);
    }
    @GetMapping("/findAll/pageable")
    public Page<Article> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }
    @GetMapping
    public long count() {
        return service.count();
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody Article article) {
        return service.delete(article);
    }

    @PostMapping("/join")
    public String save(@RequestBody Article article) {
        return service.save(article);
    }

}
