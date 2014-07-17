package com.mvcmusic.mvcmusicstore.controllers;

import com.mvcmusic.mvcmusicstore.entities.Genre;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Store/")
public class StoreController {
    
    //private static final Logger logger = Logger.getLogger(StoreController.class);
    
//    @Resource(name="genreService")
//    private GenreModel genreModel;
    
//    @Resource(name="albumService")
//    private AlbumModel albumModel;

    /**
     *  Map root of Store Page
     *  @param model
     *  @return
    */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getStoreIndexPage(ModelMap model) {
        
        List<Genre> myGenreList = new ArrayList(); //genreModel.findAllGenres();
        
        //Remove this when genreModel is populating list
        myGenreList = fillGenres(myGenreList);
        
        model.put("genreList", myGenreList);
        model.put("genreCount", myGenreList.size());
        
        return "storeindex";
    }

//    @RequestMapping(value = "/Browse", method = RequestMethod.GET)
//    public String getStoreBrowsePage(ModelMap model) {
//        return "Browse";
//    }

    /**
     * Map the Browse page
     * 
     * @param genreName
     * @param model
     * @return 
     */
    @RequestMapping(value = "/Browse", method = RequestMethod.GET)
    public String getStoreBrowsePage(@RequestParam(value = "genre", required = false) String genreName, ModelMap model) {
        model.addAttribute("genre", genreName);

        return "Browse";
    }
    
    /**
     * Map the Details page
     * 
     * @param albumId
     * @param model
     * @return 
     */

    @RequestMapping(value = "/Details", method = RequestMethod.GET)
    public String getStoreDetailsPage(@RequestParam(value = "albumId", required = false) String albumId, ModelMap model) {
        model.addAttribute("albumId", albumId);
        return "Details";
    }
    
    protected List<Genre> fillGenres(List<Genre> myGenreList){
        
        Genre genOne = new Genre();
        genOne.setGenreid(1);
        genOne.setName("Pop");
        
        Genre genTwo = new Genre();
        genTwo.setGenreid(2);
        genTwo.setName("Rock");
        
        myGenreList.add(genOne);
        myGenreList.add(genTwo);
        
        return myGenreList;
    }

}
