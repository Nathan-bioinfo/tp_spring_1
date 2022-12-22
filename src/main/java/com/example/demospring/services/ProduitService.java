package com.example.demospring.services;
import com.example.demospring.entity.Personne;
import com.example.demospring.entity.Produit;
import com.example.demospring.interfaces.IDAO;
import javax.persistence.*;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class ProduitService implements IDAO<Produit> {
    @Override
    public List<Produit> getProduits() {
        return Arrays.asList(new Produit("ford","ref A",new Date("12/01/2020"),1440,14),new Produit("fiat","ref B",new Date("12/01/1984"),2,1));
    }
    private EntityManagerFactory emf;
    private EntityManager em;
    public ProduitService(){
        emf = Persistence.createEntityManagerFactory("demospring_p");
        em = emf.createEntityManager();
    }
    @Override
    public void begin() {
        em.getTransaction().begin();
        System.out.println("Demarrage de la persistence");
    }

    @Override
    public boolean create(Produit o) {
        em.persist(o);
        return true;
    }

    @Override
    public boolean update(Produit o) {
        em.persist(o);
        return true;
    }

    @Override
    public boolean delete(Produit o) {
        em.remove(o);
        return false;
    }

    @Override
    public Produit findById(int id) {
        return em.find(Produit.class,id);
    }

    /*@Override
    public List<Produit> findAll() {
        Query query = em.createQuery("select p from Produit p");
        List<Produit> list = query.getResultList();
        return list;
    }

    @Override
    public List<Produit> findAboveValue(double p_value) {
        Query query = em.createQuery("select p from Produit p where p.prix >:value");
        query.setParameter("value",p_value);
        List<Produit> list = query.getResultList();
        return list;
    }

    @Override
    public List<Produit> findBetweenDates(Date p_date1, Date p_date2) {
        Query query = em.createQuery("select p from Produit p where p.dataAchat >:date_1 and p.dataAchat <:date_2");
        query.setParameter("date_1",p_date1);
        query.setParameter("date_2",p_date2);
        List<Produit> list = query.getResultList();
        return list;
    }

    @Override
    public double findByBrand(String p_marque) {
        Query query = em.createQuery("select sum(prix) from Produit p where p.marque =:marque");
        query.setParameter("marque",p_marque);
        double tot = (double) query.getSingleResult();
        return tot;
    }
    */
    @Override
    public void envoie() {
        em.getTransaction().commit();
    }

    @Override
    public void close() {
        em.close();
        emf.close();
    }
}
