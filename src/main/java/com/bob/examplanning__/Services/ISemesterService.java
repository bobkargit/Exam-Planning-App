package com.bob.examplanning__.Services;

import com.bob.examplanning__.Models.Semester;

import java.util.List;

public interface ISemesterService {
    public void addSemester(Semester semester);

    public void updateSemester(Semester semester);

    public List<Semester> getAllSemester();

    public void deleteSemester(Long id);

    public Semester getSemesterById(Long id);
}
