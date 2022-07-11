package kr.co.eis.api.user.repositories;

import kr.co.eis.api.user.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * packageName: kr.co.eis.api.repositories
 * fileName   : UserRepository
 * author     : Jangwonjong
 * date       : 2022-05-03
 * desc       :
 * ======================================
 * DATE          AUTHOR            NOTE
 * ======================================
 * 2022-05-03     Jangwonjong       최초 생성
 */

interface UserCustomRepository{
    @Query(value = "")
    String login(User user);
    @Modifying @Query(value = "")
    void update(User user);
}

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByUsername(String username);
}
