package com.artificialncool.notificationservice.service;


import com.artificialncool.notificationservice.dto.model.NotificationSettingsDTO;
import com.artificialncool.notificationservice.model.KorisnikSettings;
import com.artificialncool.notificationservice.repository.KorisnikSettingsRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class KorisnikSettingsService {

    private final KorisnikSettingsRepository korisnikSettingsRepository;

    public KorisnikSettings getByUsername(String username) throws EntityNotFoundException{
        return korisnikSettingsRepository.findByUsername(username)
                .orElseThrow(()-> new EntityNotFoundException("Nema settings za ovog korisnika"));
    }


    public KorisnikSettings changeUsername(String oldUsername, String newUsername) throws EntityNotFoundException{
        try {
            KorisnikSettings korisnikSettings = korisnikSettingsRepository.findByUsername(oldUsername).orElseThrow();
            korisnikSettings.setUsername(newUsername);
            return korisnikSettingsRepository.save(korisnikSettings);
        }
        catch (EntityNotFoundException ex){

        }

        return null;
    }

    public KorisnikSettings createNewKorisnikSettings(KorisnikSettings korisnikSettings){
        return korisnikSettingsRepository.save(korisnikSettings);
    }
    public KorisnikSettings updateNotificationsPreference(String username, NotificationSettingsDTO dto) throws EntityNotFoundException{
            KorisnikSettings korisnikSettings = korisnikSettingsRepository.findByUsername(username).orElseThrow(()-> new EntityNotFoundException("Nema ovog korisnika"));
            korisnikSettings.setGuest_hostAnsweredReservation(dto.isGuest_hostAnsweredReservation());
            korisnikSettings.setHost_automaticAcceptance(dto.isHost_automaticAcceptance());
            korisnikSettings.setHost_createdReservation(dto.isHost_createdReservation());
            korisnikSettings.setHost_cancelledReservation(dto.isHost_createdReservation());
            korisnikSettings.setHost_hostBeenRated(dto.isHost_hostBeenRated());
            korisnikSettings.setHost_stayBeenRated(dto.isHost_stayBeenRated());

            return korisnikSettingsRepository.save(korisnikSettings);
    }

}
