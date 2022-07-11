package kr.co.eis.api.board.services;

import kr.co.eis.api.board.domains.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

/**
 * packageName: kr.co.eis.api.board.services
 * fileName   : BoardService
 * author     : Jangwonjong
 * date       : 2022-05-09
 * desc       :
 * ======================================
 * DATE          AUTHOR            NOTE
 * ======================================
 * 2022-05-09     Jangwonjong       최초 생성
 */
public interface BoardService {
    List<Board> findAll();

    List<Board> findAll(Sort sort);

    Page<Board> findAll(Pageable pageable);

    long count();

    String delete(Board board);

    String save(Board Board);

    Optional<Board> findById(String boardid);

    boolean existsById(String boardid);
}
