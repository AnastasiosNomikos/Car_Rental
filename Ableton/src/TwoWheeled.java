// Αναστάσιος Νομικός - ΑΜ: Ε12132

public class TwoWheeled extends Vehicle {
    // --------------- Attributes ---------------
    private int height;
    private Trunk trunk;
    public enum Trunk{Saddlebags, Tail, Handlebar, Fender}

    // --------------- Constructor ---------------
    public TwoWheeled(String plate, String model, Fuel fuel, Type type, int cc, int cost, int height, Trunk trunk) {
        super(plate, model, fuel, type, cc, cost);
        this.height = height;
        this.trunk = trunk;
    }

    // --------------- Getters ---------------
    @Override
    public String getSeatsORHeight() {return String.valueOf(height);}

    @Override
    public String getDoorsORTrunk() {
        String i = null;
        switch (trunk)
        {
            case Saddlebags -> i="Saddlebags";
            case Tail -> i="Tail";
            case Fender -> i="Fender";
            case Handlebar -> i="Handlebar";
        }
        return i;
    }

    // --------------- Setters ---------------
    @Override
    public void setSeatsORHeight(int i) {this.height = i;}

    @Override
    public void setDoorsORTrunk(int i) {
        switch (i)
        {
            case 0 -> trunk=Trunk.Saddlebags;
            case 1 -> trunk = Trunk.Tail;
            case 2 -> trunk = Trunk.Handlebar;
            case 3 -> trunk = Trunk.Fender;
        }}
}
