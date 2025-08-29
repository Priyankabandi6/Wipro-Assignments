package com.example.user.Fegin;

import javax.management.Notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notification-service", url = "http://localhost:8083/api/notifications")
public interface NotificationClient {
    @PostMapping
    Notification sendNotification(@RequestBody Notification notification);
}
