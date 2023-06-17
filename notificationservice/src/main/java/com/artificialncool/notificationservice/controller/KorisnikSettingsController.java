package com.artificialncool.notificationservice.controller;

import com.artificialncool.notificationservice.dto.model.NotificationSettingsDTO;
import com.artificialncool.notificationservice.model.KorisnikSettings;
import com.artificialncool.notificationservice.service.KorisnikSettingsService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/api/notifications")
@RequiredArgsConstructor
public class KorisnikSettingsController {

    private final KorisnikSettingsService korisnikSettingsService;

    @GetMapping(value = "username/{username}")
    public ResponseEntity<KorisnikSettings> getByUsername(@PathVariable String username){
        try{
            return new ResponseEntity<>(korisnikSettingsService.getByUsername(username), HttpStatus.OK);
        }
        catch (EntityNotFoundException ex)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Korisnika nema", ex);
        }
    }

    @PostMapping(value = "/addUserSettings")
    public ResponseEntity<KorisnikSettings> addUserSettings(@RequestBody KorisnikSettings korisnikSettings) {
        return new ResponseEntity<>(korisnikSettingsService.createNewKorisnikSettings(korisnikSettings), HttpStatus.CREATED);
    }

    @PutMapping(value = "/changeUserSettings")
    public ResponseEntity<Void> changeUserSettings(@RequestBody NotificationSettingsDTO dto) {
        korisnikSettingsService.updateNotificationsPreference(dto.getKorisnikID(), dto);
        return ResponseEntity.ok().build();
    }
}
