package image.SPARSE;

import javafx.scene.paint.Color;
import java.util.HashMap;
import image.Point;
import image.RASTERimage.RasterImage;

public class SparseRasterImage extends RasterImage{
    private HashMap<Point,Color> dictionary ;

    /******************** CONSTRUCTORS *******************************/
    public SparseRasterImage(Color color, int width, int height) {
        super(color, width, height);
    }

    public SparseRasterImage(Color[][] colors) {
        super(colors);
    }

    /************** GETTERS *************************************************/
    @Override
    public Color getPixelColor(int x, int y) {
        Point myPoint = new Point(x,y);
        return dictionary.getOrDefault(myPoint,Color.WHITE);
    }

    /************** SETTERS *************************************************/
    @Override
    public void setPixelColor(Color color, int x, int y) {
        Point myPoint = new Point(x,y);
        dictionary.put(myPoint,color);
    }

    /************** OTHER METHODS *************************************************/
    @Override
    public void createRepresentation() {
       this.dictionary = new HashMap<Point,Color>();
    }
}
