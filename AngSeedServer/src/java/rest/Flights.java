/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import facades.FlightFacade;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Jonas
 */
@Path("flightinfo/")
public class Flights
{

    @Context
    private UriInfo context;
    private FlightFacade air = new FlightFacade();
    private Gson gson = new Gson();

    public Flights() {
    }

    @GET
    @Produces("application/json")
    @Consumes("application/json")
    @Path("{from}/{date}/{persons}")
    public String FlightNoTo(@PathParam("from") String from, @PathParam("date")String date, @PathParam("persons") int persons) throws InterruptedException, ExecutionException
    {
        List<entity.Flights> flights = air.getFlights(from, date, persons);
        JsonArray json = new JsonArray();
        for (entity.Flights fli : flights)
        {
            JsonObject response = new JsonObject();
            response.addProperty("date", fli.getDate());
            response.addProperty("persons", fli.getPersons());
            response.addProperty("price", fli.getPrice());
            response.addProperty("flightID", fli.getFligthID());
            response.addProperty("traveltime", fli.getTraveltime());
            response.addProperty("to", fli.getTo());
            response.addProperty("from", fli.getFrom());
            json.add(response);
        }
        String jsonStr = gson.toJson(json);
        return jsonStr;
    }

   @GET
    @Produces("application/json")
    @Consumes("application/json")
    @Path("{from}/{to}/{date}/{persons}")
    public String FlightWithTo(@PathParam("from") String from,@PathParam("to") String to, @PathParam("date")String date, @PathParam("persons") int persons) throws InterruptedException, ExecutionException
    {
        List<entity.Flights> flights = air.getFlights(from, to, date, persons);
        JsonArray json = new JsonArray();
        for (entity.Flights fli : flights)
        {
            JsonObject repsonse = new JsonObject();
            repsonse.addProperty("date", fli.getDate());
            repsonse.addProperty("persons", fli.getPersons());
            repsonse.addProperty("price", fli.getPrice());
            repsonse.addProperty("flightID", fli.getFligthID());
            repsonse.addProperty("traveltime", fli.getTraveltime());
            repsonse.addProperty("to", fli.getTo());
            repsonse.addProperty("from", fli.getFrom());
            json.add(repsonse);
        }
        String jsonStr = gson.toJson(json);
        return jsonStr;
    }
}