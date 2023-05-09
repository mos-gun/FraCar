package com.fracar.controller;

import com.fracar.config.StageManager;
import com.fracar.entity.Category;
import com.fracar.entity.Vehicle;
import com.fracar.service.VehicleService;
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
import java.util.ResourceBundle;

@Controller
public class NewVehicleController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane paneNewVehicle;

    @FXML
    private Label lblBrandName;
    @FXML
    private TextField txtfldBrandName;

    @FXML
    private Label lblModelName;
    @FXML
    private TextField txtfldModelName;

    @FXML
    private Label lblYear;
    @FXML
    private TextField txtfldYear;

    @FXML
    private Label lblPS;
    @FXML
    private TextField txtfldPS;

    @FXML
    private Label lblCurrentMiles;
    @FXML
    private TextField txtfldCurrentMiles;

    @FXML
    private Label lblCategory;
    @FXML
    private CheckBox cbxCompact;

    @FXML
    private CheckBox cbxConvertible;

    @FXML
    private CheckBox cbxSUV;

    @FXML
    private Button btnCreateVehicle;

    @FXML
    private Button btnCancel;

    @Lazy
    @Autowired
    StageManager stageManager;

    @Autowired
    VehicleService vehicleService;

    String selectedCategory;


//___________________________________________________________________________________________________


    @FXML
    void cancelOnAction(ActionEvent event) {
        stageManager.switchScene(FxmlView.HOME);
    }

    @FXML
    void chooseCategoryCompact(ActionEvent event) {
        if (cbxCompact.isSelected()) {
            cbxConvertible.setSelected(false);
            cbxSUV.setSelected(false);

            selectedCategory = cbxCompact.getText();
        }
    }

    @FXML
    void chooseCategoryConvertible(ActionEvent event) {
        if (cbxConvertible.isSelected()) {
            cbxCompact.setSelected(false);
            cbxSUV.setSelected(false);

            selectedCategory = cbxConvertible.getText();
        }
    }

    @FXML
    void chooseCategorySUV(ActionEvent event) {
        if (cbxSUV.isSelected()) {
            cbxCompact.setSelected(false);
            cbxConvertible.setSelected(false);

            selectedCategory = cbxSUV.getText();
        }
    }

    @FXML
    void createVehicleOnAction(ActionEvent event) {

        if (txtfldBrandName.getText().isEmpty()) {
            lblBrandName.setTextFill(Color.RED);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("New Vehicle could not be registered.");
            alert.setContentText("Please fill out the form completely.");
            alert.showAndWait();
            lblModelName.setTextFill(Color.BLACK);
            lblYear.setTextFill(Color.BLACK);
            lblPS.setTextFill(Color.BLACK);
            lblCurrentMiles.setTextFill(Color.BLACK);
            lblCategory.setTextFill(Color.BLACK);
        } else if (txtfldModelName.getText().isEmpty()) {
            lblModelName.setTextFill(Color.RED);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("New Vehicle could not be registered.");
            alert.setContentText("Please fill out the form completely.");
            alert.showAndWait();
            lblBrandName.setTextFill(Color.BLACK);
            lblYear.setTextFill(Color.BLACK);
            lblPS.setTextFill(Color.BLACK);
            lblCurrentMiles.setTextFill(Color.BLACK);
            lblCategory.setTextFill(Color.BLACK);
        } else if (txtfldYear.getText().isEmpty()) {
            lblYear.setTextFill(Color.RED);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("New Vehicle could not be registered.");
            alert.setContentText("Please fill out the form completely.");
            alert.showAndWait();
            lblBrandName.setTextFill(Color.BLACK);
            lblModelName.setTextFill(Color.BLACK);
            lblPS.setTextFill(Color.BLACK);
            lblCurrentMiles.setTextFill(Color.BLACK);
            lblCategory.setTextFill(Color.BLACK);
        } else if (txtfldPS.getText().isEmpty()) {
            lblPS.setTextFill(Color.RED);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("New Vehicle could not be registered.");
            alert.setContentText("Please fill out the form completely.");
            alert.showAndWait();
            lblBrandName.setTextFill(Color.BLACK);
            lblYear.setTextFill(Color.BLACK);
            lblModelName.setTextFill(Color.BLACK);
            lblCurrentMiles.setTextFill(Color.BLACK);
            lblCategory.setTextFill(Color.BLACK);
        } else if (txtfldCurrentMiles.getText().isEmpty()) {
            lblCurrentMiles.setTextFill(Color.RED);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("New Vehicle could not be registered.");
            alert.setContentText("Please fill out the form completely.");
            alert.showAndWait();
            lblBrandName.setTextFill(Color.BLACK);
            lblYear.setTextFill(Color.BLACK);
            lblPS.setTextFill(Color.BLACK);
            lblModelName.setTextFill(Color.BLACK);
            lblCategory.setTextFill(Color.BLACK);
        } else {
            try {
                Vehicle vehicle = new Vehicle(txtfldBrandName.getText(), txtfldModelName.getText(), Integer.parseInt(txtfldYear.getText()), Integer.parseInt(txtfldPS.getText()), Integer.parseInt(txtfldCurrentMiles.getText()), Category.valueOf(selectedCategory.toUpperCase()), true);
                vehicleService.saveEntity(vehicle);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText("Registration successful.");
                alert.setContentText("New Vehicle has been added to the system.");
                alert.showAndWait();
                stageManager.switchScene(FxmlView.HOME);
            } catch (Exception e) {
                lblCategory.setTextFill(Color.RED);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText("New Vehicle could not be registered.");
                alert.setContentText("Please fill out the form completely.");
                alert.showAndWait();
                lblBrandName.setTextFill(Color.BLACK);
                lblYear.setTextFill(Color.BLACK);
                lblPS.setTextFill(Color.BLACK);
                lblCurrentMiles.setTextFill(Color.BLACK);
                lblModelName.setTextFill(Color.BLACK);
            }
        }
    }


    @Override
    public String toString() {
        return "NewVehicleController{" +
                "resources=" + resources +
                ", location=" + location +
                ", paneNewVehicle=" + paneNewVehicle +
                ", txtfldBrandName=" + txtfldBrandName +
                ", txtfldModelName=" + txtfldModelName +
                ", txtfldYear=" + txtfldYear +
                ", txtfldPS=" + txtfldPS +
                ", txtfldCurrentMiles=" + txtfldCurrentMiles +
                ", cbxCompact=" + cbxCompact +
                ", cbxConvertible=" + cbxConvertible +
                ", cbxSUV=" + cbxSUV +
                ", btnCreateVehicle=" + btnCreateVehicle +
                ", btnCancel=" + btnCancel +
                ", stageManager=" + stageManager +
                ", selectedCategory='" + selectedCategory + '\'' +
                '}';
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }

}
