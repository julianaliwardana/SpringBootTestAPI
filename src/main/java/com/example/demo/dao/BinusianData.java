package com.example.demo.dao;

import com.example.demo.model.Binusian;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BinusianData {
    int insertPerson(UUID id, Binusian binusian);

    default int insertPerson(Binusian binusian) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, binusian);
    }

    List<Binusian> selectAllPeople();

    Optional<Binusian> selectPersonById(UUID id);

    int deletePersonById(UUID id);

    int updatePersonById(UUID id, Binusian binusian);

}
