package com.certificatic.jersey;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.certificatic.dao.PersonaDAO;
import com.certificatic.dao.PersonaDAOImpl;
import com.certificatic.model.Alumno;
import com.certificatic.model.Respuesta;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("alumnos")
public class MyResource {
	private PersonaDAO personaDao =  new PersonaDAOImpl();
	

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    /*@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it Giselle!";
    }
    */
    @GET
    @Produces(MediaType.APPLICATION_JSON)//@Produces(MediaType.APPLICATION_XML)
    public List<Alumno> getAlumnos(){
    	return personaDao.getAlumnos();
    	
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Respuesta addAlumno(Alumno alumno) {
    	Respuesta respuesta = new Respuesta();
    	if(alumno.getNumeroCuenta() == 0) {
    		respuesta.setCode(403);
    		respuesta.setMensaje("No contiene numero de cuenta");
    	}
    	else {
    		personaDao.addAlumno(alumno);
    		respuesta.setCode(200);
    		respuesta.setMensaje("Se guardo de forma exitosa");
    	}
    	return respuesta;
    }
    
    @DELETE
    @Path("/{alumnoId}")
    public void deleteAlumno(@PathParam("alumnoId") int idAlumno) {
    	personaDao.deleteAlumno(idAlumno);
    }
    
    
}
