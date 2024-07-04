package com.bob.examplanning__.Services;

import com.bob.examplanning__.Models.Examen;
import com.bob.examplanning__.Models.Surveillance;

import java.util.List;

public interface IExamService {

    public void addExam(Examen examen);

    public void updateExam(Examen examen);

    public List<Examen> getAllExams();

    public void deleteExam(Long id);

    public Examen getExamById(Long id);
}
