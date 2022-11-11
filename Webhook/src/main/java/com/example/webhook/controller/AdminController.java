package com.example.webhook.controller;

import com.example.webhook.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;

    @GetMapping("send-message/rest")
    public String senMessageRest(@RequestParam String text){
        return adminService.senMessageRestTemplateModule(text);
    }

    @GetMapping("send-message/feign")
    public String senMessageFeign(@RequestParam String text){
        return adminService.senMessageRestTemplateModule(text);
    }
}
