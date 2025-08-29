package com.example.user.Fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.user.Entities.Notification;

@FeignClient(name = "notificationservice")

public interface NotificationClient {
	
	@PostMapping("/api/notifications")
    Notification sendNotification(@RequestBody Notification notification);
	

}
