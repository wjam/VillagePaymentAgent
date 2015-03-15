package org.haftrust.verifier.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HT_STATIC_DATA", schema = "kj905")
public class StaticData {

    @Id
    @Column(name = "IDSTATICDATA", nullable = false)
    @GeneratedValue
    private Integer id;

    @Column(length = 45, nullable = false)
    private String type;

    @Column(length = 45, nullable = false)
    private String value;

    @Column(length = 45, nullable = false)
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "StaticData{" + "id=" + id + ", type=" + type + ", value=" + value + ", description=" + description + '}';
    }

}
