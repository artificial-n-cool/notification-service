package com.artificialncool.notificationservice.controller;

import com.artificialncool.notificationservice.dto.model.MessageDTO;
import com.artificialncool.notificationservice.model.KorisnikSettings;
import com.artificialncool.notificationservice.service.KorisnikSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import java.lang.reflect.Field;


@Controller
public class WebSocketController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    private KorisnikSettingsService korisnikSettingsService;

    /*
     * WebSockets endpoint
     *
     * Kao sto smo koristili @RequestMapping za RestController, @MessageMapping se koristi za websocket-e
     *
     * Poruka ce biti poslata svim klijentima koji su pretplatili na /socket-publisher topic,
     * a poruka koja im se salje je messageConverted (simpMessagingTemplate.convertAndSend metoda).
     *
     * Na ovaj endpoint klijenti salju poruke, ruta na koju klijenti salju poruke je /send/message (parametar @MessageMapping anotacije)
     *
     */
    @MessageMapping("/send/message/Guest_hostAnsweredReservation")
    public MessageDTO sendHostReservationNotification(MessageDTO message) throws NoSuchFieldException, IllegalAccessException {

        if (message != null && checkSettinsForNotification(message.getReceiverID(), "Guest_hostAnsweredReservation" )) {
            if (!message.getReceiverID().equals("")) {
                this.simpMessagingTemplate.convertAndSend("/socket-publisher/Guest_hostAnsweredReservation" + message.getReceiverID(),
                        message);
            } else {
                this.simpMessagingTemplate.convertAndSend("/socket-publisher/Guest_hostAnsweredReservation", message);
            }
        }

        return message;
    }

    @MessageMapping("/send/message/Host_createdReservation")
    public MessageDTO sendCreatedReservationNotification(MessageDTO message) throws NoSuchFieldException, IllegalAccessException {

        if (message != null  && checkSettinsForNotification(message.getReceiverID(), "Host_createdReservation" )) {
            if (!message.getReceiverID().equals("")) {
                this.simpMessagingTemplate.convertAndSend("/socket-publisher/Host_createdReservation" + message.getReceiverID(),
                        message);
            } else {
                this.simpMessagingTemplate.convertAndSend("/socket-publisher/Host_createdReservation", message);
            }
        }

        return message;
    }

    @MessageMapping("/send/message/Host_automaticAcceptance")
    public MessageDTO sendautomaticAcceptance(MessageDTO message) throws NoSuchFieldException, IllegalAccessException {
        if (message != null  && checkSettinsForNotification(message.getReceiverID(), "Host_automaticAcceptance" )) {
            if (!message.getReceiverID().equals("")) {
                this.simpMessagingTemplate.convertAndSend("/socket-publisher/Host_automaticAcceptance" + message.getReceiverID(),
                        message);
                // TODO: API CALL TO ACCEPT RESERVATION TO THE RESERVATION SERVICE IN THE HOST SERVICE
            } else {
                this.simpMessagingTemplate.convertAndSend("/socket-publisher/Host_automaticAcceptance", message);
            }
        }

        return message;
    }


    @MessageMapping("/send/message/Host_hostBeenRated")
    public MessageDTO sendhostBeenRated(MessageDTO message) throws NoSuchFieldException, IllegalAccessException {

        if (message != null  && checkSettinsForNotification(message.getReceiverID(), "Host_hostBeenRated" )) {
            if (!message.getReceiverID().equals("")) {
                this.simpMessagingTemplate.convertAndSend("/socket-publisher/Host_hostBeenRated" + message.getReceiverID(),
                        message);
            } else {
                this.simpMessagingTemplate.convertAndSend("/socket-publisher/Host_hostBeenRated", message);
            }
        }

        return message;
    }


    @MessageMapping("/send/message/Host_cancelledReservation")
    public MessageDTO sendcancelledReservation(MessageDTO message) throws NoSuchFieldException, IllegalAccessException {

        if (message != null  && checkSettinsForNotification(message.getReceiverID(), "Host_cancelledReservation" )) {
            if (!message.getReceiverID().equals("")) {
                this.simpMessagingTemplate.convertAndSend("/socket-publisher/Host_cancelledReservation" + message.getReceiverID(),
                        message);
            } else {
                this.simpMessagingTemplate.convertAndSend("/socket-publisher/Host_cancelledReservation", message);
            }
        }

        return message;
    }

    @MessageMapping("/send/message/Host_stayBeenRated")
    public MessageDTO sendstayBeenRated(MessageDTO message) throws NoSuchFieldException, IllegalAccessException {

        if (message != null && checkSettinsForNotification(message.getReceiverID(), "Host_stayBeenRated" )) {
            if (!message.getReceiverID().equals("")) {
                this.simpMessagingTemplate.convertAndSend("/socket-publisher/Host_stayBeenRated" + message.getReceiverID(),
                        message);
            } else {
                this.simpMessagingTemplate.convertAndSend("/socket-publisher/Host_stayBeenRated", message);
            }
        }

        return message;
    }

    private boolean checkSettinsForNotification(String username, String notification) throws NoSuchFieldException, IllegalAccessException {

        try {
            KorisnikSettings korisnikSettings = korisnikSettingsService.getByUsername(username);
            Class cl = korisnikSettings.getClass();
            Field f = cl.getDeclaredField(notification);
            f.setAccessible(true);
            return f.getBoolean(korisnikSettings);
        }
        catch (NoSuchFieldException | IllegalAccessException ex)
        {
            System.out.println(ex.getMessage());
        }

        return false;
    }


}