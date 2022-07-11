package kr.co.eis.api.board.services;

import kr.co.eis.api.board.domains.Article;
import kr.co.eis.api.board.repositories.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * packageName: kr.co.eis.api.board.services
 * fileName   : ArticleServiceImpl
 * author     : Jangwonjong
 * date       : 2022-05-09
 * desc       :
 * ======================================
 * DATE          AUTHOR            NOTE
 * ======================================
 * 2022-05-09     Jangwonjong       최초 생성
 */

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {
    public final ArticleRepository repository;


    @Override
    public List<Article> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Article> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Override
    public Page<Article> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public String delete(Article article) {
        repository.delete(article);
        return "";
    }

    @Override
    public String save(Article article) {
        repository.save(article);
        return "";
    }



}

