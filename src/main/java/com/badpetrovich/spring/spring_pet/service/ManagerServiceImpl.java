package com.badpetrovich.spring.spring_pet.service;

import com.badpetrovich.spring.spring_pet.dao.ClientRepository;
import com.badpetrovich.spring.spring_pet.dao.SectionRepository;
import com.badpetrovich.spring.spring_pet.entity.Client;
import com.badpetrovich.spring.spring_pet.entity.Section;
import net.minidev.json.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ManagerServiceImpl implements ManagerService{

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private SectionRepository sectionRepository;

    @Override
    public List<Client> getAllClients() {

        return clientRepository.findAll();

    }

    @Override
    public List<Section> getAllSections() {
        return sectionRepository.findAll();
    }

    @Override
    public void saveClient(Client client) {

        clientRepository.save(client);

    }

    @Override
    public void saveSection(Section section) {

        sectionRepository.save(section);

    }

    @Override
    public Client getClient(int id) {

        Client client = null;
        Optional<Client> optional = clientRepository.findById(id);
        if (optional.isPresent()){
            client = optional.get();
        }
        else {
            System.out.println("This id: "+ id +" does not exist");
        }
        return client;

    }

    @Override
    public Section getSection(int id) {

        Section section = null;
        Optional<Section> optional = sectionRepository.findById(id);
        if (optional.isPresent()){
            section = optional.get();
        }
        else {
            System.out.println("This id: " + id + " does not exist");
        }
        return section;

    }

    @Override
    public void addAllClientsToSection(int id) {

        List<Client> clients = clientRepository.findAll();
        Optional<Section> section = sectionRepository.findById(id);
        if(section.isPresent()){
            section.get().setClients(clients);
            sectionRepository.save(section.get());
        }
        else {
            System.out.println("This id: " + id + " does not exist");
        }

    }

    @Override
    public void addClientToSection(int idClient,int idSection) {

        Optional<Client> client = clientRepository.findById(idClient);
        Optional<Section> section = sectionRepository.findById(idSection);
        if (client.isPresent() && section.isPresent()){
            section.get().getClients().add(client.get());
            sectionRepository.save(section.get());
        }
        else {
            System.out.println("ID mistake try another");
        }

    }

    @Override
    public void addAllSectionsToClient(int id) {

       List<Section> sections = sectionRepository.findAll();
       Optional<Client> client = clientRepository.findById(id);
       if(client.isPresent()){
           client.get().setSections(sections);
           clientRepository.save(client.get());
       }
       else {
           System.out.println("This id: " + id + " does not exist");
       }

    }

    @Override
    public void addSectionToClient(int idSection,int idClient) {

        Optional<Section> section = sectionRepository.findById(idSection);
        Optional<Client> client = clientRepository.findById(idClient);
        if (section.isPresent() && client.isPresent()){
            client.get().getSections().add(section.get());
            clientRepository.save(client.get());
        }
        else {
            System.out.println("ID mistake try another");
        }

    }


    @Override
    public void deleteClient(int id) {

        clientRepository.deleteById(id);

    }

    @Override
    public void deleteSection(int id) {

        sectionRepository.deleteById(id);

    }

    @Override
    public List<Client> findAllByName(String name) {

        List<Client> clients = clientRepository.findAllByName(name);
        return clients;

    }

    @Override
    public List<Section> findAllBySection(String section) {

        List<Section> sections = sectionRepository.findAllBySection(section);
        return sections;

    }

    @Override
    public List<Client> findAllByStatus(String status) {

        List<Client> statuses = clientRepository.findAllByStatus(status);
        return statuses;

    }

}
