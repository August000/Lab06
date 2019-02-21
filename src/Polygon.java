import java.util.ArrayList;

/**
 * Abstract shape class to define a polygon.
 *
 * @author Stephen
 * @version 2019-02-18
 */
public abstract class Polygon extends Shape
{
    /**
     * A list of the lengths of the sides of the polygons.
     */
    protected ArrayList<Double> sideLengths;

    /**
     * Initializes the sideLengths arraylist and sets the Shape's ID.
     *
     * @param id The created shape's name id.
     */
    public Polygon(String id)
    {
        super(id);
        sideLengths = new ArrayList<Double>();
    }

    /**
     * Calculates the perimeter of a polygon. That is, the sum of its side lengths.
     *
     * @return The perimeter of the polygon.
     */
    @Override
	public double getPerimeter()
    {
    	double perimeter = 0;
    	
    	switch(sideLengths.size()) {
    	case 1: perimeter = 4 * sideLengths.get(0);
    		break;
    	case 2: perimeter = 2*sideLengths.get(0) + 2*sideLengths.get(1);
    		break;
    	}
    return perimeter;
    }
}
