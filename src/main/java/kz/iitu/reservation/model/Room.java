package kz.iitu.reservation.model;

public class Room {

    private String number;

    public Room(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Room{" +
                "number='" + number + '\'' +
                '}';
    }
}
