package org.example.task.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "country", nullable = false)
    private String country;

//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "store")
//    private Set<Boutique> boutique;

    public Store() {
    }

    public Store(String name, String country) {
        this.name = name;
        this.country = country;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
