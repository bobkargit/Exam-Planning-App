package com.bob.examplanning__.Services.Impl;

import com.bob.examplanning__.Models.typeExam;
import com.bob.examplanning__.Repository.typeExamRepository;
import com.bob.examplanning__.Services.ITypeExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeExamSevice implements ITypeExamService {
    @Autowired
    public typeExamRepository typeExamRepository;

    @Override
    public void addtype(typeExam type) {
        typeExamRepository.save(type);
    }

    @Override
    public void updatetype(typeExam type) {

    }

    @Override
    public List<typeExam> getAlltypes() {
        return typeExamRepository.findAll();
    }

    @Override
    public void deletetype(Long id) {
        typeExamRepository.deleteById(id);
    }

    @Override
    public typeExam gettypeById(Long id) {
        return typeExamRepository.findById(id).orElse(null);
    }
}
