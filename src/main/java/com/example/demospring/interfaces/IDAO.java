package com.example.demospring.interfaces;

import com.example.demospring.entity.Personne;
import com.example.demospring.entity.Produit;

import java.util.Date;
import java.util.List;

public interface IDAO<T>{
    void begin();
    boolean create(T o);
    boolean update(T o);
    boolean delete(T o);
    T findById(int id);
    /*
    List<T> findAll();
    List<T> findAboveValue(double value);
    List<T> findBetweenDates(Date date1, Date date2);
    double findByBrand(String p_marque);
    */
    void envoie();
    void close();
    public List<Produit> getProduits();
}
