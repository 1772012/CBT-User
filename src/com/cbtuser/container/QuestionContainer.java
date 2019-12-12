package com.cbtuser.container;

import com.cbtuser.controller.MainViewController;
import com.cbtuser.dao.AnswerDaoImpl;
import com.cbtuser.entity.Answer;
import com.cbtuser.entity.Question;
import java.io.File;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author Kafka Febianto Agiharta - 1772012
 */
public class QuestionContainer extends VBox {

    //  Static class fields
    private static int ITER = 0;

    //  Default class fields
    private int userAnswerKey = -1;
    private boolean checked = false;

    //  Variable class fields
    private ObservableList<Answer> answers = FXCollections.observableArrayList();
    private Question question = new Question();
    private AnswerDaoImpl answerDao = new AnswerDaoImpl();
    private Label lblContent = new Label();
    private int questionNumber;
    private int answerKey;
    private Text txt = new Text();

    //  Constructor
    public QuestionContainer(MainViewController main, Question question) {
        //  Set ID number of QuestionContainer
        this.questionNumber = QuestionContainer.ITER;

        //  Set question
        this.question = question;

        //  Switch media
        switch (this.question.getMediacontent().getMedia().getId()) {
            //  Video media player
            case 1:
                VideoPlayer vp = new VideoPlayer(new File(this.question
                        .getMediacontent().getMediaAddress()).toURI()
                        .toString());
                //  Check for caption
                if (this.question.getMediacontent().getCaption() != null) {
                    Label lblCaption = new Label();
                    lblCaption.setId("label-question");
                    lblCaption.setText(this.question.getMediacontent().
                            getCaption());
                    getChildren().add(lblCaption);
                }
                getChildren().add(vp);
                break;
            //  Audio media player
            case 2:
                AudioPlayer ap = new AudioPlayer(
                        this.question.getMediacontent().getMediaAddress());
                //  Check for caption
                if (this.question.getMediacontent().getCaption() != null) {
                    Label lblCaption = new Label();
                    lblCaption.setId("label-question");
                    lblCaption.setText(this.question.getMediacontent().
                            getCaption());
                    getChildren().add(lblCaption);
                }
                getChildren().add(ap);
                break;
            //  Image media
            case 3:
                MediaImageContainer imageContainer = new MediaImageContainer(
                        this.question.getMediacontent().getMediaAddress()
                );
                //  Check for caption
                if (this.question.getMediacontent().getCaption() != null) {
                    Label lblCaption = new Label();
                    lblCaption.setId("label-question");
                    lblCaption.setText(this.question.getMediacontent().
                            getCaption());
                    getChildren().add(lblCaption);
                }
                getChildren().add(imageContainer);
                break;
            case 4:
                if (this.question.getMediacontent().getCaption() != null) {
                    Text txtCaption = new Text();
                    txtCaption.setText(this.question.getMediacontent().
                            getCaption().replace("\\n", "\n"));
                    Label lblCaption = new Label();
                    lblCaption.setWrapText(true);
                    lblCaption.setText(txtCaption.getText());
                    lblCaption.setTextAlignment(TextAlignment.JUSTIFY);
                    lblCaption.setId("label-border");
                    getChildren().add(lblCaption);
                }
            default:
                break;
        }

        //  Set content text
        this.txt.setText(this.question.getContent().replace("\\n", "\n"));
        this.lblContent.setText(txt.getText());
        this.lblContent.setWrapText(true);
        this.lblContent.setTextAlignment(TextAlignment.JUSTIFY);
        this.lblContent.setId("label-black");
        getChildren().add(this.lblContent);

        //  Get answers from question
        this.answers.addAll(this.answerDao.getSpecificData(this.question));

        //  Create radio button of each answer
        RadioButtonContainer rbc = new RadioButtonContainer(this.answers,
                getCellFromGridPane(main.getGpQuestions(),
                        (QuestionContainer.ITER % 5),
                        (QuestionContainer.ITER / 5)),
                this.questionNumber, this, main);
        getChildren().add(rbc);

        //  Get answer number from radio button
        this.answerKey = rbc.getAnswerNumber();

        //  Iteration for question number
        QuestionContainer.ITER++;

        //  Set class style
        setId("box-container");
    }

    //  Usable function for getting navigation button of question
    private Node getCellFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(
                    node) == row) {
                return node;
            }
        }
        return null;
    }

    //  Getter method
    public int getQuestionNumber() {
        return questionNumber;
    }

    public int getUserAnswerKey() {
        return userAnswerKey;
    }

    public int getAnswerKey() {
        return answerKey;
    }

    public void setUserAnswerKey(int userAnswerKey) {
        this.userAnswerKey = userAnswerKey;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

}
