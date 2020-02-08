package com.example.project.pojo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "car_shop")
public class CarShop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "carShop")
    private List<Car> cars;

    public CarShop() {
    }

    public CarShop(String name, List<Car> cars){
        this.name = name;
        this.cars = cars;
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

    public List<Car> getCars() { return cars;}
}
