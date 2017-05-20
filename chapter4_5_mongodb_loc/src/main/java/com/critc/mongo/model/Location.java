package com.critc.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Document(collection = "location")
public class Location {
    @Id
    private String id;//地点名称
    private double[] position;//位置信息

    public Location(String id, double lon, double lat) {
        this.id = id;
        double[] p = new double[]{lon, lat};
        this.position = p;
    }

    public double[] getPosition() {
        return position;
    }

    public void setPosition(double[] position) {
        this.position = position;
    }

    public Location() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id='" + id + '\'' +
                ", position=" + Arrays.toString(position) +
                '}';
    }
}
