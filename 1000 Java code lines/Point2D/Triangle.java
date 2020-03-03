/**
* Triangle is subclass of Shape
* @author Viet Nguyen
* @since 08-25-2019
*/
public class Triangle extends Shape{
	
	private Point2D[] triArr;
	private double base;
	private double height;
	private Point2D p1;
	private Point2D p2;
	private Point2D p3;
	
	/**
	* Constructor of the triangle class takes 3 points
	* @param int vertex
	* @param Point2D p1
	* @param Point2D p2
	* @param Point2D p3
	*/
	public Triangle(int vertex, Point2D p1, Point2D p2, Point2D p3){		
		this.triArr = new Point2D[vertex];
		this.triArr[0] = p1;
		this.triArr[1] = p2;
		this.triArr[2] = p3;
	}
	
	/**
	* The is the get method that overrides the getVertex method from the Shape class
    * will return vertex from the array named triArr at number index
	* @return Point2D triArr[index]
	*/
	@Override 
	public Point2D getVertex(int index){
		return triArr[index];
	}
	
	/**
	* This is the Set method that overrides setVertex method of the Shape class 
	* which will assign new value to each vertex of the triangle 
	* @param int index
	* @param double x
	* @param double y
	*/
	@Override
	public void setVertex(int index, double x, double y){
		triArr[index].setX(x);
		triArr[index].setY(y);
	}
	
	/**
	* This is the area method that will calculate the area of the trianlge based on its base and height
	* @return double area = base*height/2
	*/
	@Override
	public double area(){
		double area;
		//condition 1
		if (this.triArr[0].getY() == this.triArr[1].getY()){
			base = this.triArr[0].distance(this.triArr[1]);
			height = Math.abs(this.triArr[0].getY()-this.triArr[2].getY());
			area = base*height/2;
		}else {
			//condition 2
			base = this.triArr[0].distance(this.triArr[2]);
			height = Math.abs(this.triArr[0].getY()-this.triArr[1].getY());
			area = base*height/2;
		}
		return area;
	}
	
	/** 
	* This is the perimeter method that will calculate the perimeter of the trianlge based on its three sides a,b and c.
	* @return double perimeter = a + b + c;
	*/
	@Override
	public double perimeter(){
		double perimeter = 0;
		double a = this.triArr[0].distance(this.triArr[1]);
		double b = this.triArr[1].distance(this.triArr[2]);
		double c = this.triArr[2].distance(this.triArr[0]);
		perimeter = a + b + c;
		return perimeter;
	}
	
	/**
	* Provide a String representation of this triangle. 
	*/
	@Override
	public String toString(){
		return String.format("The triangle");
	}
}