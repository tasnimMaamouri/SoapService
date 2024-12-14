/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@XmlRootElement(name="Emission")
@XmlAccessorType(XmlAccessType.FIELD)
public class Emission {
    private String sector;
    private String region;
    private double co2Emissions;

    // Getters et Setters
    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getCo2Emissions() {
        return co2Emissions;
    }

    public void setCo2Emissions(double co2Emissions) {
        this.co2Emissions = co2Emissions;
    }
}
