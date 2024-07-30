package org.notificationservice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationRequestDto implements Serializable {
    private Long recipientId;
    private String message;
    private NotificationType type;
}