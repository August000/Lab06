import org.junit.Assert;
import org.junit.Test;

/**
 * Lab 6
 *
 * Test class for shapes and their comparators.
 *
 * @author Stephen
 * @version 2019-02-18
 */
public class ShapeTest
{
	//==================================================================================================================
	// Basic Shape Testing:
	//==================================================================================================================
    /**
     * Tests for the square class.
     */
	@Test
	public void SquareTest()
	{
		Shape sqr = new Square("Square1", 3.0);
		Assert.assertEquals("Square area incorrect.", 9.0, sqr.getArea(), 0.0001);
		Assert.assertEquals("Square perimeter incorrect.", 12.0, sqr.getPerimeter(), 0.0001);
		Assert.assertEquals("Square type incorrect.", "Square", sqr.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Square1", sqr.getId());
	}

	/**
     * Tests for the rectangle class.
     */
	@Test
	public void RectangleTest()
	{
		Shape rect = new Rectangle("K", 4.0, 1.0);
		Assert.assertEquals("K", rect.getId());
		Assert.assertEquals("Rectangle area incorrect.", 4.0, rect.getArea(), 0.0001);
		Assert.assertEquals("Rectangle perimeter incorrect.", 10.0, rect.getPerimeter(), 0.0001);
		Assert.assertEquals("Rectangle", rect.getShapeType());
	}

	/**
     * Tests for the EquilateralTriangle class.
     */
	@Test
	public void TriangleTest()
	{
		Shape trig = new EquilateralTriangle("A", 4.0);
		Assert.assertEquals("A", trig.getId());
		Assert.assertEquals("Triangle area incorrect.", 6.928203230275509, trig.getArea(), 0.0001);
		Assert.assertEquals("Triangle perimeter incorrect.", 12.0, trig.getPerimeter(), 0.0001);
		Assert.assertEquals("EquilateralTriangle", trig.getShapeType());
	}

	/**
     * Tests for the trapezoid class. Also test that IDs are done correctly.
     */
	@Test
	public void TrapezoidTest()
	{
		Shape trap = new Trapezoid("T", 3.0, 3.0,2.0,5.0);
		Assert.assertEquals("T", trap.getId());
		Assert.assertEquals("Triangle area incorrect.", 9.093266739736606, trap.getArea(), 0.0001);
		Assert.assertEquals("Triangle perimeter incorrect.", 13.0, trap.getPerimeter(), 0.0001);
		Assert.assertEquals("Trapezoid", trap.getShapeType());
	}

	/**
     * Tests for the ellipse class. Also test that IDs are done correctly.
     */
	@Test
	public void EllipseTest()
	{
		Shape circ = new Ellipse("Ellipse1", 3.0, 3.0);
		Assert.assertEquals("Ellipse area incorrect.", Math.PI*3.0*3.0, circ.getArea(),0.0001);
		Assert.assertEquals("Ellipse perimeter incorrect.",
				2 * Math.PI * Math.sqrt((Math.pow(3, 2) + Math.pow(3, 2)) / 2),
				circ.getPerimeter(),0.0001);
		Assert.assertEquals("Ellipse type incorrect.", "Ellipse",circ.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Ellipse1", circ.getId());

		Shape circs = new Ellipse("Ellipse2", 5.0, 3.0);
		Assert.assertEquals("Ellipse area incorrect.", Math.PI*3*5, circs.getArea(),0.0001);
		Assert.assertEquals("Ellipse perimeter incorrect.",
				2 * Math.PI * Math.sqrt((Math.pow(5.0, 2) + Math.pow(3.0, 2)) / 2),
				circs.getPerimeter(),0.0001);
		Assert.assertEquals("Ellipse type incorrect.", "Ellipse",circs.getShapeType());
		Assert.assertEquals("Shape ID incorrect.", "Ellipse2", circs.getId());
	}

	/**
     * Tests for the circle class. Also test that IDs are done correctly.
     */
	@Test
	public void CircleTest()
	{
		Shape circ = new Circle("C", 5.0);
		
		Assert.assertEquals("C", circ.getId());
		Assert.assertEquals("TriaCieclengle area incorrect.", Math.PI*5*5, circ.getArea(), 0.0001);
		Assert.assertEquals("Circle perimeter incorrect.", 2*Math.PI*5, circ.getPerimeter(), 0.0001);
		Assert.assertEquals("Circle", circ.getShapeType());
	}

	/**
	 * Tests for Shape's toString().
	 */
	@Test
	public void ShapeToStringTest()
	{
		Shape rect = new Rectangle("A", 4.0, 1.0);
		Shape circ = new Ellipse("B", 3.0, 3.0);
	
		Assert.assertEquals("Rectangle:\t ID = A\t area = 4.000\t perimeter = 10.000", rect.toString());
		Assert.assertEquals("Ellipse:\t ID = B\t area = 28.274\t perimeter = 18.850", circ.toString());
	}

	//==================================================================================================================
	// Comparisons:
	//==================================================================================================================
	/**
     * Tests for the Shape Area Comparator class.
     */
	@Test
	public void CompareAreaTest()
	{
	    // Test equals:
		Shape rect = new Rectangle("R1", 3.0,3.0);
		Shape sqr = new Square("S1", 3.0);
		ShapeAreaComparator sc = new ShapeAreaComparator();
		Assert.assertEquals("ShapeAreaComparator should find shapes equal.", 0, sc.compare(rect, sqr));
		Assert.assertTrue("ShapeAreaComparator should find shapes equal.", sc.equals(rect, sqr));

		// Test equal perimeter, different area:
        Shape rect2 = new Rectangle("R2", 1.0, 9.0);
        Shape sqr2 = new Square("S2", 5.0);
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", -1, sc.compare(rect2, sqr2));
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", 1, sc.compare(sqr2, rect2));
        Assert.assertFalse("ShapeAreaComparator incorrectly finds shapes equal.", sc.equals(rect2, sqr2));

        // Test unequal perimeter and area:
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", 1, sc.compare(sqr2, rect));
        Assert.assertEquals("ShapeAreaComparator gave incorrect ordering.", -1, sc.compare(rect, sqr2));
        Assert.assertFalse("ShapeAreaComparator incorrectly finds shapes equal.", sc.equals(sqr2, rect));
	}

	/**
     * Tests for the Shape Perimter Comparator class.
     */
	@Test
	public void ComparePerimeterTest()
	{
		ShapeSorter sorter = new ShapeSorter();
		sorter.sortShapes(new ShapePerimeterComparator());
		
		Shape rect = new Rectangle("A", 1.0, 2.0);
		Shape square = new Square("B", 2.0);
		
		Assert.assertEquals("CompareTo is incorrect.", 1, square.compareTo(rect), 0.0001);
	}

	/**
	 * Tests the natural ordering of shapes (compareTo in shape)
	 */
	@Test
    public void NaturalCompareTest()
    {
		Shape rect = new Rectangle("A", 1.5, 2.0);
		Shape square = new Square("B", 2.0);
		
		Assert.assertEquals("CompareTo is incorrect.", 1 , square.compareTo(rect), 0.0001);
		
    }
}
