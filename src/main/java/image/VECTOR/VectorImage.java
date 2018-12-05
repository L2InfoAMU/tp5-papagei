package image.VECTOR;

import javafx.scene.paint.Color;
import java.util.List;
import image.Shape;
import image.ManageImage;
import image.Point;

public class VectorImage extends ManageImage {
    private List<Shape> shapes;

    /******************** CONSTRUCTORS *******************************/
    public VectorImage(List<Shape> shapes, int width, int height){
        setDimensions(width,height);
        this.shapes = shapes;
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
        return Color.WHITE; //if point not in a shape ==> his color is white by default.
    }
}
