package com.cbt.container;

import javafx.scene.control.RadioButton;

/**
 * @author Kafka Febianto Agiharta - 1772012
 *
 * CustomizedRadioButton is used for create custom radio button
 */
public class CustomizedRadioButton extends RadioButton {

    /**
     * @selected set the default properties
     */
    private int selected = -1;

    /**
     * Constructor of class
     */
    public CustomizedRadioButton() {
    }

    /**
     * Getter/Setter method section
     */
    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }

}
