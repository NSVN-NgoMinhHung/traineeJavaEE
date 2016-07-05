/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopService;

import BusinessAction.OrderManager;
import BusinessAction.SearchFacade;
import com.google.gson.Gson;
import entity.Order;
import entity.Product;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author hungnm
 */
@Path("shopService")
public class ShopService {

     BusinessAction.OrderManager om = new OrderManager();
    BusinessAction.SearchFacade sf = new SearchFacade();
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of StoreWebService
     */
    public ShopService() {
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
    
    @GET
    @Path("/getProductsByName/{productName}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getProductsByName(@PathParam("productName") String productName) {
        Gson gson = new Gson();
        List<Product> results;
        results = sf.getProductsByName(productName);
        return gson.toJson(results);
    }
    
    @GET
    @Path("/getProductsById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getProductsByName(@PathParam("id") int id) {
        Gson gson = new Gson();
        List<Product> results;
        results = sf.getProductsById(id);
        return gson.toJson(results);
    }
    
    @GET
    @Path("/getProductsByGenre/{genreId}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getProductsByGenre(@PathParam("genreId") Long genreId) {
        Gson gson = new Gson();
        List<Product> results;
        results = sf.getProductsByGenre(genreId);
        return gson.toJson(results);
    }
    
    @GET
    @Path("/getProductsByPrice/{price}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getProductsByPrice(@PathParam("price") String field) {
        Gson gson = new Gson();
        List<Product> results;
        String[] s = field.split(",");
        float min = Float.parseFloat(s[0]);
        float max = Float.parseFloat(s[1]);
        results = sf.getProductsByPrice(min, max);
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
    
    @POST
    @Path("/insertOrder")
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertOrder(String content) {
        Gson gson = new Gson();
        Order o = gson.fromJson(content, new Order().getClass());
        om.insertOrder(new Order( o.getDateCreated(), o.getDateShipped(), o.getCustomer(), o.getStatus()));
    }
}
