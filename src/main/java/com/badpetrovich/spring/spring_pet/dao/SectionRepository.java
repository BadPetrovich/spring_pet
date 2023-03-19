package com.badpetrovich.spring.spring_pet.dao;

import com.badpetrovich.spring.spring_pet.entity.Client;
import com.badpetrovich.spring.spring_pet.entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SectionRepository extends JpaRepository<Section, Integer> {

    public List<Section> findAllBySection(String section);

//    public void addClientToSection(Client client);

}
