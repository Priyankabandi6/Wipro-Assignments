package com.spring.services;
import java.util.List;

import com.spring.entities.*;

public interface SchoolService {
    School save(School school);
    List<School> findAll();
    School findById(Long id);
    School update(Long id, School school);
    School patchUpdateSchoolById(Long id, String schoolName);
    void deleteSchoolById(Long id);
	List<School> findBySchoolName(String name);
	List<School> findBySchoolAddress(String address);

}


