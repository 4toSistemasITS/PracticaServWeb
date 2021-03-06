/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.model.Area;
import com.model.Materia;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Angel Córdova
 */
@Stateless
@Path("com.model.materia")
public class MateriaFacadeREST extends AbstractFacade<Materia> {

    @PersistenceContext(unitName = "ColegioPU")
    private EntityManager em;
    
    @EJB
    AreaFacadeREST areaFacadeREST;
    

    public MateriaFacadeREST() {
        super(Materia.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Materia entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Materia entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Materia find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Materia> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Materia> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @POST
    @Path("crear")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String crear(@FormParam("nombre") String nombre, @FormParam("idarea") int idarea, @FormParam("director") String director) {
  
    String mensaje="{\"exitoso\":false}";
    Area ob = areaFacadeREST.find(idarea);
      try {
           create (new Materia(nombre, director, ob));
           mensaje="{\"exitoso\":bien}";
       } catch (Exception e) {
           System.out.println(e);
       }
    return mensaje;
    }
    
    
    @POST
    @Path("leer")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String leer1(@FormParam("nombre") String nombre, @FormParam("idarea") int idarea, @FormParam("director") String director) {
  
    String mensaje="{\"exitoso\":false}";
    Area ob = areaFacadeREST.find(idarea);
      try {
           create (new Materia(nombre, director, ob));
           mensaje="{\"exitoso\":bien}";
       } catch (Exception e) {
           System.out.println(e);
       }
    return mensaje;
    }
    
     
}
