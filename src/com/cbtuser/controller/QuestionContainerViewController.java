package com.cbtuser.controller;

import com.cbtuser.MainApp;
import com.cbtuser.dao.AudansquestionDaoImpl;
import com.cbtuser.dao.AudioquestionDaoImpl;
import com.cbtuser.dao.ImagequestionDaoImpl;
import com.cbtuser.dao.ImgansquestionDaoImpl;
import com.cbtuser.dao.NormalquestionDaoImpl;
import com.cbtuser.dao.NrmanquestionDaoImpl;
import com.cbtuser.dao.VidansquestionDaoImpl;
import com.cbtuser.dao.VideoquestionDaoImpl;
import com.cbtuser.entity.Audansquestion;
import com.cbtuser.entity.Audioquestion;
import com.cbtuser.entity.Imagequestion;
import com.cbtuser.entity.Imgansquestion;
import com.cbtuser.entity.Normalquestion;
import com.cbtuser.entity.Nrmansquestion;
import com.cbtuser.entity.Participant;
import com.cbtuser.entity.Vidansquestion;
import com.cbtuser.entity.Videoquestion;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Redwolfer
 */
public class QuestionContainerViewController implements Initializable {

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
    
    private ObservableList<Button> btnList;
    
    private ObservableList<Label> lblList;
    @FXML
    private ScrollPane scpQuestion;
    @FXML
    private GridPane grpBtnSwitch;
    
    private TestConfirmationViewController mainController;
    
    private Participant loginParticipant;
    
    private NormalquestionDaoImpl normalQuestDao;
    private NrmanquestionDaoImpl nrmansDao;
    private AudioquestionDaoImpl audioQuestDao;
    private AudansquestionDaoImpl audansDao;
    private ImagequestionDaoImpl imageQuestDao;
    private ImgansquestionDaoImpl imgansDao;
    private VideoquestionDaoImpl videoQuestDao;
    private VidansquestionDaoImpl vidansQuestDao;
    
    private ObservableList<Normalquestion> normalQuests;
    private ObservableList<Nrmansquestion> nrmansQuests;
    private ObservableList<Videoquestion> videoQuests;
    private ObservableList<Vidansquestion> vidansQuests;
    private ObservableList<Imagequestion> imageQuests;
    private ObservableList<Imgansquestion> imgansQuests;
    private ObservableList<Audioquestion> audioQuests;
    private ObservableList<Audansquestion> audansQuests;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
    public void setMainController(TestConfirmationViewController mainController) {
        this.mainController = mainController;
        loginParticipant = this.mainController.getLoginParticipant();
        lblNameHead.setText(loginParticipant.getName());
        lblNrpHead.setText(loginParticipant.getId());
    }
    
    private void databaseControls() {
        
    }
    
}
