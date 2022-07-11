package kr.co.eis.api.user.services;

import kr.co.eis.api.auth.domains.Messenger;
import kr.co.eis.api.user.domains.User;
import kr.co.eis.api.user.domains.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

/**
 * packageName: kr.co.eis.api.repositories
 * fileName   : User
 * author     : Jangwonjong
 * date       : 2022-05-03
 * desc       :
 * ======================================
 * DATE          AUTHOR            NOTE
 * ======================================
 * 2022-05-03     Jangwonjong       최초 생성
 */
public interface UserService {

    UserDTO login(UserDTO user);

    Messenger logout();

    List<User> findAll();

    List<User> findAll(Sort sort);

    Page<User> findAll(Pageable pageable);

    Messenger count();

    Messenger update(User user);

    Messenger delete(User user);

    Messenger save(UserDTO user);

    Optional<User> findById(String userid);

    Messenger existsById(String userid);

    // custom

    List<User> findUserName(String name); 

}
