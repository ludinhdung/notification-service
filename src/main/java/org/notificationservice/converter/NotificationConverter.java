package org.notificationservice.converter;

import org.notificationservice.dto.NotificationRequestDto;
import org.notificationservice.entity.Notification;
import org.springframework.stereotype.Component;

@Component
public class NotificationConverter {

    public static Notification toEntity(NotificationRequestDto notificationRequestDto) {
        return Notification.builder()
                .message(notificationRequestDto.getMessage())
                .type(notificationRequestDto.getType())
                .recipientId(notificationRequestDto.getRecipientId()).build();
    }
}
