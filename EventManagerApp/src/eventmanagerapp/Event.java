package eventmanagerapp;

import java.io.*;
import java.util.ArrayList;
import java.text.DecimalFormat;

/**
 *
 * @author nayju
 */
public class Event implements Serializable {

    DecimalFormat formatter = new DecimalFormat("00:00");

    private String eventName;
    private String date;
    private int time;
    private String description;
    private Venue venue;
    private String category;

    public Event(String eventName, String date, int time, String description, Venue venue, String category) {
        this.eventName = eventName;
        this.date = date;
        this.time = time;
        this.description = description;
        this.venue = venue;
        this.category = category;
    }

    public boolean equals(Event event) {

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String formatTime(int time) {
        String formattedTime;

        int hours = time / 100;
        int minutes = time % 100;
        formattedTime = String.format("%02d : %02d", hours, minutes);

        return formattedTime;
    }

}
