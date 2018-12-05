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
    public Color getColor() { return color;}

    /************** OTHER METHODS *************************************************/
    @Override
    public boolean contains(Point point) {
        return  isInsideRectangle(point);
    }
    private boolean Xcontained(Point point){
        return point.x >= x && point.x <= x + width;
    }
    private boolean Ycontained(Point point){
        return point.y >= y && point.y <= y + height;
    }
    private boolean isInsideRectangle(Point point){ return Xcontained(point) && Ycontained(point);}
}
