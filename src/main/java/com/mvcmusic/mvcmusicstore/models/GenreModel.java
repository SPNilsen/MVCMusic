/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvcmusic.mvcmusicstore.models;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvcmusic.mvcmusicstore.entities.Genre;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author seannils1
 */
@Component
@Service("genreService")
public class GenreModel {

    //Inject Database Connection
    @PersistenceContext(unitName = "MVCMusicStorePU")
    private EntityManager em;

    /**
     * Create Genre Object
     *
     */
    @Transactional
    public void create(Genre genre) {
        em.persist(genre);
    }

    /**
     *
     * @return List<Genre>
     */
    public List<Genre> findAllGenres() {
        List<Genre> genreList = new ArrayList<Genre>();

        try {
            Query q = em.createNamedQuery("Genre.findAll");
            genreList = q.getResultList();
        } catch (Exception e) {
            System.out.println("ERROR::: " + e);
        }

        return genreList;
    }

    @SuppressWarnings("unchecked")
    public Genre findGenreById(int passId) {
        List<Genre> genreList = new ArrayList<Genre>();

        try {
            Query q = em.createNamedQuery("Genre.findByGenreid");
            q.setParameter("genreid", passId);
            genreList = q.getResultList();
        } catch (Exception e) {
            System.out.println("ERROR::: " + e);
        }

        return genreList.get(0);
    }

}
