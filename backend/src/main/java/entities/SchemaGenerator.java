package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SchemaGenerator {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sebastian");
        EntityManager em = emf.createEntityManager();

    }
}
