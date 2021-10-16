// Αναστάσιος Νομικός - ΑΜ: Ε12132

abstract public class Vehicle {
    // --------------- Attributes ---------------
    private String ID, model;
    private int cc, cost;
    private Fuel fuel;
    private Type type_of_vehicle;

    public abstract String getSeatsORHeight();
    public abstract String getDoorsORTrunk();
    public abstract void setSeatsORHeight(int i);
    public abstract void setDoorsORTrunk(int i);

    public enum Fuel{Gas, Diesel}
    public enum Type{Scooter, Motorcycle, S_Car, M_Car, L_Car}

    // --------------- Constructor ---------------
    public Vehicle(String ID, String model, Fuel fuel, Type type, int cc, int cost) {
        this.ID = ID;
        this.fuel = fuel;
        this.type_of_vehicle = type;
        this.model = model;
        this.cc = cc;
        this.cost = cost;
    }

    // --------------- Getters ---------------
    public String getID() {return ID;}
    public String getModel() {return model;}
    public int getCc() {return cc;}
    public int getCost() {return cost;}
    public Fuel getFuel() {return fuel;}
    public String getType_of_vehicle() {return type_of_vehicle.toString();}

    // --------------- Setters ---------------
    public void setPlate(String ID) {this.ID = ID;}
    public void setCc(int cc) {this.cc = cc;}
    public void setCost(int cost) {this.cost = cost;}
    public void setFuel(Fuel fuel) {this.fuel = fuel;}
    public void setType_of_vehicle(Type type_of_vehicle) {this.type_of_vehicle = type_of_vehicle;}
    public void setModel(String model) {this.model = model;}
}
