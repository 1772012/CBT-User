package com.cbtuser.controller;

import com.cbtuser.dao.AudansquestionDaoImpl;
import com.cbtuser.dao.AudioquestionDaoImpl;
import com.cbtuser.dao.ImagequestionDaoImpl;
import com.cbtuser.dao.ImgansquestionDaoImpl;
import com.cbtuser.dao.NormalquestionDaoImpl;
import com.cbtuser.dao.NrmanquestionDaoImpl;
import com.cbtuser.dao.SubtestdatabaseDaoImpl;
import com.cbtuser.dao.VidansquestionDaoImpl;
import com.cbtuser.dao.VideoquestionDaoImpl;
import com.cbtuser.entity.Audansquestion;
import com.cbtuser.entity.Audioquestion;
import com.cbtuser.entity.Imagequestion;
import com.cbtuser.entity.Imgansquestion;
import com.cbtuser.entity.Normalquestion;
import com.cbtuser.entity.Nrmansquestion;
import com.cbtuser.entity.Participant;
import com.cbtuser.entity.Subtest;
import com.cbtuser.entity.Subtestdatabase;
import com.cbtuser.entity.Test;
import com.cbtuser.entity.Vidansquestion;
import com.cbtuser.entity.Videoquestion;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Redwolfer
 */
public class QuestionContainerViewController implements Initializable {

    //  FXML attributes
    @FXML
    private BorderPane root;
    @FXML
    private Pane logoPane;
    @FXML
    private ImageView imgCbt;
    @FXML
    private Label lblNameHead;
    @FXML
    private Label lblWelcomeHead;
    @FXML
    private Label lblNrpHead;
    @FXML
    private ScrollPane scpQuestion;
    @FXML
    private GridPane grpBtnSwitch;

    //  Create main controller
    private TestConfirmationViewController mainController;

    //  Create observable list of objects
    private ObservableList<Normalquestion> normalQuests;
    private ObservableList<Nrmansquestion> nrmansQuests;
    private ObservableList<Videoquestion> videoQuests;
    private ObservableList<Vidansquestion> vidansQuests;
    private ObservableList<Imagequestion> imageQuests;
    private ObservableList<Imgansquestion> imgansQuests;
    private ObservableList<Audioquestion> audioQuests;
    private ObservableList<Audansquestion> audansQuests;

    //  Create observable list of subtests
    private ObservableList<Subtest> subtests;

    //  Create observable list of subtest databases
    private ObservableList<Subtestdatabase> subtestDatabases;

    //  Create observable list of node
    private ObservableList<Node> questionNode;

    //  Create observable list of radio buttons
    private ObservableList<RadioButton> radioButtons;

    //  Create observable list of buttons
    private ObservableList<Button> buttons;

    //  Create temp object
    private Participant loginParticipant;
    private Test test;

    //  Create dao controller
    private NormalquestionDaoImpl normalQuestDao;
    private NrmanquestionDaoImpl nrmansDao;
    private AudioquestionDaoImpl audioQuestDao;
    private AudansquestionDaoImpl audansDao;
    private ImagequestionDaoImpl imageQuestDao;
    private ImgansquestionDaoImpl imgansDao;
    private VideoquestionDaoImpl videoQuestDao;
    private VidansquestionDaoImpl vidansQuestDao;
    
    private SubtestdatabaseDaoImpl subtestdatabaseDao;
    @FXML
    private VBox vboxQuestion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    /*
        main controller initialize
     */
    public void setMainController(TestConfirmationViewController mainController) {
        this.mainController = mainController;
        initFxmlControls();
        databaseControls();
        questionControls();
        questionButtonControls();
        
    }

