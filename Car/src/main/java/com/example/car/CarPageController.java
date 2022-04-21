package com.example.car;

import javafx.animation.PathTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.crypto.Cipher;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CarPageController extends Thread implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    private AnchorPane pane;
    @FXML
    private Circle isStartedCircle;
    @FXML
    private Circle isStartedCircle1;
    @FXML
    private Circle isStartedCircle2;
    @FXML
    private ImageView gasImageView;
    @FXML
    private ImageView brakeImageView;
    @FXML
    private ImageView audiImageView;
    @FXML
    private ImageView clutchImageView;
    @FXML
    private ImageView ronaldoImageView;
    @FXML
    private Slider gearSlider;
    @FXML
    private TextField modelTextField;
    @FXML
    private TextField registrationNumberTextField;
    @FXML
    private Text speedTextField;
    @FXML
    private Text engineSpeedTextField;
    @FXML
    private Pane mapPane;
    @FXML
    private TextField capacityTextField;
    @FXML
    private TextField typeTextField;
    @FXML
    private Text destinationText;
    @FXML
    private TextField clutchPriceTextField;
    @FXML
    private TextField weightClutchTextField;
    @FXML
    private TextField conditionClutchTextField;
    @FXML
    private ComboBox<Car> carsComboBox;


    private Car car = new Car(4, 8, "Audi RS7", "R1 ZIOMO", "Petrol");
    private final Competition competition = new Competition();

    File file4 = new File("images/audiRS.png");
    Image image4 = new Image(file4.toURI().toString());

    File file5 = new File("images/amg.png");
    Image image5 = new Image(file5.toURI().toString());


    File file6 = new File("images/bmw.png");
    Image image6 = new Image(file5.toURI().toString());


    File file7 = new File("images/passat.png");
    Image image7 = new Image(file5.toURI().toString());

    ///////////////////////////////////////////






    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        gearSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                car.getGearbox().setCurrentGear((int) gearSlider.getValue());           ///////// BIERZE Z LISTENERA WARTOSC SLIDERA
            }

        });
        audiImageView.setX(14);
        audiImageView.setY(14);
        destinationText.setText((int)car.getEndPosition().getX() + ", " + (int)car.getEndPosition().getY());

        capacityTextField.setText(String.valueOf(car.getEngine().getCapacity()));
        typeTextField.setText(car.getEngine().getType());

        File file = new File("images/gas.png");
        Image image = new Image(file.toURI().toString());
        gasImageView.setImage(image);

        File file2 = new File("images/brake.png");
        Image image2 = new Image(file2.toURI().toString());
        brakeImageView.setImage(image2);

        File file3 = new File("images/clutch.png");
        Image image3 = new Image(file3.toURI().toString());
        clutchImageView.setImage(image3);

        File file4 = new File("images/audiRS.png");
        Image image4 = new Image(file4.toURI().toString());
        audiImageView.setImage(image4);



        gearSlider.setMax(car.getGearbox().getNumberOfGears());
        gearSlider.setDisable(true);

        modelTextField.setText(car.getModel());
        registrationNumberTextField.setText(car.getRegistrationNumber());
        speedTextField.setText(String.valueOf(car.getCurrentSpeed()));
        clutchPriceTextField.setText(String.valueOf(car.getGearbox().getClutch().getPrice()));
        weightClutchTextField.setText(String.valueOf(car.getGearbox().getClutch().getWeight()));
        conditionClutchTextField.setText("good");
        carsComboBox.getItems().add(car);
        offButtonOnAction();

        car.setImage(image4);
        audiImageView.setImage(car.getImage());
        start();
    }

    public void onButtonOnAction() {
        /*mediaPlayer2.stop();
        mediaPlayer2.play();

         */
        isStartedCircle.setFill(Color.GREEN);
        isStartedCircle1.setFill(Color.GREEN);
        car.carStart();
        engineSpeedTextField.setText(String.valueOf(car.getEngine().getEngineSpeed()));
    }

    public void offButtonOnAction() {
        isStartedCircle.setFill(Color.RED);
        isStartedCircle1.setFill(Color.RED);
        isStartedCircle2.setFill(Color.RED);
        car.carStop();
        gearSlider.setValue(0);
        gearSlider.setDisable(true); //reset wciskania sprzegla
        speedTextField.setText(String.valueOf(car.getCurrentSpeed()));
        engineSpeedTextField.setText(String.valueOf(car.getEngine().getEngineSpeed()));
    }

    public void clutchOnAction() {
        /*mediaPlayer4.stop();
        mediaPlayer4.play();

         */
        if (car.getEngine().isStarted()) {
            if (car.getGearbox().getClutch().isPut()) {
                car.getGearbox().getClutch().release();
                isStartedCircle2.setFill(Color.RED);
                gearSlider.setDisable(true);
            } else {
                car.getGearbox().getClutch().putIn();
                isStartedCircle2.setFill(Color.GREEN);
                gearSlider.setDisable(false);
            }
        }
    }

    public void brakePedalOnAction() {
        /*mediaPlayer3.stop();
        mediaPlayer3.play();

         */
        if (car.getEngine().isStarted()) {
            if (car.getCurrentSpeed() < 50) {
                car.decreaseSpeed(10);
                car.getEngine().decreaseEngineSpeed(500);
            } else if (car.getCurrentSpeed() < 100) {
                car.decreaseSpeed(20);
                car.getEngine().decreaseEngineSpeed(500);
            } else if (car.getCurrentSpeed() < 150) {
                car.decreaseSpeed(30);
                car.getEngine().decreaseEngineSpeed(500);
            } else if (car.getCurrentSpeed() < 200) {
                car.decreaseSpeed(40);
                car.getEngine().decreaseEngineSpeed(500);
            } else if (car.getCurrentSpeed() <= 300) {
                car.decreaseSpeed(50);
                car.getEngine().decreaseEngineSpeed(500);
            }

            if (car.getCurrentSpeed() <= 0) {
                car.setCurrentSpeed(0);
            }

            if (car.getEngine().getEngineSpeed() < 1000)
                car.getEngine().setEngineSpeed(1000);
            speedTextField.setText(String.valueOf(car.getCurrentSpeed()));
            engineSpeedTextField.setText(String.valueOf(car.getEngine().getEngineSpeed()));
        }
    }

    public void gasPedalOnAction() {
        /*mediaPlayer.stop();
        mediaPlayer.play();

         */
        if (car.getEngine().isStarted() && !car.getGearbox().getClutch().isPut()) {
            if (car.getGearbox().getCurrentGear() == 1) {
                car.increaseSpeed(25);
            } else if (car.getGearbox().getCurrentGear() == 2) {
                car.increaseSpeed(21);
            } else if (car.getGearbox().getCurrentGear() == 3) {
                car.increaseSpeed(18);
            } else if (car.getGearbox().getCurrentGear() == 4) {
                car.increaseSpeed(15);
            } else if (car.getGearbox().getCurrentGear() == 5) {
                car.increaseSpeed(13);
            } else if (car.getGearbox().getCurrentGear() == 6) {
                car.increaseSpeed(11);
            } else if (car.getGearbox().getCurrentGear() == 7) {
                car.increaseSpeed(9);
            } else if (car.getGearbox().getCurrentGear() == 8) {
                car.increaseSpeed(8);
            }
            if (car.getEngine().getEngineSpeed() + 500 >= car.getEngine().getMaxEngineSpeed())
                car.getEngine().setEngineSpeed(car.getEngine().getMaxEngineSpeed());
            else
                car.getEngine().increaseEngineSpeed(500);


            speedTextField.setText(String.valueOf(car.getCurrentSpeed()));
            engineSpeedTextField.setText(String.valueOf(car.getEngine().getEngineSpeed()));
        }
    }

    public void goToOnAction() throws Exception {
        mapPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                car.getEndPosition().setX(mouseEvent.getX());
                car.getEndPosition().setY(mouseEvent.getY());
                destinationText.setText((int)car.getEndPosition().getX() + ", " + (int)car.getEndPosition().getY());
            }
        });
    }

    /*public void takeStep() {
        double distance = Math.sqrt(Math.pow(
                car.getEndPosition().getX()- car.getStartPosition().getX(), 2) +
                Math.pow(car.getEndPosition().getY() - car.getStartPosition().getY(), 2));
        double iterations = distance * 25 / (car.getCurrentSpeed());
        double stepX = Math.abs(car.getEndPosition().getX() - car.getStartPosition().getX()) / iterations;
        double stepY = Math.abs(car.getEndPosition().getY() - car.getStartPosition().getY()) / iterations;
        if(Math.abs(car.getEndPosition().getX() - car.getStartPosition().getX()) > 2
                && Math.abs(car.getEndPosition().getY() - car.getStartPosition().getY()) > 2 ) {
            if (car.getStartPosition().getX() < car.getEndPosition().getX()
                    && car.getStartPosition().getY() < car.getEndPosition().getY()) {
                car.getStartPosition().setX(car.getStartPosition().getX() + stepX);
                car.getStartPosition().setY(car.getStartPosition().getY() + stepY);
            } else if (car.getStartPosition().getX() < car.getEndPosition().getX()
                    && car.getStartPosition().getY() > car.getEndPosition().getY()) {
                car.getStartPosition().setX(car.getStartPosition().getX() + stepX);
                car.getStartPosition().setY(car.getStartPosition().getY() - stepY);
            } else if (car.getStartPosition().getX() > car.getEndPosition().getX()
                    && car.getStartPosition().getY() < car.getEndPosition().getY()) {
                car.getStartPosition().setX(car.getStartPosition().getX() - stepX);
                car.getStartPosition().setY(car.getStartPosition().getY() + stepY);
            } else if (car.getStartPosition().getX() > car.getEndPosition().getX()
                    && car.getStartPosition().getY() > car.getEndPosition().getY()) {
                car.getStartPosition().setX(car.getStartPosition().getX() - stepX);
                car.getStartPosition().setY(car.getStartPosition().getY() - stepY);
            }
        }
        else{
            car.setCurrentSpeed(0);
            speedTextField.setText(String.valueOf(car.getCurrentSpeed()));
            car.getEngine().setEngineSpeed(1000);
            engineSpeedTextField.setText(String.valueOf(car.getEngine().getEngineSpeed()));
        }

        audiImageView.setX((int)car.getStartPosition().getX());
        audiImageView.setY((int)car.getStartPosition().getY());
        destinationText.setText(String.valueOf((int)car.getEndPosition().getX()) + ", " +
                String.valueOf((int)car.getEndPosition().getY()));
    }

     */

    public void resetButtonOnAction() {
        /*mediaPlayer5.stop();
        mediaPlayer5.play();

         */
        offButtonOnAction();
        car.getStartPosition().setX(14);
        car.getStartPosition().setY(14);
        car.getEndPosition().setX(14);
        car.getEndPosition().setY(14);
    }

    public void deleteButtonOnAction() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);   ///// tworzy alert typu Confirm
        alert.setTitle(null);
        alert.setHeaderText("Car removal");
        alert.setContentText("Are you sure you want to remove the car: " + car.getModel() + ", " + car.getRegistrationNumber() + "?");
        /////////////////////////////////////////////////////
        if (alert.showAndWait().get() == ButtonType.OK) {
            if(carsComboBox.getItems().indexOf(car) != 0)
                carsComboBox.getItems().remove(car);
            else {
                alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle(null);
                alert.setHeaderText("An error has occured");
                alert.setContentText("You can not remove default car!");
                alert.showAndWait();
            }
        }
    }


    public void addButtonOnAction() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CarApp.class.getResource("AddCarPage.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        AddCarPageController addCarPageController = fxmlLoader.getController();
        addCarPageController.getCombo(carsComboBox);
        stage.setResizable(true); //// bez zmiany wielkosci
        stage.show();
    }

    public void getValueFromCombo() {
        car = carsComboBox.getValue();

        capacityTextField.setText(String.valueOf(car.getEngine().getCapacity()));
        typeTextField.setText(car.getEngine().getType());
        gearSlider.setMax(car.getGearbox().getNumberOfGears());
        gearSlider.setValue(car.getGearbox().getCurrentGear());
        gearSlider.setDisable(true);
        modelTextField.setText(car.getModel());
        registrationNumberTextField.setText(car.getRegistrationNumber());
        speedTextField.setText(String.valueOf(car.getCurrentSpeed()));
        clutchPriceTextField.setText(String.valueOf(car.getGearbox().getClutch().getPrice()));
        weightClutchTextField.setText(String.valueOf(car.getGearbox().getClutch().getWeight()));
        conditionClutchTextField.setText("good");
    }

    public void run() {
        while(true) {
            try {
                gearSlider.setValue(car.getGearbox().getCurrentGear());
                audiImageView.setY(car.getStartPosition().getY());
                audiImageView.setX(car.getStartPosition().getX());
                destinationText.setText((int)car.getEndPosition().getX() + ", " + (int)car.getEndPosition().getY());
                speedTextField.setText(String.valueOf(car.getCurrentSpeed()));
                engineSpeedTextField.setText(String.valueOf(car.getEngine().getEngineSpeed()));
                audiImageView.setImage(car.getImage());
                if(car.getEngine().isStarted()) {
                    if(car.getGearbox().getClutch().isPut()) {
                        isStartedCircle.setFill(Color.GREEN);
                        isStartedCircle1.setFill(Color.GREEN);
                        isStartedCircle2.setFill(Color.GREEN);
                    }
                    else {
                        isStartedCircle.setFill(Color.GREEN);
                        isStartedCircle1.setFill(Color.GREEN);
                        isStartedCircle2.setFill(Color.RED);
                    }
                }
                else {
                    isStartedCircle.setFill(Color.RED);
                    isStartedCircle1.setFill(Color.RED);
                    isStartedCircle2.setFill(Color.RED);
                }
                sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



