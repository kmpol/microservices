package pl.karol.notification.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.karol.clients.notification.NotificationRequest;
import pl.karol.notification.model.Notification;
import pl.karol.notification.repository.NotificationRepository;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public void sendNotification(NotificationRequest notificationRequest) {
        Notification notification = Notification.builder()
                .message(notificationRequest.message())
                .toCustomerId(notificationRequest.toCustomerId())
                .sender("test")
                .toCustomerEmail(notificationRequest.toCustomerEmail())
                .sentAt(LocalDateTime.now())
                .build();
        notificationRepository.save(notification);
    }
}
