public class ShapeRunner{
	public static void main(String[] args){
		
		Point2D[] p = new Point2D[5];
		p[0] = new Point2D(1,1);
		p[1] = new Point2D(5,1);
		p[2] = new Point2D(5,4);
		p[3] = new Point2D(1,4);
		p[4] = new Point2D(3,3);
		Rectangle rectangle = new Rectangle(4, p[0], p[1], p[2], p[3]);
		Triangle triangle = new Triangle(3, p[0], p[1], p[4]);
		System.out.printf("The areas of the rectangle and the triangle are %.02f and %.02f", rectangle.area(), triangle.area());
	}
}