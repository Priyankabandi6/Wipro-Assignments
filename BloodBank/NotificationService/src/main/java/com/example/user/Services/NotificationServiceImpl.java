package com.example.user.Services;
import java.util.List;

import org.springframework.stereotype.Service;
import com.example.user.Entities.Notification;
import com.example.user.Repository.NotificationRepository;
@Service
public class NotificationServiceImpl implements NotificationService {	
	private final NotificationRepository notificationRepository;
    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public Notification sendNotification(Notification notification) {
        notification.setStatus("SENT");
        return notificationRepository.save(notification);
    }
	
    @Override
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }
	

}
