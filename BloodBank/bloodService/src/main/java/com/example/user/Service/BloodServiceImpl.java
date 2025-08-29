package com.example.user.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.user.Entites.Blood;
import com.example.user.Reposirty.BloodRepository;

@Service
public class BloodServiceImpl implements BloodService {

    private final BloodRepository bloodRepository;

    public BloodServiceImpl(BloodRepository bloodRepository) {
        this.bloodRepository = bloodRepository;
    }

    @Override
    public Blood saveBlood(Blood blood) {
        return bloodRepository.save(blood);
    }

    @Override
    public List<Blood> getAllBlood() {
        return bloodRepository.findAll();
    }

    @Override
    public Optional<Blood> getBloodById(Long id) {
        return bloodRepository.findById(id);
    }

    @Override
    public Blood updateBlood(@PathVariable Long id, @RequestBody(required = false) Blood blood) {
        return bloodRepository.findById(id).map(existingBlood -> {
            existingBlood.setBloodGroup(blood.getBloodGroup());
            existingBlood.setQuantity(blood.getQuantity());
            existingBlood.setStatus(blood.getStatus());
            return bloodRepository.save(existingBlood);
        }).orElseThrow(() -> new RuntimeException("Blood record not found with ID: " + id));
    }

    @Override
    public void deleteBlood(Long id) {
        bloodRepository.deleteById(id);
    }
}

