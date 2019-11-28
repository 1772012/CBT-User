package com.cbtuser.container;

import javafx.scene.control.RadioButton;

/**
 *
 * @author Redwolfer
 */
public class CustomizedRadioButton extends RadioButton {

    private int selected = -1;

    public CustomizedRadioButton() {
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }

}
