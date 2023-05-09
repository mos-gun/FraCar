package com.fracar.controller;

import com.fracar.config.StageManager;
import com.fracar.entity.Address;
import com.fracar.entity.Customer;
import com.fracar.service.AddressService;
import com.fracar.service.CustomerService;
import com.fracar.view.FxmlView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

@Controller
public class EditCustomerController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane paneEditCustomer;

    @FXML
    private Label lblCustomerNo;

    @FXML
    private TextField txtfldCustomerNo;

    @FXML
    private Label lblGender;

    @FXML
    private CheckBox cbxGenderMale;

    @FXML
    private CheckBox cbxGenderFemale;

    @FXML
    private DatePicker dateDOB;

    @FXML
    private TextField txtfldFirstName;

    @FXML
    private TextField txtfldLastName;

    @FXML
    private TextField txtfldStreetName;

    @FXML
    private TextField txtfldHouseNo;

    @FXML
    private TextField txtfldZipCode;

    @FXML
    private TextField txtfldCity;

    @FXML
    private TextField txtfldPhoneNo;

    @FXML
    private TextField txtfldEmail;

    @FXML
    private Button btnUpdateCustomer;

    @FXML
    private Button btnRemoveCustomer;

    @FXML
    private Label lblDOB;

    @FXML
    private Button btnCancel;

    @Lazy
    @Autowired
    StageManager stageManager;

    @Autowired
    CustomerService customerService;

    @Autowired
    AddressService addressService;

    String selectedGender;

    Customer customer;

    Address address;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    //___________________________________________________________________________________________________

    @FXML
    void cancelOnAction(ActionEvent event) {
        stageManager.switchScene(FxmlView.HOME);
    }

    @FXML
    void chooseGenderMale(ActionEvent event) {
        if (cbxGenderMale.isSelected()) {
            cbxGenderFemale.setSelected(false);

            selectedGender = cbxGenderMale.getText();
        }
    }

    @FXML
    void chooseGenderFemale(ActionEvent event) {
        if (cbxGenderFemale.isSelected()) {
            cbxGenderMale.setSelected(false);

            selectedGender = cbxGenderFemale.getText();
        }
    }

    @FXML
    void searchCustomerOnAction(ActionEvent event) {
        try {
            customer = customerService.findEntityById(Long.parseLong(txtfldCustomerNo.getText()));
            address = customer.getAddressId();
            setCustomer(customer);
            if (customer.getTitle().equals(cbxGenderMale.getText())) {
                cbxGenderMale.setSelected(true);
            }else cbxGenderFemale.setSelected(true);
            dateDOB.setPromptText(customer.getDob().toString());
            txtfldFirstName.setText(customer.getFirstName());
            txtfldLastName.setText(customer.getLastName());
            txtfldStreetName.setText(address.getStreetName());
            txtfldHouseNo.setText(address.getHouseNo());
            txtfldZipCode.setText(address.getZipCode());
            txtfldCity.setText(address.getCity());
            txtfldPhoneNo.setText(address.getPhoneNo());
            txtfldEmail.setText(address.getEmail());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Customer search failed.");
            alert.setContentText("Customer with the entered Customer number does not exist.");
            alert.showAndWait();
        }

    }

    @FXML
    void updateCustomerOnAction(ActionEvent event) {
        customer.setFirstName(txtfldFirstName.getText());
        customer.setLastName(txtfldLastName.getText());
        customer.setDob(dateDOB.getValue());
        customer.setTitle(selectedGender);
        address.setStreetName(txtfldStreetName.getText());
        address.setHouseNo(txtfldHouseNo.getText());
        address.setZipCode(txtfldZipCode.getText());
        address.setCity(txtfldCity.getText());
        address.setPhoneNo(txtfldPhoneNo.getText());
        address.setEmail(txtfldEmail.getText());
        if (dateDOB.equals(null)) {
            lblDOB.setTextFill(Color.RED);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Customer edit failed.");
            alert.setContentText("Date of Birth must be entered.");
            alert.showAndWait();
        } else{
            customerService.updateEntity(customer);
            addressService.updateEntity(address);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Edit successful.");
            alert.setContentText("Changes to the customer information have been saved.");
            alert.showAndWait();
            stageManager.switchScene(FxmlView.HOME);
        }
//        try {
//            customerService.updateEntity(customer);
//            addressService.updateEntity(address);
//        } catch (Exception e) {
//
//        }

    }

    @FXML
    void removeCustomerOnAction(ActionEvent event) {
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
        alert1.setTitle("Confirmation Request");
        alert1.setHeaderText("Click <Remove> to delete the customer from the system.");
        alert1.setContentText("Do you want to delete the selected customer?");

        ButtonType buttonTypeRemove = new ButtonType("Remove");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert1.getButtonTypes().setAll(buttonTypeRemove, buttonTypeCancel);

        Optional<ButtonType> result = alert1.showAndWait();
        if (result.get() == buttonTypeRemove) {
            System.exit(0);
        } else {

        }
        customerService.deleteEntity(customer);
        Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
        alert2.setTitle("Information");
        alert2.setHeaderText("Deletion successful.");
        alert2.setContentText("Customer has been removed from the system.");
        alert2.showAndWait();
        stageManager.switchScene(FxmlView.HOME);
    }


    @Override
    public String toString() {
        return "EditCustomerController{" +
                "resources=" + resources +
                ", location=" + location +
                ", paneEditCustomer=" + paneEditCustomer +
                ", lblCustomerNo=" + lblCustomerNo +
                ", txtfldCustomerNo=" + txtfldCustomerNo +
                ", lblGender=" + lblGender +
                ", cbxGenderMale=" + cbxGenderMale +
                ", cbxGenderFemale=" + cbxGenderFemale +
                ", dateDOB=" + dateDOB +
                ", txtfldFirstName=" + txtfldFirstName +
                ", txtfldLastName=" + txtfldLastName +
                ", txtfldStreetName=" + txtfldStreetName +
                ", txtfldHouseNo=" + txtfldHouseNo +
                ", txtfldZipCode=" + txtfldZipCode +
                ", txtfldCity=" + txtfldCity +
                ", txtfldPhoneNo=" + txtfldPhoneNo +
                ", txtfldEmail=" + txtfldEmail +
                ", btnUpdateCustomer=" + btnUpdateCustomer +
                ", btnRemoveCustomer=" + btnRemoveCustomer +
                ", btnCancel=" + btnCancel +
                ", stageManager=" + stageManager +
                ", customerService=" + customerService +
                ", selectedGender='" + selectedGender + '\'' +
                '}';
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
