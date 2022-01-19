package com.example.demo.dao;

import com.example.demo.model.Binusian;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeData")
public class FakeBinusianDataAccessService implements BinusianData {

    private static List<Binusian> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, @NotNull Binusian binusian) {
        DB.add(new Binusian(id, binusian.getName(), binusian.getNim(), binusian.getAge(), binusian.getAddress()));
        return 0;
    }

    @Override
    public List<Binusian> selectAllPeople() {
        return DB;
    }

    @Override
    public Optional<Binusian> selectPersonById(UUID id) {
        return DB.stream()
                .filter(binusian -> binusian.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Binusian> personMaybe = selectPersonById(id);
        if (personMaybe.isEmpty()) {
            return 0;
        }
        DB.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Binusian update) {
        return selectPersonById(id)
                .map(binusian -> {
                    int indexOfPersonToUpdate = DB.indexOf(binusian);
                    if (indexOfPersonToUpdate >= 0) {
                        DB.set(indexOfPersonToUpdate, new Binusian(id, update.getName(), update.getNim(), update.getAge(), update.getAddress()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
