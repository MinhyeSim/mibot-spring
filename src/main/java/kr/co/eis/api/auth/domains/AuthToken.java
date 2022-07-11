package kr.co.eis.api.auth.domains;

import io.jsonwebtoken.*;
import lombok.extern.java.Log;

import java.util.Date;
import java.util.HashMap;

/**
 * packageName: kr.co.eis.api.security.domain
 * fileName   : SecurityToken
 * author     : Jangwonjong
 * date       : 2022-05-23
 * desc       :
 * ======================================
 * DATE          AUTHOR            NOTE
 * ======================================
 * 2022-05-23     Jangwonjong       최초 생성
 */
@Log
public class AuthToken {
    private String token;
    private String key;

    public AuthToken(String key) {
        this.key = key;
        this.token = createToken();
    }

    private String createToken() {
        try {
            HashMap<String, Object> headers = new HashMap<>();
            headers.put("typ","JWT");
            headers.put("alg","HS256");
            HashMap<String, Object> payload = new HashMap<>();
            headers.put("data","dddd");
            Date exp = new Date();
            exp.setTime(exp.getTime() + 1000 * 60L * 10L);

            return Jwts.builder()
                    .setHeader(headers)
                    .setClaims(payload)
                    .setSubject("user")
                    .setExpiration(exp)
                    .signWith(SignatureAlgorithm.HS256, key.getBytes())
                    .compact();
        }
        catch (SecurityException e){log.info("SecurityException JWT");}
        catch (MalformedJwtException e){log.info("MalformedJwtException JWT");}
        catch (ExpiredJwtException e){log.info("ExpiredJwtException JWT");}
        catch (UnsupportedJwtException e){log.info("UnsupportedJwtException JWT");}
        catch (IllegalAccessError e){log.info("IllegalAccessError JWT");}

        return null;
    }
}
