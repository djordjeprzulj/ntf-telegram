package edu.ftn.iis.soas.telegram.controller;

import edu.ftn.iis.soas.domain.model.Notification;
import edu.ftn.iis.soas.domain.model.NotificationRequest;
import edu.ftn.iis.soas.telegram.service.TelegramService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
@RequestMapping("/api/telegram")
public class TelegramController {

    private final TelegramService telegramService;

    @PostMapping("send")
    public void sendMessage(@RequestBody Notification notification) {
        log.info("Notification to send: " + notification);
        telegramService.send(notification);
    }

}
