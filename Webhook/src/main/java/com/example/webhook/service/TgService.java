package com.example.webhook.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
@RequiredArgsConstructor
public class TgService {

    private final WebhookService webhookService;

    public void request(Update update){
        if (update.hasMessage()){
            String text = update.getMessage().getText();
            switch (text.toLowerCase()){
                case "/start":
                    webhookService.whenStart(update);
                    break;
                case "salom":
                    webhookService.hello(update);
                    break;
                case "uz":
                    System.out.println("uz");
                    break;
                case "ru":
                    System.out.println("ru");
                    break;
                case "en":
                    System.out.println("en");
                    break;
                default:
                    webhookService.defaultNot(update);
                    break;
            }
        }
    }
}
