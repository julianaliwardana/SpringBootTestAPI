package com.example.demo.service;

import com.example.demo.dao.BinusianData;
import com.example.demo.model.Binusian;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BinusianService {

    private final BinusianData binusianData;

    @Autowired
    public BinusianService(@Qualifier("postgres") BinusianData binusianData) {
        this.binusianData = binusianData;
    }

    public int addPerson(Binusian binusian) {
        return binusianData.insertPerson(binusian);
    }

    public Optional<Binusian> getPersonById(UUID id) {
        return binusianData.selectPersonById(id);
    }

    public List<Binusian> getAllPeople() {
        return binusianData.selectAllPeople();
    }

    public int deletePerson(UUID id) {
        return binusianData.deletePersonById(id);
    }

    public int updatePerson(UUID id, Binusian newBinusian) {
        return binusianData.updatePersonById(id, newBinusian);
    }

}
