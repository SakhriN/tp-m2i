package org.example;

public class Lieu {

    String name;
    int id;

    String address;

    int capacity;


public Lieu(){

}

    public Lieu(String name, String address, int capacity) {
        this.name = name;
        this.address = address;
        this.capacity = capacity;
    }

    public Lieu(int id,String name, String address, int capacity) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.capacity = capacity;
    }


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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    @Override
    public String toString() {
        return "Lieu numéro : " +
                ", id= " + name +
                ", name= " + name +
                ", address= " + address +
                ", capacity= " + capacity +
                " | ";
    }
}
