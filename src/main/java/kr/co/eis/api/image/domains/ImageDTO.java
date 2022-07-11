package kr.co.eis.api.image.domains;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * packageName: kr.co.mibot.api.image
 * fileName   : ImageDTO
 * author     : Jangwonjong
 * date       : 2022-06-18
 * desc       :
 * ======================================
 * DATE          AUTHOR            NOTE
 * ======================================
 * 2022-06-18     Jangwonjong       최초 생성
 */
@Component @Data
public class ImageDTO {
    @ApiModelProperty(position = 1) private long imageId;
    @ApiModelProperty(position = 2) private long userId;

}
