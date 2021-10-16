// Αναστάσιος Νομικός - ΑΜ: Ε12132

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Objects;

public class App extends JFrame{
    private JPanel App;
    private JPanel Main_Window;
    private JPanel cityWin;
    private JButton manageCitiesButton;
    private JTabbedPane tabbedPane1;
    private JButton cityBack;
    private JPanel storeWin;
    private JPanel vehicleWin;
    private JPanel clientWin;
    private JPanel rentalWin;
    private JTabbedPane tabbedPane2;
    private JButton storeBack;
    private JButton vehicleBack;
    private JTabbedPane tabbedPane3;
    private JButton manageStoresButton;
    private JButton manageClientsButton;
    private JButton manageVehiclesButton;
    private JButton manageRentalsButton;
    private JButton clientBack;
    private JTabbedPane tabbedPane4;
    private JButton rentalBack;
    private JTabbedPane tabbedPane5;
    private JTextField newCityTXT;
    private JButton newCityBTN;
    private JTextField newStoreTXT;
    private JButton newStoreBTN;
    private JTextField newClientID;
    private JTextField newClientLicence;
    private JTextField newClientName;
    private JTextField newClientSurname;
    private JTextField newClientEmail;
    private JTextField newClientAddress;
    private JTextField newClientTelephone;
    private JButton addClientBTN;
    private JButton newRentalBTN;
    private JComboBox<String> newRentalVehicle;
    private JComboBox<String> newRentalClient;
    private JComboBox<String> newRentalPickStore;
    private JComboBox<String> newRentalReturnStore;
    private JTable cityTable;
    private JButton cityEditBTN;
    private JButton cityDelBTN;
    private JTextField cityEditTXT;
    private JTable storeTable;
    private JTable vehicleTable;
    private JTable clientTable;
    private JTextField storeEditTXT;
    private JButton storeEditBTN;
    private JButton storeDelBTN;
    private JComboBox<String> storeSearchBOX;
    private JButton storeSearchBTN;
    private JTextField searchClientTXT;
    private JButton searchClientBTN;
    private JButton clientDelBTN;
    private JButton editClientBTN;
    private JButton editClientConfirmBTN;
    private JTextField editClientName;
    private JTextField editClientSurname;
    private JTextField editClientEmail;
    private JTextField editClientAddress;
    private JTextField editClientTelephone;
    private JPanel editClientWin;
    private JLabel previousID;
    private JLabel previousLicence;
    private JComboBox<String> newStoreCityBox;
    private JTable rentalTable;
    private JButton rentalDelBTN;
    private JButton vehicleDelBTN;
    private JButton vehicleEditBTN;
    private JComboBox<String> vehicleSearchBox;
    private JButton vehicleSearchBTN;
    private JTextField vehiclePlateTXT;
    private JTextField vehicleModelTXT;
    private JRadioButton gasRADIO;
    private JRadioButton dieselRADIO;
    private JRadioButton scooterRadio;
    private JRadioButton smallCarRadio;
    private JRadioButton motorcycleRadio;
    private JRadioButton mediumCarRadio;
    private JRadioButton largeCarRadio;
    private JTextField vehicleCCTXT;
    private JTextField vehicleCostTXT;
    private JButton newVehicleBTN;
    private JTextField carSeatsTXT;
    private JTextField carDoorsTXT;
    private JTextField bikeHeightTXT;
    private JComboBox<String> bikeTrunkBox;
    private JPanel editCarWin;
    private JLabel previousCar;
    private JTextField carModel;
    private JRadioButton carGas;
    private JTextField carCC;
    private JTextField carCost;
    private JTextField carSeats;
    private JTextField carDoors;
    private JRadioButton carSmall;
    private JRadioButton carM;
    private JRadioButton carL;
    private JRadioButton carDiesel;
    private JButton carConfirm;
    private JButton allStoresBTN;
    private JButton allVehiclesBTN;
    private JButton allClientsBTN;
    private JPanel editBikeWin;
    private JTextField bikeCost;
    private JTextField bikeHeight;
    private JTextField bikeCC;
    private JTextField bikeModel;
    private JRadioButton bikeGas;
    private JComboBox<String> bikeTrunkEditBox;
    private JButton bikeConfirm;
    private JRadioButton bikeDiesel;
    private JRadioButton bikeScooter;
    private JRadioButton bikeMotorcycle;
    private JLabel previousBike;

