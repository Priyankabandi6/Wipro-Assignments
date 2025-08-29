package com.example.user.Services;

import java.util.List;

import com.example.user.Entities.Notification;

public interface NotificationService {
	
	Notification sendNotification(Notification notification);

	List<Notification> getAllNotifications();

}
