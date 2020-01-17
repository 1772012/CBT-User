package com.cbt.container;

import com.cbt.MainApp;
import com.cbt.controller.MainViewController;
import com.cbt.dao.AnswerDaoImpl;
import com.cbt.entity.Answer;
import com.cbt.entity.Question;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * @author Kafka Febianto Agiharta - 1772012
 *
 * QuestionContainer is used for create container the question There are 4 type
 * of question: Video, Audio, Image, Text
 */
public class QuestionContainer extends VBox {

    /**
     * @ITER used for iteration of question numbering. It started from 0
     */
    private static int ITER = 0;

    /**
     * Default class fields
     *
     * @userAnswerKey is the default answer when the answer is not yet answered.
     * @checked is for checking the question
     */
    private int userAnswerKey = -1;
    private boolean checked = false;

    /**
     * Variable class fields
     *
     * @answers is temporary list of 5 answers each question
     * @question is temporary question object
     * @answerDao is DAO for answer
     * @questionNumber is number of this question
     * @answerKey is answer of this question
     */
    private ObservableList<Answer> answers = FXCollections.observableArrayList();
    private Question question = new Question();
    private AnswerDaoImpl answerDao = new AnswerDaoImpl();
    private int questionNumber;
    private int answerKey;

    /**
     * Object that created for question content
     */
    private Label lblContent = new Label();
    private Label lblSubtest = new Label();
    private Text txt = new Text();
    private WebView viewCaption = new WebView();
    private WebEngine engineCaption = this.viewCaption.getEngine();

    /**
     * Block below is constructor of class
     *
     * @param main
     * @param question
     */
    public QuestionContainer(MainViewController main, Question question) {
        /**
         * Block below for set the question number and question object
         */
        this.questionNumber = QuestionContainer.ITER;
        this.question = question;

        this.lblSubtest.setText(this.question.getCoursedatabase().getName());
        HBox boxSubtest = new HBox(this.lblSubtest);
        boxSubtest.setId("box-themed");
        boxSubtest.setAlignment(Pos.CENTER_LEFT);
        boxSubtest.setPadding(new Insets(8));
        getChildren().add(boxSubtest);

        /**
         * Block below is for switching media type
         */
        switch (this.question.getMediacontent().getMedia().getId()) {

            /**
             * Case 1 is for video question
             */
            case 1:
                VideoPlayerQuestion vp = new VideoPlayerQuestion(
                        this.question.getMediacontent().getMediaAddress());

                /**
                 * Code block below is for checking whether question has media
                 * content or not
                 */
                if (this.question.getMediacontent().getCaption() != null) {
                    Label lblCaption = new Label();
                    lblCaption.setId("label-question");
                    lblCaption.setText(this.question.getMediacontent().
                            getCaption());
                    getChildren().add(lblCaption);
                }
                getChildren().add(vp);
                break;

            /**
             * Case 2 is for audio question
             */
            case 2:
                AudioPlayerQuestion ap = new AudioPlayerQuestion(
                        this.question.getMediacontent().getMediaAddress());

                /**
                 * Code block below is for checking whether question has media
                 * content or not
                 */
                if (this.question.getMediacontent().getCaption() != null) {
                    Label lblCaption = new Label();
                    lblCaption.setId("label-question");
                    lblCaption.setText(this.question.getMediacontent().
                            getCaption());
                    getChildren().add(lblCaption);
                }
                getChildren().add(ap);
                break;

            /**
             * Case 3 is for image question
             */
            case 3:
                MediaImageContainer imageContainer = new MediaImageContainer(
                        this.question.getMediacontent().getMediaAddress()
                );

                /**
                 * Code block below is for checking whether question has media
                 * content or not
                 */
                if (this.question.getMediacontent().getCaption() != null) {
                    Label lblCaption = new Label();
                    lblCaption.setId("label-question");
                    lblCaption.setText(this.question.getMediacontent().
                            getCaption());
                    getChildren().add(lblCaption);
                }
                getChildren().add(imageContainer);
                break;

            /**
             * Case 4 is for text question
             */
            case 4:
                /**
                 * Code block below is for checking whether question has media
                 * content or not
                 */
                if (this.question.getMediacontent().getCaption() != null) {
                    this.engineCaption.loadContent(this.question.
                            getMediacontent().
                            getCaption());
                    this.engineCaption.setUserStyleSheetLocation(MainApp.class.
                            getResource("view/css/webViewStyle.css").
                            toString());
                    this.viewCaption.setMaxHeight(300);

                    getChildren().add(this.viewCaption);
                }
            default:
                break;
        }

        /**
         * Code block below is for set the question content
         */
        this.txt.setText(this.question.getContent());
        this.lblContent.setText(txt.getText());
        this.lblContent.setWrapText(true);
        this.lblContent.setTextAlignment(TextAlignment.JUSTIFY);
        this.lblContent.setId("label-black");
        getChildren().add(this.lblContent);

        /**
         * Code below is for fetch the question answer
         */
        this.answers.addAll(this.answerDao.getSpecificData(this.question));

        /**
         * Code block below is for create radio buttons
         */
        RadioButtonContainer rbc = new RadioButtonContainer(this.answers,
                getCellFromGridPane(main.getGpQuestions(),
                        (QuestionContainer.ITER % 5),
                        (QuestionContainer.ITER / 5)),
                this.questionNumber, this, main);
        getChildren().add(rbc);

        /**
         * Code below to get answer number from radio button
         */
        this.answerKey = rbc.getAnswerNumber();

        /**
         * Code below for iteration through question number
         */
        QuestionContainer.ITER++;

        /**
         * Code below for set the class style
         */
        setId("box-container");
    }

    /**
     * Function below for getting navigation button of question
     */
    private Node getCellFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(
                    node) == row) {
                return node;
            }
        }
        return null;
    }

    /**
     * Getter method section
     */
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
