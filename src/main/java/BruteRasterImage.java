import image.*;
import javafx.scene.paint.Color;

public class BruteRasterImage implements Image {
    public Color[][] pixels;
    public int width;
    public int height;

    /******************** CONSTRUCTORS *******************************/
    public BruteRasterImage(Color color, int width, int height){

    }
    public BruteRasterImage(Color[][] colors){

    }

    /************** GETTERS *************************************************/

    @Override
    public Color getPixelColor(int x, int y) {
        return null;
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }
    /************** SETTERS *************************************************/
    public void setPixelColor(Color color, int x, int y){

    }
    public Color getPixelColor(int x, int y){

    }

    private void setPixelsColor(Color[][] pixels){

    }
    private void setPixelsColor(Color color){

    }
    protected void setWidth(int width){

    }
    protected void setHeight(int height){

    }
    /************** OTHER METHODS *************************************************/
    public void createRepresentation(){

    }
}
