/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mvcmusic.mvcmusicstore.models;

import com.mvcmusic.mvcmusicstore.entities.Genre;
import java.util.ArrayList;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author seannils1
 */
@Component
@Service("genreService")
public class GenreModel {

    //Inject Database Connection
    @PersistenceContext
    private EntityManager em;
    
    @Transactional
    public void create(Genre genre) {
        em.persist(genre);
    }
    
    public List<Genre> findAllGenres() {
        List<Genre> myGenreList = new ArrayList<Genre>();
        
        try{
            Query q = em.createNamedQuery("Genre.findAll");
            myGenreList = q.getResultList();
        } catch (Exception ex){}
        
        return myGenreList;
    }
    /**
     * 
     * @param genreId
     * @return 
     */
    @SuppressWarnings("unchecked")
    public Genre findGenreById(int genreId){
         List<Genre> myGenreList = new ArrayList<Genre>();
        
        try{
            Query q = em.createNamedQuery("Genre.findByGenreId");
            q.setParameter("genreId", genreId);
            
            myGenreList = q.getResultList();
            
        } catch (Exception ex){
        //Handle the Exception 
        }
        
        return myGenreList.get(0);
    
    }
    
}
