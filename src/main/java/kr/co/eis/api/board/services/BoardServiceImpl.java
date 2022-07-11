package kr.co.eis.api.board.services;

import kr.co.eis.api.board.domains.Board;
import kr.co.eis.api.board.repositories.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    public final BoardRepository repository;

    @Override
    public List<Board> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Board> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Board> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public String delete(Board board) {
        return null;
    }

    @Override
    public String save(Board Board) {
        return null;
    }

    @Override
    public Optional<Board> findById(String boardid) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String boardid) {
        return false;
    }
}