    private final ArrayList<City> cityList = new ArrayList<>();
    private final ArrayList<Store> storeList = new ArrayList<>();
    private final ArrayList<Client> clientList = new ArrayList<>();
    private final ArrayList<Rental> rentalList = new ArrayList<>();
    private final ArrayList<Vehicle> vehicleList = new ArrayList<>();


    // ------------------------------ Helper Function ------------------------------

    private void fillData()
    {
        City city1 = new City("Athens");
        cityList.add(city1);
        City city2 = new City("Volos");
        cityList.add(city2);

        Store store1 = new Store("Magazi1", city1.getName());
        storeList.add(store1);
        Store store2 = new Store("Magazi2", city1.getName());
        storeList.add(store2);

        Client client1 = new Client("AK4710", "A210", "Tasos", "Nomikos", "tasos@nomikos.com", "Zwgrafou 10", "2102345678");
        clientList.add(client1);
        Client client2 = new Client("HZ7894", "B123", "Stathis", "Tsirigwths", "stathis@tsirigotis.com", "Zwgrafou 15", "2101234567");
        clientList.add(client2);

        Car car = new Car("ABG123", "Ford Fiesta", Vehicle.Fuel.Diesel, Vehicle.Type.S_Car, 1200, 20, 5, 3);
        vehicleList.add(car);
        TwoWheeled bike = new TwoWheeled("EZH123", "Yamaha", Vehicle.Fuel.Gas, Vehicle.Type.Motorcycle, 900, 15, 120, TwoWheeled.Trunk.Saddlebags);
        vehicleList.add(bike);
    }

    // ------------------------------ Methods ------------------------------

    public void deleteClient(String ID)
    {
        clientList.removeIf(i -> i.getID().equals(ID));
    }

    public void deleteStore(int ID)
    {
        storeList.removeIf(i -> i.getID() == ID );
    }

    public void deleteCity(int ID)
    {
        cityList.removeIf(i -> i.getID() == ID );
    }

    public void deleteVehicle(String plate)
    {
        vehicleList.removeIf(i -> i.getID().equals(plate));
    }

    public void cancelRental(int ID)
    {
        rentalList.removeIf(i -> i.getID() == ID);
    }

    // ------------------------------------------------- PopUp windows -------------------------------------------------
    private void popSelect(JPanel panel)
    {
        JOptionPane.showMessageDialog(panel, "Select an item first.");
    }

    private void popFill(JPanel panel)
    {
        JOptionPane.showMessageDialog(panel, "Please fill all the appropriate fields.");
    }

    // ------------------------------------------------- fill JBoxes, JComboBoxes, JTables -------------------------------------------------
    private void populateBox(JComboBox<String> box, String where)
    {
        box.removeAllItems();
        switch (where)
        {
            case "Store" -> { //fill Store's ComboBox with names of cities
                for (City i : cityList)
                    box.addItem(i.getName());
            }
            case "Vehicle" -> {
                box.addItem("TwoWheeled");
                box.addItem("Car");
            }
            case "Trunk" -> {
                box.addItem("Saddlebags");
                box.addItem("Tail");
                box.addItem("Handlebar");
                box.addItem("Fender");
            }
        }
    }

    private void populateSearchTable(String window, String search)
    {
        switch (window)
        {
            case "Store" -> {
                String[] a ={"ID", "Name", "City"};
                populateJTable(storeTable, a, window, search);
            }
            case "Vehicle" -> {
                String[] b;
                if (search.equals("Car"))
                    b = new String[]{"Plate", "Model", "Fuel", "Type", "CC (L)", "Cost (per day)", "Seats", "Doors"};
                else
                    b = new String[]{"Plate", "Model", "Fuel", "Type", "CC (L)", "Cost (per day)", "Height", "Trunk"};

                populateJTable(vehicleTable, b, window, search);
            }
            case "Client" -> {
                String[] d = {"ID", "Licence", "Name", "Surname", "E-mail", "Address", "Telephone"};
                populateJTable(clientTable, d, window, search);
            }
        }
    }

