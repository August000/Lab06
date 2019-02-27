import java.util.Collections;

import org.junit.Assert;
import org.junit.Test;

/**
 * Lab 6
 *
 * Test class for ShapeSorter.
 * Implicitly tests that the comparators are implemented correctly.
 *
 * @author Stephen
 * @version 2019-02-18
 */
public class ShapeSorterTest
{
	/**
	 * Test that shapes are added correctly.
	 */
	@Test
	public void AddShapeTest()
	{
		ShapeSorter sorter = new ShapeSorter();

		Shape a = new Rectangle("test", 3, 3);
		Shape b = new EquilateralTriangle("test2", 4);
		Shape c = new Square("test3", 3);
		Shape d = new Circle("test4", 1.5);

		sorter.addShape(a);
        sorter.addShape(b);
        sorter.addShape(c);
        sorter.addShape(d);

		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(0), a);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(1), b);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(2), c);
		Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(3), d);
	}

	/**
	 * Tests sorting via the default ordering.
	 */
	@Test
	public void SortShapesDefaultTest()
	{
	    ShapeSorter sorter = new ShapeSorter();
	    
	    Shape a = new Rectangle("A", 4, 2);
	    Shape b = new Square("B", 3);
	    Shape c = new Rectangle("C", 1, 8);
        Shape d = new Circle("D", 1.5);
       
        //Test 1
        sorter.addShape(a);
        sorter.addShape(d);
        
        sorter.sortShapes();
        
        Assert.assertEquals("Shapes order incorrect...", sorter.shapes.get(0), d);
        Assert.assertEquals("Shapes order incorrect...", sorter.shapes.get(1), a);
        
        sorter.shapes.clear();
        
        
        //Test -1
        sorter.addShape(d);
        sorter.addShape(a);
        
        sorter.sortShapes();
        
        Assert.assertEquals("Shapes order incorrect...", sorter.shapes.get(0), d);
        Assert.assertEquals("Shapes order incorrect...", sorter.shapes.get(1), a);
        
        sorter.shapes.clear();
        
        //TestEquals Bigger
        sorter.addShape(a);
        sorter.addShape(c);
        
        sorter.sortShapes();
        
        Assert.assertEquals("Shapes order incorrect...", sorter.shapes.get(0), a);
        Assert.assertEquals("Shapes order incorrect...", sorter.shapes.get(1), c);
        
        sorter.shapes.clear();
        
        //TestEquals Smaller
        sorter.addShape(c);
        sorter.addShape(a);
        
        sorter.sortShapes();
        
        Assert.assertEquals("Shapes order incorrect...", sorter.shapes.get(0), a);
        Assert.assertEquals("Shapes order incorrect...", sorter.shapes.get(1), c);
        
        sorter.shapes.clear();
        
        //Test Same Shape 
        sorter.addShape(b);
        sorter.addShape(b);
        
        sorter.sortShapes();
        
        Assert.assertEquals("Shapes order incorrect...", sorter.shapes.get(0), b);
        Assert.assertEquals("Shapes order incorrect...", sorter.shapes.get(1), b);
        
        sorter.shapes.clear();
	}

	/**
	 * Tests sorting by area ordering.
	 */
	@Test
	public void SortShapesAreaTest()
	{
	    
	    ShapeSorter sorter = new ShapeSorter();
	    
	    Shape a = new Rectangle("A", 4, 2);
        Shape b = new Square("B", 3);
        Shape c = new Rectangle("C", 1, 8);
        Shape d = new Circle("D", 1.5);
        
        sorter.addShape(a);
        sorter.addShape(b);
        sorter.addShape(c);
        sorter.addShape(d);
        
        sorter.sortShapes(new ShapeAreaComparator());
       
        Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(0), d);
        Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(1), a);
        Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(2), c);
        Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(3), b);
       
	}

	/**
	 * Tests sorting by perimeter ordering.
	 */
	@Test
	public void SortShapesPerimeterTest()
	{
	    ShapeSorter sorter = new ShapeSorter();
       
        Shape a = new Rectangle("A", 4, 2);
        Shape b = new Square("B", 3);
        Shape c = new Rectangle("C", 1, 8);
        Shape d = new Circle("D", 1.5);
        
        sorter.addShape(a);
        sorter.addShape(b);
        sorter.addShape(c);
        sorter.addShape(d);
        
        sorter.sortShapes(new ShapePerimeterComparator());

        Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(0), d);
        Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(1), a);
        Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(2), b);
        Assert.assertEquals("Shapes added incorrectly...", sorter.shapes.get(3), c);
        
        Assert.assertEquals(true,  c.equals(c));
        Assert.assertEquals(false, b.equals(c));
        
	    
	    
	}

	/**
	 * Tests the toString.
	 */
	@Test
	public void ToStringTest()
	{
	    ShapeSorter sorter = new ShapeSorter();
	    
	    Shape a = new Rectangle("A", 4, 2);
        Shape b = new Square("B", 3);
        
        sorter.addShape(a);
        sorter.addShape(b);
        
        Assert.assertEquals(a.toString()+"\n"+b.toString()+"\n",sorter.toString());
        
      
	}
}
