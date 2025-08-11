package com.spring.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entities.*;
import com.spring.repo.*;

import java.util.*;

@Service
public class SchoolServiceImp implements SchoolService {

    @Autowired
    private SchoolRepo schoolRepo;

    @Override
    public School save(School school) {
        return schoolRepo.save(school);
    }

    @Override
    public List<School> findAll() {
        return schoolRepo.findAll();
    }

    @Override
    public School findById(Long id) {
        return schoolRepo.findById(id).orElse(null);
    }

    @Override
    public School update(Long id, School school) {
        school.setId(id);
        return schoolRepo.save(school);
    }

    @Override
    public School patchUpdateSchoolById(Long id, String schoolName) {
        School existing = schoolRepo.findById(id).orElse(null);
        if (existing != null) {
            existing.setSchoolName(schoolName);
            return schoolRepo.save(existing);
        }
        return null;
    }

    @Override
    public void deleteSchoolById(Long id) {
        schoolRepo.deleteById(id);
    }

	@Override
	public List<School> findBySchoolName(String name) {
		return null;
	}

	@Override
	public List<School> findBySchoolAddress(String address) {
		return null;
	}
}