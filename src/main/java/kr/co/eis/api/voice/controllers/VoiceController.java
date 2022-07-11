package kr.co.eis.api.voice.controllers;

import kr.co.eis.api.voice.services.VoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * packageName: kr.co.mibot.api.voice.controllers
 * fileName   : VoiceController
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
@RequestMapping("/voices")
public class VoiceController {
    private final VoiceService service;
}
