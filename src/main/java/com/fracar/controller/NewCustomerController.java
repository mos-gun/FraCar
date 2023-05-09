package com.fracar.controller;

import com.fracar.config.StageManager;
import com.fracar.entity.Address;
import com.fracar.entity.Customer;
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
import java.time.LocalDate;
import java.util.ResourceBundle;


@Controller
public class NewCustomerController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane paneNewCustomer;

    @FXML
    private Label lblGender;
    @FXML
    private CheckBox cbxGenderMale;
    @FXML
    private CheckBox cbxGenderFemale;

    @FXML
    private Label lblDOB;
    @FXML
    private DatePicker dateDOB;

    @FXML
    private Label lblFirstName;
    @FXML
    private TextField txtfldFirstName;

    @FXML
    private Label lblLastName;
    @FXML
    private TextField txtfldLastName;

    @FXML
    private Label lblStreetName;
    @FXML
    private TextField txtfldStreetName;

    @FXML
    private Label lblHouseNo;
    @FXML
    private TextField txtfldHouseNo;

    @FXML
    private Label lblZipCode;
    @FXML
    private TextField txtfldZipCode;

    @FXML
    private Label lblCity;
    @FXML
    private TextField txtfldCity;

    @FXML
    private Label lblPhoneNo;
    @FXML
    private TextField txtfldPhoneNo;

    @FXML
    private Label lblEmail;
    @FXML
    private TextField txtfldEmail;

    @FXML
    private Button btnCreate;

    @FXML
    private Button btnCancel;

    @Lazy
    @Autowired
    StageManager stageManager;

    @Autowired
    CustomerService customerService;

    String selectedGender;




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
    void createCustomerOnAction(ActionEvent event) {

        LocalDate localDate = dateDOB.getValue();
        if (selectedGender == null) {
            lblGender.setTextFill(Color.RED);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("New Customer could not be registered.");
            alert.setContentText("Please fill out the form completely.");
            alert.showAndWait();
            lblLastName.setTextFill(Color.BLACK);
            lblFirstName.setTextFill(Color.BLACK);
            lblDOB.setTextFill(Color.BLACK);
            lblStreetName.setTextFill(Color.BLACK);
            lblHouseNo.setTextFill(Color.BLACK);
            lblZipCode.setTextFill(Color.BLACK);
            lblCity.setTextFill(Color.BLACK);
            lblPhoneNo.setTextFill(Color.BLACK);
            lblEmail.setTextFill(Color.BLACK);
        } else if (txtfldLastName.getText().isEmpty()) {
            lblLastName.setTextFill(Color.RED);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("New Customer could not be registered.");
            alert.setContentText("Please fill out the form completely.");
            alert.showAndWait();
            lblGender.setTextFill(Color.BLACK);
            lblFirstName.setTextFill(Color.BLACK);
            lblDOB.setTextFill(Color.BLACK);
            lblStreetName.setTextFill(Color.BLACK);
            lblHouseNo.setTextFill(Color.BLACK);
            lblZipCode.setTextFill(Color.BLACK);
            lblCity.setTextFill(Color.BLACK);
            lblPhoneNo.setTextFill(Color.BLACK);
            lblEmail.setTextFill(Color.BLACK);
        } else if (txtfldFirstName.getText().isEmpty()) {
            lblFirstName.setTextFill(Color.RED);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("New Customer could not be registered.");
            alert.setContentText("Please fill out the form completely.");
            alert.showAndWait();
            lblLastName.setTextFill(Color.BLACK);
            lblGender.setTextFill(Color.BLACK);
            lblDOB.setTextFill(Color.BLACK);
            lblStreetName.setTextFill(Color.BLACK);
            lblHouseNo.setTextFill(Color.BLACK);
            lblZipCode.setTextFill(Color.BLACK);
            lblCity.setTextFill(Color.BLACK);
            lblPhoneNo.setTextFill(Color.BLACK);
            lblEmail.setTextFill(Color.BLACK);
        } else if (dateDOB.getValue() == null) {
            lblDOB.setTextFill(Color.RED);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("New Customer could not be registered.");
            alert.setContentText("Please fill out the form completely.");
            alert.showAndWait();
            lblLastName.setTextFill(Color.BLACK);
            lblFirstName.setTextFill(Color.BLACK);
            lblGender.setTextFill(Color.BLACK);
            lblStreetName.setTextFill(Color.BLACK);
            lblHouseNo.setTextFill(Color.BLACK);
            lblZipCode.setTextFill(Color.BLACK);
            lblCity.setTextFill(Color.BLACK);
            lblPhoneNo.setTextFill(Color.BLACK);
            lblEmail.setTextFill(Color.BLACK);
        } else if (txtfldStreetName.getText().isEmpty()) {
            lblStreetName.setTextFill(Color.RED);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("New Customer could not be registered.");
            alert.setContentText("Please fill out the form completely.");
            alert.showAndWait();
            lblLastName.setTextFill(Color.BLACK);
            lblFirstName.setTextFill(Color.BLACK);
            lblDOB.setTextFill(Color.BLACK);
            lblGender.setTextFill(Color.BLACK);
            lblHouseNo.setTextFill(Color.BLACK);
            lblZipCode.setTextFill(Color.BLACK);
            lblCity.setTextFill(Color.BLACK);
            lblPhoneNo.setTextFill(Color.BLACK);
            lblEmail.setTextFill(Color.BLACK);
        } else if (txtfldHouseNo.getText().isEmpty()) {
            lblHouseNo.setTextFill(Color.RED);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("New Customer could not be registered.");
            alert.setContentText("Please fill out the form completely.");
            alert.showAndWait();
            lblLastName.setTextFill(Color.BLACK);
            lblFirstName.setTextFill(Color.BLACK);
            lblDOB.setTextFill(Color.BLACK);
            lblStreetName.setTextFill(Color.BLACK);
            lblGender.setTextFill(Color.BLACK);
            lblZipCode.setTextFill(Color.BLACK);
            lblCity.setTextFill(Color.BLACK);
            lblPhoneNo.setTextFill(Color.BLACK);
            lblEmail.setTextFill(Color.BLACK);
        } else if (txtfldZipCode.getText().isEmpty()) {
            lblZipCode.setTextFill(Color.RED);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("New Customer could not be registered.");
            alert.setContentText("Please fill out the form completely.");
            alert.showAndWait();
            lblLastName.setTextFill(Color.BLACK);
            lblFirstName.setTextFill(Color.BLACK);
            lblDOB.setTextFill(Color.BLACK);
            lblStreetName.setTextFill(Color.BLACK);
            lblHouseNo.setTextFill(Color.BLACK);
            lblGender.setTextFill(Color.BLACK);
            lblCity.setTextFill(Color.BLACK);
            lblPhoneNo.setTextFill(Color.BLACK);
            lblEmail.setTextFill(Color.BLACK);
        } else if (txtfldCity.getText().isEmpty()) {
            lblCity.setTextFill(Color.RED);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("New Customer could not be registered.");
            alert.setContentText("Please fill out the form completely.");
            alert.showAndWait();
            lblLastName.setTextFill(Color.BLACK);
            lblFirstName.setTextFill(Color.BLACK);
            lblDOB.setTextFill(Color.BLACK);
            lblStreetName.setTextFill(Color.BLACK);
            lblHouseNo.setTextFill(Color.BLACK);
            lblZipCode.setTextFill(Color.BLACK);
            lblGender.setTextFill(Color.BLACK);
            lblPhoneNo.setTextFill(Color.BLACK);
            lblEmail.setTextFill(Color.BLACK);
        } else if (txtfldPhoneNo.getText().isEmpty()) {
            lblPhoneNo.setTextFill(Color.RED);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("New Customer could not be registered.");
            alert.setContentText("Please fill out the form completely.");
            alert.showAndWait();
            lblLastName.setTextFill(Color.BLACK);
            lblFirstName.setTextFill(Color.BLACK);
            lblDOB.setTextFill(Color.BLACK);
            lblStreetName.setTextFill(Color.BLACK);
            lblHouseNo.setTextFill(Color.BLACK);
            lblZipCode.setTextFill(Color.BLACK);
            lblCity.setTextFill(Color.BLACK);
            lblGender.setTextFill(Color.BLACK);
            lblEmail.setTextFill(Color.BLACK);
        } else if (txtfldEmail.getText().isEmpty()) {
            txtfldEmail.setText("none");
            lblEmail.setTextFill(Color.RED);
            lblLastName.setTextFill(Color.BLACK);
            lblFirstName.setTextFill(Color.BLACK);
            lblDOB.setTextFill(Color.BLACK);
            lblStreetName.setTextFill(Color.BLACK);
            lblHouseNo.setTextFill(Color.BLACK);
            lblZipCode.setTextFill(Color.BLACK);
            lblCity.setTextFill(Color.BLACK);
            lblPhoneNo.setTextFill(Color.BLACK);
            lblGender.setTextFill(Color.BLACK);
        } else {
            Address address = new Address(txtfldStreetName.getText(), txtfldHouseNo.getText(), txtfldZipCode.getText(), txtfldCity.getText(), txtfldPhoneNo.getText(), txtfldEmail.getText());
            Customer customer = new Customer(selectedGender, txtfldLastName.getText(), txtfldFirstName.getText(), localDate, address);
            customerService.saveEntity(customer);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Registration successful.");
            alert.setContentText("New Customer has been added to the system.");
            alert.showAndWait();
            stageManager.switchScene(FxmlView.HOME);
        }

    }


    @Override
    public String toString() {
        return "NewCustomerController{" +
                "resources=" + resources +
                ", location=" + location +
                ", paneNewCustomer=" + paneNewCustomer +
                ", lblGender=" + lblGender +
                ", cbxGenderMale=" + cbxGenderMale +
                ", cbxGenderFemale=" + cbxGenderFemale +
                ", lblDOB=" + lblDOB +
                ", dateDOB=" + dateDOB +
                ", lblFirstName=" + lblFirstName +
                ", txtfldFirstName=" + txtfldFirstName +
                ", lblLastName=" + lblLastName +
                ", txtfldLastName=" + txtfldLastName +
                ", lblStreetName=" + lblStreetName +
                ", txtfldStreetName=" + txtfldStreetName +
                ", lblHouseNo=" + lblHouseNo +
                ", txtfldHouseNo=" + txtfldHouseNo +
                ", lblZipCode=" + lblZipCode +
                ", txtfldZipCode=" + txtfldZipCode +
                ", lblCity=" + lblCity +
                ", txtfldCity=" + txtfldCity +
                ", lblPhoneNo=" + lblPhoneNo +
                ", txtfldPhoneNo=" + txtfldPhoneNo +
                ", lblEmail=" + lblEmail +
                ", txtfldEmail=" + txtfldEmail +
                ", btnCreate=" + btnCreate +
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
