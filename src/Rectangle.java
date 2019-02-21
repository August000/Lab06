
public class Rectangle extends Polygon{

	double height;
	double width;
	
	public Rectangle(String id, double height, double width) {
		this.height = height;
		this.width = width;
	}
	
	public double getArea(){
		return height*width;
	}
	
	public String getShape() {
		return "Rectangle";
	}
	
}
