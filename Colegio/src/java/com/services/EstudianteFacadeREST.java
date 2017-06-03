/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.model.Area;
import com.model.Estudiante;
import com.model.Materia;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
@Path("com.model.estudiante")
public class EstudianteFacadeREST extends AbstractFacade<Estudiante> {

    @PersistenceContext(unitName = "ColegioPU")
    private EntityManager em;

    
    @EJB
    MateriaFacadeREST materiaFacadeREST;
    
    public EstudianteFacadeREST() {
        super(Estudiante.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Estudiante entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Estudiante entity) {
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
    public Estudiante find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Estudiante> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Estudiante> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    public String crear(@FormParam("nombre") String nombre, @FormParam("idmateria") int idmateria, @FormParam("curso") String curso) {
  
    String mensaje="{\"exitoso\":false}";
    Materia ob = materiaFacadeREST.find(idmateria);
      try {
           create (new Estudiante(nombre, curso, ob));
           mensaje="{\"exitoso\":bien}";
       } catch (Exception e) {
           System.out.println(e);
       }
    return mensaje;
    }
    
    
    @POST
    @Path("leer")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String leer1(@FormParam("nombre") String nombre, @FormParam("idmateria") int idmateria,  @FormParam("curso") String curso) {
  
    String mensaje="{\"exitoso\":false}";
    Materia ob = materiaFacadeREST.find(idmateria);
      try {
           create (new Estudiante(nombre, mensaje, ob));
           mensaje="{\"exitoso\":bien}";
       } catch (Exception e) {
           System.out.println(e);
       }
    return mensaje;
    }
    
    @POST
    @Path("eliminar")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String eliminar(@FormParam("idmateria") int idmateria, @FormParam("eliminado") boolean eliminado) {
        String mensaje = "{\"exitoso\":false,\"motivo\":";
        Estudiante v = buscar_por_id(idmateria);
        Materia ob = materiaFacadeREST.find(idmateria);
        short el=1;
       if (v != null) {
             v.setEliminado(el);
       
            try {
                edit(v);
                mensaje = "{\"exitoso\":true";
            } catch (Exception e) {
                mensaje += "\"Excepcion en base\"";
            }
        } else {
            mensaje += "\"Datos no correctos\"";
        }
        mensaje += "}";
        return mensaje;

    }
    
    @POST
    @Path("editar")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
    public String editar(@FormParam("nombre") String nombre, @FormParam("curso") String curso, @FormParam("idmateria") int idmateria) {
        String mensaje = "{\"exitoso\":false,\"motivo\":";
        Estudiante v = buscar_por_id(idmateria);
        Materia ob = materiaFacadeREST.find(idmateria);
        if (v != null) {
            v.setNombre(nombre);
            v.setCurso(curso);
            v.setIdmateria(ob);
            try {
                edit(v);
                mensaje = "{\"exitoso\":true";
            } catch (Exception e) {
                mensaje += "\"Excepcion en base\"";
            }
        } else {
            mensaje += "\"Datos no correctos\"";
        }
        mensaje += "}";
        return mensaje;

    }
    
    public Estudiante buscar_por_id(int idestudiante) {
        Estudiante es = null;
        TypedQuery<Estudiante> qry;
        qry = getEntityManager().createQuery("SELECT e FROM Estudiante e WHERE e.idestudiante = :idestudiante", Estudiante.class);
        qry.setParameter("idestudiante", idestudiante);
      
        try {
            return qry.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }
}
