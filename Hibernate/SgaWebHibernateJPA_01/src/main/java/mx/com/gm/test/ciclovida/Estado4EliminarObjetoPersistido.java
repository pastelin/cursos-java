package mx.com.gm.test.ciclovida;

import javax.persistence.*;
import mx.com.gm.domain.Contacto;

public class Estado4EliminarObjetoPersistido {

    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();
        
        //definimos la varibale
        Contacto contacto = null;
        
        //recuperamos el objeto
        //1. transitivo
        contacto = em.find(Contacto.class, 3);
        
        em.getTransaction().begin();
        
        //Remove
        em.remove(em.merge(contacto));
        
        em.getTransaction().commit();
        
        //3. transitivo
        System.out.println("Contacto: " + contacto);
        
        
    }
    
}
