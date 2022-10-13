package Case.OOP;

import java.io.Serializable;

public class Hotel implements Serializable {
    private int id;
    private double price;
    private int numberOfRoom;
    private int numberOfPeople;

    public Hotel() {
    }

    public Hotel(int id, double price, int numberOfRoom, int numberOfPeople) {
        this.id = id;
        this.price = price;
        this.numberOfRoom = numberOfRoom;
        this.numberOfPeople = numberOfPeople;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberOfRoom() {
        return numberOfRoom;
    }

    public void setNumberOfRoom(int numberOfRoom) {
        this.numberOfRoom = numberOfRoom;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", price=" + price +
                ", numberOfRoom=" + numberOfRoom +
                ", numberOfPeople=" + numberOfPeople +
                '}';
    }


}
