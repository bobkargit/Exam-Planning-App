package com.bob.examplanning__.Services;

import com.bob.examplanning__.Models.typeExam;

import java.util.List;

public interface ITypeExamService {
    public void addtype(typeExam type);

    public void updatetype(typeExam type);

    public List<typeExam> getAlltypes();

    public void deletetype(Long id);

    public typeExam gettypeById(Long id);
}
