package com.example.project.repository;

import com.example.project.pojo.CarShop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarShopRepository extends JpaRepository<CarShop, Long> {

}
