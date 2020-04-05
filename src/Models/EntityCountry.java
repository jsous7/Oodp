package Models;

import juliana.cct.oodp.Continents;

/**
 *
 * @author Juliana_Sousa <juliana.oli.sousa@gmail.com>
 */
public class EntityCountry {
    
    protected String code;
    protected String name;
    protected String continent;
    protected Float surfaceArea;
    protected String headOfState;

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

    public Float getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(Float surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public String getHeadOfState() {
        return headOfState;
    }

    public void setHeadOfState(String headOfState) {
        this.headOfState = headOfState;
    }
}
