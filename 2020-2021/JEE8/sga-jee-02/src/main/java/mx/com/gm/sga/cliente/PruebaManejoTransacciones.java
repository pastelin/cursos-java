package mx.com.gm.sga.cliente;

import javax.naming.*;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.servicio.PersonaServiceRemote;
import org.apache.logging.log4j.*;

public class PruebaManejoTransacciones {

    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        
        try {
            
            Context jndi = new InitialContext();
            PersonaServiceRemote personaService = (PersonaServiceRemote) jndi.lookup("java:global/sga-jee-web-v8/PersonaServicioImpl!mx.com.gm.sga.servicio.PersonaServiceRemote");
            
            log.debug("Iniciando prueba Manejo transaccional PersonaService");
            
            //buscar un objeto persona
            Persona persona1 = personaService.encontrarPersonaPorId(new Persona(2));
            log.debug("Persona encontrada: " + persona1);
            
            //Cambiar el apellido persona
            persona1.setApellido("Cambio con error ................................................................");
            
            personaService.modificarPersona(persona1);
            log.debug("Objeto modificado: " + persona1);
            log.debug("Fin prueba EJB transaccional");
            
        } catch(NamingException ex) {
            ex.printStackTrace(System.out);
        }
        
    }
    
    
    
}
