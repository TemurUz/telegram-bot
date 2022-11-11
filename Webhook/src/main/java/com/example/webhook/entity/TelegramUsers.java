package com.example.webhook.entity;

import com.example.webhook.model.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TelegramUsers {
    @Id
    private Long id;
    private String firstName;
    @Column(unique = true)
    private String userName;
    private String type;

}
