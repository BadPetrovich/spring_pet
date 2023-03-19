package com.badpetrovich.spring.spring_pet.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="sections")
public class Section {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "section")
    private String section;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinTable(name = "client_section", joinColumns = @JoinColumn(name = "section_id")
                                        ,inverseJoinColumns = @JoinColumn(name = "client_id"))
    private List<Client> clients;

    public Section() {
    }

    public Section(String section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", clients=" + clients +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
