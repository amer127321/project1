package com.example.project.controller;

import com.example.project.pojo.Car;
import com.example.project.pojo.CarShop;
import com.example.project.service.CarShopService;
import com.example.project.service.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class CarshopController {
    @Autowired
    private CarShopService service;

    @GetMapping("/carshops")
    public ResponseEntity<List<CarShop>> getAllCarShops() {
        List<CarShop> list = service.getAllCarShops();

        return new ResponseEntity<List<CarShop>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("carshop/{id}")
    public ResponseEntity<CarShop> getCarShopById(@PathVariable("id") Long id) throws RecordNotFoundException {
        CarShop carShop = service.getCarShopById(id);

        return new ResponseEntity<CarShop>(carShop, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("car/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable("id") Long id) throws RecordNotFoundException {
        Car car = service.getCarById(id);

        return new ResponseEntity<Car>(car, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> carList = service.getAllCars();

        return new ResponseEntity<List<Car>>(carList, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("carshop/{id}")
    public String deleteCarShopById(@PathVariable("id") Long id) throws RecordNotFoundException {
        service.deleteCarShopById(id);
        return "Shop has been deleted successfully!";
    }

    @DeleteMapping("car/{id}")
    public String deleteCarById(@PathVariable("id") Long id) throws RecordNotFoundException {
        service.deleteCarById(id);
        return "Car has been deleted successfully!";
    }

    @PostMapping("/carshop")
    public ResponseEntity<CarShop> createCarShop(@RequestBody CarShop carShop) {
        return ResponseEntity.ok().body(this.service.createCarShop(carShop));
    }

    @PostMapping("/car/{carShopId}")
    public Optional<Car> createCar(@PathVariable(value = "carShopId") Long car_id, @Valid @RequestBody Car car) {
        return service.createCar(car_id, car);
    }

}