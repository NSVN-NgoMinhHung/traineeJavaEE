/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storeWebService;

import DataAccess.SearchFacade;
import com.google.gson.Gson;
import entity.Product;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author hungnm
 */
@Stateless
@Path("storeWebService")
public class StoreWebService {
    
    DataAccess.SearchFacade sf = new SearchFacade();
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of StoreWebService
     */
    public StoreWebService() {
    }

    /**
     * Retrieves representation of an instance of storeWebService.StoreWebService
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }
    
    @GET
    @Path("/getListProducts")
    @Produces(MediaType.APPLICATION_JSON)
    public String getListProductJson() {
        Gson gson = new Gson();
        List<Product> results;
        results = sf.getAllProducts();
        return gson.toJson(results);
    }

    /**
     * PUT method for updating or creating an instance of StoreWebService
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
