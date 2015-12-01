/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entity.Airport;
import entity.FlightInstance;
import entity.Passenger;
import entity.Reservation;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Andreas
 */
public class AirlineFacade {
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("SEM3PU");
    private EntityManager em = emf.createEntityManager();
    
    public List<FlightInstance> findFlightsWithNoDest(Airport origin, Date departureDate, int numOfTickets){
        Query query = em.createNamedQuery("FlightInstance.findWithoutDest");
        query.setParameter("from", origin);
        query.setParameter("date", departureDate);
        query.setParameter("seats", numOfTickets);
        return query.getResultList();   
    }    
    
    public List<FlightInstance> findFlightsWithDest(Airport origin, Airport destination, Date departureDate, int numOfTickets){
        Query query = em.createNamedQuery("FlightInstance.findWithDest");
        query.setParameter("from", origin);
        query.setParameter("to", destination);
        query.setParameter("date", departureDate);
        query.setParameter("seats", numOfTickets);
        return query.getResultList();
    }
    
    public void makeReservation(String flightID, int numberOfSeats, String reserveName, int reservePhone, String reserveEmail, List<Passenger> passengers){
        Reservation res = new Reservation(flightID, numberOfSeats, reserveName, reservePhone, reserveEmail, passengers);
        em.getTransaction().begin();
        em.persist(res);
        em.getTransaction().commit();
        em.close();   
    }
}
