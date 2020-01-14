package com.cbtuser.container;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * @author Kafka Febianto Agiharta - 1772012
 *
 * MediaImageContainer is used for create image based question
 */
public class MediaImageContainer extends ImageView {

    /**
     * Code below for create class objects
     */
    private Image img;

    /**
     * Block below is constructor of class
     *
     * @param source
     */
    public MediaImageContainer(String source) {

        /**
         * Set the image
         */
        this.img = new Image(source);
        setImage(this.img);
        setPreserveRatio(true);
        setFitHeight(300);
        setFitHeight(300);
    }
}
