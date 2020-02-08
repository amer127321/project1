package com.example.project.service;

import com.example.project.pojo.Car;
import com.example.project.pojo.CarShop;
import com.example.project.repository.CarRepository;
import com.example.project.repository.CarShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarShopService implements FakeCarShopService {
    @Autowired
    CarShopRepository repository;
    @Autowired
    CarRepository carRepository;

    public List<CarShop> getAllCarShops()
    {
        List<CarShop> carShopsList = repository.findAll();

        if(carShopsList.size() > 0) {
            return carShopsList;
        } else {
            return new ArrayList<CarShop>();
        }
    }
    public List<Car> getAllCars()
    {
        List<Car> carsList = carRepository.findAll();

        if(carsList.size() > 0) {
            return carsList;
        } else {
            return new ArrayList<Car>();
        }
    }

    public CarShop getCarShopById(Long id) throws RecordNotFoundException
    {
        Optional<CarShop> carShop = repository.findById(id);

        if(carShop.isPresent()) {
            return carShop.get();
        } else {
            throw new RecordNotFoundException("No shop record exist for given id");
        }
    }

    public Car getCarById(Long id) throws RecordNotFoundException
    {
        Optional<Car> car = carRepository.findById(id);

        if(car.isPresent()) {
            return car.get();
        } else {
            throw new RecordNotFoundException("No car record exist for given id");
        }
    }

    public void deleteCarShopById(Long id) throws RecordNotFoundException
    {
        Optional<CarShop> carShop = repository.findById(id);

        if(carShop.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No shop record exist for given id");
        }
    }

    public void deleteCarById(Long id) throws RecordNotFoundException
    {
        Optional<Car> car = carRepository.findById(id);

        if(car.isPresent())
        {
            carRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No car record exist for given id");
        }
    }

    public CarShop createCarShop(CarShop carShop) {
        return repository.save(carShop);
    }

    public Optional<Car> createCar(Long id, Car car) {
        return repository.findById(id).map(cars -> {
            car.setCarShop(cars);
            return carRepository.save(car);
        });
    }
}
