package kr.co.eis.api.board.domains;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * packageName: kr.co.eis.api.auth.domains
 * fileName   : Board
 * author     : Jangwonjong
 * date       : 2022-05-18
 * desc       :
 * ======================================
 * DATE          AUTHOR            NOTE
 * ======================================
 * 2022-05-18     Jangwonjong       최초 생성
 */

@AllArgsConstructor @NoArgsConstructor @Getter @Builder
@Component
@Entity
@Table(name = "boards")
public class Board {
    @Id
    @Column(name = "board_id")
    @GeneratedValue
    private long boardId;
    @Column private @NotNull String boardname;
    @Column(name = "created_date") @NotNull private String createdDate;

    @OneToMany(mappedBy = "board")
    List<Article> ls2 = new ArrayList<>();


}
