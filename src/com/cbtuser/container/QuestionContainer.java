package com.cbtuser.container;

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

/**
 *
 * @author Kafka Febianto Agiharta - 1772012
 */
public class QuestionContainer extends VBox {

    //  Number of question
    private int questionNumber;
    //  Answer number of question
    private int answerNumber;
    //  User answer of question
    private int userAnswer = -1;
    //  Label for question content
    private Label lbl;
    //  Observable list of answers
    private ObservableList<Answer> answers;
    //  New question
    private Question question = new Question();
    //  New answer DAO
    private AnswerDaoImpl answerDao;
    //

    //  Class constructor
    public QuestionContainer(
            Question question,
            int questionNumber,
            int navigationNumber,
            GridPane gpQuestions) {

        //  Set VBox CSS style
        setId("vbox-question-container");

        //  Set this attributes
        this.question = question;
        this.answers = FXCollections.observableArrayList();
        this.answerDao = new AnswerDaoImpl();
        this.questionNumber = questionNumber;

        //  Check if the question has media content
        switch (this.question.getMediacontent().getMedia().getId()) {
            //  Video media content
            case 1:
                VideoPlayer vp = new VideoPlayer(new File(this.question
                        .getMediacontent().getMediaAddress()).toURI()
                        .toString());
                getChildren().add(vp);
                break;
            //  Audio media content
            case 2:
                //  TODO FOR AUDIO QUESTION
                break;
            //  Image media content
            case 3:
                MediaImageContainer imageContainer = new MediaImageContainer(
                        this.question.getMediacontent().getMediaAddress()
                );
                getChildren().add(imageContainer);
                break;
            //  Nothing to do here...
            default:
                break;
        }

        //  Set this question content label
        this.lbl = new Label(this.question.getId());
        this.lbl.setId("label-question-view");
        this.lbl.setText(this.question.getContent());

        //  Get answers from question
        this.answers.addAll(this.answerDao.getSpecificData(this.question));

        //  Create radio button of each answer
        RadioButtonContainer rbc = new RadioButtonContainer(this.answers,
                getCellFromGridPane(gpQuestions, (navigationNumber % 5),
                        (navigationNumber / 5)),
                this.questionNumber, this);

        //  Get answer number from radio button
        this.answerNumber = rbc.getAnswerNumber();

//        this.userAnswer = rbc.getUserAnswer();
        //  Add nodes to VBox
        getChildren().add(this.lbl);
        getChildren().add(rbc);
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

    public int getAnswerNumber() {
        return answerNumber;
    }

    public int getUserAnswer() {
        return userAnswer;
    }

    public void setUserAnswer(int userAnswer) {
        this.userAnswer = userAnswer;
    }

}
