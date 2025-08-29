package com.example.user.Service;

import java.util.List;

import com.example.user.Entities.RequestBlood;

public interface RequestBloodService {
	RequestBlood saveRequest(RequestBlood requestBlood);
    List<RequestBlood> getAllRequests();
    RequestBlood getRequestById(Long id);
    RequestBlood updateRequest(Long id, RequestBlood requestBlood);
    void deleteRequest(Long id);

	
	
}
