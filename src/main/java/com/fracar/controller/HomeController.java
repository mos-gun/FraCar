package com.fracar.controller;

import com.fracar.config.StageManager;
import com.fracar.entity.*;
import com.fracar.service.AddressService;
import com.fracar.service.CustomerService;
import com.fracar.service.VehicleService;
import com.fracar.view.FxmlView;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;


@Controller
public class HomeController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane paneHome;

    @FXML
    private MenuBar menubarHome;                                    //Menu bar

    @FXML
    private Menu btnMenuNew;

    @FXML
    private MenuItem btnMenuNewCustomer;

    @FXML
    private MenuItem btnMenuNewVehicle;

    @FXML
    private Menu btnMenuEdit;

    @FXML
    private MenuItem btnMenuEditCustomer;

    @FXML
    private MenuItem btnMenuEditVehicle;

    @FXML
    private Menu btnMenuOther;

    @FXML
    private MenuItem btnMenuOtherPrint;

    @FXML
    private MenuItem btnMenuOtherHelp;

    @FXML
    private MenuItem btnMenuOtherExit;                             // Menu bar

    @FXML
    private Label lblEmployeeName;

    @FXML
    private Button btnLogout;

    @FXML
    private TextField txtfldSearchCustomer;                         //Customer Info

    @FXML
    private TextField txtfldDob;

    @FXML
    private TextField txtfldFirstName;

    @FXML
    private TextField txtfldLastName;

    @FXML
    private TextField txtfldEmail;

    @FXML
    private TextField txtfldPhoneNo;

    @FXML
    private TextField txtfldStreetName;

    @FXML
    private TextField txtfldHouseNo;

    @FXML
    private TextField txtfldZipCode;

    @FXML
    private TextField txtfldCity;                                   //Customer Info

    @FXML
    private DatePicker dateBegin;                                   // Vehicle Info

    @FXML
    private DatePicker dateEnd;

    @FXML
    private TextField txtfldFilter;

    @FXML
    private CheckBox cbxCategoryCompact;

    @FXML
    private CheckBox cbxCategoryConvertible;

    @FXML
    private CheckBox cbxCategorySUV;

    @FXML
    private TextField txtfldSelectedCategory;

    @FXML
    private TextField txtfldVehicleNo;

    @FXML
    private TextField txtfldVehicleInfo;

    @FXML
    private TextField txtfldCalcCost;                               // Vehicle Info

    @FXML
    private Button btnConfirmOrder;

    @FXML                                                           // TabPane
    private TabPane tabpaneHome;

    @FXML
    private Tab tabVehicle;

    @FXML
    private TableView<Vehicle> tblVehicle;

    @FXML
    private TableColumn<Vehicle, Long> tblclmVehicleNo;

    @FXML
    private TableColumn<Vehicle, String> tblclmBrand;

    @FXML
    private TableColumn<Vehicle, String> tblclmModel;

    @FXML
    private TableColumn<Vehicle, Integer> tblclmYear;

    @FXML
    private TableColumn<Vehicle, Integer> tblclmPS;

    @FXML
    private TableColumn<Vehicle, Integer> tblclmCurrentMilage;

    @FXML
    private TableColumn<Vehicle, Category> tblclmCategory;

    @FXML
    private TableColumn<Vehicle, Boolean> tblclmAvailability;

    @FXML
    private Tab tabCustomer;

    @FXML
    private TableView<Customer> tblCustomer;

    @FXML
    private TableColumn<Customer, Long> tblclmCustomerNo;

    @FXML
    private TableColumn<Customer, String> tblclmLastName;

    @FXML
    private TableColumn<Customer, String> tblclmFirstName;

    @FXML
    private TableColumn<Customer, LocalDate> tblclmDOB;                //???

    @FXML
    private TableColumn<Address, String> tblclmStreetName;

    @FXML
    private TableColumn<Address, String> tblclmHouseNo;

    @FXML
    private TableColumn<Address, String> tblclmZipCode;

    @FXML
    private TableColumn<Address, String> tblclmCity;

    @FXML
    private ListView<Customer> customerSearchResultList;

    private int sum;

    public int getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }


    @Lazy
    @Autowired
    StageManager stageManager;

    @Autowired
    LoginController loginController;

    @Autowired
    VehicleService vehicleService;

    @Autowired
    CustomerService customerService;

    @Autowired
    AddressService addressService;

    Vehicle choosenVehicle;

    Customer currentCustomer;

    Address addressCustomer;

    Employee employee;

    String selectedCategory;

    int priceOfDeposit = 0, priceCompact = 35, priceConvertible = 65, priceSUV = 85;

    private int pricePerDay = 0;

    public void setDateBegin(DatePicker dateBegin) {
        this.dateBegin = dateBegin;
    }

    public DatePicker getDateBegin() {
        return dateBegin;
    }

    public DatePicker getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(DatePicker dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Integer getPriceOfDeposit() {
        return priceOfDeposit;
    }

    public void setPriceOfDeposit(Integer priceOfDeposit) {
        this.priceOfDeposit = priceOfDeposit;
    }

    public Integer getPriceCompact() {
        return priceCompact;
    }

    public void setPriceCompact(Integer priceCompact) {
        this.priceCompact = priceCompact;
    }

    public Integer getPriceConvertible() {
        return priceConvertible;
    }

    public void setPriceConvertible(Integer priceConvertible) {
        this.priceConvertible = priceConvertible;
    }

    public Integer getPriceSUV() {
        return priceSUV;
    }

    public void setPriceSUV(Integer priceSUV) {
        this.priceSUV = priceSUV;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void calculatePrice() {
        switch (choosenVehicle.getCategoryAsString().toUpperCase()) {
            case "COMPACT":
                pricePerDay = priceCompact;
                priceOfDeposit = 500;
                sum = (priceCompact + 200) + priceOfDeposit;
                System.out.println("sum = " + sum);
                break;
            case "CONVERTIBLE":
                pricePerDay = priceConvertible;
                priceOfDeposit = 1000;
                sum = (priceConvertible + 400) + priceOfDeposit;
                System.out.println("sum = " + sum);
                break;
            case "SUV":
                pricePerDay = priceSUV;
                priceOfDeposit = 1500;
                sum = (priceSUV + 600) + priceOfDeposit;
                System.out.println("sum = " + sum);
                break;
            default:
                priceOfDeposit = 0;
                break;
        }
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Address getAddressCustomer() {
        return addressCustomer;
    }

    public void setAddressCustomer(Address addressCustomer) {
        this.addressCustomer = addressCustomer;
    }

    public Customer getCurrentCustomer() {
        return currentCustomer;
    }

    public void setCurrentCustomer(Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
    }


    public Vehicle getChoosenVehicle() {
        return choosenVehicle;
    }

    public void setChoosenVehicle(Vehicle choosenVehicle) {
        this.choosenVehicle = choosenVehicle;
    }

    public HomeController() {


    }


//___________________________________________________________________________________________________

    @FXML
    void chooseCategoryCompact(ActionEvent event) {              //choose Category/KM
        if (cbxCategoryCompact.isSelected()) {
            cbxCategoryConvertible.setSelected(false);
            cbxCategorySUV.setSelected(false);

            selectedCategory = cbxCategoryCompact.getText();
            txtfldSelectedCategory.setText(selectedCategory);
            priceOfDeposit = priceCompact;

        } else if (!cbxCategoryCompact.isSelected()) {
            txtfldSelectedCategory.setText("");
            priceOfDeposit = 0;
        }
    }

    @FXML
    void chooseCategoryConvertible(ActionEvent event) {
        if (cbxCategoryConvertible.isSelected()) {
            cbxCategoryCompact.setSelected(false);
            cbxCategorySUV.setSelected(false);

            selectedCategory = cbxCategoryConvertible.getText();
            txtfldSelectedCategory.setText(selectedCategory);
            priceOfDeposit = priceConvertible;

        } else if (!cbxCategoryConvertible.isSelected()) {
            txtfldSelectedCategory.setText("");
            priceOfDeposit = 0;
        }
    }

    @FXML
    void chooseCategorySUV(ActionEvent event) {
        if (cbxCategorySUV.isSelected()) {
            cbxCategoryCompact.setSelected(false);
            cbxCategoryConvertible.setSelected(false);

            selectedCategory = cbxCategorySUV.getText();
            txtfldSelectedCategory.setText(selectedCategory);
            priceOfDeposit = priceSUV;

        } else if (!cbxCategorySUV.isSelected()) {
            txtfldSelectedCategory.setText("");
            priceOfDeposit = 0;
        }
    }

    @FXML
    void logoutOnAction(ActionEvent event) {
        stageManager.switchScene(FxmlView.LOGIN);
    }

    @FXML
    void newCustomerOnAction(ActionEvent event) {
        stageManager.switchScene(FxmlView.NEW_CUSTOMER);
    }

    @FXML
    void newVehicleOnAction(ActionEvent event) {
        stageManager.switchScene(FxmlView.NEW_VEHICLE);
    }

    @FXML
    void editCustomerOnAction(ActionEvent event) {
        stageManager.switchScene(FxmlView.EDIT_CUSTOMER);
    }

    @FXML
    void editVehicleOnAction(ActionEvent event) {
        stageManager.switchScene(FxmlView.EDIT_VEHICLE);
    }

    @FXML
    void printOnAction(ActionEvent event) {
        List<String> choices = new ArrayList<>();
        choices.add("Customer");
        choices.add("Vehicle");
        choices.add("Order");

        ChoiceDialog<String> dialog = new ChoiceDialog<>("Customer", choices);
        dialog.setTitle("Print...");
        dialog.setHeaderText("Choose, what to print.");
        dialog.setContentText("Print a ");

        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Printing Process...");
            alert.showAndWait();
        }
    }

    @FXML
    void exitOnAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Request");
        alert.setHeaderText("Click <Exit> to close the application.");
        alert.setContentText("Do you want to exit the program?");

        ButtonType buttonTypeExit = new ButtonType("Exit");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeExit, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeExit) {
            System.exit(0);
        } else {

        }
    }

    @FXML
    void confirmOrderOnAction(ActionEvent event) {
        try {
            if (!dateBegin.getValue().equals(null) && !dateEnd.getValue().equals(null)) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Request");
                alert.setHeaderText("Click <Confirm> to create the order.");
                alert.setContentText("The order will be created.");

                ButtonType buttonTypeConfirm = new ButtonType("Confirm");
                ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

                alert.getButtonTypes().setAll(buttonTypeConfirm, buttonTypeCancel);
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == buttonTypeConfirm) {
                    stageManager.switchScene(FxmlView.ORDER_CONFIRMATION);
                } else {

                }
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Dates have not been entered.");
            alert.showAndWait();
        }
    }


    @FXML
    void searchCustomerOnAction(ActionEvent event) {
        String searchTerm = txtfldSearchCustomer.getText();
        ObservableList<Customer> customers = FXCollections.observableArrayList(customerService.findBySearchTerm(searchTerm));
        if (customers.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Customer Search failed!");
            alert.setContentText("No customers were found. \nPlease try again.");
            alert.showAndWait();
        } else {
            customerSearchResultList.setItems(customers);
        }
    }

    @FXML
    public void onCustomerSearchResultClick(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount() == 2) {
            Customer customer = customerSearchResultList.getSelectionModel().getSelectedItem();
            Address address = customer.getAddressId();
            txtfldDob.setText(customer.getDob().toString());
            txtfldFirstName.setText(customer.getFirstName());
            txtfldLastName.setText(customer.getLastName());
            txtfldStreetName.setText(address.getStreetName());
            txtfldHouseNo.setText(address.getHouseNo());
            txtfldZipCode.setText(address.getZipCode());
            txtfldCity.setText(address.getCity());
            txtfldEmail.setText(address.getEmail());
            txtfldPhoneNo.setText(address.getPhoneNo());
            setAddressCustomer(address);
            customer.setAddressId(address);
            setCurrentCustomer(customer);
        }

    }


    @FXML
    public void chooseVehicle(ActionEvent event) {

        try {
            Vehicle vehicle = vehicleService.findEntityById(Long.parseLong(txtfldVehicleNo.getText()));
            String vehicleInfo = vehicle.getBrand() + " " + vehicle.getModel();
            txtfldVehicleInfo.setText(vehicleInfo);
            setChoosenVehicle(vehicle);
            calculatePrice();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Vehicle Search failed!");
            alert.setContentText("Vehicle number not entered or does not exist.");
            alert.showAndWait();
        }
//         else {
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Information");
//            alert.setHeaderText("Vehicle Search");
//            alert.setContentText("Vehicle with entered vehicle no. does not exist.");
//            alert.showAndWait();
//        }
    }

    @Override
    public String toString() {
        return "HomeController{" +
                "resources=" + resources +
                ", location=" + location +
                ", paneHome=" + paneHome +
                ", menubarHome=" + menubarHome +
                ", btnMenuNew=" + btnMenuNew +
                ", btnMenuNewCustomer=" + btnMenuNewCustomer +
                ", btnMenuNewVehicle=" + btnMenuNewVehicle +
                ", btnMenuEdit=" + btnMenuEdit +
                ", btnMenuEditCustomer=" + btnMenuEditCustomer +
                ", btnMenuEditVehicle=" + btnMenuEditVehicle +
                ", btnMenuOther=" + btnMenuOther +
                ", btnMenuOtherPrint=" + btnMenuOtherPrint +
                ", btnMenuOtherHelp=" + btnMenuOtherHelp +
                ", btnMenuOtherExit=" + btnMenuOtherExit +
                ", lblEmployeeName=" + lblEmployeeName +
                ", btnLogout=" + btnLogout +
                ", txtfldSearchCustomer=" + txtfldSearchCustomer +
                ", txtfldDob=" + txtfldDob +
                ", txtfldFirstName=" + txtfldFirstName +
                ", txtfldLastName=" + txtfldLastName +
                ", txtfldEmail=" + txtfldEmail +
                ", txtfldPhoneNo=" + txtfldPhoneNo +
                ", txtfldStreetName=" + txtfldStreetName +
                ", txtfldHouseNo=" + txtfldHouseNo +
                ", txtfldZipCode=" + txtfldZipCode +
                ", txtfldCity=" + txtfldCity +
                ", dateBegin=" + dateBegin +
                ", dateEnd=" + dateEnd +
                ", txtfldFilter=" + txtfldFilter +
                ", cbxCategoryCompact=" + cbxCategoryCompact +
                ", cbxCategoryConvertible=" + cbxCategoryConvertible +
                ", cbxCategorySUV=" + cbxCategorySUV +
                ", txtfldSelectedCategory=" + txtfldSelectedCategory +
                ", txtfldVehicleNo=" + txtfldVehicleNo +
                ", txtfldVehicleInfo=" + txtfldVehicleInfo +
                ", txtfldCalcCost=" + txtfldCalcCost +
                ", btnConfirmOrder=" + btnConfirmOrder +
                ", tabpaneHome=" + tabpaneHome +
                ", tabVehicle=" + tabVehicle +
                ", tblVehicle=" + tblVehicle +
                ", tblclmVehicleNo=" + tblclmVehicleNo +
                ", tblclmBrand=" + tblclmBrand +
                ", tblclmModel=" + tblclmModel +
                ", tblclmYear=" + tblclmYear +
                ", tblclmPS=" + tblclmPS +
                ", tblclmCurrentMilage=" + tblclmCurrentMilage +
                ", tblclmCategory=" + tblclmCategory +
                ", tblclmAvailability=" + tblclmAvailability +
                ", tabCustomer=" + tabCustomer +
                ", tblCustomer=" + tblCustomer +
                ", tblclmCustomerNo=" + tblclmCustomerNo +
                ", tblclmLastName=" + tblclmLastName +
                ", tblclmFirstName=" + tblclmFirstName +
                ", tblclmDOB=" + tblclmDOB +
                ", tblclmStreetName=" + tblclmStreetName +
                ", tblclmHouseNo=" + tblclmHouseNo +
                ", tblclmZipCode=" + tblclmZipCode +
                ", tblclmCity=" + tblclmCity +
                ", customerSearchResultList=" + customerSearchResultList +
                ", stageManager=" + stageManager +
                ", loginController=" + loginController +
                ", vehicleService=" + vehicleService +
                ", customerService=" + customerService +
                ", addressService=" + addressService +
                ", selectedCategory='" + selectedCategory + '\'' +
                ", priceOfDeposit=" + priceOfDeposit +
                ", priceCompact=" + priceCompact +
                ", priceConvertible=" + priceConvertible +
                ", priceSUV=" + priceSUV +
                '}';
    }


    private void setCellValuesForCustomer() {
        ObservableList<Customer> customers = FXCollections.observableArrayList(customerService.findAll());
        tblclmCustomerNo.setCellValueFactory(new PropertyValueFactory<>("CustomerNo"));
        tblclmLastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        tblclmFirstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        tblCustomer.setItems(customers);

    }
    private void setCellValuesForAddressOfCustomer(){

        tblclmDOB.setCellValueFactory(new PropertyValueFactory<>("DOB"));
        tblclmStreetName.setCellValueFactory(new PropertyValueFactory<>("StreetName"));
        tblclmHouseNo.setCellValueFactory(new PropertyValueFactory<>("HouseNo"));
        tblclmZipCode.setCellValueFactory(new PropertyValueFactory<>("ZipCode"));
        tblclmCity.setCellValueFactory(new PropertyValueFactory<>("City"));
    }

    private void filterVehicleTable() {
//        try {
            ObservableList<Vehicle> vehicles = FXCollections.observableArrayList(vehicleService.findAll());
            FilteredList<Vehicle> filteredData = new FilteredList<>(vehicles, p -> true);
            filteredData.predicateProperty().bind(Bindings.createObjectBinding(() ->
                            vehicle -> ((vehicle.getBrand().contains(txtfldFilter.getText())) ||
                                    (vehicle.getModel().contains(txtfldFilter.getText()))) &&
                                    vehicle.getCategoryAsString().contains(txtfldSelectedCategory.getText()),
                    txtfldFilter.textProperty(),
                    txtfldSelectedCategory.textProperty()));
            SortedList<Vehicle> sortedData = new SortedList<>(filteredData);
            sortedData.comparatorProperty().bind(tblVehicle.comparatorProperty());
            tblVehicle.setItems(sortedData);
//        } catch (Exception e) {
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Information");
//            alert.setHeaderText("Vehicle Filter failed");
//            alert.setContentText("Vehicle number has not been entered OR vehicle with entered vehicle number does not exist.");
//            alert.showAndWait();
//        }
    }

    private void setCellValueFactories() {
        ObservableList<Vehicle> vehicles = FXCollections.observableArrayList(vehicleService.findAll());
        tblclmAvailability.setCellValueFactory(new PropertyValueFactory<>("availability"));
        tblclmBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        tblclmCategory.setCellValueFactory(new PropertyValueFactory<>("Category"));
        tblclmCurrentMilage.setCellValueFactory(new PropertyValueFactory<>("currentMiles"));
        tblclmModel.setCellValueFactory(new PropertyValueFactory<>("Model"));
        tblclmPS.setCellValueFactory(new PropertyValueFactory<>("ps"));
        tblclmYear.setCellValueFactory(new PropertyValueFactory<>("Year"));
        tblclmVehicleNo.setCellValueFactory(new PropertyValueFactory<>("vehicleID"));
        tblVehicle.setItems(vehicles);




    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Employee employee = loginController.getEmployee();
        setEmployee(employee);
        lblEmployeeName.setText(employee.nameToString());
        setCellValueFactories();
        setCellValuesForCustomer();
        filterVehicleTable();


    }


}







