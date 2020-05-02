package kz.iitu.reservation.model;

import java.sql.Timestamp;

public class ReservedRooms {

    private int employeeId;
    private String roomNumber;
    private Timestamp date;
    private Timestamp toDate;

    public ReservedRooms(int employeeId, String roomNumber, Timestamp date, Timestamp toDate) {
        this.employeeId = employeeId;
        this.roomNumber = roomNumber;
        this.date = date;
        this.toDate = toDate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Timestamp getToDate() {
        return toDate;
    }

    public void setToDate(Timestamp toDate) {
        this.toDate = toDate;
    }

    @Override
    public String toString() {
        return "ReservedRooms{" +
                "employeeId=" + employeeId +
                ", roomNumber='" + roomNumber + '\'' +
                ", date=" + date +
                ", toDate=" + toDate +
                '}';
    }
}
