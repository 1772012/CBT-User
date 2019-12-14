package com.cbtuser.container;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Kafka Febianto Agiharta - 1772012
 */
public class MediaImageContainer extends ImageView {

    //  Create Image field
    private Image img;

    //  MediaImageContainer constructor
    public MediaImageContainer(String source) {

        //  Create new Image from source
        this.img = new Image(source);

        //  Sets the Image to ImageView
        setImage(this.img);
    }
}
