package com.example.webhook.repository;

import com.example.webhook.entity.TelegramUsers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelegramUsersRepository extends JpaRepository<TelegramUsers, Long> {
}
