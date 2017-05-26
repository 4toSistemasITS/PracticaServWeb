/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.services;

import com.model.Animales;
import java.util.List;
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
@Path("com.model.animales")
public class AnimalesFacadeREST extends AbstractFacade<Animales> {

    @PersistenceContext(unitName = "WebApplication2PU")
    private EntityManager em;

    public AnimalesFacadeREST() {
        super(Animales.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Animales entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Animales entity) {
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
    public Animales find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Animales> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Animales> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
    @POST
    @Path("consulta")
    @Produces({MediaType.APPLICATION_JSON,  MediaType.APPLICATION_JSON})
    public List<Animales> consulta(@PathParam("usuario") String valor, @PathParam("contraseña") String valor2, @PathParam("extinto") int valor3){
        List<Animales> retorno=null;
        if (valor.equals("angel")&&valor2.equals("1234")){
            retorno=consultarExtincion(valor3);
        }
        return retorno;
    }
    
    @POST
    @Path("login")
    @Produces({MediaType.APPLICATION_JSON,  MediaType.APPLICATION_JSON})
    public Animales login(@FormParam("usuario") String usuario, @FormParam("contraseña") String password){
        Animales u= login1(usuario, password);
        return u;
            
    }
    ////METODO PARA CREAR UN USUARIO
    @POST
    @Path("crear")
    @Produces({MediaType.APPLICATION_JSON,  MediaType.APPLICATION_JSON})
    public String crear(@FormParam("usuario") String usuario, @FormParam("contraseña") String password){
        String mensaje="{\"exitoso\":false}";
        if(comprobar_usuario(usuario)== null){
//                try {
                    create(new Animales(false, usuario, password));
                    mensaje="{\"exitoso\":se ha creado el usuario}";
//                } catch (Exception e) {
//                } 
        }
        return mensaje;
            
    }
 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
    @POST
    @Path("consultarValidos")
    @Produces({MediaType.APPLICATION_JSON,  MediaType.APPLICATION_JSON})
    public List<Animales> consultarValidos(@PathParam("eliminado") boolean eliminado){
        List<Animales> retorno=obtenerPorEliminado(eliminado);
        
        return retorno;
    }
    
    @POST
    @Path("consultarExtincion")
    @Produces({MediaType.APPLICATION_JSON,  MediaType.APPLICATION_JSON})
    public List<Animales> consultarExtincion(@PathParam("extinto") int extinto){
        List<Animales> retorno=obtenerPorExtinto(extinto);
        
        return retorno;
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    List<Animales> obtenerPorEliminado(boolean valor){
        TypedQuery<Animales> qry;
        qry = getEntityManager().createQuery("SELECT a FROM Animales a WHERE a.eliminado = :eliminado", Animales.class);
        qry.setParameter("eliminado", valor);
        try{
            return qry.getResultList();
        }catch(NoResultException e){
           return null; 
        }
    }
    
    List<Animales> obtenerPorExtinto(int valor){
        TypedQuery<Animales> qry;
        qry = getEntityManager().createQuery("SELECT a FROM Animales a WHERE a.extincion = :extincion", Animales.class);
        qry.setParameter("extincion", valor);
        try{
            return qry.getResultList();
        }catch(NoResultException e){
           return null; 
        }
    }
    
    public Animales login1(String usuario, String password){
        Animales u = null;
        TypedQuery<Animales> qry;
        qry = getEntityManager().createQuery("SELECT a FROM Animales a WHERE a.usuario = :usuario and a.password = :password and a.eliminado = :eliminado", Animales.class);
        qry.setParameter("usuario", usuario);
        qry.setParameter("password", password);
        qry.setParameter("eliminado", false);
        try{
            return qry.getSingleResult();
        }catch(NoResultException e){
           return null; 
        }
        
    }
    
    public Animales comprobar_usuario(String usuario){
        Animales u = null;
        TypedQuery<Animales> qry;
        qry = getEntityManager().createQuery("SELECT a FROM Animales a WHERE a.usuario = :usuario ", Animales.class);
        qry.setParameter("usuario", usuario);
        try{
            return qry.getSingleResult();
        }catch(NoResultException e){
           return null; 
        }
        
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
