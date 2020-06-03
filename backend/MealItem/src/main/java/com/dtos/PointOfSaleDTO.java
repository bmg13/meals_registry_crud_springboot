package com.dtos;

public class PointOfSaleDTO {

    private long pointOfSaleId;
    private String building;
    private String floor;
    private String room;
    private String opensAt;
    private String closesAt;
    private String downTimeStart;
    private String downTimeEnd;
    private boolean state;

    public PointOfSaleDTO() {
    }

    public PointOfSaleDTO(
            long pointOfSaleId,
            String building,
            String floor,
            String room,
            String opensAt,
            String closesAt,
            String downTimeStart,
            String downTimeEnd,
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

    public String getDownTimeStart() {
        return downTimeStart;
    }

    public void setDownTimeStart(String downTimeStart) {
        this.downTimeStart = downTimeStart;
    }

    public String getDownTimeEnd() {
        return downTimeEnd;
    }

    public void setDownTimeEnd(String downTimeEnd) {
        this.downTimeEnd = downTimeEnd;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
