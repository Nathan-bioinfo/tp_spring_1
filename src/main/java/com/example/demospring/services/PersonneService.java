package com.example.demospring.services;

import com.example.demospring.entity.Personne;
import com.example.demospring.interfaces.IpersonneService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class PersonneService implements IpersonneService {
    @Override
    public List<Personne> getPersonnes() {
        return Arrays.asList(new Personne(1,"Charles","Pasqua"),new Personne(2,"Jacques","Attali"));
    }
}
