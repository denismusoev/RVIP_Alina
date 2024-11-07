package com.example.RVIP_lab1.service;
import com.example.RVIP_lab1.model.Animal;
import org.springframework.stereotype.Service;
import com.example.RVIP_lab1.repository.AnimalRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class AnimalService {

    private final AnimalRepository repository;

    public AnimalService(AnimalRepository repository) {
        this.repository = repository;
    }

    public Animal checkInAnimal(Animal animal) {
        animal.setStatus("IN_HOTEL");
        return repository.save(animal);
    }

    public Animal extendStay(Long id, LocalDate newCheckOutDate) {
        Animal animal = repository.findById(id).orElseThrow();
        animal.setCheckOutDate(newCheckOutDate);
        return repository.save(animal);
    }

    public Animal checkOutAnimal(Long id) {
        Animal animal = repository.findById(id).orElseThrow();
        animal.setStatus("CHECKED_OUT");
        animal.setCheckOutDate(LocalDate.now());
        return repository.save(animal);
    }

    public List<Animal> getAnimalsInHotel() {
        return repository.findAll().stream()
                .filter(a -> "IN_HOTEL".equals(a.getStatus()))
                .toList();
    }

    public List<Animal> getCheckedOutAnimals() {
        return repository.findAll().stream()
                .filter(a -> "CHECKED_OUT".equals(a.getStatus()))
                .toList();
    }
}

