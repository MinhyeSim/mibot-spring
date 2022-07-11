package kr.co.eis.api.user.domains;

import com.sun.istack.NotNull;
import kr.co.eis.api.board.domains.Article;
import kr.co.eis.api.image.domains.Image;
import kr.co.eis.api.text.domains.Text;
import kr.co.eis.api.voice.domains.Voice;
import lombok.*;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * packageName: kr.co.eis.api.domains
 * fileName   : user
 * author     : Jangwonjong
 * date       : 2022-05-03
 * desc       :
 * ======================================
 * DATE          AUTHOR            NOTE
 * ======================================
 * 2022-05-03     Jangwonjong       최초 생성
 */

@AllArgsConstructor @NoArgsConstructor @Getter @Builder
@Setter
@ToString
@Entity @Eager
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue private long userId;
    @Column private @NotNull String username;
    @Column private @NotNull String password;
    @Column private @NotNull String name;
    @Column private @NotNull String email;
    @Column private @NotNull String address;
    @Column private @NotNull String birth;
    @Column private @NotNull String tel;
    @Column private String token;

    @OneToMany(mappedBy = "user")
    List<Article> ls = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    List<Text> texts = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    List<Voice> voices = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    List<Image> images = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    public List<Role> roles;

}
