package com.badpetrovich.spring.spring_pet.controller;

import com.badpetrovich.spring.spring_pet.entity.Client;
import com.badpetrovich.spring.spring_pet.entity.Section;
import com.badpetrovich.spring.spring_pet.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class RESTController {

    @Autowired
    private ManagerService managerService;

    @GetMapping("clients")
    public List<Client> showAllClients(){
        List<Client> allClients = managerService.getAllClients();
        return allClients;
    }

    @GetMapping("sections")
    public List<Section> showAllSections(){
        List<Section> allSections = managerService.getAllSections();
        return allSections;
    }

    @GetMapping("clients/{id}")
    public Client getClient (@PathVariable int id){
        Client client = managerService.getClient(id);

        return client;
    }

    @GetMapping("sections/{id}")
    public Section getSection (@PathVariable int id){
        Section section = managerService.getSection(id);

        return section;
    }

    @PostMapping("clients/{id}")
    public void saveAllSectionsToClient (@PathVariable int id){

        managerService.addAllSectionsToClient(id);

    }

    @PostMapping("sections/{id}")
    public void saveAllClientsToSection (@PathVariable int id){

        managerService.addAllClientsToSection(id);

    }

    @PostMapping("clients/{idSection}/{idClient}")
    public void saveSectionToToClient (@PathVariable int idSection, @PathVariable int idClient){

        managerService.addSectionToClient(idSection, idClient);

    }

    @PostMapping("sections/{idClient}/{idSection}")
    public void saveClientToToSection(@PathVariable int idClient, @PathVariable int idSection){

        managerService.addClientToSection(idClient, idSection);

    }

    @PostMapping("clients")
    public Client addNewClient(@RequestBody Client client){
        managerService.saveClient(client);
        return client;
    }

    @PostMapping("sections")
    public Section addNewSection(@RequestBody Section section){
        managerService.saveSection(section);
        return section;
    }

    @PutMapping("clients")
    public Client updateClient(@RequestBody Client client){
        managerService.saveClient(client);
        return client;
    }

    @PutMapping("sections")
    public Section updateSection(@RequestBody Section section){
        managerService.saveSection(section);
        return section;
    }

    @DeleteMapping("clients/{id}")
    public String deleteClient(@PathVariable int id){
        managerService.deleteClient(id);
        return "Client with ID = " + id + " was deleted";
    }


    @DeleteMapping("sections/{id}")
    public String deleteSection(@PathVariable int id){
        managerService.deleteSection(id);
        return "Section with ID = " + id + " was deleted";
    }

    @GetMapping("clients/name/{name}")
    public List<Client> showAllClientsByName(@PathVariable String name){
        List<Client> clients = managerService.findAllByName(name);
        return clients;
    }

    @GetMapping("clients/section/{section}")
    public List<Section> showCurrentSection(@PathVariable String section){

        List<Section> sections = managerService.findAllBySection(section);
        return sections;

    }

    @GetMapping("clients/status/{status}")
    public List<Client> showCurrentStatus(@PathVariable String status){

        List<Client> statuses = managerService.findAllByStatus(status);
        return statuses;

    }


}