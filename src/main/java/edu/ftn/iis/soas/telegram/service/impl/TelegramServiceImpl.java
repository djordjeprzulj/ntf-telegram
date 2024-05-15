package edu.ftn.iis.soas.telegram.service.impl;

import edu.ftn.iis.soas.domain.model.Notification;
import edu.ftn.iis.soas.telegram.service.TelegramService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class TelegramServiceImpl implements TelegramService {

    @Value("${ntf.telegram.bot.token}")
    private String telegramBotToken;

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public String send(Notification notification) {

        String url = "https://api.telegram.org/bot" + telegramBotToken + "/sendMessage";
        String chatId = notification.getDestination();
        String text = notification.getPayload();

        String path = url + "?chat_id=" + chatId + "&text=" + text;
        log.info(path);
        String response = restTemplate.postForObject(path, null, String.class);
        log.trace("response: " + response);
        return response;
    }
}
