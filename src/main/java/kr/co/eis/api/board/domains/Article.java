package kr.co.eis.api.board.domains;

import com.sun.istack.NotNull;
import kr.co.eis.api.user.domains.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * packageName: kr.co.eis.api.auth.domains
 * fileName   : Article
 * author     : Jangwonjong
 * date       : 2022-05-18
 * desc       :
 * ======================================
 * DATE          AUTHOR            NOTE
 * ======================================
 * 2022-05-18     Jangwonjong       최초 생성
 */
@Getter @Builder @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "articles")
public class Article {
    @Id
    @Column(name = "article_id")
    @GeneratedValue private long articleId;
    @Column @NotNull private String title;
    @Column @NotNull private String content;
    @Column(name = "written_date") @NotNull private String writtenDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    Board board;
}
