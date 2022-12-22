package com.example.demospring.controller;

import com.example.demospring.entity.Personne;
import com.example.demospring.entity.Produit;
import com.example.demospring.interfaces.IDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/produit")
public class ProduitController {
    @Autowired
    @Qualifier("produitService")
    private IDAO produitService;
    @GetMapping("/")
    public List<Produit> getProduits()
    {
        return produitService.getProduits();
    }

    @GetMapping("/create")
    public void creeProd()
    {
        Produit mon_prod = new Produit("fiouf","ref A",new Date("12/01/2020"),1440,14);
        produitService.begin();
        produitService.create(mon_prod);
        produitService.envoie();
        produitService.close();
        System.out.println("test");
    }

    @PostMapping("/post")
    public Produit postProduit(@RequestParam String marque, String reference, Date dataAchat, double prix, int stock){
        return new Produit(marque,reference,dataAchat,prix,stock);
    }

    /*
    @PostMapping("/post")
    public void createProd()
    {
        produitService.begin();
        produitService.create(new Produit(1,"peugeot","ref truc",new Date("2015/01/02"),1200,42));
        produitService.create(new Produit(2,"citroen","ref machin",new Date(),1244,1));
        produitService.create(new Produit(3,"ford","ref bidule",new Date("2020/07/12"),12000,45));
        produitService.create(new Produit(4,"lada","ref chouette",new Date(),2400,120));
        produitService.create(new Produit(5,"fiat","ref bidule",new Date("2020/07/12"),1,45));
        produitService.create(new Produit(6,"ford","ref chouette",new Date(),124,120));
        produitService.create(new Produit(7,"ford","ref bidule",new Date("2017/07/12"),12000,45));
        produitService.create(new Produit(8,"lada","ref broudille",new Date("2012/01/14"),12,120));
        produitService.envoie();
    }*/
}
