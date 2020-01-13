package com.cbtuser.container;

import com.cbtuser.controller.MainViewController;
import com.cbtuser.entity.Answer;
import java.util.HashMap;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

/**
 * @author Kafka Febianto Agiharta - 1772012
 *
 * RadioButtonContainer is used for create radio buttons
 */
public class RadioButtonContainer extends VBox {

    /**
     * Create class objects
     */
    private ToggleGroup tg = new ToggleGroup();

    /**
     * Create list of temporary answer (5 Answer)
     */
    private ObservableList<Answer> answers = FXCollections.observableArrayList();

    /**
     * Create mapping for answers enumeration
     */
    private static final Map<Integer, String> alphaMap = new HashMap<>();

    static {
        alphaMap.put(0, "A. ");
        alphaMap.put(1, "B. ");
        alphaMap.put(2, "C. ");
        alphaMap.put(3, "D. ");
        alphaMap.put(4, "E. ");
    }

    /**
     * Default class attributes
     *
     * @iter for iteration of radio buttons
     * @questionNumber question number
     * @answerNumber answer number
     */
    private int iter = 0;
    private int questionNumber;
    private int answerNumber;

    /**
     * Block below is constructor of class
     *
     * @param answers
     * @param gridPaneNode
     * @param questionNumber
     * @param qstCon
     * @param main
     *
     * This constructor creates 5 answers for each question. Answers are added
     * into temporary list of answers. Each new RadioButton are created and set
     * the text with answers enumeration.
     */
    public RadioButtonContainer(ObservableList<Answer> answers,
            Node gridPaneNode, int questionNumber, QuestionContainer qstCon,
            MainViewController main) {

        /**
         * Set the class attributes
         */
        this.answers = answers;
        this.questionNumber = questionNumber;

        /**
         * For each answer, set the text and CSS attributes into RadioButton
         */
        this.answers.forEach((Answer ans) -> {

            /**
             * Create new RadioButton
             */
            CustomizedRadioButton rb = new CustomizedRadioButton();

            /**
             * Code block below to set the attributes into RadioButton
             */
            rb.setText(RadioButtonContainer.alphaMap.get(this.iter) + ans.
                    getContent());
            rb.setId("radiobutton-question");
            rb.setToggleGroup(this.tg);
            rb.setSelected(this.iter);

            /**
             * Code block below to set functionality of RadioButton
             */
            rb.setOnAction((ActionEvent e) -> {

                /**
                 * Set the user answer key
                 */
                qstCon.setUserAnswerKey(rb.getSelected());

                /**
                 * Parsing GridPane to VBox
                 */
                VBox vboxQst = (VBox) gridPaneNode;

                /**
                 * Parsing VBox to Button
                 */
                Button btnQst = (Button) vboxQst.getChildren().get(0);

                /**
                 * Code block below for changing the CSS if Button is clicked
                 */
                switch (btnQst.getId()) {

                    /**
                     * If Button is Blue -> Change into green
                     */
                    case "button-blue":
                        btnQst.setId("button-green");
                        main.getBoxNumberChange().setId("box-container-green");
                        main.getBoxLayout1Change().setId("box-container-green");
                        main.getBoxLayout2Change().setId("box-container-green");
                        main.getVboxQuestion().setId("box-border-green");
                        break;

                    /**
                     * If Button is green -> Change into green
                     */
                    case "button-green":
                        btnQst.setId("button-green");
                        main.getBoxNumberChange().setId("box-container-green");
                        main.getBoxLayout1Change().setId("box-container-green");
                        main.getBoxLayout2Change().setId("box-container-green");
                        main.getVboxQuestion().setId("box-border-green");
                        break;

                    /**
                     * If Button is yellow -> Change into green
                     */
                    case "button-yellow":
                        btnQst.setId("button-yellow");
                        main.getBoxNumberChange().setId("box-container-yellow");
                        main.getBoxLayout1Change().setId("box-container-yellow");
                        main.getBoxLayout2Change().setId("box-container-yellow");
                        main.getVboxQuestion().setId("box-border-yellow");
                    default:
                        break;
                }
            });

            /**
             * Add radio button to class
             */
            getChildren().add(rb);

            /**
             * Get the next iteration
             */
            this.iter++;
        });

        /**
         * Set the question answer
         */
        for (int i = 0; i < answers.size(); i++) {
            if (answers.get(i).getTrueAnswer() == 1) {
                this.answerNumber = i;
                break;
            }
        }

        /**
         * Set the class properties
         */
        setId("vbox-radiobutton");
    }

    /**
     * Getter method section
     */
    public int getQuestionNumber() {
        return questionNumber;
    }

    public int getAnswerNumber() {
        return answerNumber;
    }

}
