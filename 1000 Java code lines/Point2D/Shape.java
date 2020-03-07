/**
* Shape is abstract class that will be extended by two subclasses: Triangle and Rectangle
* @author Viet Nguyen
* @since 08-25-2019
*/
public abstract class Shape{
	
	public abstract Point2D getVertex(int index);
	
	public abstract void setVertex(int index, double x, double y);
	
	public abstract double area();
	public abstract double perimeter();
	
	public abstract String toString();
}