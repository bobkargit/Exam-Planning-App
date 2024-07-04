package com.bob.examplanning__.Services;

import com.bob.examplanning__.Models.ElementPedago;
import com.bob.examplanning__.Models.User;

import java.util.List;

public interface IElementService {
    public void addElement(ElementPedago elementPedago);

    public void updateElement(ElementPedago elementPedago);

    public List<ElementPedago> getAllElements();

    public void deleteElement(Long id);

    public ElementPedago getElementById(Long id);
}
