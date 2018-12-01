package sparse;

import image.Point;
import javafx.scene.paint.Color;
import raster.RasterImage;

import java.util.HashMap;

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
        return dictionary.get(myPoint);
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
