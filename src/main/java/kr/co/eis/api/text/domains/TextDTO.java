package kr.co.eis.api.text.domains;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * packageName: kr.co.mibot.api.text
 * fileName   : TextDTO
 * author     : Jangwonjong
 * date       : 2022-06-18
 * desc       :
 * ======================================
 * DATE          AUTHOR            NOTE
 * ======================================
 * 2022-06-18     Jangwonjong       최초 생성
 */
@Component @Data
public class TextDTO {
    @ApiModelProperty(position = 1) private long textId;
    @ApiModelProperty(position = 2) private long userId;
}
