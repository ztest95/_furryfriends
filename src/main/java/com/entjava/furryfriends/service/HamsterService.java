package com.entjava.furryfriends.service;

import com.entjava.furryfriends.model.Hamster;
import com.entjava.furryfriends.repository.HamsterRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class HamsterService {
    @Autowired
    private HamsterRepository hamsterRepository;

    public List<Hamster> findAllHamsters() {
        return hamsterRepository.findAll();
    }

    public Hamster saveHamster(Hamster hamster) {
        return hamsterRepository.save(hamster);
    }

    public void deleteHamster(Long id) {
        hamsterRepository.deleteById(id);
    }
}

