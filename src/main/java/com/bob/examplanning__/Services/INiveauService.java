package com.bob.examplanning__.Services;

import com.bob.examplanning__.Models.Groupe;
import com.bob.examplanning__.Models.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface INiveauService {
    public void addNiveau(Niveau niveau);

    public void updateNiveau(Niveau niveau);

    public List<Niveau> getAllNiveaux();

    public void deleteNiveau(Long id);

    public Niveau getNiveauById(Long id);
}
