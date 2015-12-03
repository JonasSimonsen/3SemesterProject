/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entity.Flights;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 *
 * @author Jonas
 */
public class GetFlights implements Callable<List<Flights>>
{

    private URL url = null;
    private String finalUrl = "";
    private URLConnection urlConn = null;
    private InputStreamReader in = null;
    private final StringBuilder sb = new StringBuilder();
    private BufferedReader bufferedReader = null;
    private String airlineName;
    private List<Flights> flights = null;
    private Gson gson = null;
    private JsonObject object;
    private JsonArray jsonArray;

    public GetFlights(String finalUrl)
    {
        this.finalUrl = finalUrl;
    }

    //kalder metoden getAirlines i facaden, callable - sende get ud til alle i databasen som modtager json resultater hvorefter det videresendes som json resultater
    @Override
    public List<Flights> call() throws Exception
    {
        flights = new ArrayList<>();
        object = new JsonObject();
        gson = new Gson();
        url = new URL(finalUrl);
        urlConn = url.openConnection();
        if (urlConn != null && urlConn.getInputStream() != null)
        {

            in = new InputStreamReader(urlConn.getInputStream(), Charset.defaultCharset());
            bufferedReader = new BufferedReader(in);
            int cp;
            while ((cp = bufferedReader.read()) != -1)
            {
                sb.append((char) cp);
            }
            object = new JsonParser().parse(sb.toString()).getAsJsonObject();

            airlineName = object.get("airline").getAsString();
            jsonArray = object.get("flights").getAsJsonArray();

            for (int i = 0; i < jsonArray.size(); i++)
            {
                JsonObject json = (JsonObject) jsonArray.get(i);

                Flights f = new Flights(
                        airlineName,
                        json.get("date").getAsString(),
                        json.get("persons").getAsInt(),
                        json.get("price").getAsDouble(),
                        json.get("flightID").getAsString(),
                        json.get("traveltime").getAsInt(),
                        json.get("to").getAsString(),
                        json.get("from").getAsString());
                flights.add(f);
            }
        }
        return flights;
    }
}
