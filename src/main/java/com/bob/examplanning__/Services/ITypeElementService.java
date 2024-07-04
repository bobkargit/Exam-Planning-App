package com.bob.examplanning__.Services;


import com.bob.examplanning__.Models.TypeElement;


import java.util.List;

public interface ITypeElementService {
    public void addtype(TypeElement type);

    public void updatetype(TypeElement type);

    public List<TypeElement> getAlltypes();

    public void deletetype(Long id);

    public TypeElement gettypeById(Long id);
}
