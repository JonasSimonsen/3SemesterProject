/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Andreas
 */
@Entity
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String flightID;
    private int numberOfSeats;
    private String reserveName;
    private int reservePhone;
    private String ReserveEmail;
    @OneToMany
    List<Passenger> passengerList;

    public Reservation(String flightID, int numberOfSeats, String reserveName, int reservePhone, String ReserveEmail, List<Passenger> passengerList) {
        this.flightID = flightID;
        this.numberOfSeats = numberOfSeats;
        this.reserveName = reserveName;
        this.reservePhone = reservePhone;
        this.ReserveEmail = ReserveEmail;
        this.passengerList = passengerList;
    }

    public Reservation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getReserveName() {
        return reserveName;
    }

    public void setReserveName(String reserveName) {
        this.reserveName = reserveName;
    }

    public int getReservePhone() {
        return reservePhone;
    }

    public void setReservePhone(int reservePhone) {
        this.reservePhone = reservePhone;
    }

    public String getReserveEmail() {
        return ReserveEmail;
    }

    public void setReserveEmail(String ReserveEmail) {
        this.ReserveEmail = ReserveEmail;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

}
