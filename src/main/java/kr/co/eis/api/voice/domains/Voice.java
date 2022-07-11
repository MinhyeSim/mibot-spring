package kr.co.eis.api.voice.domains;

import io.swagger.annotations.ApiModelProperty;
import kr.co.eis.api.user.domains.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * packageName: kr.co.mibot.api.voice
 * fileName   : Voice
 * author     : Jangwonjong
 * date       : 2022-06-18
 * desc       :
 * ======================================
 * DATE          AUTHOR            NOTE
 * ======================================
 * 2022-06-18     Jangwonjong       최초 생성
 */
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
@Table(name = "voices")
public class Voice {
    @Id
    @Column(name = "voice_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) private long voiceId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
