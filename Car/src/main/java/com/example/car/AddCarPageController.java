package com.example.car;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class AddCarPageController implements Initializable {

    @FXML
    private TextField registration2TextField;
    @FXML
    private TextField model2TextField;
    @FXML
    private TextField capacity2TextField;
    @FXML
    private RadioButton dieselCheckBox;
    @FXML
    private RadioButton petrolCheckBox;
    @FXML
    private RadioButton fiveCheckBox;
    @FXML
    private RadioButton sixCheckBox;
    @FXML
    private RadioButton sevenCheckBox;
    @FXML
    private RadioButton eightCheckBox;
    @FXML
    private Label missingTextField;
    @FXML
    private AnchorPane mainPane;
    @FXML
    private ImageView audiImageView;
    @FXML
    private ImageView mercedesImageView;
    @FXML
    private ImageView bmwImageView;
    @FXML
    private ImageView passatImageView;
    @FXML
    private RadioButton audiRadioButton;
    @FXML
    private RadioButton merolRadioButton;
    @FXML
    private RadioButton bmwRadioButton;
    @FXML
    private RadioButton passatRadioButton;


    private Car car;
    private final ToggleGroup toggleGroup = new ToggleGroup();
    private final ToggleGroup toggleGroup2 = new ToggleGroup();
    private final ToggleGroup toggleGroup3 = new ToggleGroup(); // do ikonek aut
    private boolean iconSelected = false;
    private boolean audiSelected = false;
    private boolean merolSelected = false;
    private boolean bmwSelected = false;
    private boolean passatSelected = false;
    ComboBox<Car> comboBox;

    File file = new File("images/audiRS.png");
    Image audi = new Image(file.toURI().toString());


    File file2 = new File("images/amg.png");
    Image merol = new Image(file2.toURI().toString());


    File file3 = new File("images/bmw.png");
    Image bmw = new Image(file3.toURI().toString());


    File file4 = new File("images/passat.png");
    Image passat = new Image(file4.toURI().toString());

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fiveCheckBox.setToggleGroup(toggleGroup);
        sevenCheckBox.setToggleGroup(toggleGroup);
        sixCheckBox.setToggleGroup(toggleGroup);
        eightCheckBox.setToggleGroup(toggleGroup);
        dieselCheckBox.setToggleGroup(toggleGroup2);
        petrolCheckBox.setToggleGroup(toggleGroup2);

        audiRadioButton.setToggleGroup(toggleGroup3);
        bmwRadioButton.setToggleGroup(toggleGroup3);
        merolRadioButton.setToggleGroup(toggleGroup3);
        audiRadioButton.setToggleGroup(toggleGroup3);

        audiImageView.setImage(audi);
        mercedesImageView.setImage(merol);
        bmwImageView.setImage(bmw);
        passatImageView.setImage(passat);
    }

    public void getCombo(ComboBox<Car> comboBox) {
        this.comboBox = comboBox;
    }


    public void add() {
        if(audiRadioButton.isSelected() || merolRadioButton.isSelected() || bmwRadioButton.isSelected() || passatRadioButton.isSelected()) {
            iconSelected = true;
        }
        else
            iconSelected = false;
        if (registration2TextField.getText().isBlank() || model2TextField.getText().isBlank() ||
                capacity2TextField.getText().isBlank() || !dieselCheckBox.isSelected() && !petrolCheckBox.isSelected()) {
            missingTextField.setText("Missing data");
        } else {
            try {
                if (fiveCheckBox.isSelected()) {
                    if(iconSelected) {
                        if (petrolCheckBox.isSelected()) {
                            car = new Car(Double.parseDouble(capacity2TextField.getText()), 5, model2TextField.getText(),
                                    registration2TextField.getText(), "Petrol");
                        }
                        else {
                            car = new Car(Double.parseDouble(capacity2TextField.getText()), 5, model2TextField.getText(),
                                    registration2TextField.getText(), "Diesel");

                        }
                        if(audiRadioButton.isSelected())
                            car.setImage(audi);
                        else if(bmwRadioButton.isSelected())
                            car.setImage(bmw);
                        else if(merolRadioButton.isSelected())
                            car.setImage(merol);
                        else if(passatRadioButton.isSelected())
                            car.setImage(passat);
                        missingTextField.setText("");
                        Stage stage = (Stage) mainPane.getScene().getWindow(); /// aktualna scena, ktora chcemy zamknac
                        comboBox.getItems().add(car);
                        stage.close();
                    }
                    else
                        missingTextField.setText("Missing data");
                } else if (sixCheckBox.isSelected()) {
                    if(iconSelected) {
                        if (petrolCheckBox.isSelected())
                            car = new Car(Double.parseDouble(capacity2TextField.getText()), 6, model2TextField.getText(),
                                    registration2TextField.getText(), "Petrol");
                        else {
                            car = new Car(Double.parseDouble(capacity2TextField.getText()), 6, model2TextField.getText(),
                                    registration2TextField.getText(), "Diesel");
                        }
                        if(audiRadioButton.isSelected())
                            car.setImage(audi);
                        else if(bmwRadioButton.isSelected())
                            car.setImage(bmw);
                        else if(merolRadioButton.isSelected())
                            car.setImage(merol);
                        else if(passatRadioButton.isSelected())
                            car.setImage(passat);
                        missingTextField.setText("");
                        Stage stage = (Stage) mainPane.getScene().getWindow(); /// aktualna scena, ktora chcemy zamknac
                        comboBox.getItems().add(car);
                        stage.close();
                    }
                    else
                        missingTextField.setText("Missing data");
                } else if (sevenCheckBox.isSelected()) {
                    if(iconSelected) {
                        if (petrolCheckBox.isSelected())
                            car = new Car(Double.parseDouble(capacity2TextField.getText()), 7, model2TextField.getText(),
                                    registration2TextField.getText(), "Petrol");
                        else {
                            car = new Car(Double.parseDouble(capacity2TextField.getText()), 7, model2TextField.getText(),
                                    registration2TextField.getText(), "Diesel");
                        }
                        if(audiRadioButton.isSelected())
                            car.setImage(audi);
                        else if(bmwRadioButton.isSelected())
                            car.setImage(bmw);
                        else if(merolRadioButton.isSelected())
                            car.setImage(merol);
                        else if(passatRadioButton.isSelected())
                            car.setImage(passat);
                        missingTextField.setText("");
                        Stage stage = (Stage) mainPane.getScene().getWindow(); /// aktualna scena, ktora chcemy zamknac
                        comboBox.getItems().add(car);
                        stage.close();
                    }
                    else
                        missingTextField.setText("Missing data");
                } else if (eightCheckBox.isSelected()) {
                    if(iconSelected) {
                        if (petrolCheckBox.isSelected())
                            car = new Car(Double.parseDouble(capacity2TextField.getText()), 8, model2TextField.getText(),
                                    registration2TextField.getText(), "Petrol");
                        else {
                            car = new Car(Double.parseDouble(capacity2TextField.getText()), 8, model2TextField.getText(),
                                    registration2TextField.getText(), "Diesel");
                        }
                        if(audiRadioButton.isSelected())
                            car.setImage(audi);
                        else if(bmwRadioButton.isSelected())
                            car.setImage(bmw);
                        else if(merolRadioButton.isSelected())
                            car.setImage(merol);
                        else if(passatRadioButton.isSelected())
                            car.setImage(passat);
                        missingTextField.setText("");
                        Stage stage = (Stage) mainPane.getScene().getWindow(); /// aktualna scena, ktora chcemy zamknac
                        comboBox.getItems().add(car);
                        stage.close();
                    }
                    else
                        missingTextField.setText("Missing data");
                } else
                    missingTextField.setText("Missing data");
            }
            catch(NumberFormatException e) {
                missingTextField.setText("Capacity value must be a number");
            }
        }
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
