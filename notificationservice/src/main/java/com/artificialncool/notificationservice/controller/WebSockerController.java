package com.artificialncool.notificationservice.controller;

import com.artificialncool.notificationservice.dto.model.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

//@Controller
//public class WebSocketController {
//
//    @Autowired
//
//    private SimpMessagingTemplate simpMessagingTemplate;
//
//
//    /*
//     * WebSockets endpoint
//     *
//     * Kao sto smo koristili @RequestMapping za RestController, @MessageMapping se koristi za websocket-e
//     *
//     * Poruka ce biti poslata svim klijentima koji su pretplatili na /socket-publisher topic,
//     * a poruka koja im se salje je messageConverted (simpMessagingTemplate.convertAndSend metoda).
//     *
//     * Na ovaj endpoint klijenti salju poruke, ruta na koju klijenti salju poruke je /send/message (parametar @MessageMapping anotacije)
//     *
//     */
//    @MessageMapping("/send/message")
//    public MessageDTO broadcastNotification(MessageDTO message) {
//        if (message != null && (message.getReceiverID().equals(""))) {
////                this.simpMessagingTemplate.convertAndSend("/socket-publisher/" + message.get("toId"),
////                        message);
//            } else {
//                this.simpMessagingTemplate.convertAndSend("/socket-publisher", message);
//        }
//
//
//        return message;
//    }
//    @MessageMapping("/send/message")
//    public MessageDTO broadcastNotification(MessageDTO message) {
//        if (message != null && (message.getReceiverID().equals(""))) {
//            this.simpMessagingTemplate.convertAndSend("/socket-publisher/" + message.get("toId"),
//                    message);
//        } else {
//            this.simpMessagingTemplate.convertAndSend("/socket-publisher", message);
//        }
//
//
//        return message;
//    }
//    @MessageMapping("/send/message")
//    public MessageDTO broadcastNotification(MessageDTO message) {
//        if (message != null && (message.getReceiverID().equals(""))) {
//            this.simpMessagingTemplate.convertAndSend("/socket-publisher/" + message.get("toId"),
//                    message);
//        } else {
//            this.simpMessagingTemplate.convertAndSend("/socket-publisher", message);
//        }
//
//
//        return message;
//    }
//    @MessageMapping("/send/message")
//    public MessageDTO broadcastNotification(MessageDTO message) {
//        if (message != null && (message.getReceiverID().equals(""))) {
//            this.simpMessagingTemplate.convertAndSend("/socket-publisher/" + message.get("toId"),
//                    message);
//        } else {
//            this.simpMessagingTemplate.convertAndSend("/socket-publisher", message);
//        }
//
//
//        return message;
//    }
//    @MessageMapping("/send/message")
//    public MessageDTO broadcastNotification(MessageDTO message) {
//        if (message != null && (message.getReceiverID().equals(""))) {
//            this.simpMessagingTemplate.convertAndSend("/socket-publisher/" + message.get("toId"),
//                    message);
//        } else {
//            this.simpMessagingTemplate.convertAndSend("/socket-publisher", message);
//        }
//
//
//        return message;
//    }
//    @MessageMapping("/send/message")
//    public MessageDTO broadcastNotification(MessageDTO message) {
//        if (message != null && (message.getReceiverID().equals(""))) {
//            this.simpMessagingTemplate.convertAndSend("/socket-publisher/" + message.get("toId"),
//                    message);
//        } else {
//            this.simpMessagingTemplate.convertAndSend("/socket-publisher", message);
//        }
//
//
//        return message;
//    }
//
//    /*@SuppressWarnings("unchecked")
//    private Map<String, String> parseMessage(String message) {
//        ObjectMapper mapper = new ObjectMapper();
//        Map<String, String> retVal;
//
//        try {
//            retVal = mapper.readValue(message, Map.class); // parsiranje JSON stringa
//        } catch (IOException e) {
//            retVal = null;
//        }
//
//        return retVal;
//    }*/
//}
