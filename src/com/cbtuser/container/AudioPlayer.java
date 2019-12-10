package com.cbtuser.container;

import java.io.File;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author Kafka Febianto Agiharta - 1772012
 */
public class AudioPlayer extends HBox {

    private Button btnPlay = new Button();
    private Slider sdrDuration = new Slider();
    private Slider sdrVolume = new Slider();
    private Label lbl = new Label("Volume : ");
    private MediaPlayer audio;
    private Media media;

    public AudioPlayer(String file) {
        this.media = new Media(new File(file).toURI().toString());
        this.audio = new MediaPlayer(this.media);
        this.audio.setOnPlaying(() -> {
            this.sdrDuration.setValue((this.audio.
                    getCurrentTime().toMillis() / this.audio.getTotalDuration().
                            toMillis()) * 100);
        });
        this.btnPlay.setOnAction((ActionEvent e) -> {
            MediaPlayer.Status sts = this.audio.getStatus();
            if (sts == MediaPlayer.Status.PLAYING) {
                this.btnPlay.setText(">");
                this.audio.pause();
            } else {
                this.btnPlay.setText("||");
                this.audio.play();
            }
        });

        this.audio.currentTimeProperty().addListener(((Observable o) -> {
            updatesValues();
        }));

        this.sdrDuration.valueProperty().addListener((Observable o) -> {
            if (this.sdrDuration.isPressed()) {
                this.audio.seek(this.audio.getMedia().getDuration().multiply(
                        this.sdrDuration.getValue() / 100));
            }
        });

        this.sdrVolume.valueProperty().addListener((Observable o) -> {
            if (this.sdrVolume.isPressed()) {
                this.audio.setVolume(this.sdrVolume.getValue() / 100);
            }
        });

        setId("mediaBarController");

        getChildren().add(this.btnPlay);
        getChildren().add(this.sdrDuration);
        getChildren().add(this.lbl);
        getChildren().add(this.sdrVolume);

    }

    protected void updatesValues() {
        Platform.runLater(() -> {
            this.sdrDuration.setValue(
                    ((this.audio.getCurrentTime().toMillis() / this.audio.
                    getTotalDuration().toMillis()) * 100));
        });
    }

    public Slider getAudioSlider() {
        return this.sdrDuration;
    }

    public Button getBtnPlay() {
        return this.btnPlay;
    }

    public MediaPlayer getPlayer() {
        return this.audio;
    }

}
