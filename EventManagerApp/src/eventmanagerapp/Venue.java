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
public class Venue implements Serializable{
    
    private String name;
    private String streetName;
    private int addressNumber;

    public Venue(String name, String streetName, int addressNumber) {
        this.name = name;
        this.streetName = streetName;
        this.addressNumber = addressNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(int addressNumber) {
        this.addressNumber = addressNumber;
    }
    
    
}
