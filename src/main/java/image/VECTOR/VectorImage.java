package image.VECTOR;

import image.Point;
import javafx.scene.paint.Color;
import java.util.List;
import image.Image;
import image.Shape;

public class VectorImage implements Image {
    private List<Shape> shapes;
    private int width;
    private int height;

    /******************** CONSTRUCTORS *******************************/
    public VectorImage(List<Shape> shapes, int width, int height){
        this.shapes = shapes;
        this.width = width;
        this.height = height;
    }

    /************** GETTERS *************************************************/
    @Override
    public Color getPixelColor(int x, int y) {
        Point myPoint = new Point(x,y);
        for (Shape myShape : shapes){
            if (myShape.contains(myPoint)){
                return myShape.getColor();
            }
        }
        return Color.WHITE; //if point not in a shape ==> his color is white.
    }
    @Override
    public int getWidth() { return this.width; }
    @Override
    public int getHeight() { return this.height; }

    /************** SETTERS *************************************************/
    protected void setWidth(int width){this.width = width;}
    protected void setHeight(int height){this.height = height;}

}
