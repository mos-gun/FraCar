package com.fracar.controller;

import com.fracar.config.StageManager;
import com.fracar.entity.Employee;
import com.fracar.service.EmployeeService;
import com.fracar.view.FxmlView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class LoginController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane paneLogin;

    @FXML
    private Label lblLogin;

    @FXML
    private TextField txtfldUsername;

    @FXML
    private PasswordField pwfldPassword;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnExit;

    @Autowired
    EmployeeService employeeService;

    @Lazy
    @Autowired
    StageManager stageManager;

    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
//___________________________________________________________________________________________________

    @FXML
    void exitOnAction(ActionEvent event) {
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }


    @FXML
    void loginOnAction(ActionEvent event) {

        if (employeeService.authenticate(getUsername(), getPassword())) {
            employee = employeeService.findByUsername(getUsername());

            setEmployee(employee);

            stageManager.switchScene(FxmlView.HOME);

        } else {
            lblLogin.setText("Login failed");
            lblLogin.setTextFill(Color.RED);
        }
    }


    public String getUsername() {
        return txtfldUsername.getText();
    }

    public String getPassword() {
        return pwfldPassword.getText();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}