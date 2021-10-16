// Αναστάσιος Νομικός - ΑΜ: Ε12132

public class Client {
    // --------------- Attributes ---------------
    private final String licence, ID;
    private String name, surname, email, address, telephone;

    // --------------- Constructor ---------------
    public Client(String ID, String licence, String name, String surname, String email, String address, String telephone)
    {
        this.ID = ID;
        this.telephone = telephone;
        this.licence = licence;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.address = address;
    }

    // --------------- Getters ---------------
    public String getTelephone() {return telephone;}
    public String getLicence() {return licence;}
    public String getID() {return ID;}
    public String getName() {return name;}
    public String getSurname() {return surname;}
    public String getEmail() {return email;}
    public String getAddress() {return address;}

    // --------------- Setters ---------------
    public void setTelephone(String telephone) {this.telephone = telephone;}
    public void setName(String name) {this.name = name;}
    public void setSurname(String lastname) {this.surname = lastname;}
    public void setEmail(String email) {this.email = email;}
    public void setAddress(String address) {this.address = address;}
}
