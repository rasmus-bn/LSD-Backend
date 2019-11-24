package logic;

import javax.persistence.EntityManager;

public class User {
    public contract.dto.User authUser(EntityManager em, contract.dto.User user){
        try {
            return em.createQuery("SELECT U FROM User U WHERE U.userName = :username AND U.password = :password", entities.dto.User.class)
                    .setParameter("username", user.getUserName())
                    .setParameter("password", user.getPassword())
                    .getSingleResult().toDto();
        }catch (Exception e){
            return null;
        }
    }
}
