package application.service;

import application.model.Farm;

import java.util.List;

public interface FarmService {

    void add(Farm farm);

    Farm findById(Integer id);

    List<Farm> findAll();

    void update(Farm farm);

    void deleteById(Integer id);
}
