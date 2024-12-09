package com.klef.jfsd.exam;

import javax.persistence.*;

@Entity
@Table(name = "department") // Ensure the table name matches your database table
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name") // Column name in the database
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "hod_name") // Optional column
    private String hodName;

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHodName() {
        return hodName;
    }

    public void setHodName(String hodName) {
        this.hodName = hodName;
    }
}
