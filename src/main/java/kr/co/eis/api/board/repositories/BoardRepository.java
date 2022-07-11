package kr.co.eis.api.board.repositories;

import kr.co.eis.api.board.domains.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * packageName: kr.co.eis.api.board.repositories
 * fileName   : BoardRepository
 * author     : Jangwonjong
 * date       : 2022-05-09
 * desc       :
 * ======================================
 * DATE          AUTHOR            NOTE
 * ======================================
 * 2022-05-09     Jangwonjong       최초 생성
 */
@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
}
