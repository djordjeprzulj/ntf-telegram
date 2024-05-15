package edu.ftn.iis.soas.telegram.service;

import edu.ftn.iis.soas.domain.model.Notification;
import edu.ftn.iis.soas.domain.model.NotificationRequest;

public interface TelegramService {
    String send(Notification notification);
}
