package com.example.user.Service;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.user.Entities.Doner;
import com.example.user.Reposirty.DonerRepo;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class DonorServiceImpl implements DonorService {
	private final DonerRepo donorRepo;	
	@Override
    public Doner addDonor(Doner donor) {
        return donorRepo.save(donor);
    }	
	@Override
    public Doner updateDonor(Long id, Doner donor) {
        Doner existingDonor = donorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Donor not found with id: " + id));

        existingDonor.setName(donor.getName());
        existingDonor.setBloodGroup(donor.getBloodGroup());
        existingDonor.setCity(donor.getCity());
        existingDonor.setContactNumber(donor.getContactNumber());
        return donorRepo.save(existingDonor);
    }

	public List<Doner> findByCategory(String bloodGroup, String city, Integer contactNumber) {
		if (bloodGroup != null && city != null && contactNumber != null) {
	        return donorRepo.findByBloodGroupAndCityAndContactNumber(bloodGroup, city, contactNumber);
	    } else if (bloodGroup != null && city != null) {
	        return donorRepo.findByBloodGroupAndCity(bloodGroup, city);
	    } else if (bloodGroup != null) {
	        return donorRepo.findByBloodGroup(bloodGroup);
	    } else if (city != null) {
	        return donorRepo.findByCity(city);
	    } else {
	        return donorRepo.findAll();
	    }
		
	}

	@Override
	public ResponseEntity removeDonor(Long id) {
		donorRepo.deleteById(id);
		return null;		
	}
	@Override
	public Doner getDonorById(Long id) {
		return donorRepo.getDonorById(id);
		         
	}	

}
