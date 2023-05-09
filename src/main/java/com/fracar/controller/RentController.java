package com.fracar.controller;

import com.fracar.config.StageManager;
import com.fracar.entity.Employee;
import com.fracar.entity.Rent;
import com.fracar.service.*;
import com.fracar.view.FxmlView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.ResourceBundle;

@Controller
public class RentController implements Initializable {

    @FXML
    public Label lblEmployeeNo;
    @FXML
    public Label lblEmployeeFirstName;
    @FXML
    public Label lblEmployeeLastName;
    @FXML
    public Label lblBeginDate;
    @FXML
    public Label lblEndDate;
    @FXML
    public Label lblPricePerDay;
    @FXML
    public Label lblPriceXTime;
    @FXML
    public Label lblTotal;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane paneOrderConfirmation;

    @FXML
    private Button btnCancelOrder;

    @FXML
    private Button btnReturnHome;

    @FXML
    private SplitPane splitpaneInformation;

    @FXML
    private Label lblCustomerNo;

    @FXML
    private Label lblFirstName;

    @FXML
    private Label lblLastName;

    @FXML
    private Label lblDOB;

    @FXML
    private Label lblStreetName;

    @FXML
    private Label lblHouseNo;

    @FXML
    private Label lblZipCode;

    @FXML
    private Label lblCity;

    @FXML
    private Label lblPhoneNo;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblBrand;

    @FXML
    private Label lblModel;

    @FXML
    private Label lblYear;

    @FXML
    private Label lblPS;

    @FXML
    private Label lblCurrentMilage;

    @FXML
    private Label lblCategory;

    @FXML
    private Label lblDeposit;

    @FXML
    private Button btnPayment;

    @Lazy
    @Autowired
    StageManager stageManager;

    @Autowired
    EmployeeService employeeService;
    @Autowired
    VehicleService vehicleService;
    @Autowired
    CustomerService customerService;
    @Autowired
    AddressService addressService;
    @Autowired
    HomeController homeController;
    @Autowired
    RentService rentService;

//___________________________________________________________________________________________________


    @FXML
    void cancelOrderOnAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Request");
        alert.setHeaderText("Click <Cancel Order> to cancel the order.");
        alert.setContentText("The order will be permanently reversed.");

