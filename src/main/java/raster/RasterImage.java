package raster;

import image.Image;
import javafx.scene.paint.Color;

import static util.Matrices.*;
import static util.Matrices.getColumnCount;

public abstract class RasterImage implements Image {
    protected int width;
    protected int height;

    /******************** CONSTRUCTORS *******************************/
    public RasterImage(Color color, int width, int height){
        this.height = height;
        this.width = width;
        createRepresentation();
        setPixelsColor(color);
    }

    public RasterImage(Color[][] colors){
        //Check for possible error cases
        checkmatrice(colors);

        this.width = getRowCount(colors);
        this.height = getColumnCount(colors);
        createRepresentation();
        setPixelsColor(colors);
    }

    /************** GETTERS *************************************************/
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
    public abstract void setPixelColor(Color color, int x, int y);

    /**
     * Set all pixel to be of the same color
     * @param color
     */
    protected void setPixelsColor(Color color){
        for(int column=0; column <this.width; column++){
            for(int row=0; row<this.width; row++){
                setPixelColor(color,column,row);
            }//end column
        }//end row
    }

    /**
     * Set all the pixel's image to be as the new matrice(pixels) is coded
     * @param pixels
     */
    protected void setPixelsColor(Color[][] pixels){
        for(int column=0; column < width ; column++){
            for (int row=0; row < height; row++){
                Color new_color = pixels[column][row];
                setPixelColor(new_color, column, row);
            } // end for row
        }// enf for column
    }

    protected void setWidth(int width){ this.width = width; }

    protected void setHeight(int height){ this.height = height; }


    /************** OTHER METHODS *************************************************/
    public abstract void createRepresentation();

    protected void checkmatrice(Color[][] colors){
        requiresNonNull(colors);
        requiresNonZeroDimensions(colors);
        requiresRectangularMatrix(colors);
    }


}
