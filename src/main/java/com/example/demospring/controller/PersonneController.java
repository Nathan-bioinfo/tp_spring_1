package com.example.demospring.controller;

import com.example.demospring.entity.Personne;
import com.example.demospring.interfaces.IpersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/personne")
public class PersonneController {
    @Autowired
    // ici tu peux mettre personneService2 ou personneService
    @Qualifier("personneService2")
    private IpersonneService personneService;
    @GetMapping("")
    /*public String getPersonnes(){
        return("Une liste de personne");
    }*/
    public List<Personne> getPersonnes()
    {
        return  personneService.getPersonnes();
    }
    @PostMapping("/post")
    public String pagePost(){
        return("Creation d'une personne");
    }
    @GetMapping("/{id}")
    public String getPersonne(@PathVariable Integer id){
        return("Une seule personne avec l'id : " + id);
    }

    @PostMapping("/post1")
    public Personne postPersonne(@RequestBody Personne personne){
        return personne;
    }

    @PostMapping("/post2")
    public Personne postPersonne(@RequestParam String nom, @RequestParam String prenom){
        return new Personne(1,nom,prenom);
    }
}
