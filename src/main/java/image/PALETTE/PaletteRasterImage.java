package image.PALETTE;  // REMEMBER  x => columns AND y => ROWS

import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.util.List;
import image.RASTERimage.RasterImage;

public class PaletteRasterImage extends RasterImage {
    private List<Color> palette;
    private int[][] indexesOfColors;


    /************** CONSTRUCTOR *************************************************/
    public PaletteRasterImage(Color color, int width, int height){
        super(color,width,height);
    }

    public PaletteRasterImage(Color[][] pixels){
        super(pixels);
    }
    /************** GETTERS *************************************************/
    @Override
    public Color getPixelColor(int x, int y) {
        int index = indexesOfColors[x][y];
        return palette.get(index);
    }

    /************** SETTERS *************************************************/
    public void setPixelColor(Color color, int x, int y){
        if (palette.indexOf(color) == -1){ // if color not in the palette
            palette.add(color);//add it in our palette.
        }
        int index = palette.indexOf(color);
        indexesOfColors[x][y] = index;
    }
    /************** METHODS *************************************************/
    public void createRepresentation(){
        this.palette = new ArrayList<>();
        indexesOfColors = new int[width][height];
    }
}
