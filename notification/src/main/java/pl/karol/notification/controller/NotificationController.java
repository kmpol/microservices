package pl.karol.notification.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import pl.karol.clients.notification.NotificationRequest;
import pl.karol.notification.service.NotificationService;

@RestController
@RequestMapping("api/v1/notification")
@RequiredArgsConstructor
@Slf4j
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping
    public void saveNotification(@RequestBody NotificationRequest notificationRequest) {
        log.info("Notification request POST wuth data: {}", notificationRequest);
        notificationService.sendNotification(notificationRequest);
    }

}
