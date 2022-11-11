package com.example.webhook.controller;

import com.example.webhook.service.TgService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.objects.Update;

@RestController
@RequestMapping("/api/telegram")
@RequiredArgsConstructor
public class WebhookController {

    private final TgService tgService;

    @PostMapping
    public void telegramUsers(@RequestBody Update update){
        tgService.request(update);
    }


}
