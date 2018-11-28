
// REMEMBER  x => columns AND y => ROWS

import image.Image;
import javafx.scene.paint.Color;

import java.util.List;

public class PaletteRasterImage implements Image {

    private int width;
    private int height;
    private List<Color> palette;
    private int[][] indexesOfColors;


    /************** CONSTRUCTOR *************************************************/
    public PaletteRasterImage(Color color, int width, int height){
        this.height = height;
        this.width = width;
        palette.set(0, color);
        // all pixel have to have this index.
        for(int column=0; column < width ; column++){
            for (int row=0; row < height; row++){
                indexesOfColors[column][row] = 0;
            } // end for row
        }// enf for column
    }

    public PaletteRasterImage(Color[][] pixels){


    }

    /************** METHODS *************************************************/
    @Override
    public Color getPixelColor(int x, int y) {
        //het the index of the color in [x][y]:
        int index = indexesOfColors[x][y];
        return palette.get(index);
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }
}
