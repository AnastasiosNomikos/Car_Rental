// Αναστάσιος Νομικός - ΑΜ: Ε12132

public class Store {
    // --------------- Attributes ---------------
    private final int ID;
    private static int MAX_CODE = 0;
    private String name;
    private final String city;

    // --------------- Constructor ---------------
    Store(String name, String city)
    {
        this.ID = ++MAX_CODE;
        this.name = name;
        this.city = city;
    }

    // --------------- Getters ---------------
    public int getID(){
        return ID;
    }
    public String getName(){
        return name;
    }
    public String getCity() { return city; }

    // --------------- Setters ---------------
    public void setName(String name){
        this.name = name;
    }
}
