/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Andreas & Jonas
 */
public class Flights
{
    private String airlineName;
    private String date;
    private int persons;
    private double price;
    private String fligthID;
    private int traveltime;
    private String to;
    private String from;

    public Flights(String airlineName, String date, int persons, double price, String fligthID, int traveltime, String to, String from) {
        this.airlineName = airlineName;
        this.date = date;
        this.persons = persons;
        this.price = price;
        this.fligthID = fligthID;
        this.traveltime = traveltime;
        this.to = to;
        this.from = from;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPersons() {
        return persons;
    }

    public void setPersons(int persons) {
        this.persons = persons;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFligthID() {
        return fligthID;
    }

    public void setFligthID(String fligthID) {
        this.fligthID = fligthID;
    }

    public int getTraveltime() {
        return traveltime;
    }

    public void setTraveltime(int traveltime) {
        this.traveltime = traveltime;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    @Override
    public String toString()
    {
        return "Flight{" + "airlineName=" + airlineName + ", date=" + date + ", persons=" + persons + ", price=" + price + ", fligthID=" + fligthID + ", traveltime=" + traveltime + ", to=" + to + ", from=" + from + '}';
    }
}
