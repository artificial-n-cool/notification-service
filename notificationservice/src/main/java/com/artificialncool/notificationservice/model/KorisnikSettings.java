package com.artificialncool.notificationservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document("korisnikSetting")
public class KorisnikSettings {

    @Id
    private String id;

    @Indexed(unique = true)
    private String username;

    @JsonIgnore
    private String password;

    private boolean Guest_hostAnsweredReservation;

    private boolean Host_createdReservation;

    private boolean Host_cancelledReservation;

    private boolean Host_stayBeenRated;

    private boolean Host_hostBeenRated;

    private boolean Host_automaticAcceptance;

}
