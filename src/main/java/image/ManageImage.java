package image;

import javafx.scene.paint.Color;

public abstract class ManageImage implements Image {
    protected int width;
    protected int height;

    /************** GETTERS *************************************************/
    @Override
    public abstract Color getPixelColor(int x, int y);
    @Override
    public int getWidth() {return width;}
    @Override
    public int getHeight() {return height;}

    /************** SETTERS *************************************************/
    protected void setWidth(int width){ this.width = width; }

    protected void setHeight(int height){ this.height = height;}

    /**
     *  Set the Width and Height.
     * @param width
     * @param height
     */
    protected void setDimensions(int width,int height){
        setWidth(width);
        setHeight(height);
    }
}
