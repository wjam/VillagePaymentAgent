/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.haftrust.verifier.model;

/**
 *
 * @author LabClass
 */
public class District implements java.io.Serializable {

    private int id;
    private String title;
    private String description;
    private Region region;

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

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "District{" + "id=" + id + ", title=" + title + ", description=" + description + ", region=" + region + '}';
    }
    
}
