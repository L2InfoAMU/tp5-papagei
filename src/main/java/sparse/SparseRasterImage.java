package sparse;

import image.Point;
import javafx.scene.paint.Color;
import raster.RasterImage;

import java.util.Map;

public class SparseRasterImage extends RasterImage{

    /******************** CONSTRUCTORS *******************************/
    public SparseRasterImage(Color color, int width, int height) {
        super(color, width, height);
    }

    public SparseRasterImage(Color[][] colors) {
        super(colors);
    }

    /************** GETTERS *************************************************/


    /************** SETTERS *************************************************/

    Map<Point,Color>
    @Override
    public void setPixelColor(Color color, int x, int y) {

    }

    @Override
    public Color getPixelColor(int x, int y) {
        return null;
    }
    /************** OTHER METHODS *************************************************/

    @Override
    public void createRepresentation() {

    }
}