    private void populateJTable(JTable table, String[] columns, String list, String search)
    {
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);

        switch (list) {
            case "Store" -> {
                for (Store i : storeList) {
                    if (i.getCity().equals(search))
                    {
                        int ID = i.getID();
                        String name = i.getName();

                        String[] data = {String.valueOf(ID), name, search};
                        tableModel.addRow(data);
                    }
                }
                table.setModel(tableModel);
            }
            case "Vehicle" -> {
                for (Vehicle i : vehicleList) {
                    String type = i.getType_of_vehicle();
                    if (search.equals("Car"))
                    {
                        if (type.equals("S_Car") || type.equals("M_Car") || type.equals("L_Car"))
                        {
                            String plate = i.getID();
                            String model = i.getModel();
                            String fuel = i.getFuel().toString();
                            String cc = String.valueOf(i.getCc());
                            String cost = String.valueOf(i.getCost());
                            String seatsORheight = i.getSeatsORHeight();
                            String doorsORtrunk = i.getDoorsORTrunk();
                            String[] data = {plate, model, fuel, type, cc, cost, seatsORheight, doorsORtrunk};
                            tableModel.addRow(data);
                        }
                    }
                    else
                    {
                        if (type.equals("Scooter") || type.equals("Motorcycle"))
                        {
                            String plate = i.getID();
                            String model = i.getModel();
                            String fuel = i.getFuel().toString();
                            String cc = String.valueOf(i.getCc());
                            String cost = String.valueOf(i.getCost());
                            String seatsORheight = i.getSeatsORHeight();
                            String doorsORtrunk = i.getDoorsORTrunk();
                            String[] data = {plate, model, fuel, type, cc, cost, seatsORheight, doorsORtrunk};
                            tableModel.addRow(data);
                        }
                    }
                }
                table.setModel(tableModel);
            }
            case "Client" -> {

                for (Client i : clientList) {
                    if (search.equals(i.getID()))
                    {
                        String licence = i.getLicence();
                        String name = i.getName();
                        String surname = i.getSurname();
                        String email = i.getEmail();
                        String address = i.getAddress();
                        String tel = i.getTelephone();

                        String[] data = {search, licence, name, surname, email, address, tel};
                        tableModel.addRow(data);
                    }
                }
                table.setModel(tableModel);
            }
        }
    }

    private void populateJTable(String window)
    {
        switch (window) {
            case "City" -> {
                String[] a = {"ID", "Name"};
                populateJTable(cityTable, a, window);
            }
            case "Store" ->{
                    String[] b = {"ID", "Name", "City"};
                    populateJTable(storeTable, b, window);
            }
            case "Vehicle" -> {
                String[] c = {"Plate", "Model", "Fuel", "Type", "CC (L)", "Cost (per day)", "Seats/Height", "Doors/Trunk"};
                populateJTable(vehicleTable, c, window);
            }
            case "Client" -> {
                String[] d = {"ID", "Licence", "Name", "Surname", "E-mail", "Address", "Telephone"};
                populateJTable(clientTable, d, window);
            }
            case "Rental" -> {
                String[] e = {"ID", "Plate", "Client", "Pick-up Store", "Pick-up Date", "Drop-off Store", "Drop-off Date", "Total cost"};
                populateJTable(rentalTable, e, window);
            }
        }
    }

    private void populateJTable(JTable table, String[] columns, String list)
    {
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);

        switch (list)
        {
            case "City":
                for (City i: cityList)
                {
                    int ID = i.getID();
                    String name = i.getName();

                    String[] data = {String.valueOf(ID), name};
                    tableModel.addRow(data);
                }

                table.setModel(tableModel);
                break;

            case "Store":
                for (Store i: storeList)
                {
                    int ID = i.getID();
                    String name = i.getName();
                    String city = i.getCity();

                    String[] data = {String.valueOf(ID), name, city};
                    tableModel.addRow(data);
                }

                table.setModel(tableModel);
                break;
            case "Vehicle":
                for (Vehicle i : vehicleList)
                {
                    String plate = i.getID();
                    String model = i.getModel();
                    String fuel = i.getFuel().toString();
                    String type = i.getType_of_vehicle();
                    String cc = String.valueOf(i.getCc());
                    String cost = String.valueOf(i.getCost());
                    String seatsORheight = i.getSeatsORHeight();
                    String doorsORtrunk = i.getDoorsORTrunk();

                    String[] data = {plate, model, fuel, type, cc, cost, seatsORheight, doorsORtrunk};
                    tableModel.addRow(data);
                }

                table.setModel(tableModel);
                break;
            case "Client":
                for (Client i: clientList)
                {
                    String ID = i.getID();
                    String licence = i.getLicence();
                    String name = i.getName();
                    String surname = i.getSurname();
                    String email = i.getEmail();
                    String address = i.getAddress();
                    String tel = i.getTelephone();

                    String[] data = {ID, licence, name, surname, email, address, tel};
                    tableModel.addRow(data);
                }

                table.setModel(tableModel);
                break;
            case "Rental":
                for (Rental i : rentalList)
                {
                    String ID = String.valueOf(i.getID());
                    String plate = i.getVehicle_ID();
                    String client = i.getClient();
                    String pick_store = String.valueOf(i.getStore_acquire());
                    String drop_store = String.valueOf(i.getStore_return());

                    //dates
                    String[] data = {ID, plate, client, pick_store, drop_store};
                    tableModel.addRow(data);
                }
                break;
        }
    }


    // ------------------------------ GUI Stuff ------------------------------

    private void switchPanel(JPanel panel)
    {
        App.removeAll();
        App.add(panel);
        App.repaint();
        App.revalidate();
    }

    public void deleteEntry(int col, JTable table, String window)
    {
        int row = table.getSelectedRow();
        int toDel;
        String toDelete;

        switch (window) {
            case "City" -> {
                toDel = Integer.parseInt(table.getModel().getValueAt(row, col).toString());
                deleteCity(toDel);
            }
            case "Store" -> {
                toDel = Integer.parseInt(table.getModel().getValueAt(row, col).toString());
                deleteStore(toDel);
            }
            case "Vehicle" -> {
                toDelete = table.getModel().getValueAt(row, col).toString();
                deleteVehicle(toDelete);
            }
            case "Client" -> {
                toDelete = table.getModel().getValueAt(row, col).toString();
                deleteClient(toDelete);
            }
            case "Rental" -> {
                toDel = Integer.parseInt(table.getModel().getValueAt(row, col).toString());
                cancelRental(toDel);
            }
        }

        populateJTable(window);
    }
    //ΑΝ ΓΡΑΨΕΙ ΟΤΙΔΗΠΟΤΕ ΕΚΤΟΣ ΑΠΟ ΑΥΤΑ ΤΑ 3, ΔΕΝ ΤΟ ΔΕΧΕΤΑΙ
    private void isDigit(KeyEvent e)
    {
        char c = e.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE)))
            e.consume();
    }

    public App()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100, 1200, 700);
        setLocationRelativeTo(null);
        setContentPane(App);
        setTitle("Ableton");

        fillData();

        // ------------------------------------------------- Buttons that switch between panels -------------------------------------------------
        manageCitiesButton.addActionListener(e -> {
            switchPanel(cityWin);
            populateJTable("City");
        });
        cityBack.addActionListener(e -> switchPanel(Main_Window));
        storeBack.addActionListener(e -> switchPanel(Main_Window));
        clientBack.addActionListener(e -> switchPanel(Main_Window));
        vehicleBack.addActionListener(e -> switchPanel(Main_Window));
        rentalBack.addActionListener(e -> switchPanel(Main_Window));

        manageStoresButton.addActionListener(e -> {
            populateBox(storeSearchBOX, "Store");
            populateBox(newStoreCityBox, "Store");
            populateJTable("Store");
            switchPanel(storeWin);
        });
        manageClientsButton.addActionListener(e -> {
            populateJTable("Client");
            switchPanel(clientWin);
        });
        manageVehiclesButton.addActionListener(e -> {
            populateBox(vehicleSearchBox, "Vehicle");
            populateBox(bikeTrunkBox, "Trunk");
            populateJTable("Vehicle");
            switchPanel(vehicleWin);
        });
        manageRentalsButton.addActionListener(e -> {
            populateJTable("Rental");

            newRentalClient.removeAllItems();
            newRentalVehicle.removeAllItems();
            newRentalPickStore.removeAllItems();
            newRentalReturnStore.removeAllItems();

            for (Client i : clientList)
                newRentalClient.addItem(i.getID());

            for (Vehicle i : vehicleList)
                newRentalVehicle.addItem(i.getID());

            for (Store i : storeList)
            {
                newRentalPickStore.addItem(i.getName());
                newRentalReturnStore.addItem(i.getName());
            }

            switchPanel(rentalWin);
        });



        // ------------------------------------------------- DIGITS ONLY ALLOWED -------------------------------------------------
        KeyAdapter listener1 = new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                isDigit(e);
            }
        };
        carSeatsTXT.addKeyListener(listener1);
        carDoorsTXT.addKeyListener(listener1);
        bikeHeightTXT.addKeyListener(listener1);
        newClientTelephone.addKeyListener(listener1);
        editClientTelephone.addKeyListener(listener1);
        vehicleCostTXT.addKeyListener(listener1);
        vehicleCCTXT.addKeyListener(listener1);
        carCC.addKeyListener(listener1);
        carCost.addKeyListener(listener1);
        carSeats.addKeyListener(listener1);
        carDoors.addKeyListener(listener1);
        bikeCost.addKeyListener(listener1);
        bikeHeight.addKeyListener(listener1);
        bikeCC.addKeyListener(listener1);

        // -------------------------------------------------  New entries -------------------------------------------------
        newCityBTN.addActionListener(e -> {
            String cityName = newCityTXT.getText();
            City cityNew = new City(cityName);
            cityList.add(cityNew);

            populateJTable("City");
        });

        addClientBTN.addActionListener(e -> {
            String ID = newClientID.getText();
            String licence = newClientLicence.getText();
            String name = newClientName.getText();
            String surname = newClientSurname.getText();
            String email = newClientEmail.getText();
            String address = newClientAddress.getText();
            String tel = newClientTelephone.getText();

            Client clientNew = new Client(ID, licence, name, surname, email, address, tel);
            clientList.add(clientNew);

            populateJTable("Client");
        });

        newStoreBTN.addActionListener(e -> {
            String name = newStoreTXT.getText();
            String city = Objects.requireNonNull(newStoreCityBox.getSelectedItem()).toString();

            Store storeNew = new Store(name, city);
            storeList.add(storeNew);

            populateJTable("Store");
        });

        newVehicleBTN.addActionListener(e -> {
            String plate = vehiclePlateTXT.getText();
            String model = vehicleModelTXT.getText();
            int cc = Integer.parseInt(vehicleCCTXT.getText());
            int cost = Integer.parseInt(vehicleCostTXT.getText());

            Vehicle.Fuel fuel = null;
            Vehicle.Type type = null;
            if (gasRADIO.isSelected())
                fuel = Vehicle.Fuel.Gas;
            else if (dieselRADIO.isSelected())
                fuel = Vehicle.Fuel.Diesel;

            if (scooterRadio.isSelected())
                type = Vehicle.Type.Scooter;
            else if (motorcycleRadio.isSelected())
                type = Vehicle.Type.Motorcycle;
            else if (smallCarRadio.isSelected())
                type = Vehicle.Type.S_Car;
            else if (mediumCarRadio.isSelected())
                type = Vehicle.Type.M_Car;
            else if (largeCarRadio.isSelected())
                type = Vehicle.Type.L_Car;

            if (type == Vehicle.Type.Scooter || type == Vehicle.Type.Motorcycle)
            {
                int height = Integer.parseInt(bikeHeightTXT.getText());
                TwoWheeled.Trunk trunk;
                int i = bikeTrunkBox.getSelectedIndex();
                if (i == 0)
                    trunk = TwoWheeled.Trunk.Saddlebags;
                else if (i == 1)
                    trunk = TwoWheeled.Trunk.Tail;
                else if (i == 2)
                    trunk = TwoWheeled.Trunk.Handlebar;
                else
                    trunk = TwoWheeled.Trunk.Fender;

                TwoWheeled item = new TwoWheeled(plate, model, fuel, type, cc, cost, height, trunk);
                vehicleList.add(item);
            }
            else
            {
                int doors = Integer.parseInt(carDoorsTXT.getText());
                int seats = Integer.parseInt(carSeatsTXT.getText());
                Car item = new Car(plate, model, fuel, type, cc, cost, seats, doors);
                vehicleList.add(item);
            }

            populateJTable("Vehicle");
        });

        newRentalBTN.addActionListener(e -> {
            String plate = Objects.requireNonNull(newRentalVehicle.getSelectedItem()).toString();
            String clientID = Objects.requireNonNull(newRentalClient.getSelectedItem()).toString();
            String pickStore = Objects.requireNonNull(newRentalPickStore.getSelectedItem()).toString();
            String returnStore = Objects.requireNonNull(newRentalReturnStore.getSelectedItem()).toString();
        });

        // ------------------------------------------------- Edit entries -------------------------------------------------
        cityEditBTN.addActionListener(e -> {

            if (cityTable.getSelectionModel().isSelectionEmpty())
                JOptionPane.showMessageDialog(cityWin, "Select an item first");
            else
            {
                String name = cityEditTXT.getText();
                int row = cityTable.getSelectedRow();
                int toEdit = Integer.parseInt(cityTable.getModel().getValueAt(row, 0).toString());

                for (City i: cityList)
                {
                    int ID = i.getID();
                    if (ID == toEdit)
                    {
                        i.setName(name);
                        break;
                    }
                }
                populateJTable("City");
            }
        });

        storeEditBTN.addActionListener(e -> {
            if (storeTable.getSelectionModel().isSelectionEmpty())
                popSelect(storeWin);
            else
            {
                String name = storeEditTXT.getText();
                int row = storeTable.getSelectedRow();
                int toEdit = Integer.parseInt(storeTable.getModel().getValueAt(row, 0).toString());

                for (Store i: storeList)
                {
                    int ID = i.getID();
                    if (ID == toEdit)
                    {
                        i.setName(name);
                        break;
                    }
                }
                populateJTable("Store");
            }
        } );

        carConfirm.addActionListener(e -> {
                    String model = carModel.getText();
                    int cc = Integer.parseInt(carCC.getText());
                    int cost = Integer.parseInt(carCost.getText());
                    int seats = Integer.parseInt(carSeats.getText());
                    int doors = Integer.parseInt(carDoors.getText());

                    Vehicle.Fuel fuel;
                    if (carGas.isSelected())
                        fuel = Vehicle.Fuel.Gas;
                    else fuel = Vehicle.Fuel.Diesel;

                    Vehicle.Type type;
                    if (carSmall.isSelected())
                        type = Vehicle.Type.S_Car;
                    else if (carM.isSelected())
                        type = Vehicle.Type.M_Car;
                    else
                        type = Vehicle.Type.L_Car;

                    int row = vehicleTable.getSelectedRow();
                    String toEdit = vehicleTable.getModel().getValueAt(row, 0).toString();
                    for (Vehicle i : vehicleList) {
                        String ID = i.getID();
                        if (ID.equals(toEdit)) {
                            i.setPlate(ID);
                            i.setModel(model);
                            i.setType_of_vehicle(type);
                            i.setFuel(fuel);
                            i.setCc(cc);
                            i.setCost(cost);
                            i.setSeatsORHeight(seats);
                            i.setDoorsORTrunk(doors);
                        }

                    }
                    populateJTable("Vehicle");
                    switchPanel(vehicleWin);
                });

        bikeConfirm.addActionListener(e -> {
            String model = bikeModel.getText();
            int cc = Integer.parseInt(bikeCC.getText());
            int cost = Integer.parseInt(bikeCost.getText());
            int height = Integer.parseInt(bikeHeight.getText());


            Vehicle.Fuel fuel;
            if (bikeGas.isSelected())
                fuel = Vehicle.Fuel.Gas;
            else fuel = Vehicle.Fuel.Diesel;

            Vehicle.Type type;
            if (bikeScooter.isSelected())
                type = Vehicle.Type.Scooter;
            else
                type = Vehicle.Type.Motorcycle;

            int trunk = bikeTrunkEditBox.getSelectedIndex();

            int row = vehicleTable.getSelectedRow();
            String toEdit = vehicleTable.getModel().getValueAt(row, 0).toString();

            for (Vehicle i : vehicleList) {
                String ID = i.getID();
                if (ID.equals(toEdit)) {
                    i.setPlate(ID);
                    i.setModel(model);
                    i.setType_of_vehicle(type);
                    i.setFuel(fuel);
                    i.setCc(cc);
                    i.setCost(cost);
                    i.setSeatsORHeight(height);
                    i.setDoorsORTrunk(trunk);
                }
            }
            populateJTable("Vehicle");
            switchPanel(vehicleWin);
        });

        editClientConfirmBTN.addActionListener(e -> {
            String name = editClientName.getText();
            String surname = editClientSurname.getText();
            String email = editClientEmail.getText();
            String address = editClientAddress.getText();
            String tel = editClientTelephone.getText();

            int row = clientTable.getSelectedRow();
            String toEdit = clientTable.getModel().getValueAt(row, 0).toString();

            for (Client i: clientList)
            {
                String ID = i.getID();
                if (ID.equals(toEdit))
                {
                    i.setName(name);
                    i.setSurname(surname);
                    i.setEmail(email);
                    i.setAddress(address);
                    i.setTelephone(tel);
                    break;
                }
            }
            populateJTable("Client");

            switchPanel(clientWin);
        });

        editClientBTN.addActionListener(e -> {
            if (clientTable.getSelectionModel().isSelectionEmpty())
                popSelect(clientWin);
            else
            {
                int row = clientTable.getSelectedRow();

                String toEdit = clientTable.getModel().getValueAt(row, 0).toString();

                for (Client i: clientList)
                {
                    String ID = i.getID();
                    if (ID.equals(toEdit))
                    {
                        previousID.setText(i.getID());
                        previousLicence.setText(i.getLicence());
                        editClientName.setText(i.getName());
                        editClientSurname.setText(i.getSurname());
                        editClientEmail.setText(i.getEmail());
                        editClientAddress.setText(i.getAddress());
                        editClientTelephone.setText(i.getTelephone());
                        break;
                    }
                }
                switchPanel(editClientWin);
            }
        });

        vehicleEditBTN.addActionListener(e -> {
            if (vehicleTable.getSelectionModel().isSelectionEmpty())
                popSelect(vehicleWin);
            else
            {
                int row = vehicleTable.getSelectedRow();
                String toEdit = vehicleTable.getModel().getValueAt(row, 0).toString();
                String currType = vehicleTable.getModel().getValueAt(row, 3).toString();

                if (currType.equals("Scooter") || currType.equals("Motorcycle"))
                {
                    populateBox(bikeTrunkEditBox, "Trunk");
                    for (Vehicle i: vehicleList)
                    {
                        String ID = i.getID();
                        if (ID.equals(toEdit))
                        {
                            previousBike.setText(i.getID());
                            bikeModel.setText(i.getModel());
                            bikeCC.setText(String.valueOf(i.getCc()));
                            bikeCost.setText(String.valueOf(i.getCost()));

                            Vehicle.Fuel fuel = i.getFuel();
                            if (fuel == Vehicle.Fuel.Gas)
                                bikeGas.setSelected(true);
                            else bikeDiesel.setSelected(true);

                            String type = i.getType_of_vehicle();
                            switch (type) {
                                case "Scooter" -> {
                                    bikeScooter.setSelected(true);
                                    bikeHeight.setText(i.getSeatsORHeight());
                                    bikeTrunkEditBox.setSelectedItem(i.getDoorsORTrunk());
                                }
                                case "Motorcycle" -> {
                                    bikeMotorcycle.setSelected(true);
                                    bikeHeight.setText(i.getSeatsORHeight());
                                    bikeTrunkEditBox.setSelectedItem(i.getDoorsORTrunk());
                                }
                            }
                            switchPanel(editBikeWin);
                            break;
                        }
                    }
                }

                else
                {
                    for (Vehicle i: vehicleList)
                    {
                        String ID = i.getID();
                        if (ID.equals(toEdit))
                        {
                            previousCar.setText(i.getID());
                            carModel.setText(i.getModel());
                            carCC.setText(String.valueOf(i.getCc()));
                            carCost.setText(String.valueOf(i.getCost()));
                            carSeats.setText(i.getSeatsORHeight());
                            carDoors.setText(i.getDoorsORTrunk());

                            Vehicle.Fuel fuel = i.getFuel();
                            if (fuel == Vehicle.Fuel.Gas)
                                carGas.setSelected(true);
                            else carDiesel.setSelected(true);

                            String type = i.getType_of_vehicle();
                            switch (type)
                            {
                                case "S_Car" -> carSmall.setSelected(true);
                                case "M_Car" -> carM.setSelected(true);
                                case "L_Car" -> carL.setSelected(true);
                            }

                            switchPanel(editCarWin);
                            break;
                        }
                    }
                }
            }
        });


        // ------------------------------------------------- Delete entries -------------------------------------------------
        cityDelBTN.addActionListener(e -> {
            if (cityTable.getSelectionModel().isSelectionEmpty())
                popSelect(cityWin);
            else deleteEntry(0, cityTable, "City"); } );

        storeDelBTN.addActionListener(e -> {
            if (storeTable.getSelectionModel().isSelectionEmpty())
                popSelect(storeWin);
            else deleteEntry(0, storeTable, "Store"); } );

        clientDelBTN.addActionListener(e -> {
            if (clientTable.getSelectionModel().isSelectionEmpty())
                popSelect(clientWin);
            else deleteEntry(0, clientTable, "Client"); } );

        vehicleDelBTN.addActionListener(e -> {
            if (vehicleTable.getSelectionModel().isSelectionEmpty())
                popSelect(vehicleWin);
            else deleteEntry(0, vehicleTable, "Vehicle");
        });

        rentalDelBTN.addActionListener(e -> {
            if (rentalTable.getSelectionModel().isSelectionEmpty())
                popSelect(rentalWin);
            else deleteEntry(0, rentalTable, "Rental");
        });

        // ------------------------------------------------- Search entries -------------------------------------------------
        storeSearchBTN.addActionListener(e -> {
            String search = Objects.requireNonNull(storeSearchBOX.getSelectedItem()).toString();
            if (search.isEmpty())
                popFill(storeWin);
            else
            {
                populateSearchTable("Store", search);
            }
        });

        vehicleSearchBTN.addActionListener(e -> {
            String search = Objects.requireNonNull(vehicleSearchBox.getSelectedItem()).toString();
            populateSearchTable("Vehicle", search);
        });

        searchClientBTN.addActionListener(e -> {
            String search = searchClientTXT.getText();
            populateSearchTable("Client", search);
        });

        // ------------------------------------------------- Show all entries -------------------------------------------------
        allStoresBTN.addActionListener(e -> populateJTable("Store"));
        allVehiclesBTN.addActionListener(e -> populateJTable("Vehicle"));
        allClientsBTN.addActionListener(e -> populateJTable("Client"));
    }
}

