package kr.co.eis.api.text.controllers;

import kr.co.eis.api.text.services.TextService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName: kr.co.mibot.api.text.controllers
 * fileName   : TextController
 * author     : Jangwonjong
 * date       : 2022-06-18
 * desc       :
 * ======================================
 * DATE          AUTHOR            NOTE
 * ======================================
 * 2022-06-18     Jangwonjong       최초 생성
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/texts")
public class TextController {
    private final TextService service;
}
