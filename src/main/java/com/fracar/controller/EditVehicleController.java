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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

@Controller
public class EditVehicleController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane paneEditVehicle;

    @FXML
    private Label lblVehicleNo;

    @FXML
    private TextField txtfldVehicleNo;

    @FXML
    private TextField txtfldBrandName;

    @FXML
    private TextField txtfldModelName;

    @FXML
    private TextField txtfldYear;

    @FXML
    private TextField txtfldPS;

    @FXML
    private TextField txtfldCurrentMiles;

    @FXML
    private CheckBox cbxCompact;

    @FXML
    private CheckBox cbxConvertible;

    @FXML
    private CheckBox cbxSUV;

    @FXML
    private Button btnUpdateVehicle;

    @FXML
    private Button btnRemoveVehicle;

    @FXML
    private Button btnCancel;

    @Lazy
    @Autowired
    StageManager stageManager;

    @Autowired
    VehicleService vehicleService;

    Vehicle vehicle;

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
    void searchVehicleOnAction(ActionEvent event) {
        vehicle = vehicleService.findEntityById(Long.parseLong(txtfldVehicleNo.getText()));
        txtfldBrandName.setText(vehicle.getBrand());
        txtfldModelName.setText(vehicle.getModel());
        txtfldYear.setText(String.valueOf(vehicle.getYear()));
        txtfldPS.setText(String.valueOf(vehicle.getPs()));
        txtfldCurrentMiles.setText(String.valueOf(vehicle.getCurrentMiles()));
        if (vehicle.getCategoryAsString().equals(cbxCompact.getText())) {
            cbxCompact.setSelected(true);
        } else if (vehicle.getCategoryAsString().equals(cbxConvertible.getText())) {
            cbxConvertible.setSelected(true);
        } else if (vehicle.getCategoryAsString().equals(cbxSUV.getText())) {
            cbxSUV.setSelected(true);
        }
    }

    @FXML
    void updateVehicleOnAction(ActionEvent event) {
        vehicle.setBrand(txtfldBrandName.getText());
        vehicle.setModel(txtfldModelName.getText());
        vehicle.setYear(Integer.parseInt(txtfldYear.getText()));
        vehicle.setPs(Integer.parseInt(txtfldPS.getText()));
        vehicle.setCurrentMiles(Integer.parseInt(txtfldCurrentMiles.getText()));
        if(cbxCompact.isSelected()){
            vehicle.setCategory(Category.COMPACT);
        } else if (cbxConvertible.isSelected()) {
            vehicle.setCategory(Category.CONVERTIBLE);
        } else if (cbxSUV.isSelected()) {
            vehicle.setCategory(Category.SUV);
        }

        vehicleService.updateEntity(vehicle);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Edit successful.");
        alert.setContentText("Changes to the vehicle information have been saved.");
        alert.showAndWait();
        stageManager.switchScene(FxmlView.HOME);
    }

    @FXML
    void removeVehicleOnAction(ActionEvent event) {
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
        alert1.setTitle("Confirmation Request");
        alert1.setHeaderText("Click <Remove> to delete the vehicle from the system.");
        alert1.setContentText("Do you want to delete the selected vehicle?");

        ButtonType buttonTypeRemove = new ButtonType("Remove");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert1.getButtonTypes().setAll(buttonTypeRemove, buttonTypeCancel);

        Optional<ButtonType> result = alert1.showAndWait();
        if (result.get() == buttonTypeRemove) {
            System.exit(0);
        } else {

        }

        vehicleService.deleteEntity(vehicle);
        Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
        alert2.setTitle("Information");
        alert2.setHeaderText("Deletion successful.");
        alert2.setContentText("Vehicle has been removed from the system.");
        alert2.showAndWait();
        stageManager.switchScene(FxmlView.HOME);
    }

    @Override
    public String toString() {
        return "EditVehicleController{" +
                "resources=" + resources +
                ", location=" + location +
                ", paneEditVehicle=" + paneEditVehicle +
                ", lblVehicleNo=" + lblVehicleNo +
                ", txtfldVehicleNo=" + txtfldVehicleNo +
                ", txtfldBrandName=" + txtfldBrandName +
                ", txtfldModelName=" + txtfldModelName +
                ", txtfldYear=" + txtfldYear +
                ", txtfldPS=" + txtfldPS +
                ", txtfldCurrentMiles=" + txtfldCurrentMiles +
                ", cbxCompact=" + cbxCompact +
                ", cbxConvertible=" + cbxConvertible +
                ", cbxSUV=" + cbxSUV +
                ", btnUpdateVehicle=" + btnUpdateVehicle +
                ", btnRemoveVehicle=" + btnRemoveVehicle +
                ", btnCancel=" + btnCancel +
                ", stageManager=" + stageManager +
                ", selectedCategory='" + selectedCategory + '\'' +
                '}';
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
