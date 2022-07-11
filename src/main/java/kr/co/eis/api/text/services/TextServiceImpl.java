package kr.co.eis.api.text.services;

import kr.co.eis.api.text.repositories.TextRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * packageName: kr.co.mibot.api.text.services
 * fileName   : TextServiceImpl
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
public class TextServiceImpl implements TextService{
    private final TextRepository repository;
}
