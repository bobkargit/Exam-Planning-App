package com.bob.examplanning__.Services.Impl;

import com.bob.examplanning__.Models.Semester;
import com.bob.examplanning__.Repository.SemesterRepository;
import com.bob.examplanning__.Services.ISemesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SemesterService implements ISemesterService {

    @Autowired
    private SemesterRepository semesterRepository;

    @Override
    public void addSemester(Semester semester) {

    }

    @Override
    public void updateSemester(Semester semester) {

    }

    @Override
    public List<Semester> getAllSemester() {
        return semesterRepository.findAll();
    }

    @Override
    public void deleteSemester(Long id) {

    }

    @Override
    public Semester getSemesterById(Long id) {
        return null;
    }
}
