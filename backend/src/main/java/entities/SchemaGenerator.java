package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Collection;
import java.util.TimeZone;

public class SchemaGenerator {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sebastian");
        EntityManager em = emf.createEntityManager();
        Collection<Country> countries = new ArrayList<Country>();
        countries.add(new Country("Denmark", TimeZone.getTimeZone("Europe/Copenhagen")));
        countries.add(new Country("Germany", TimeZone.getTimeZone("Europe/Berlin")));
        countries.add(new Country("NewYork", TimeZone.getTimeZone("America/New_York")));

        em.getTransaction().begin();
        for (Country c : countries) {
            em.persist(c);
        }
        em.getTransaction().commit();
    }
}

//    public static void createCountry(EntityManager em, Collection<Country> countries){
//       Country country = em.getReference(Country.class, 201);
//        System.out.println(country.getTimeZone().getID());


