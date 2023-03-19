package com.badpetrovich.spring.spring_pet.dao;

import com.badpetrovich.spring.spring_pet.entity.Client;
import com.badpetrovich.spring.spring_pet.entity.Section;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    public List<Client> findAllByName(String name);

    public List<Client> findAllByStatus(String status);


//    public List<Section> addSectionToClient(Section section);
}
