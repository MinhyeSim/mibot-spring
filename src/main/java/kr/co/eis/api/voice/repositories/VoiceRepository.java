package kr.co.eis.api.voice.repositories;

import kr.co.eis.api.voice.domains.Voice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * packageName: kr.co.mibot.api.text.repositories
 * fileName   : VoiceRepository
 * author     : Jangwonjong
 * date       : 2022-06-18
 * desc       :
 * ======================================
 * DATE          AUTHOR            NOTE
 * ======================================
 * 2022-06-18     Jangwonjong       최초 생성
 */
@Repository
public interface VoiceRepository extends JpaRepository<Voice, Long> {
}
