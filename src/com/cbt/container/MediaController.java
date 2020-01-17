package com.cbt.container;

import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

/**
 * @author Kafka Febianto Agiharta - 1772012
 *
 * MediaController is used for controlling video and audio.
 */
public class MediaController extends HBox {

    /**
     * Block below contains each attributes of MediaController
     */
    private Button btnMediaControl = new Button();
    private StackPane paneMedia = new StackPane();
    private Slider sdrMediaControl = new Slider();
    private ProgressBar pbMediaControl = new ProgressBar(0);
    private Label lblDuration = new Label("00:00");
    private StackPane paneVolume = new StackPane();
    private Slider sdrVolumeControl = new Slider();
    private ProgressBar pbVolumeControl = new ProgressBar(0.5);
    private ImageView imgVolume = new ImageView(new Image(
            "com/cbt/view/css/images/volume.png"));

    /**
     * Block below is constructor of class
     */
    public MediaController(MediaPlayer player) {

        /**
         * Code block below for create media player control button. this button
         * controls pause and play for media player.
         */
        this.btnMediaControl.setMinSize(30, 30);
        this.btnMediaControl.setPrefSize(40, 40);
        this.btnMediaControl.setMaxSize(50, 50);
        this.btnMediaControl.setId("button-play");
        this.btnMediaControl.setOnAction((ActionEvent e) -> {
            MediaPlayer.Status sts = player.getStatus();
            if (sts == MediaPlayer.Status.PLAYING) {
                this.btnMediaControl.setId("button-play");
                player.pause();
            } else {
                this.btnMediaControl.setId("button-pause");
                player.play();
            }
        });
        getChildren().add(this.btnMediaControl);

        /**
         * Code block below for create objects that control slider and duration
         * of media player.
         */
        player.setOnPlaying(() -> {
            this.sdrMediaControl.setValue(
                    (player.getCurrentTime().toMillis() / player.
                    getTotalDuration().toMillis()) * 100);
        });
        this.sdrMediaControl.valueProperty().addListener(
                (ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
                    this.pbMediaControl.setProgress(new_val.doubleValue() / 100);
                });
        this.sdrMediaControl.valueProperty().addListener((Observable o) -> {
            if (this.sdrMediaControl.isPressed()) {
                player.seek(player.getMedia().getDuration().multiply(
                        this.sdrMediaControl.getValue() / 100));
            }
        });
        this.sdrMediaControl.setId("media-progress-bar");
        this.pbMediaControl.setMinSize(300, 15);
        this.pbMediaControl.setPrefSize(300, 15);
        this.pbMediaControl.setMaxSize(Double.MAX_VALUE, 15);
        this.sdrMediaControl.setMinSize(300, 15);
        this.sdrMediaControl.setPrefSize(300, 15);
        this.sdrMediaControl.setMaxSize(Double.MAX_VALUE, 15);
        this.paneMedia.getChildren().addAll(this.pbMediaControl,
                this.sdrMediaControl);
        HBox.setHgrow(this.paneMedia, Priority.ALWAYS);
        getChildren().add(this.paneMedia);

        /**
         * Code block below for create duration label.
         */
        this.lblDuration.setId("label-black");
        this.lblDuration.textProperty().bind(
                Bindings.createStringBinding(() -> {
                    Duration time = player.getCurrentTime();
                    return String.format("%02d:%02d",
                            (int) time.toMinutes(),
                            (int) time.toSeconds() % 60);
                },
                        player.currentTimeProperty()));
        this.lblDuration.setMaxSize(USE_PREF_SIZE, 10);
        getChildren().add(this.lblDuration);

        /**
         * Code block below for create image view.
         */
        this.imgVolume.prefHeight(40);
        this.imgVolume.prefWidth(40);
        getChildren().add(this.imgVolume);

        /**
         * Code block below for create object that controls volume.
         */
        this.sdrVolumeControl.valueProperty().addListener(
                (ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
                    this.pbVolumeControl.
                            setProgress(new_val.doubleValue() / 100);
                });
        this.sdrVolumeControl.setId("volume-progress-bar");
        this.sdrVolumeControl.valueProperty().addListener((Observable o) -> {
            if (this.sdrVolumeControl.isPressed()) {
                player.setVolume(this.sdrVolumeControl.getValue() / 100);
            }
        });
        this.pbVolumeControl.setMinSize(60, 10);
        this.pbVolumeControl.setPrefSize(60, 10);
        this.pbVolumeControl.setMaxSize(Double.MAX_VALUE, 10);
        this.sdrVolumeControl.setMinSize(60, 10);
        this.sdrVolumeControl.setPrefSize(60, 10);
        this.sdrVolumeControl.setMaxSize(Double.MAX_VALUE, 10);
        this.sdrVolumeControl.setValue(50);
        this.paneVolume.setMaxWidth(75);
        this.paneVolume.getChildren().addAll(this.pbVolumeControl,
                this.sdrVolumeControl);
        HBox.setHgrow(this.paneVolume, Priority.ALWAYS);
        getChildren().add(this.paneVolume);
        setAlignment(Pos.CENTER_LEFT);
        setSpacing(8);
        setPadding(new Insets(8));
    }

    /**
     * Getter method sections
     */
    public Button getBtnMediaControl() {
        return btnMediaControl;
    }

    public Slider getSdrMediaControl() {
        return sdrMediaControl;
    }

}
