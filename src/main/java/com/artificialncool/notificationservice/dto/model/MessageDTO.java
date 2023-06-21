package com.artificialncool.notificationservice.dto.model;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MessageDTO {

    private String message;
    private String senderID;
    private String receiverID;

}
