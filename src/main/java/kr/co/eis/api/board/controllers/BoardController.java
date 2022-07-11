package kr.co.eis.api.board.controllers;

import kr.co.eis.api.board.domains.Board;
import kr.co.eis.api.board.services.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * packageName: kr.co.eis.api.board.controllers
 * fileName   : BoardController
 * author     : Jangwonjong
 * date       : 2022-05-09
 * desc       :
 * ======================================
 * DATE          AUTHOR            NOTE
 * ======================================
 * 2022-05-09     Jangwonjong       최초 생성
 */
@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService service;
    @GetMapping("/findAll")
    public List<Board> findAll() {
        return service.findAll();
    }
    @GetMapping("/findAll/sort")
    public List<Board> findAll(Sort sort) {
        return service.findAll(sort);
    }
    @GetMapping("/findAll/pageable")
    public Page<Board> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }
    @GetMapping
    public long count() {
        return service.count();
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody Board board) {
        return service.delete(board);
    }

    @PostMapping("/join")
    public String save(@RequestBody Board board) {
        return service.save(board);
    }
    @GetMapping("/findById/{boardid}")
    public Optional<Board> findById(@PathVariable String boardid) {
        return service.findById(boardid);
    }

    @GetMapping("/existsById/{boardid}")
    public boolean existsById(@PathVariable String boardid) {
        return service.existsById(boardid);
    }
}
