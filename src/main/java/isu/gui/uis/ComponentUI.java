package isu.gui.uis;

import java.awt.*;

public abstract class ComponentUI {

    protected int x;
    protected int y;
    protected int width;
    protected int height;
    boolean isSelected;
    boolean isEnabled;

    public ComponentUI(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public abstract void paintComponent(Graphics g);

    public boolean isOverlapping(int x, int y){

        if(x < this.x || x > (this.x + width))return false;
        if(y < this.y || y > (this.y + height))return false;
        return true;
    }



}
