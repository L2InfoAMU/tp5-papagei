// REMEMBER  x => columns AND y => ROWS
//test tp a domicile
import image.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

import static util.Matrices.*;

public class PaletteRasterImage implements Image {

    private int width;
    private int height;
    private List<Color> palette;
    private int[][] indexesOfColors;


    /************** CONSTRUCTOR *************************************************/
    public PaletteRasterImage(Color color, int width, int height){
        this.height = height;
        this.width = width;
        createRepresentation();
        setPixelsColor(color);
    }

    public PaletteRasterImage(Color[][] pixels){
        //Check for possible error cases
        requiresNonNull(pixels);
        requiresNonZeroDimensions(pixels);
        requiresRectangularMatrix(pixels);
        //set les attributs de this.
        this.width = getColumnCount(pixels);
        this.height = getRowCount(pixels);
        createRepresentation();
        setPixelsColor(pixels);
    }
    /************** GETTERS *************************************************/
    @Override
    public Color getPixelColor(int x, int y) {
        //het the index of the color in [x][y]:
        int index = indexesOfColors[x][y];
        return palette.get(index);
    }

    @Override
    public int getWidth() { return this.width; }

    @Override
    public int getHeight() { return this.height; }
    /************** SETTERS *************************************************/
    /**
     * change the color of 1 pixel in : (x,y) position.
     * @param color
     * @param x
     * @param y
     */
    public void setPixelColor(Color color, int x, int y){
        if (palette.indexOf(color) == -1){ // if color not in the palette
            palette.add(color);//add it in our palette.
        }
        int index = palette.indexOf(color);
        indexesOfColors[x][y] = index;
    }

    /**
     * Set all the pixel's image to be as the new matrice(pixels) is coded
     * @param pixels
     */
    public void setPixelsColor(Color[][] pixels){
        for(int column=0; column < width ; column++){
            for (int row=0; row < height; row++){
                Color new_color = pixels[column][row];
                setPixelColor(new_color, column, row);// set the new byte in indexesOfColors[x][y]
            } // end for row
        }// enf for column
    }

    /**
     * Set all pixel to be of the same color
     * @param color
     */
    private void setPixelsColor(Color color){
        if (palette.indexOf(color) == -1){ // if color not in the palette
            palette.add(color);//add it in our palette.
        }
        int index = palette.indexOf(color);
        for(int column=0; column < width ; column++){
            for (int row=0; row < height; row++){
                indexesOfColors[column][row] = index;
            } // end for => row
        }// enf for => column
    }

    protected void setWidth(int width){ this.width = width; }

    protected void setHeight(int height){ this.height = height; }

    /************** METHODS *************************************************/
    public void createRepresentation(){
        this.palette = new ArrayList<>();
        indexesOfColors = new int[width][height];
    }

}
