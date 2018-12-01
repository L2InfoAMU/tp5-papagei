package image;

import javafx.scene.paint.Color;

public class Rectangle implements Shape {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;

    /******************** CONSTRUCTORS *******************************/
    public Rectangle(int x, int y, int width, int height, Color color){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }
    /************** GETTERS *************************************************/
    @Override
    public Color getColor() { return this.color;}

    /************** OTHER METHODS *************************************************/
    @Override
    public boolean contains(Point point) { //TODO demander si c'est plus opti.
        if (point.x > this.x && point.x < this.x + width){ // check first for X value
            if (point.y > this.y && point.y < this.y + height){// if X is OK then check for Y
                return true;
            }
        }
        return false;
    }
}
