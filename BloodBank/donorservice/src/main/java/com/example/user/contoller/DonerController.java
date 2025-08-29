package com.example.user.contoller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
import com.example.user.Entities.Doner;
import com.example.user.Service.DonorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@RestController
@RequestMapping("/api/v1/donors")
@RequiredArgsConstructor
@Slf4j
public class DonerController {
	@Autowired
	private final DonorService donorService;
	
	@PostMapping("/addDonor")
	public Doner addDonor(@RequestBody Doner donor) {
		return donorService.addDonor(donor);
	}
	
	@PutMapping("/update/{id}")
	public Doner updateDonor(@PathVariable Long id, @RequestBody Doner donor) {
        return donorService.updateDonor(id, donor);
    }
	
	@GetMapping("/findByCategory")
	public List<Doner> getDonors(@RequestParam(required = false) String bloodGroup,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) Integer contactNumber){
		 return donorService.findByCategory(bloodGroup, city, contactNumber);
		
	}
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<String> removeDonor(@PathVariable Long id) {
		donorService.removeDonor(id);
		return ResponseEntity.ok("Deleted successfully");
		
	}
	
	@GetMapping("/getDonorById/{id}")
	public Doner getDonorById(@PathVariable Long id) {
	    return donorService.getDonorById(id);
	   
	}

}
