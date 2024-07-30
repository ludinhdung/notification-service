package org.notificationservice.controller;

import lombok.RequiredArgsConstructor;
import org.notificationservice.entity.Notification;
import org.notificationservice.repository.NotificationRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationRepository notificationRepository;

    @GetMapping
    public Iterable<Notification> notifications(){
        return notificationRepository.findAll();
    }
}
