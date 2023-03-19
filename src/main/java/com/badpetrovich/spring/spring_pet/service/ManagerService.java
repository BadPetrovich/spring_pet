package com.badpetrovich.spring.spring_pet.service;

import com.badpetrovich.spring.spring_pet.entity.Client;
import com.badpetrovich.spring.spring_pet.entity.Section;

import java.util.List;

public interface ManagerService {

    public List<Client> getAllClients();

    public List<Section> getAllSections();

    public void saveClient(Client employee);

    public void saveSection(Section section);

    public Client getClient(int id);

    public Section getSection(int id);

    public void addAllClientsToSection(int id);

    public void addClientToSection(int idSection,int idClient);

    public void addAllSectionsToClient(int id);

    public void addSectionToClient(int idSection,int idClient);

    public void deleteClient(int id);

    public void deleteSection(int id);

    public List<Client> findAllByName(String name);

    public List<Section> findAllBySection(String section);

    public List<Client> findAllByStatus(String status);
}
