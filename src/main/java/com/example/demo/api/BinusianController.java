package com.example.demo.api;

import com.example.demo.model.Binusian;
import com.example.demo.service.BinusianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class BinusianController {

    private final BinusianService binusianService;

    @Autowired
    public BinusianController(BinusianService binusianService) {
        this.binusianService = binusianService;
    }

    @PostMapping
    public void addPerson(@NonNull @RequestBody Binusian binusian) {
        binusianService.addPerson(binusian);
    }

    @GetMapping
    public List<Binusian> getAllPeople() {
        return binusianService.getAllPeople();
    }

    @GetMapping(path = "{id}")
    public Binusian getPersonById(@PathVariable("id") UUID id) {
        return binusianService.getPersonById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id) {
        binusianService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id, @NonNull @RequestBody Binusian binusianToUpdate) {
        binusianService.updatePerson(id, binusianToUpdate);
    }
}
