package com.cbtuser.container;

import com.cbtuser.controller.MainViewController;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;

/**
 * @author Kafka Febianto Agiharta - 1772012
 *
 * ButtonNavigationContainer is used for create buttons in navigation container
 */
public class ButtonNavigationContainer extends VBox {

    /**
     * Object that create navigation button
     */
    private Button btn = new Button();
    private int btnNumber;

    /**
     * Block below is constructor of class
     *
     * @param navigationNumber
     * @param vboxQuestion
     * @param navigationVbox
     * @param lblNavigation
     * @param prev
     * @param next
     * @param size
     * @param nav
     */
    public ButtonNavigationContainer(
            int navigationNumber,
            VBox vboxQuestion,
            ObservableList<VBox> navigationVbox,
            Label lblNavigation,
            Button prev,
            Button next,
            int size,
            MainViewController nav) {

        /**
         * Code below to set the button navigation number
         */
        this.btnNumber = navigationNumber + 1;

        /**
         * Code block below to set the button properties
         */
        this.btn.setId("button-blue");
        this.btn.setText(String.valueOf(this.btnNumber));
        this.btn.setMaxWidth(Double.MAX_VALUE);
        this.btn.setMaxHeight(Double.MAX_VALUE);

        /**
         * Code block below to set the button behavior when clicked
         */
        this.btn.setOnAction((ActionEvent e) -> {
            nav.setPreviousNav(nav.getNavigationNumber());

            /**
             * Code block below for checking whether previous question has media
             */
            navigationVbox.get(nav.getPreviousNav()).getChildren().forEach(
                    (qst) -> {

                        /**
                         * If the previous question has video media
                         */
                        if (qst instanceof VideoPlayerQuestion) {
                            VideoPlayerQuestion vp = (VideoPlayerQuestion) qst;
                            if (vp.getPlayer().getStatus() == MediaPlayer.Status.PLAYING) {
                                vp.getStatusBox().toFront();
                                vp.getPlayer().pause();
                                vp.getController().getBtnMediaControl().setId(
                                        "button-play");
                            }

                            /**
                             * If the previous question has audio media
                             */
                        } else if (qst instanceof AudioPlayerQuestion) {
                            AudioPlayerQuestion ap = (AudioPlayerQuestion) qst;
                            if (ap.getPlayer().getStatus() == MediaPlayer.Status.PLAYING) {
                                ap.getPlayer().pause();
                                ap.getBtnMediaControl().setId("button-play");
                            }
                        }
                    });

            /**
             * Code below for gather the question
             */
            QuestionContainer qst = (QuestionContainer) navigationVbox.get(
                    this.btnNumber - 1);

            /**
             * Code block below is for check the bottom navigation bar whether
             * question number reach minimum number or maximum number
             */
            nav.setNavigationNumber(this.btnNumber - 1);
            if (this.btnNumber - 1 == 0) {
                prev.setDisable(true);
                next.setDisable(false);
            } else if (this.btnNumber - 1 == size - 1) {
                next.setDisable(true);
                prev.setDisable(false);
            } else {
                prev.setDisable(false);
                next.setDisable(false);
            }

            /**
             * Code block below to set the previous question to new question
             */
            vboxQuestion.getChildren().clear();
            vboxQuestion.getChildren().add(navigationVbox.
                    get(this.btnNumber - 1));
            lblNavigation.setText(String.valueOf(this.btnNumber));

            /**
             * Code block below is for set the status of question whether is
             * answered, checked or unanswered
             */
            if (((QuestionContainer) nav.getNavigationVbox().get(
                    this.btnNumber - 1)).getUserAnswerKey() == -1) {
                if (!((QuestionContainer) nav.getNavigationVbox().get(
                        this.btnNumber - 1)).isChecked()) {
                    nav.getBoxNumberChange().setId("box-container-blue");
                    nav.getBoxLayout1Change().setId("box-container-blue");
                    nav.getBoxLayout2Change().setId("box-container-blue");
                    nav.getVboxQuestion().setId("box-border-blue");
                } else {
                    nav.getBoxNumberChange().setId("box-container-yellow");
                    nav.getBoxLayout1Change().setId("box-container-yellow");
                    nav.getBoxLayout2Change().setId("box-container-yellow");
                    nav.getVboxQuestion().setId("box-border-yellow");
                }
            } else {
                if (!((QuestionContainer) nav.getNavigationVbox().get(
                        this.btnNumber - 1)).isChecked()) {
                    nav.getBoxNumberChange().setId("box-container-green");
                    nav.getBoxLayout1Change().setId("box-container-green");
                    nav.getBoxLayout2Change().setId("box-container-green");
                    nav.getVboxQuestion().setId("box-border-green");
                } else {
                    nav.getBoxNumberChange().setId("box-container-yellow");
                    nav.getBoxLayout1Change().setId("box-container-yellow");
                    nav.getBoxLayout2Change().setId("box-container-yellow");
                    nav.getVboxQuestion().setId("box-border-yellow");
                }
            }

        });

        /**
         * Code below to set the class properties
         */
        setId("box-navigation");
        getChildren().add(this.btn);
    }
}
