package com.example.demospring.entity;
import javax.persistence.*;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Produit {
    @Id
    @GeneratedValue
    private int id;
    private String marque;
    private String reference;
    private Date dataAchat;
    private double prix;
    private int stock;

    public Produit(String marque, String reference, Date dataAchat, double prix, int stock) {
        this.id = id;
        this.marque = marque;
        this.reference = reference;
        this.dataAchat = dataAchat;
        this.prix = prix;
        this.stock = stock;
    }
    public Produit(){};
}
