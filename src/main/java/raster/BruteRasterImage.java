package raster;

import image.*;
import javafx.scene.paint.Color;

import static util.Matrices.*;
import static util.Matrices.getRowCount;

public class BruteRasterImage implements Image {
    public Color[][] pixels;
    public int width;
    public int height;

    /******************** CONSTRUCTORS *******************************/
    public BruteRasterImage(Color color, int width, int height){
        this.height = height;
        this.width = width;
        createRepresentation();
        setPixelsColor(color);
    }
    public BruteRasterImage(Color[][] colors){
        //Check for possible error cases
        requiresNonNull(colors);
        requiresNonZeroDimensions(colors);
        requiresRectangularMatrix(colors);
        //set les attributs de this.
        this.width = getColumnCount(colors);
        this.height = getRowCount(colors);
        createRepresentation();
        setPixelsColor(colors);

    }
    /************** GETTERS *************************************************/
    @Override
    public Color getPixelColor(int x, int y) { return pixels[x][y]; }

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
        this.pixels[x][y]= color;
    }

    /**
     * Set all the pixel's image to be as the new matrice(pixels) is coded
     * @param pixels
     */
    private void setPixelsColor(Color[][] pixels){
        Color new_color;
        for(int column=0; column<width ; column++){
            for (int row=0; row<height; row++){
                new_color = pixels[column][row];
                setPixelColor(new_color, column, row);
            } // end for row
        }// enf for column
    }

    /**
     * Set all pixel to be of the same color
     * @param color
     */
    private void setPixelsColor(Color color){
        for(int column=0; column <this.width; column++){
            for(int row=0; row<this.width; row++){
                this.pixels[column][row] = color;
            }//end column
        }//end row
    }

    protected void setWidth(int width){ this.width = width; }

    protected void setHeight(int height){ this.height = height; }
    /************** OTHER METHODS *************************************************/
    public void createRepresentation(){
        this.pixels = new Color[this.width][this.height];
    }
}
