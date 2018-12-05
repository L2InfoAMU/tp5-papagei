package image.RASTERimage;


import javafx.scene.paint.Color;
import static util.Matrices.*;
import image.ManageImage;

public abstract class RasterImage extends ManageImage {

    /******************** CONSTRUCTORS *******************************/
    public RasterImage(Color color, int width, int height){
        setDimensions(width,height);
        createRepresentation();
        setPixelsColor(color);
    }

    public RasterImage(Color[][] colors){
        //Check for possible error cases
        checkmatrix(colors);

        width = getRowCount(colors);
        height = getColumnCount(colors);
        createRepresentation();
        setPixelsColor(colors);
    }

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
            }
        }
    }
    /**
     * Set all the pixel's image to be as the new matrix(pixels) is coded
     * @param pixels
     */
    protected void setPixelsColor(Color[][] pixels){
        for(int column=0; column < width ; column++){
            for (int row=0; row < height; row++){
                Color new_color = pixels[column][row];
                setPixelColor(new_color, column, row);
            }
        }
    }

    /************** OTHER METHODS *************************************************/
    public abstract void createRepresentation();

    protected void checkmatrix(Color[][] colors){
        requiresNonNull(colors);
        requiresNonZeroDimensions(colors);
        requiresRectangularMatrix(colors);
    }
}
