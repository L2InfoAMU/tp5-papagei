package palette;// REMEMBER  x => columns AND y => ROWS
import image.*;
import raster.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

import static util.Matrices.*;

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
        //het the index of the color in [x][y]:
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
