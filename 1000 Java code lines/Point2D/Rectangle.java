/**
* Rectangle is subclass of Shape
* @author Viet Nguyen
* @since 08-25-2019
*/
public class Rectangle extends Shape{
	
	private Point2D[] recArr;
	private double width=0;
	private double length=0;
	private Point2D p1;
	private Point2D p2;
	private Point2D p3;
	private Point2D p4;
	
	/**
	* Constructor of the rectangle class takes 4 points
	* @param int vertex
	* @param Point2D p1
	* @param Point2D p2
	* @param Point2D p3
	* @param Point2D p4
	*/
	public Rectangle(int vertex, Point2D p1, Point2D p2, Point2D p3, Point2D p4){		
		this.recArr = new Point2D[vertex];
		this.recArr[0] = p1;
		this.recArr[1] = p2;
		this.recArr[2] = p3;
		this.recArr[3] = p4;
	}
	
	/**
	* The is the get method that overrides the getVertex method from the Shape class
    * will return vertex from the array named recArr at number index
	* @return Point2D triArr[index]
	*/
	@Override 
	public Point2D getVertex(int index){
		return recArr[index];
	}
	
	/**
	* This is the Set method that overrides setVertex method of the Shape class 
	* which will assign new value to each vertex of the rectangle 
	* @param int index
	* @param double x
	* @param double y
	*/
	@Override
	public void setVertex(int index, double x, double y){
		recArr[index].setX(x);
		recArr[index].setY(y);
	}
	
	/**
	* This is the area method that will calculate the area of the rectanlge based on width and length
	* @return double area = width * lenght;
	*/
	@Override
	public double area(){
		length = recArr[0].distance(recArr[1]);
		width = recArr[0].distance(recArr[3]);
		return width*length;	
	}
	
	/** 
	* This is the perimeter method that will calculate the perimeter of the trianlge based on width and length
	* @return double perimeter = (width + length)*2
	*/
	@Override
	public double perimeter(){
		width = recArr[0].distance(recArr[1]);
		length = recArr[0].distance(recArr[3]);
		return 2*(width+length);
	}
	
	/**
	* Provide a String representation of this rectangle. 
	*/
	@Override
	public String toString(){
		return String.format("The rectangle");
	}
}