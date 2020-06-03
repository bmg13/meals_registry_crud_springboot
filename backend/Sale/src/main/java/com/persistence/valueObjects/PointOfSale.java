package com.persistence.valueObjects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "point_of_sale")
public class PointOfSale implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pointOfSaleId;

    @Column
    private String location;

    @Column
    private String building;

    @Column
    private String floor;

    @Column
    private String room;

    @Column
    private String opensAt;

    @Column
    private String closesAt;

    @Column
    private Date downTimeStart;

    @Column
    private Date downTimeEnd;

    @Column
    private boolean state;

    public PointOfSale() {
    }

    public PointOfSale(
            String building,
            String floor,
            String room,
            String opensAt,
            String closesAt,
            Date downTimeStart,
            Date downTimeEnd,
            boolean state) {
        this.building = building;
        this.floor = floor;
        this.room = room;
        this.opensAt = opensAt;
        this.closesAt = closesAt;
        this.downTimeStart = downTimeStart;
        this.downTimeEnd = downTimeEnd;
        this.state = state;
    }

    public PointOfSale(
            long pointOfSaleId,
            String building,
            String floor,
            String room,
            String opensAt,
            String closesAt,
            Date downTimeStart,
            Date downTimeEnd,
            boolean state) {
        this.pointOfSaleId = pointOfSaleId;
        this.building = building;
        this.floor = floor;
        this.room = room;
        this.opensAt = opensAt;
        this.closesAt = closesAt;
        this.downTimeStart = downTimeStart;
        this.downTimeEnd = downTimeEnd;
        this.state = state;
    }

    public long getPointOfSaleId() {
        return pointOfSaleId;
    }

    public void setPointOfSaleId(long pointOfSaleId) {
        this.pointOfSaleId = pointOfSaleId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getOpensAt() {
        return opensAt;
    }

    public void setOpensAt(String opensAt) {
        this.opensAt = opensAt;
    }

    public String getClosesAt() {
        return closesAt;
    }

    public void setClosesAt(String closesAt) {
        this.closesAt = closesAt;
    }

    public Date getDownTimeStart() {
        return downTimeStart;
    }

    public void setDownTimeStart(Date downTimeStart) {
        this.downTimeStart = downTimeStart;
    }

    public Date getDownTimeEnd() {
        return downTimeEnd;
    }

    public void setDownTimeEnd(Date downTimeEnd) {
        this.downTimeEnd = downTimeEnd;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}