        ButtonType buttonTypeCancel = new ButtonType("Cancel Order");
        ButtonType buttonTypeContinue = new ButtonType("Continue", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeCancel, buttonTypeContinue);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeCancel) {
            stageManager.switchScene(FxmlView.HOME);
        } else {

        }
    }

    @FXML
    void paymentProcessOnAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Payment Process...");
        alert.showAndWait();
        btnReturnHome.setDisable(false);
    }

    @FXML
    void returnHomeOnAction(ActionEvent event) {
        stageManager.switchScene(FxmlView.HOME);
    }


    @Override
    public String toString() {
        return "OrderConfirmationController{" +
                "resources=" + resources +
                ", location=" + location +
                ", paneOrderConfirmation=" + paneOrderConfirmation +
                ", btnCancelOrder=" + btnCancelOrder +
                ", btnReturnHome=" + btnReturnHome +
                ", splitpaneInformation=" + splitpaneInformation +
                ", lblCustomerNo=" + lblCustomerNo +
                ", lblFirstName=" + lblFirstName +
                ", lblLastName=" + lblLastName +
                ", lblDOB=" + lblDOB +
                ", lblStreetName=" + lblStreetName +
                ", lblHouseNo=" + lblHouseNo +
                ", lblZipCode=" + lblZipCode +
                ", lblCity=" + lblCity +
                ", lblPhoneNo=" + lblPhoneNo +
                ", lblEmail=" + lblEmail +
                ", lblBrand=" + lblBrand +
                ", lblModel=" + lblModel +
                ", lblYear=" + lblYear +
                ", lblPS=" + lblPS +
                ", lblCurrentMilage=" + lblCurrentMilage +
                ", lblCategory=" + lblCategory +
                ", lblDeposit=" + lblDeposit +
                ", stageManager=" + stageManager +
                '}';
    }


    public Label getLblCustomerNo() {
        return lblCustomerNo;
    }

    public void setLblCustomerNo(Label lblCustomerNo) {
        this.lblCustomerNo = lblCustomerNo;
    }

    public Label getLblFirstName() {
        return lblFirstName;
    }

    public void setLblFirstName(Label lblFirstName) {
        this.lblFirstName = lblFirstName;
    }

    public Label getLblLastName() {
        return lblLastName;
    }

    public void setLblLastName(Label lblLastName) {
        this.lblLastName = lblLastName;
    }

    public Label getLblDOB() {
        return lblDOB;
    }

    public void setLblDOB(Label lblDOB) {
        this.lblDOB = lblDOB;
    }

    public Label getLblStreetName() {
        return lblStreetName;
    }

    public void setLblStreetName(Label lblStreetName) {
        this.lblStreetName = lblStreetName;
    }

    public Label getLblHouseNo() {
        return lblHouseNo;
    }

    public void setLblHouseNo(Label lblHouseNo) {
        this.lblHouseNo = lblHouseNo;
    }

    public Label getLblZipCode() {
        return lblZipCode;
    }

    public void setLblZipCode(Label lblZipCode) {
        this.lblZipCode = lblZipCode;
    }

    public Label getLblCity() {
        return lblCity;
    }

    public void setLblCity(Label lblCity) {
        this.lblCity = lblCity;
    }

    public Label getLblPhoneNo() {
        return lblPhoneNo;
    }

    public void setLblPhoneNo(Label lblPhoneNo) {
        this.lblPhoneNo = lblPhoneNo;
    }

    public Label getLblEmail() {
        return lblEmail;
    }

    public void setLblEmail(Label lblEmail) {
        this.lblEmail = lblEmail;
    }

    public Label getLblBrand() {
        return lblBrand;
    }

    public void setLblBrand(Label lblBrand) {
        this.lblBrand = lblBrand;
    }

    public Label getLblModel() {
        return lblModel;
    }

    public void setLblModel(Label lblModel) {
        this.lblModel = lblModel;
    }

    public Label getLblYear() {
        return lblYear;
    }

    public void setLblYear(Label lblYear) {
        this.lblYear = lblYear;
    }

    public Label getLblPS() {
        return lblPS;
    }

    public void setLblPS(Label lblPS) {
        this.lblPS = lblPS;
    }

    public Label getLblCurrentMilage() {
        return lblCurrentMilage;
    }

    public void setLblCurrentMilage(Label lblCurrentMilage) {
        this.lblCurrentMilage = lblCurrentMilage;
    }

    public Label getLblEmployeeNo() {
        return lblEmployeeNo;
    }

    public void setLblEmployeeNo(Label lblEmployeeNo) {
        this.lblEmployeeNo = lblEmployeeNo;
    }

    public Label getLblEmployeeFirstName() {
        return lblEmployeeFirstName;
    }

    public void setLblEmployeeFirstName(Label lblEmployeeFirstName) {
        this.lblEmployeeFirstName = lblEmployeeFirstName;
    }

    public Label getLblEmployeeLastName() {
        return lblEmployeeLastName;
    }

    public void setLblEmployeeLastName(Label lblEmployeeLastName) {
        this.lblEmployeeLastName = lblEmployeeLastName;
    }

    public Label getLblBeginDate() {
        return lblBeginDate;
    }

    public void setLblBeginDate(Label lblBeginDate) {
        this.lblBeginDate = lblBeginDate;
    }

    public Label getLblEndDate() {
        return lblEndDate;
    }

    public void setLblEndDate(Label lblEndDate) {
        this.lblEndDate = lblEndDate;
    }

    public Label getLblPricePerDay() {
        return lblPricePerDay;
    }

    public void setLblPricePerDay(Label lblPricePerDay) {
        this.lblPricePerDay = lblPricePerDay;
    }

    public Label getLblPriceXTime() {
        return lblPriceXTime;
    }

    public void setLblPriceXTime(Label lblPriceXTime) {
        this.lblPriceXTime = lblPriceXTime;
    }

    public Label getLblTotal() {
        return lblTotal;
    }

    public void setLblTotal(Label lblTotal) {
        this.lblTotal = lblTotal;
    }

    public Label getLblCategory() {
        return lblCategory;
    }

    public void setLblCategory(Label lblCategory) {
        this.lblCategory = lblCategory;
    }


    void fillCustomerInfo() {
        lblLastName.setText(homeController.getCurrentCustomer().getLastName());
        lblFirstName.setText(homeController.getCurrentCustomer().getFirstName());
        lblDOB.setText(homeController.getCurrentCustomer().getDob().format(DateTimeFormatter.ofPattern("dd.MM.YYYY")));
        lblCustomerNo.setText(String.valueOf(homeController.getCurrentCustomer().getCustomerId()));
    }

    void fillVehicleInfo() {
        lblBrand.setText(homeController.getChoosenVehicle().getBrand());
        lblCategory.setText(homeController.getChoosenVehicle().getCategoryAsString());
        lblCurrentMilage.setText(String.valueOf(homeController.getChoosenVehicle().getCurrentMiles()));
        lblYear.setText(String.valueOf(homeController.getChoosenVehicle().getYear()));
        lblPS.setText(String.valueOf(homeController.getChoosenVehicle().getPs()));
        lblModel.setText(String.valueOf(homeController.getChoosenVehicle().getModel()));

    }

    void fillAddressInfo() {
        lblStreetName.setText(homeController.getAddressCustomer().getStreetName());
        lblZipCode.setText(homeController.getAddressCustomer().getZipCode());
        lblPhoneNo.setText(homeController.getAddressCustomer().getPhoneNo());
        lblHouseNo.setText(homeController.getAddressCustomer().getHouseNo());
        lblEmail.setText(homeController.getAddressCustomer().getEmail());
        lblCity.setText(homeController.getAddressCustomer().getCity());

    }

    void fillEmployeeInfo() {
        Employee employee = homeController.getEmployee();
        lblEmployeeNo.setText(Long.toString(employee.getEmployeeId()));
        lblEmployeeFirstName.setText(employee.getFirstName());
        lblEmployeeLastName.setText(employee.getLastName());

    }

    void fillDateInfos(){
        try{
            LocalDate dateBegin = homeController.getDateBegin().getValue();
            LocalDate dateEnd = homeController.getDateEnd().getValue();
            dateBegin.format(DateTimeFormatter.ofPattern("d.MM.uuuu"));
            dateEnd.format(DateTimeFormatter.ofPattern("d.MM.uuuu"));
            lblBeginDate.setText(String.valueOf(dateBegin));
            lblEndDate.setText(String.valueOf(dateEnd));
        } catch (Exception e){
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Information");
//            alert.setHeaderText("Dates have not been entered.");
//            alert.showAndWait();
//            stageManager.switchScene(FxmlView.HOME);
        }

    }
    void fillPriceInfos(){
        lblPricePerDay.setText(String.valueOf(homeController.getPricePerDay()));
        lblTotal.setText(String.valueOf(homeController.getSum()));



    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnReturnHome.setDisable(true);
        fillCustomerInfo();
        fillVehicleInfo();
        fillAddressInfo();
        fillEmployeeInfo();
        fillDateInfos();
        fillPriceInfos();
        Rent rent = new Rent(homeController.getCurrentCustomer(), homeController.getAddressCustomer(), homeController.getChoosenVehicle(), homeController.getEmployee());


    }
}
