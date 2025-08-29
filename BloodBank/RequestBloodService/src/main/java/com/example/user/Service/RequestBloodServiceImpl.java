package com.example.user.Service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.user.Entities.RequestBlood;
import com.example.user.Repository.RequestBloodRepository;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor 
public class RequestBloodServiceImpl implements RequestBloodService{
	private final RequestBloodRepository requestBloodRepository;
    public RequestBlood saveRequest(RequestBlood requestBlood) {
        return requestBloodRepository.save(requestBlood);
    }
    public List<RequestBlood> getAllRequests() {
        return requestBloodRepository.findAll();
    }
    public RequestBlood getRequestById(Long id) {
        return requestBloodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Request not found with id: " + id));
    }

    public RequestBlood updateRequest(Long id, RequestBlood requestBlood) {
        RequestBlood existing = getRequestById(id);
        existing.setPatientName(requestBlood.getPatientName());
        existing.setBloodGroup(requestBlood.getBloodGroup());
        existing.setQuantity(requestBlood.getQuantity());
        existing.setHospitalName(requestBlood.getHospitalName());
        existing.setStatus(requestBlood.getStatus());
        return requestBloodRepository.save(existing);
    }

    public void deleteRequest(Long id) {
        requestBloodRepository.deleteById(id);
    }
}
	


