// Αναστάσιος Νομικός - ΑΜ: Ε12132
//ΑΥΤΗ Η ΚΛΑΣΗ ΔΕΝ ΚΑΝΕΙ ΤΙΠΟΤΑ ΛΟΓΩ ΕΛΛΕΙΨΗΣ ΤΗΣ ΗΜΕΡΟΜΗΝΙΑΣ ΣΤΟ GUI


import java.sql.Timestamp;

public class Rental {
    // --------------- Attributes ---------------
    private static int MAX_CODE = 0;
    private final int ID;
    private int store_acquire, store_return, cost;
    private String vehicle_ID, client;
    //
    private Timestamp date_acquire, date_return;

    // --------------- Constructor ---------------
    public Rental(String vehicle_ID, String client, int store_acquire, int store_return, Timestamp date_acquire, Timestamp date_return, int cost)
    {
        this.ID = ++MAX_CODE;
        this.vehicle_ID = vehicle_ID;
        this.client = client;
        this.store_acquire = store_acquire;
        this.store_return = store_return;
        this.date_acquire = date_acquire;
        this.date_return = date_return;
        this.cost = cost;
    }

    // --------------- Getters ---------------
    public int getID() {return ID;}
    public String getVehicle_ID() {return vehicle_ID;}
    public String getClient() {return client;}
    public int getStore_acquire() {return store_acquire;}
    public int getStore_return() {return store_return;}
    public Timestamp getDate_acquire() {return date_acquire;}
    public Timestamp getDate_return() {return date_return;}
    public int getCost() {return cost;}

    // --------------- Setters ---------------
    public void setVehicle_ID(String vehicle_ID) {this.vehicle_ID = vehicle_ID;}
    public void setClient(String client) {this.client = client;}
    public void setStore_acquire(int store_acquire) {this.store_acquire = store_acquire;}
    public void setStore_return(int store_return) {this.store_return = store_return;}
    public void setDate_acquire(Timestamp date_acquire) {this.date_acquire = date_acquire;}
    public void setDate_return(Timestamp date_return) {this.date_return = date_return;}
    public void setCost(int cost) {this.cost = cost;}
}
