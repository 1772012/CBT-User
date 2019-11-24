package com.cbtuser.controller;

import com.cbtuser.MainApp;
import com.cbtuser.dao.AnswerDaoImpl;
import com.cbtuser.dao.ParticipantDaoImpl;
import com.cbtuser.dao.QuestionDaoImpl;
import com.cbtuser.dao.ScoreDaoImpl;
import com.cbtuser.dao.SubtestDaoImpl;
import com.cbtuser.dao.TestDaoImpl;
import com.cbtuser.entity.Answer;
import com.cbtuser.entity.Mediacontent;
import com.cbtuser.entity.Participant;
import com.cbtuser.entity.Question;
import com.cbtuser.entity.Subtest;
import com.cbtuser.entity.Test;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.image.Image;

/**
 * FXML Controller class
 *
 * @author Kafka Febianto Agiharta - 1772012
 */
public class MainViewController implements Initializable {

    //  FXML attributes
    @FXML
    private AnchorPane root;
    @FXML
    private BorderPane scoreBorderPane;
    @FXML
    private BorderPane userBorderPane;
    @FXML
    private BorderPane loginBorderPane;
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Pane imgLoginPane;
    @FXML
    private ImageView imgLogoLoginWhite;
    @FXML
    private Pane imgUserPane;
    @FXML
    private ImageView imgLogoUserWhite;
    @FXML
    private VBox userViewPage;
    @FXML
    private VBox testViewPage;
    @FXML
    private Label lblNameHeaderParticipant;
    @FXML
    private Label lblIdHeaderParticipant;
    @FXML
    private Label lblIdParticipant;
    @FXML
    private Label lblNameParticipant;
    @FXML
    private Label lblInstituteParticipant;
    @FXML
    private Label lblEmailParticipant;
    @FXML
    private TextField txtTokenTest;
    @FXML
    private Label lblIdTest;
    @FXML
    private Label lblNameTest;
    @FXML
    private Label lblDateTest;
    @FXML
    private Label lblDateTimeTest;
    @FXML
    private BorderPane questionBorderPane;
    @FXML
    private VBox vboxQuestion;
    @FXML
    private Label lblQstParticipantName;
    @FXML
    private Label lblQstParticipantId;
    @FXML
    private GridPane gpQuestions;
    @FXML
    private Label lblQstTestName;
    @FXML
    private Button btnPrev;
    @FXML
    private Button btnWarn;
    @FXML
    private Button btnNext;
    @FXML
    private Label lblNavigation;
    @FXML
    private Label lblFinalTestHeader;
    @FXML
    private Label lblNameFinal;
    @FXML
    private Label lblIdFinal;
    @FXML
    private Label lblScoreFinal;
    @FXML
    private Label lblTrueAnswerFinal;
    @FXML
    private Label lblTimeFinal;

    //  Dao controllers
    private TestDaoImpl testDao;
    private ParticipantDaoImpl participantDao;
    private SubtestDaoImpl subtestDao;
    private QuestionDaoImpl questionDao;
    private AnswerDaoImpl answerDao;
    private Mediacontent mediaContentDao;
    private ScoreDaoImpl scoreDao;

    //  Observable lists
    private ObservableList<Subtest> subtests;
    private ObservableList<Question> questions;
    private ObservableList<Answer> answers;
    private ObservableList<Mediacontent> mediacontents;
    private ObservableList<VBox> navigationVbox;
    private ObservableList<Integer> trueAnswerKey;
    private Map<Integer, String> mapKey;
//    private Map<Integer, Integer> trueAnswerKey;
    

    //  Stages
    private Stage subtestStage;

    //  Temp objects
    private Participant participant;
    private Test test;

    //  Temp primitive data
    private int navigationNumber = 0;
    private int idx = 0;
    private boolean found = false;
    private double score = 0;

    //  FXML Utilities
    private double editTestX;
    private double editTestY;
    @FXML
    private Label lblTimerCount;
    
    static Thread thread = new Thread();

