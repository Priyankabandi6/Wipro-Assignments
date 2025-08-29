package com.example.user.Controller;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.user.Entities.Notification;
import com.example.user.Services.NotificationService;
@RestController
@RequestMapping("/api/notifications")
public class NotificationController {	
	private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public Notification sendNotification(@RequestBody Notification notification) {
        return notificationService.sendNotification(notification);
    }
    
    @GetMapping
    public List<Notification> getAllNotifications() {
        return notificationService.getAllNotifications();
    }
}
