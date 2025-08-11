package com.spring.controller;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.spring.entities.School;
import com.spring.services.SchoolService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/schools")
@Slf4j
public class SchoolController {

    @Autowired
    private SchoolService schoolService;

    @PostMapping("/saveSchool")	
    public School saveSchool(@RequestBody School school) {
        return schoolService.save(school);
    }

    @GetMapping
    public List<School> getAll() {
        return schoolService.findAll();
    }

    @GetMapping("/getSchoolById/{id}")
    public School getSchoolById(@PathVariable Long id) {
        return schoolService.findById(id);
    }

    @PutMapping("/updateSchoolById/{id}")
    public School updateSchoolById(@PathVariable Long id, @RequestBody School school) {
        return schoolService.update(id, school);
    }

    @PatchMapping("/patchUpdateSchoolById/{id}")
    public School patchUpdateSchoolById(@PathVariable Long id,
    		@RequestParam(required = false) String name,
    		@RequestParam(required = false) String address) {
        return schoolService.patchUpdateSchoolById(id, name);
    }


    @DeleteMapping("/deleteSchoolById/{id}")
    public String deleteSchoolById(@PathVariable Long id) {
        schoolService.deleteSchoolById(id);
        return "Deleted Successfully";
    }

    @GetMapping("/by-name/{name}")
    public List<School> getByName(@PathVariable String name) {
        return schoolService.findBySchoolName(name);
    }
    @GetMapping("/by-address/{address}")
    public List<School> getByAddress(@PathVariable String address) {
        return schoolService.findBySchoolAddress(address);
    }
}