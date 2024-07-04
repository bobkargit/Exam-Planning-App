package com.bob.examplanning__.Services.Impl;

import com.bob.examplanning__.Models.TypeElement;
import com.bob.examplanning__.Repository.TypeElementRepository;
import com.bob.examplanning__.Services.ITypeElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeElementService implements ITypeElementService {
    @Autowired
    private TypeElementRepository typeElementRepository;

    @Override
    public void addtype(TypeElement type) {
        typeElementRepository.save(type);
    }

    @Override
    public void updatetype(TypeElement type) {

    }

    @Override
    public List<TypeElement> getAlltypes() {
        return typeElementRepository.findAll();
    }

    @Override
    public void deletetype(Long id) {
         typeElementRepository.deleteById(id);
    }

    @Override
    public TypeElement gettypeById(Long id) {
        return typeElementRepository.findById(id).orElse(null);
    }
}
