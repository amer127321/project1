package com.example.project.repository;

import com.example.project.pojo.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByCarShopId(Long car_id);
    Optional<Car> findByIdAndCarShopId(Long id, Long car_id);
}
