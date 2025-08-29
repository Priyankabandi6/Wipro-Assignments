package com.example.user.Service;

import java.util.List;
import java.util.Optional;

import com.example.user.Entites.Blood;

public interface BloodService {
	Blood saveBlood(Blood blood);
    List<Blood> getAllBlood();
    Optional<Blood> getBloodById(Long id);
    Blood updateBlood(Long id, Blood blood);
    void deleteBlood(Long id);

}
