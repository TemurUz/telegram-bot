package com.example.webhook.service;

import com.example.webhook.entity.TelegramUsers;
import com.example.webhook.model.RestConstants;
import com.example.webhook.payload.ResultTelegram;
import com.example.webhook.repository.TelegramUsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WebhookService {

    private final RestTemplate restTemplate;
    private final TelegramUsersRepository telegramUsersRepository;

    public void whenStart(Update update){
        SendMessage sendMessage = new SendMessage(update.getMessage().getChatId().toString(), "Xush kelibsan");
        var result = restTemplate.postForObject(
                RestConstants.TELEGRAM_BASE_URL + RestConstants.BOT +
                        RestConstants.SECRET_TOKEN + "/sendMessage", sendMessage, ResultTelegram.class);
        TelegramUsers users = new TelegramUsers();
        result.accept(users);
        telegramUsersRepository.save(users);
        System.out.println(result);
    }

    public void hello(Update update){
        SendMessage sendMessage = new SendMessage(update.getMessage().getChatId().toString(), "Salom n nnnnnnnnnnnnnnnnnnnnnnnnnnn️");
        Object o = restTemplate.postForObject(
                RestConstants.TELEGRAM_BASE_URL + RestConstants.BOT +
                        RestConstants.SECRET_TOKEN + "/sendMessage", sendMessage, Object.class);
        System.out.println(o);
    }

    public void defaultNot(Update update){
        SendMessage sendMessage = new SendMessage(update.getMessage().getChatId().toString(), "Lug'atimizda bunaqa so'z yuq ️");
        Object o = restTemplate.postForObject(
                RestConstants.TELEGRAM_BASE_URL  + RestConstants.BOT +
                        RestConstants.SECRET_TOKEN + "/sendMessage", sendMessage, Object.class);
        System.out.println(o);
    }

    public List<TelegramUsers> getAllUsers(){
        return telegramUsersRepository.findAll();
    }

}
