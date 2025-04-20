/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eventmanagerapp;
import java.io.*;
/**
 *
 * @author nayju
 */
public class Event implements Serializable{
    
    private String eventName;
    private String date;
    private int time;
    private String description;
    private Venue venue;

    public Event(String eventName, String date, int time, String description, Venue venue) {
        this.eventName = eventName;
        this.date = date;
        this.time = time;
        this.description = description;
        this.venue = venue;
    }
    
    public boolean equals(Event event){
        
        return this.eventName.equals(eventName) && this.date.equals(date) && this.description.equals(description);
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }
    
    
    
    
}
