/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import util.GetFlights;
import entity.Flights;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Andreas & Jonas
 */
public class FlightFacade
{

    private List<String> urls;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU-Local");

    public List<String> getAirlines()
    {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        urls = em.createQuery("SELECT u.url from Airline u").getResultList();
        em.getTransaction().commit();
        return urls;
    }

    public List<Flights> getFlights(String airport, String date, int numberOfTickets) throws InterruptedException, ExecutionException
    {
        String finalUrl;
        urls = getAirlines();
        List<Flights> flights = new ArrayList();
        List<Future<List<Flights>>> list = new ArrayList();
        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (String url : urls)
        {
            finalUrl = url + "api/flightinfo/" + airport + "/" + date + "/" + numberOfTickets + "";
            // System.out.println(finalUrl);
            Future<List<Flights>> future = executor.submit(new GetFlights(finalUrl));
            list.add(future);
        }

        for (Future<List<Flights>> future : list)
        {
            List<Flights> temp = future.get();
            for (Flights temp1 : temp)
            {
                flights.add(temp1);
            }
        }
        return flights;
    }

    public List<Flights> getFlights(String airport, String destination, String date, int numberOfTickets) throws InterruptedException, ExecutionException
    {
        String finalUrl;
        urls = getAirlines();
        List<Flights> flights = new ArrayList();
        List<Future<List<Flights>>> list = new ArrayList();
        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (String url : urls)
        {
            finalUrl = url + "api/flightinfo/" + airport + "/" + destination + "/" + date + "/" + numberOfTickets + "";
            System.out.println(finalUrl);
            Future<List<Flights>> future = executor.submit(new GetFlights(finalUrl));
            list.add(future);
        }

        for (Future<List<Flights>> future : list)
        {
            List<Flights> temp = future.get();
            for (Flights temp1 : temp)
            {
                flights.add(temp1);
            }
        }
        return flights;
    }
}

