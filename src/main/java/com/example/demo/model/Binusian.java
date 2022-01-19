package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Binusian {
    private final UUID id;

    private final String name;

    private final Long nim;

    private final Integer age;

    private final String address;

    public Binusian(@JsonProperty("id") UUID id,
                    @JsonProperty("name") String name,
                    @JsonProperty("nim") Long nim,
                    @JsonProperty("age") Integer age,
                    @JsonProperty("address") String address) {
        this.id = id;
        this.name = name;
        this.nim = nim;
        this.age = age;
        this.address = address;
    }

    public UUID getId() { return id; }

    public String getName() { return name; }

    public Long getNim() { return nim; }

    public Integer getAge() { return age; }

    public String getAddress() { return address; }
}
