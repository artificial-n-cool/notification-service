package com.artificialncool.notificationservice.repository;

import com.artificialncool.notificationservice.model.KorisnikSettings;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface KorisnikSettingsRepository extends MongoRepository<KorisnikSettings, String> {

    Optional<KorisnikSettings> findByUsername(String username);


}
