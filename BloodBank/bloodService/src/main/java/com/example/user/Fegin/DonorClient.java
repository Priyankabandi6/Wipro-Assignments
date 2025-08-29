package com.example.user.Fegin;
import java.util.List;
import java.util.Optional;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.user.Entites.Blood;
import com.example.user.dto.Doner;
@FeignClient(name = "donor-service", url = "http://localhost:8080/api/v1/donors")
public interface DonorClient {
    @GetMapping("/getDonorById/{id}")
    Doner getDonorById(@PathVariable("id") Long id);
}

