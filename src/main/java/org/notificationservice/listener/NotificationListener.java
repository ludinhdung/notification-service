package org.notificationservice.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.notificationservice.converter.NotificationConverter;
import org.notificationservice.dto.NotificationRequestDto;
import org.notificationservice.entity.Notification;
import org.notificationservice.repository.NotificationRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationListener {

    private final NotificationRepository notificationRepository;

    @RabbitListener(queues = "faqueue")
    @SneakyThrows
    public void handleMessage(String message) {
        NotificationRequestDto notificationRequestDto = new ObjectMapper().readValue(message, NotificationRequestDto.class);
        log.info("Test receive message {}", notificationRequestDto);
        Notification notification = NotificationConverter.toEntity(notificationRequestDto);
        notificationRepository.save(notification);
    }
}
