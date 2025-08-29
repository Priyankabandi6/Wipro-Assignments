package com.example.user.Service;
import com.example.user.Entities.Doner;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface DonorService {
	Doner addDonor(Doner donor);
    Doner updateDonor(Long id, Doner donor);
    List<Doner> findByCategory(String bloodGroup, String city, Integer contactNumber);
    ResponseEntity removeDonor(Long id);
	Doner getDonorById(Long id);

}
