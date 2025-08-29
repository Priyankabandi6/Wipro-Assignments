package com.example.user.Repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.example.user.Entities.Notification;

public interface NotificationRepository extends JpaRepositoryImplementation<Notification, Long> {

}
