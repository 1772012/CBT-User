package com.cbtuser.container;

import java.io.File;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

/**
 *
 * @author Kafka Febianto Agiharta - 1772012
 */
public class AudioPlayer extends HBox {

    //  Initialization of objects
    private Button btnPlay = new Button();
    private Slider sdrDuration = new Slider();
    private Slider sdrVolume = new Slider();
    private ImageView volImage = new ImageView(new Image(
            "com/cbtuser/view/css/images/volume.png"));
    private MediaPlayer audio;
    private Media media;
    private Label lblDuration = new Label("00:00");

    //  Constructor
    public AudioPlayer(String file) {

        //  Set Media
        this.media = new Media(new File(file).toURI().toString());

        //  Set MediaPlayer
        this.audio = new MediaPlayer(this.media);
        this.audio.setVolume(0.5);
        this.audio.setOnPlaying(() -> {
            this.sdrDuration.setValue((this.audio.
                    getCurrentTime().toMillis() / this.audio.getTotalDuration().
                            toMillis()) * 100);
        });
        this.audio.currentTimeProperty().addListener(((Observable o) -> {
            updatesValues();
        }));

        //  Set play Button
        btnPlay.setPrefWidth(40);
        this.btnPlay.setId("button-play");
        this.btnPlay.setOnAction((ActionEvent e) -> {
            MediaPlayer.Status sts = this.audio.getStatus();
            if (sts == MediaPlayer.Status.PLAYING) {
                this.btnPlay.setId("button-play");
                this.audio.pause();
            } else {
                this.btnPlay.setId("button-pause");
                this.audio.play();
            }
        });

        //  Set duration Slider
        this.sdrDuration.setId("media-progress-bar");
        this.sdrDuration.valueProperty().addListener((Observable o) -> {
            if (this.sdrDuration.isPressed()) {
                this.audio.seek(this.audio.getMedia().getDuration().multiply(
                        this.sdrDuration.getValue() / 100));
            }
        });
        HBox.setHgrow(this.sdrDuration, Priority.ALWAYS);

        // Set duration Label
        this.lblDuration.setId("label-black");
        this.lblDuration.textProperty().bind(
                Bindings.createStringBinding(() -> {
                    Duration time = this.audio.getCurrentTime();
                    return String.format("%02d:%02d",
                            (int) time.toMinutes(),
                            (int) time.toSeconds() % 60);
                },
                        this.audio.currentTimeProperty()));

        //  Set volume ImageView
        this.volImage.prefHeight(40);
        this.volImage.prefWidth(40);

        //  Set volume Slider
        this.sdrVolume.setPrefWidth(60);
        this.sdrVolume.setValue(50);
        this.sdrVolume.setId("volume-progress-bar");
        this.sdrVolume.valueProperty().addListener((Observable o) -> {
            if (this.sdrVolume.isPressed()) {
                this.audio.setVolume(this.sdrVolume.getValue() / 100);
            }
        });

        //  Set class attributes
        setId("mediabar-controller");
        setPrefWidth(400);
        setMaxWidth(400);
        setAlignment(Pos.CENTER_LEFT);

        //  Add objects into class
        getChildren().add(this.btnPlay);
        getChildren().add(this.sdrDuration);
        getChildren().add(this.lblDuration);
        getChildren().add(this.volImage);
        getChildren().add(this.sdrVolume);
    }

    //  Function to update Media values
    protected void updatesValues() {
        Platform.runLater(() -> {
            this.sdrDuration.setValue(
                    ((this.audio.getCurrentTime().toMillis() / this.audio.
                    getTotalDuration().toMillis()) * 100));
        });
    }

    //  Getter / Setter
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
