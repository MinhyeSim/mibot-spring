package kr.co.eis.api.auth.configs;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;

/**
 * packageName: kr.co.eis.api.config
 * fileName   : SecurityConfig
 * author     : Jangwonjong
 * date       : 2022-05-23
 * desc       :
 * ======================================
 * DATE          AUTHOR            NOTE
 * ======================================
 * 2022-05-23     Jangwonjong       최초 생성
 */

@RequiredArgsConstructor
public class AuthFilterConfiguration extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    @Override
    public void configure(HttpSecurity builder) throws Exception {
        super.configure(builder);
    }
}
