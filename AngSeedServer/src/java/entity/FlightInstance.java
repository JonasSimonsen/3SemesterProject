/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Andreas
 */
@NamedQueries({
    @NamedQuery(name = "FlightInstance.findByDepartureDate", query = "SELECT f.depatureDate FROM FlightInstance AS f"),
    @NamedQuery(name = "FlightInstance.findBySeats", query = "SELECT f.availableSeats FROM FlightInstance AS f"),
    @NamedQuery(name = "FlightInstance.findByOrigin", query = "SELECT f.origin from FlightInstance AS f"),
    @NamedQuery(name = "FlightInstance.findWithoutDest", query = "SELECT f FROM FlightInstance f WHERE f.origin = :from AND f.departureDate = :date AND f.availableSeats >= :seats"),
    @NamedQuery(name = "FlightInstance.findWithDest", query = "SELECT f FROM FlightInstance WHERE f.origin = :from AND f.destination = :to AND f.departureDate = :date AND f.availableSeats >= :seats"),
    @NamedQuery(name = "FlightInstance.findByFlightNumber", query = "SELECT f FROM FlightInstance WHERE f.FlightNumber = :fnumber")
})
@Entity
public class FlightInstance implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int departureTime;
    private Date departureDate;
    private int flightTime;
    private String flightNumber;
    @OneToMany
    private Airport destination;
    @OneToMany
    private Airport origin;
    private int availableSeats;
    private int price;

    public FlightInstance(int departureTime, Date departureDate, int flightTime, String flightNumber, Airport destination, Airport origin, int availableSeats, int price) {
        this.departureTime = departureTime;
        this.departureDate = departureDate;
        this.flightTime = flightTime;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.availableSeats = availableSeats;
        this.price = price;
    }

    public FlightInstance() {
    }

    public int getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(int departureTime) {
        this.departureTime = departureTime;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public int getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(int flightTime) {
        this.flightTime = flightTime;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Airport getOrigin() {
        return origin;
    }

    public void setOrigin(Airport origin) {
        this.origin = origin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
