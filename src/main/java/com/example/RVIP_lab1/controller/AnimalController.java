package com.example.RVIP_lab1.controller;
import com.example.RVIP_lab1.service.AnimalService;
import com.example.RVIP_lab1.model.Animal;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    private final AnimalService service;

    public AnimalController(AnimalService service) {
        this.service = service;
    }

    @PostMapping("/checkin")
    public Animal checkInAnimal(@RequestBody Animal animal) {
        return service.checkInAnimal(animal);
    }

    @PutMapping("/extend/{id}")
    public Animal extendStay(@PathVariable Long id, @RequestParam String newDate) {
        LocalDate newCheckOutDate = LocalDate.parse(newDate);
        return service.extendStay(id, newCheckOutDate);
    }

    @PutMapping("/checkout/{id}")
    public Animal checkOutAnimal(@PathVariable Long id) {
        return service.checkOutAnimal(id);
    }

    @GetMapping("/in-hotel")
    public List<Animal> getAnimalsInHotel() {
        return service.getAnimalsInHotel();
    }

    @GetMapping("/checked-out")
    public List<Animal> getCheckedOutAnimals() {
        return service.getCheckedOutAnimals();
    }
}