    /*
        Function for initialization
     */
    private void databaseControls() {

        //  Initialize dao
        normalQuestDao = new NormalquestionDaoImpl();
        nrmansDao = new NrmanquestionDaoImpl();
        audioQuestDao = new AudioquestionDaoImpl();
        audansDao = new AudansquestionDaoImpl();
        imageQuestDao = new ImagequestionDaoImpl();
        imgansDao = new ImgansquestionDaoImpl();
        videoQuestDao = new VideoquestionDaoImpl();
        vidansQuestDao = new VidansquestionDaoImpl();
        subtestdatabaseDao = new SubtestdatabaseDaoImpl();

        //  Initialize array lists
        normalQuests = FXCollections.observableArrayList();
        nrmansQuests = FXCollections.observableArrayList();
        videoQuests = FXCollections.observableArrayList();
        vidansQuests = FXCollections.observableArrayList();
        imageQuests = FXCollections.observableArrayList();
        imgansQuests = FXCollections.observableArrayList();
        audioQuests = FXCollections.observableArrayList();
        audansQuests = FXCollections.observableArrayList();
        subtests = FXCollections.observableArrayList();
        subtestDatabases = FXCollections.observableArrayList();

        //  initialize temporary current Test 
        test = this.mainController.getTest();

        //  get all data from dao
        subtests.addAll(this.mainController.getSubtest());

        //  importing from SubtestDatabase to list
        subtests.forEach((subtest) -> {
            subtestDatabases.add(subtestdatabaseDao.getSpecificOneData(subtest));
        });

        //  Gathering questions from database
        subtestDatabases.forEach((subtestDatabase) -> {
            normalQuests.addAll(normalQuestDao.getSpecificData(subtestDatabase));
        });

        //  Gathering answer from database
        normalQuests.forEach((normalQuest) -> {
            subtestDatabases.forEach((database) -> {
                nrmansQuests.addAll(nrmansDao.getSpecificData(normalQuest, database));
            });
        });

        //  Commented test
//        videoQuests.addAll(videoQuests.getSpecificData(object));
//        imageQuests.addAll(imageQuests.getSpecificData(object));
//        audioQuests.addAll(audioQuests.getSpecificData(object));
    }
    
    private void questionControls() {
        questionNode = FXCollections.observableArrayList();
        radioButtons = FXCollections.observableArrayList();
        radioButtons.add(new RadioButton(nrmansQuests.get(0).getContent()));
        radioButtons.add(new RadioButton(nrmansQuests.get(1).getContent()));
        radioButtons.add(new RadioButton(nrmansQuests.get(2).getContent()));
        radioButtons.add(new RadioButton(nrmansQuests.get(3).getContent()));
        radioButtons.add(new RadioButton(nrmansQuests.get(4).getContent()));
        
        questionNode.add(new Label(normalQuests.get(0).getContent()));
        questionNode.add(radioButtons.get(0));
        questionNode.add(radioButtons.get(1));
        questionNode.add(radioButtons.get(2));
        questionNode.add(radioButtons.get(3));
        questionNode.add(radioButtons.get(4));
        
        vboxQuestion.getChildren().addAll(questionNode);
        
    }
    
    private void questionButtonControls() {
        buttons = FXCollections.observableArrayList();
        
        int totalQuestion = 50;
//        for (int i = 0; i < subtests.size(); i++) {
//            totalQuestion += subtests.get(i).getAmount();
//        }
        int pos = 1;
        for (int i = 0; i < (totalQuestion / 5); i++) {
            for (int j = 0; j < 5; j++) {
                Button button = new Button(String.valueOf(pos));
                button.setStyle("-fx-background-color: #0068ac;\n"
                        + "    -fx-background-radius: 0px;\n"
                        + "    -fx-text-fill: white;\n"
                        + "    -fx-font-family: 'Calibri';\n"
                        + "    -fx-font-size: 18px;\n"
                        + "    -fx-font-weight: bold;");
                grpBtnSwitch.add(button, j, i);
                pos++;
                
            }
            
        }
    }
    
    private void initFxmlControls() {
        loginParticipant = this.mainController.getLoginParticipant();
        lblNameHead.setText(loginParticipant.getFirstName() + " " + loginParticipant.getLastName());
        lblNrpHead.setText(loginParticipant.getId());
    }
    
}
