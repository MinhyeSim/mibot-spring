package kr.co.eis.api.user.domains;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * packageName: kr.co.eis.api.auth.domains
 * fileName   : UserDTO
 * author     : Jangwonjong
 * date       : 2022-05-24
 * desc       :
 * ======================================
 * DATE          AUTHOR            NOTE
 * ======================================
 * 2022-05-24     Jangwonjong       최초 생성
 */

@Component @Data
public class UserDTO {
    @ApiModelProperty(position = 1) private long userId;
    @ApiModelProperty(position = 2) String username;
    @ApiModelProperty(position = 3) String password;
    @ApiModelProperty(position = 4) String name;
    @ApiModelProperty(position = 5) String email;
    @ApiModelProperty(position = 6) String address;
    @ApiModelProperty(position = 7) String birth;
    @ApiModelProperty(position = 8) String tel;
    @ApiModelProperty(position = 10) private String token;
    @ApiModelProperty(position = 11) private List<Role> roles;

}
