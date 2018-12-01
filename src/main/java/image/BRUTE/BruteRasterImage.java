package image.BRUTE;

import javafx.scene.paint.Color;
import image.RASTERimage.RasterImage;

public class BruteRasterImage extends RasterImage {
    private Color[][] pixels;
    /******************** CONSTRUCTORS *******************************/
    public BruteRasterImage(Color color, int width, int height){
        super(color,width,height);
    }

    public BruteRasterImage(Color[][] colors){
        super(colors);
    }
    /************** GETTERS *************************************************/
    @Override
    public Color getPixelColor(int x, int y) { return pixels[x][y]; }

    /************** SETTERS *************************************************/

    public void setPixelColor(Color color, int x, int y){
        this.pixels[x][y]= color;
    }

    /************** OTHER METHODS *************************************************/
    public void createRepresentation(){
        this.pixels = new Color[this.width][this.height];
    }
}
