package com.cbt.container;

import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * @author Kafka Febianto Agiharta - 1772012
 *
 * AudioPlayerQuestion is used for create audio based question.
 */
public class AudioPlayerQuestion extends HBox {

    /**
     * Block below contains each attributes of AudioPlayerQuestion
     */
    private Media media;
    private MediaPlayer player;
    private MediaController controller;

    /**
     * Block below is constructor of class
     *
     * @param path
     */
    public AudioPlayerQuestion(String path) {

        /**
         * Code block below is for create audio media player
         */
        this.media = new Media(path);
        this.player = new MediaPlayer(this.media);
        this.player.setVolume(0.5);
        this.player.currentTimeProperty().addListener(((Observable o) -> {
            updatesValues();
        }));
        this.controller = new MediaController(this.player);
        HBox.setHgrow(controller, Priority.ALWAYS);
        getChildren().add(controller);

        /**
         * Code block below is for setting class attributes
         */
        setId("mediabar-controller");
        setMinSize(600, 50);
        setPrefSize(600, 55);
        setMaxSize(600, 60);
        setAlignment(Pos.CENTER_LEFT);
    }

    /**
     * Method below is for updating the media slider while audio is playing
     */
    protected void updatesValues() {
        Platform.runLater(() -> {
            this.getSdrMediaControl().setValue(
                    ((this.player.getCurrentTime().toMillis() / this.player.
                    getTotalDuration().toMillis()) * 100));
        });
    }

    /**
     * Getter method section
     */
    public MediaPlayer getPlayer() {
        return player;
    }

    public Button getBtnMediaControl() {
        return this.controller.getBtnMediaControl();
    }

    public Slider getSdrMediaControl() {
        return this.controller.getSdrMediaControl();
    }

}
