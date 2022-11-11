package com.example.webhook.feign;

import com.example.webhook.model.RestConstants;
import com.example.webhook.payload.ResultTelegram;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@FeignClient(url = RestConstants.TELEGRAM_BASE_URL,
    name = "TelegramFeign")
public interface TelegramFeign {

    @PostMapping("/{path}/sendMessage")
    ResultTelegram sendMessageToUser(@PathVariable String path, @RequestBody SendMessage sendMessage);
}
