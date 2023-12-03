package pl.karol.notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.karol.notification.model.Notification;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
}
