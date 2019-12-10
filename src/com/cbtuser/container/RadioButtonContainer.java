package com.cbtuser.container;

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
 *
 * @author Kafka Febianto Agiharta - 1772012
 */
public class RadioButtonContainer extends VBox {

    //  Create ToggleGroup for RadioButton
    private ToggleGroup tg = new ToggleGroup();

    //  Create current Question Answers (Max 5 Answers)
    private ObservableList<Answer> answers = FXCollections.observableArrayList();

    //  Create mapping for answers enumeration
    private static final Map<Integer, String> alphaMap = new HashMap<>();

    //
    static {
        alphaMap.put(0, "A. ");
        alphaMap.put(1, "B. ");
        alphaMap.put(2, "C. ");
        alphaMap.put(3, "D. ");
        alphaMap.put(4, "E. ");
    }

    //  Iteration for looping
    private int iter = 0;

    //  Question number
    private int questionNumber;

    //  Answer number
    private int answerNumber;

    //  Main class constructor
    public RadioButtonContainer(ObservableList<Answer> answers,
            Node gridPaneNode, int questionNumber, QuestionContainer qstCon) {

        setId("vbox-radiobutton");

        /*  This constructor creates 5 answers for each question.
            Answers are added into temporary list of answers.
            Each new RadioButton are created and set the text
            with answers enumeration.*/
        //
        //  Set the list of answers into this class
        this.answers = answers;

        //  Create integer for this question number
        this.questionNumber = questionNumber;

        //  For each answer, set the text and css attributes into RadioButton
        this.answers.forEach((Answer ans) -> {

            //  Create new RadioButton
            CustomizedRadioButton rb = new CustomizedRadioButton();

            // Set the attributes into RadioButton
            rb.setText(RadioButtonContainer.alphaMap.get(this.iter) + ans.
                    getContent());
            rb.setId("radiobutton-question");
            rb.setToggleGroup(this.tg);
            rb.setSelected(this.iter);

            // Set functionality of RadioButton
            rb.setOnAction((ActionEvent e) -> {

                qstCon.setUserAnswer(rb.getSelected());

                //  Parsing GridPane to VBox
                VBox vboxQst = (VBox) gridPaneNode;

                //  Parsing VBox to Button
                Button btnQst = (Button) vboxQst.getChildren().get(0);

                //  Change the CSS if Button is clicked
                switch (btnQst.getId()) {

                    //  If Button is Blue -> Change into green
                    case "button-blue":
                        btnQst.setId("button-green");
                        break;

                    //  If Button is green -> Change into green
                    case "button-green":
                        btnQst.setId("button-green");
                        break;

                    //  If Button is yellow -> Change into yellow
                    case "button-yellow":
                        btnQst.setId("button-yellow");

                    //  If Button is Blue, do nothing
                    default:
                        break;
                }
            });

            //  Add each RadioButton to VBox
            getChildren().add(rb);

            //  Get the next iteration
            this.iter++;
        });

        //  Set the question answer
        for (int i = 0; i < answers.size(); i++) {
            if (answers.get(i).getTrueAnswer() == 1) {
                this.answerNumber = i;
                break;
            }
        }

    }

    //  Create getter method
    public int getQuestionNumber() {
        return questionNumber;
    }

    public int getAnswerNumber() {
        return answerNumber;
    }

}
