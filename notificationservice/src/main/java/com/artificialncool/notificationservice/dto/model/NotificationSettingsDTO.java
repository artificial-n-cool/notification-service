package com.artificialncool.notificationservice.dto.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationSettingsDTO {

    private String korisnikID;

    private boolean Guest_hostAnsweredReservation;

    private boolean Host_createdReservation;

    private boolean Host_cancelledReservation;

    private boolean Host_stayBeenRated;

    private boolean Host_hostBeenRated;

    private boolean Host_automaticAcceptance;

}