    //  =================================================
    //  Initializations of controller class
    //  @param url
    //  @param rb
    //  =================================================
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initFXMLControls();
        initDaoControls();
        initListControls();
        initUtilityControls();
        initControllerControls();
    }

    //  =================================================
    //  Initializations
    //  =================================================
    //
    //  Creates first initialization of FXML Controllers
    private void initFXMLControls() {

        //  Lock the imgCbt size to parent container
        imgLogoLoginWhite.fitWidthProperty().bind(imgLoginPane.widthProperty());
        imgLogoLoginWhite.fitHeightProperty().bind(imgLoginPane.heightProperty());

        imgLogoUserWhite.fitWidthProperty().bind(imgUserPane.widthProperty());
        imgLogoUserWhite.fitHeightProperty().bind(imgUserPane.heightProperty());

        //  Disable the TextField focus
        final BooleanProperty firstTime = new SimpleBooleanProperty(true);
        txtUsername.focusedProperty().addListener((observable, oldValue,
                newValue) -> {
            if (newValue && firstTime.get()) {
                root.requestFocus();
                firstTime.setValue(false);
            }
        });
    }

    //  Creates DAO control on first initialization
    private void initDaoControls() {
        participantDao = new ParticipantDaoImpl();
        testDao = new TestDaoImpl();
        subtestDao = new SubtestDaoImpl();
        questionDao = new QuestionDaoImpl();
        scoreDao = new ScoreDaoImpl();
        answerDao = new AnswerDaoImpl();
    }

    //  Creates Observable List on first initialization
    private void initListControls() {
        subtests = FXCollections.observableArrayList();
        questions = FXCollections.observableArrayList();
        answers = FXCollections.observableArrayList();
        mediacontents = FXCollections.observableArrayList();
        navigationVbox = FXCollections.observableArrayList();
    }

    //  Creates usable utilities on first initialization
    private void initUtilityControls() {
        mapKey = new HashMap<>();
        mapKey.put(0, "A. ");
        mapKey.put(1, "B. ");
        mapKey.put(2, "C. ");
        mapKey.put(3, "D. ");
        mapKey.put(4, "E. ");

        trueAnswerKey = FXCollections.observableArrayList();
    }

    //  controls FXML at initialization
    private void initControllerControls() {

        //  Disables the button at initialization
        btnPrev.setDisable(true);
    }

    //  =================================================
    //  Login View Sections
    //  =================================================
    //
    //  If login button is clicked
    @FXML
    private void loginButtonClick(ActionEvent event) {
        if (login()) {

            //  Set text into nodes
            lblNameHeaderParticipant.setText(participant.getFirstName() + " " + participant.getLastName());
            lblIdHeaderParticipant.setText(participant.getId());
            lblNameParticipant.setText(participant.getFirstName() + " " + participant.getLastName());
            lblIdParticipant.setText(participant.getId());
            lblInstituteParticipant.setText(participant.getInstitute().getName());
            lblEmailParticipant.setText(participant.getEmail());

            //  Show User section
            userBorderPane.toFront();
        } else {
            alertErrorShow("Login error", "Username atau Password salah! silahkan coba lagi.", AlertType.ERROR);
        }
    }

    //  Function for login button
    private boolean login() {

        //  Boolean variable to check the object
        boolean valid;

        //  Create temp object for Participant
        Participant tempParticipant = new Participant();
        tempParticipant.setUsername(txtUsername.getText());
        tempParticipant.setPassword(txtPassword.getText());

        //  Get one object from Participant
        participant = participantDao.getOneData(tempParticipant);

        //  Checks if the object is null
        valid = (participant != null);

        return valid;
    }

    //  =================================================
    //  User View Sections
    //  =================================================
    //
    //  If confirmation button is clicked
    @FXML
    private void btnTestConfirmationClick(ActionEvent event) {
        if (tokenConfirmation()) {

            //  Set text into nodes
            lblIdTest.setText(test.getId());
            lblNameTest.setText(test.getName());
            lblDateTest.setText(dateFormatter(test.getDate()));
            lblDateTimeTest.setText(String.valueOf(test.getStartTime()));

            //  Get subtest from database
            subtests.addAll(subtestDao.getSpecificData(test));

            //  Show test section
            testViewPage.toFront();
        } else {
            alertErrorShow("Token Error", "Token salah! harap masukan kembali.", AlertType.ERROR);
        }
    }

    private boolean tokenConfirmation() {

        //  Boolean variable to check the object
        boolean valid;

        //  Create temp object for test
        Test tempTest = new Test();
        tempTest.setToken(txtTokenTest.getText());

        //  Get one object from test
        test = testDao.getOneData(tempTest);

        //  Check if the object is null
        valid = (test != null);

        return valid;
    }

    //  =================================================
    //  Test View Sections
    //  =================================================
    //
    //  If the view subtest is clicked
    @FXML
    private void btnSubtestClick(ActionEvent event) {
        try {

            //  Create new stage
            subtestStage = new Stage();
            subtestStage.setTitle("Lihat Mata Pelajaran");
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource(
                    "view/TestListView.fxml"));
            VBox testPane = loader.load();
            TestListViewController controller = loader.getController();
            controller.setMainController(this);
            Scene scene = new Scene(testPane);
            subtestStage.setScene(scene);
            subtestStage.setResizable(false);
            subtestStage.initOwner(root.getScene().getWindow());
            subtestStage.initModality(Modality.APPLICATION_MODAL);
            subtestStage.initStyle(StageStyle.UNDECORATED);

            //  Utilities for dragabble stage
            testPane.setOnMousePressed((MouseEvent event1) -> {
                editTestX = subtestStage.getX() - event1.getScreenX();
                editTestY = subtestStage.getY() - event1.getScreenY();
            });
            testPane.setOnMouseDragged((MouseEvent event1) -> {
                subtestStage.setX(event1.getScreenX() + editTestX);
                subtestStage.setY(event1.getScreenY() + editTestY);
            });

            //  Show the stage
            if (!subtestStage.isShowing()) {
                subtestStage.show();
            } else {
                subtestStage.toFront();
            }

        } catch (IOException e) {
            Logger.getLogger(TestListViewController.class.getName()).
                    log(Level.SEVERE, null, e);
        }
    }

    //  If the start button is clicked
    @FXML
    private void btnQuestionStartClick(ActionEvent event) throws InterruptedException {

        //  Set the initial text
        lblQstParticipantName.setText(participant.getFirstName() + " " + participant.getLastName());
        lblQstParticipantId.setText(participant.getId());
        lblQstTestName.setText(test.getName());
        lblNavigation.setText(String.valueOf(navigationNumber + 1));

        //  Add question based on subtests
        subtests.forEach((subtest) -> {
            questions.addAll(questionDao.getSpecificData(subtest));
        });

        //  Creates navigation button for question
        for (int i = 0; i < questions.size(); i++) {

            //  Create button and put attributes on it
            Button btn = new Button();
            btn.setId("button-question-view");
            btn.setText(String.valueOf(i + 1));
            btn.setMaxWidth(Double.MAX_VALUE);
            btn.setMaxHeight(Double.MAX_VALUE);
            btn.setOnAction((ActionEvent e) -> {
                navigationNumber = Integer.parseInt(btn.getText()) - 1;
                if (navigationNumber == 0) {
                    btnPrev.setDisable(true);
                    btnNext.setDisable(false);
                } else if (navigationNumber == questions.size() - 1) {
                    btnNext.setDisable(true);
                    btnPrev.setDisable(false);
                } else {
                    btnPrev.setDisable(false);
                    btnNext.setDisable(false);
                }
                vboxQuestion.getChildren().clear();
                vboxQuestion.getChildren().add(navigationVbox.get(navigationNumber));
                lblNavigation.setText(String.valueOf(navigationNumber + 1));

            });

            //  Create VBox and put button on it
            VBox box = new VBox();
            box.getChildren().add(btn);
            box.setId("vbox-button-question-view");

            //  Add to Grid Pane
            gpQuestions.add(box, (i % 5), (i / 5));
        }

        //  Create questions and put answers into vbox
        for (int i = 0; i < questions.size(); i++) {

            //  Create temp VBox and set objects in it
            VBox vboxTemp = new VBox();
            vboxTemp.setId("vbox-question-view");

            //  Check if question has a media
            switch (questions.get(i).getMediacontent().getMedia().getId()) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:

                    //  Create Image object
                    ImageView imgView = new ImageView(new Image(
                            "file:" + questions.get(i).getMediacontent().getMediaAddress()));

                    //  Create gap from HBox (just for style)
                    HBox hboxGap = new HBox();
                    hboxGap.setPrefHeight(20);

                    //  Add image to VBox temp
                    vboxTemp.getChildren().add(imgView);
                    vboxTemp.getChildren().add(hboxGap);

                    break;
                default:
                    break;
            }

            //  Create temp label and set attributes on it
            Label lblTemp = new Label(questions.get(i).getId());
            lblTemp.setId("label-question-view");
            lblTemp.setText(questions.get(i).getContent());

            //  Create gap from HBox (just for style)
            HBox hboxGap = new HBox();
            hboxGap.setPrefHeight(20);

            //  Set the objects into VBox
            vboxTemp.getChildren().add(lblTemp);
            vboxTemp.getChildren().add(hboxGap);

            //  Get all answer from question (this is temporary list)
            answers.addAll(answerDao.getSpecificData(questions.get(i)));

            //  Create toggle group for radio buttons
            ToggleGroup groupTemp = new ToggleGroup();

            //  Create Vbox list of Radio buttons
            VBox vboxRadioButtons = new VBox();

            //  Create radio buttons
            for (int j = 0; j < questions.get(i).getAnswers().size(); j++) {
                
                //  Create Answer key for scoring later
                if (answers.get(j).getTrueAnswer() == 1) {
                    trueAnswerKey.add(j);
                }

                //  Create radio button and put attributes on it
                RadioButton rbTemp = new RadioButton(answers.get(j).getId().getId());
                rbTemp.setId("radiobutton-question-view");
                rbTemp.setToggleGroup(groupTemp);
                rbTemp.setText(mapKey.get(j) + answers.get(j).getContent());

                //  Add each radio buttons to temp VBoxRadioButtons
                vboxRadioButtons.getChildren().add(rbTemp);
            }

            //  Add list of Radio Buttons to VBox
            vboxTemp.getChildren().add(vboxRadioButtons);

            //  Clears the temporary list
            answers.clear();

            //  Add to list of VBox
            navigationVbox.add(vboxTemp);
        }

        //  Add first question to Main View of VBox
        vboxQuestion.getChildren().add(navigationVbox.get(navigationNumber));
        
        //  Show the question view
        questionBorderPane.toFront();
        
    }

    //  =================================================
    //  Question View Sections
    //  =================================================
    //
    //  If the Previous button is clicked
    @FXML
    private void btnPrevClick(ActionEvent event) {

        //  If the navigationNumber high than zero, then enables the button
        if (navigationNumber > 0) {
            navigationNumber -= 1;
            vboxQuestion.getChildren().clear();
            vboxQuestion.getChildren().add(navigationVbox.get(navigationNumber));
            btnNext.setDisable(false);
            lblNavigation.setText(String.valueOf(navigationNumber + 1));
        }

        //  If the navigationNumber is zero, then disables the button
        if (navigationNumber == 0) {
            btnPrev.setDisable(true);
        }
    }

    //  If the Check button is clicked
    @FXML
    private void btnCheckClick(ActionEvent event) {

        //  Call method for check cell and parse it
        VBox vboxQst = (VBox) getCellFromGridPane(gpQuestions, (navigationNumber % 5), (navigationNumber / 5));
        Button btnQst = (Button) vboxQst.getChildren().get(0);

        //  Check the button id
        if (btnQst.getId().equals("button-question-view")) {
            btnQst.setId("button-question-view-mark");
        } else {
            btnQst.setId("button-question-view");
        }

    }

    //  If the Next button is clicked
    @FXML
    private void btnNextClick(ActionEvent event) {

        //  If the navigationNumber lower than end of question list, then enables the button
        if (navigationNumber < questions.size() - 1) {
            navigationNumber += 1;
            vboxQuestion.getChildren().clear();
            vboxQuestion.getChildren().add(navigationVbox.get(navigationNumber));
            btnPrev.setDisable(false);
            lblNavigation.setText(String.valueOf(navigationNumber + 1));
        }

        //  If the navigationNumber reach end of question list, then disables the button
        if (navigationNumber == questions.size() - 1) {
            btnNext.setDisable(true);
        }
    }

    //  If the end button is clicked
    @FXML
    private void btnEndTestClick(ActionEvent event) {

        //  Create alert for confirmation of ending test
        Alert alert = new Alert(AlertType.CONFIRMATION, "Apakah Anda yakin ingin mengakhiri tes?",
                ButtonType.YES, ButtonType.NO);
        alert.setHeaderText("Konfirmasi selesai");
        alert.initOwner(root.getScene().getWindow());
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.showAndWait();

        //  If choose yes
        if (alert.getResult() == ButtonType.YES) {
            
            //  Bruteforce all radiobuttons to get answer
            navigationVbox.forEach((nav) -> {
                found = false;
                nav.getChildren().forEach((node) -> {   // Masuk ke setiap node of komponen soal {Image, Label dll}
                    if (node instanceof VBox) {
                        for (int i = 0; i < ((VBox) node).getChildren().size(); i++) { // Masuk ke list of radiobutton
                            RadioButton rb = (RadioButton) ((VBox) node).getChildren().get(i);
                            if (rb.isSelected() && trueAnswerKey.get(idx) == i) {
                                found = true;
                                score++;
                            }
                        }
                    }
                });
                idx++;
            });
            
            //  Set the initial text
            lblFinalTestHeader.setText(test.getName());
            lblNameFinal.setText(participant.getFirstName() + " " + participant.getLastName());
            lblIdFinal.setText(participant.getId());
            lblScoreFinal.setText(String.valueOf((score/questions.size()) * 100));
            lblTrueAnswerFinal.setText(String.valueOf((int)score) + " / " + String.valueOf(questions.size()));

            //  Show the score view
            scoreBorderPane.toFront();
        }
    }

    //  =================================================
    //  Score View Sections
    //  =================================================
    //
    //  if the exit button is pressed
    @FXML
    private void btnExitPlatform(ActionEvent event) {
        Platform.exit();
    }

    //  =================================================
    //  Usable Functions
    //  =================================================
    //
    //  Usable for formatting date
    private String dateFormatter(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd MMMM yyyy", Locale.ENGLISH);
        return sdf.format(date);
    }

    //  Usable for show alert
    private void alertErrorShow(String header, String content, AlertType type) {
        Alert alert = new Alert(type);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.initOwner(root.getScene().getWindow());
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.show();
    }

    //  Bruteforce node
    private Node getCellFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }

    //  =================================================
    //  Getter / Setter
    //  =================================================
    //
    //  Get Subtest
    public ObservableList<Subtest> getSubtest() {
        return subtests;
    }
}