package com.example.user.Reposirty;
import java.util.List;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import com.example.user.Entities.Doner;
public interface DonerRepo extends JpaRepositoryImplementation<Doner, Long> {
	
	List<Doner> findByBloodGroup(String bloodGroup);
	List<Doner> findByCity(String city);
	List<Doner> findByContactNumber(Integer contactNumber);
	Doner getDonorById(Long id);
	List<Doner> findByBloodGroupAndCityAndContactNumber(String bloodGroup, String city, Integer contactNumber);
	List<Doner> findByBloodGroupAndCity(String bloodGroup, String city);
	
}
