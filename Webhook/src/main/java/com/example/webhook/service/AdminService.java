package com.example.webhook.service;

import com.example.webhook.entity.TelegramUsers;
import com.example.webhook.feign.TelegramFeign;
import com.example.webhook.model.RestConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final RestTemplate restTemplate;
    private final WebhookService webhookService;

    private final TelegramFeign telegramFeign;

    public String senMessageRestTemplateModule(String text){
        List<TelegramUsers> allUsers =
                webhookService.getAllUsers();
        for (TelegramUsers users: allUsers){
            SendMessage sendMessage = new SendMessage(users.getId().toString(), text);
            Object o = restTemplate.postForObject(
                    RestConstants.TELEGRAM_BASE_URL + RestConstants.BOT +
                            RestConstants.SECRET_TOKEN + "/sendMessage", sendMessage, Object.class);
            System.out.println(o);
        }
        return "Xabar yuborildi :) ........";
    }

    public String senMessageFeignModule(String text){
        List<TelegramUsers> allUsers =
                webhookService.getAllUsers();
        for (TelegramUsers users: allUsers){
            SendMessage sendMessage = new SendMessage(users.getId().toString(), text);
            var resultTelegram = telegramFeign.sendMessageToUser(RestConstants.BOT + RestConstants.SECRET_TOKEN, sendMessage);
            System.out.println(resultTelegram);
        }
        return "Xabar yuborildi :) ........";
    }
}
