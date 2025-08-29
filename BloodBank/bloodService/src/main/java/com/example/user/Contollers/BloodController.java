package com.example.user.Contollers;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.user.Entites.Blood;
import com.example.user.Fegin.DonorClient;
import com.example.user.Service.BloodService;
import com.example.user.dto.Doner;

import lombok.RequiredArgsConstructor;
@RestController
@RequiredArgsConstructor

@RequestMapping("/api/blood")
public class BloodController {	
	private final BloodService bloodService; 
	
	private final DonorClient donorClient;
	
	@GetMapping(value = "/donor/{id}", produces = "application/json")
    public ResponseEntity<Doner> getDonor(@PathVariable Long id) {
        Doner donor = donorClient.getDonorById(id);
        return ResponseEntity.ok(donor);
                
    }
	
	@PostMapping("/create")
    public Blood saveBlood(@RequestBody Blood blood) {
        return bloodService.saveBlood(blood);
    }

    @GetMapping
    public List<Blood> getAllBlood() {
        return bloodService.getAllBlood();
    }

    @GetMapping("/{id}")
    public Blood getBloodById(@PathVariable Long id) {
        return bloodService.getBloodById(id)
                .orElseThrow(() -> new RuntimeException("Blood record not found with ID: " + id));
    }

    @PutMapping("/Update/{id}")
    public Blood updateBlood(@PathVariable Long id, @RequestBody Blood blood) {
        return bloodService.updateBlood(id, blood);
    }

    @DeleteMapping("/{id}")
    public String deleteBlood(@PathVariable Long id) {
        bloodService.deleteBlood(id);
        return "Blood record deleted with ID: " + id;
    }
}
	


