package com.avi.practice.company.cloudkitchen.parsers.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

/**
 * POJO Object to convert orders json fromat
 */
@XmlRootElement(name="row")
@XmlAccessorType(XmlAccessType.FIELD)
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String temp;
    private double shelfLife;
    private double decayRate;

    public final String getId() {
        return id;
    }

    public final void setId(String id) {
        this.id = id;
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final String getTemp() {
        return temp;
    }

    public final void setTemp(String temp) {
        this.temp = temp;
    }

    public double getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(double shelfLife) {
        this.shelfLife = shelfLife;
    }

    public final double getDecayRate() {
        return decayRate;
    }

    public final void setDecayRate(double decayRate) {
        this.decayRate = decayRate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", temp='" + temp + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
