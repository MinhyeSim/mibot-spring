package kr.co.eis.api.voice.services;

import kr.co.eis.api.voice.repositories.VoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * packageName: kr.co.mibot.api.voice.services
 * fileName   : VoiceServiceImpl
 * author     : Jangwonjong
 * date       : 2022-06-18
 * desc       :
 * ======================================
 * DATE          AUTHOR            NOTE
 * ======================================
 * 2022-06-18     Jangwonjong       최초 생성
 */
@Service
@RequiredArgsConstructor
public class VoiceServiceImpl implements VoiceService{
    private final VoiceRepository repository;
}
