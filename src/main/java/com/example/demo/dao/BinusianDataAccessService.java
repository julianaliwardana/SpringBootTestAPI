package com.example.demo.dao;

import com.example.demo.model.Binusian;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class BinusianDataAccessService implements BinusianData {
    @Override
    public int insertPerson(UUID id, Binusian binusian) {
        return 0;
    }

    @Override
    public List<Binusian> selectAllPeople() {
        return List.of(new Binusian(UUID.randomUUID(), "Julian ALifirman Wardana", 2440065264L, 20, "Bandung"));
    }

    @Override
    public Optional<Binusian> selectPersonById(UUID id) {
        return Optional.empty();
    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Binusian binusian) {
        return 0;
    }
}
