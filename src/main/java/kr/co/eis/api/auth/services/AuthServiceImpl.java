package kr.co.eis.api.auth.services;

import kr.co.eis.api.user.repositories.UserRepository;
import kr.co.eis.api.user.domains.User;
import kr.co.eis.api.auth.domains.Auth;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * packageName: kr.co.eis.api.security.domains
 * fileName   : UserDetailsServiceImpl
 * author     : Jangwonjong
 * date       : 2022-05-23
 * desc       :
 * ======================================
 * DATE          AUTHOR            NOTE
 * ======================================
 * 2022-05-23     Jangwonjong       최초 생성
 */
@Service
@RequiredArgsConstructor//서비스는 중간에 끼어있기 때문에 필요
public class AuthServiceImpl implements UserDetailsService {
    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = Optional.ofNullable(repository.findByUsername(username))
                .orElseThrow(()-> new UsernameNotFoundException(username+"에 해당하는 객체가 존재 안함."));
        return Auth.build(user.get());
    }
}
