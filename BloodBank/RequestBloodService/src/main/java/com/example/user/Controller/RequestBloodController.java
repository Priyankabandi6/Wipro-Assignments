package com.example.user.Controller;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.user.Entities.RequestBlood;
import com.example.user.Service.RequestBloodService;
@RestController
@RequestMapping("/api/request-blood")
public class RequestBloodController {
	
	private final RequestBloodService requestBloodService;
	
	public RequestBloodController(RequestBloodService requestBloodService) {
        this.requestBloodService = requestBloodService;
    }

    @PostMapping
    public RequestBlood createRequest(@RequestBody RequestBlood requestBlood) {
        return requestBloodService.saveRequest(requestBlood);
    }

    @GetMapping
    public List<RequestBlood> getAllRequests() {
        return requestBloodService.getAllRequests();
    }

    @GetMapping("/{id}")
    public RequestBlood getRequestById(@PathVariable Long id) {
        return requestBloodService.getRequestById(id);
    }

    @PutMapping("/{id}")
    public RequestBlood updateRequest(@PathVariable Long id, @RequestBody RequestBlood requestBlood) {
        return requestBloodService.updateRequest(id, requestBlood);
    }

    @DeleteMapping("/{id}")
    public String deleteRequest(@PathVariable Long id) {
        requestBloodService.deleteRequest(id);
        return "Request with ID " + id + " deleted successfully";
    }
}
	


