/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import juliana.cct.oodp.Continents;

/**
 *
 * @author Juliana_Sousa <juliana.oli.sousa@gmail.com>
 */
public class EntityCountry {
    
    private String code;
    private String name;
    private String continent;
    private Float surface_area;
    private String head_of_state;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public Float getSurface_area() {
        return surface_area;
    }

    public void setSurface_area(Float surface_area) {
        this.surface_area = surface_area;
    }

    public String getHead_of_state() {
        return head_of_state;
    }

    public void setHead_of_state(String head_of_state) {
        this.head_of_state = head_of_state;
    }
}
