package com.fracar.view;

import java.util.ResourceBundle;

/**
 * @author Kevin Kopps Laptop
 */

public enum FxmlView {

    LOGIN {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("login.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/Login.fxml";
        }
    },

    HOME {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("home.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/Home.fxml";
        }
    },

    NEW_CUSTOMER {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("newCustomer.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/NewCustomer.fxml";
        }
    },

    NEW_VEHICLE {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("newVehicle.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/NewVehicle.fxml";
        }
    },

    EDIT_CUSTOMER {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("editCustomer.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/EditCustomer.fxml";
        }
    },

    EDIT_VEHICLE {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("editVehicle.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/EditVehicle.fxml";
        }
    },

    ORDER_CONFIRMATION {
        @Override
        public String getTitle() {
            return getStringFromResourceBundle("orderConfirmation.title");
        }

        @Override
        public String getFxmlFile() {
            return "/fxml/Rent.fxml";
        }
    };


    public abstract String getTitle();
    public abstract String getFxmlFile();

    String getStringFromResourceBundle(String key){
        return ResourceBundle.getBundle("Bundle").getString(key);
    }

}
