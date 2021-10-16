// Αναστάσιος Νομικός - ΑΜ: Ε12132

public class City {
    // --------------- Attributes ---------------
    
    //ΒΟΗΘΑΕΙ ΣΤΗΝ ΑΝΑΓΝΩΣΙΜΟΤΗΤΑ ΚΑΙ ΠΡΟΣΤΑΤΕΥΤΕΙ ΑΠΟ ΤΥΧΟΝ ΛΑΘΗ
    private final int ID;
    private static int MAX_CODE = 0;
    private String name;

    // --------------- Constructor ---------------
    City(String name)
    {
        this.ID = ++MAX_CODE;
        this.name = name;
    }


    // --------------- Getters ---------------
    public String getName() {return name;}
    public int getID() {return ID;}

    // --------------- Setters ---------------
    public void setName(String name) {this.name = name;}

}
