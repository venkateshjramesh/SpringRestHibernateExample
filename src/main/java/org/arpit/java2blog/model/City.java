package org.arpit.java2blog.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by rameve02 on 08-04-2017.
 */
@Entity
@Table(name="CITY")
public class City {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;

    @Column(name="name")
    String name;

    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "country_id")
    Country country;

    public City() {
        super();
    }

    public City(Integer id, String name, Country country) {
        super();
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country=" + country +
                '}';
    }
}
