package com.example.user.Fegin;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.user.Entities.Doner;
@FeignClient(name = "DONOR-SERVICE", path = "/donors")
public interface DonerInterface {	
	@PostMapping
    Doner addDonor(@RequestBody Doner donor);
	
    @PutMapping("/{id}")
    Doner updateDonor(@PathVariable("id") Long id, @RequestBody Doner donor);
    
    @GetMapping
    List<Doner> findByCategory(
            @RequestParam(required = false) String bloodGroup,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) int contactNumber);
    
    @DeleteMapping("/delete/{id}")
    void removeDonor(@PathVariable("id") Long id);
    
    @GetMapping("/getDonorById/{id}")
    Doner getDonorById(@PathVariable("id") Long id);   
}
