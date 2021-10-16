// Αναστάσιος Νομικός - ΑΜ: Ε12132

public class Car extends Vehicle {
    // --------------- Attributes ---------------
    private int seats, doors;

    // --------------- Constructor ---------------
    public Car(String plate, String model, Fuel fuel, Type type, int cc, int cost, int seats, int doors)
    {
        super(plate, model, fuel, type, cc, cost);
        this.seats = seats;
        this.doors = doors;
    }


    // --------------- Getters ---------------
    @Override
    public String getSeatsORHeight() {return String.valueOf(seats);}

    @Override
    public String getDoorsORTrunk() {return String.valueOf(doors);}


    // --------------- Setters ---------------
    @Override
    public void setSeatsORHeight(int i) {this.seats = i;}

    @Override
    public void setDoorsORTrunk(int i) {this.doors = i;}
}
