
public class Rectangle extends Polygon{

	private double height;
	private double width;
	
	public Rectangle(String id, double height, double width) {
		super(id);
		this.height = height;
		this.width = width;
		
		sideLengths.add(height);
		sideLengths.add(width);
		sideLengths.add(height);
		sideLengths.add(width);
		
	}
	public double getArea(){
		return height*width;
	}

	@Override
	public String getShapeType() {
		return "Rectangle";
	}
	
}
