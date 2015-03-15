package org.haftrust.verifier.model;

/**
 *
 * @author LabClass
 */
public class Region implements java.io.Serializable {

    private int id;
    private String title;
    private String description;
    private Country country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Region{" + "id=" + id + ", title=" + title + ", description=" + description + ", country=" + country + '}';
    }
    
}
