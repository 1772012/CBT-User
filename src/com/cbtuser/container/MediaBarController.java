package com.cbtuser.container;

import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;

/**
 *
 * @author Redwolfer
 */
public class MediaBarController extends HBox {
    
    private Slider videoSlider = new Slider();
    private Slider volumeSlider = new Slider();
    private Button btnPlay = new Button("||");
    private Label lblVolume = new Label("Volume : ");
    private MediaPlayer player;
    
    public MediaBarController(MediaPlayer player) {
        this.player = player;
        
        setAlignment(Pos.CENTER);
        setPadding(new Insets(5, 10, 5, 10));
        
        volumeSlider.setPrefWidth(70);
        volumeSlider.setMinWidth(30);
        volumeSlider.setValue(100);
        
        videoSlider.setValue(0);
        
        HBox.setHgrow(this.videoSlider, Priority.ALWAYS);
        
        btnPlay.setPrefWidth(30);
        
        getChildren().add(btnPlay);
        getChildren().add(videoSlider);
        getChildren().add(lblVolume);
        getChildren().add(volumeSlider);
        
        btnPlay.setOnAction((ActionEvent e) -> {
            Status sts = this.player.getStatus();
            if (sts == Status.PLAYING) {
                if (this.player.getCurrentTime().greaterThanOrEqualTo(this.player.getTotalDuration())) {
                    this.player.seek(this.player.getStartTime());
                    this.player.play();
                } else {
                    this.player.pause();
                    btnPlay.setText(">");
                }
            }
            if (sts == Status.HALTED || sts == Status.STOPPED || sts == Status.PAUSED) {
                this.player.play();
                btnPlay.setText("||");
            }
        });
        
        this.player.currentTimeProperty().addListener(((Observable o) -> {
            updatesValues();
        }));
        
        videoSlider.valueProperty().addListener((Observable o) -> {
            if (videoSlider.isPressed()) {
                this.player.seek(this.player.getMedia().getDuration().multiply(videoSlider.getValue() / 100));
            }
        });
        
        volumeSlider.valueProperty().addListener((Observable o) -> {
            if (volumeSlider.isPressed()) {
                this.player.setVolume(volumeSlider.getValue() / 100);
            }
        });
    }
    
    protected void updatesValues() {
        Platform.runLater(() -> {
            videoSlider.setValue(player.getStartTime().toMillis() * 100);
        });
    }

    public Slider getVideoSlider() {
        return videoSlider;
    }
    
   
}
