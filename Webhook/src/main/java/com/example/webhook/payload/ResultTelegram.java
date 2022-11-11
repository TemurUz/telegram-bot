package com.example.webhook.payload;

import com.example.webhook.entity.TelegramUsers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.telegram.telegrambots.meta.api.objects.Message;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultTelegram {
    private boolean ok;

    private Message result;

    public Message getResult() {
        return result;
    }

    public void accept(TelegramUsers en){
        var chat = getResult().getChat();
        en.setId(chat.getId());
        en.setFirstName(chat.getFirstName());
        en.setUserName(chat.getUserName());
        en.setType(chat.getType());
    }
}
