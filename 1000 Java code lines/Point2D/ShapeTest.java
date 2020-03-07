/**
* HW 1: A class that tests all public methods of Triangle class and Rectangle class
* CS 2120 Dr. Summa
* @author	Viet Nguyen
* @version 	August 25th, 2019
*/
import static org.junit.Assert.*;
import org.junit.*;

public class ShapeTest{
	
	Point2D[] p;
	Rectangle rectangle;
	Triangle triangle;
	
	@Test
	public void ConstructorRectangleTest(){
		for(int i= 0; i<5; i++){
			Point2D[] p = new Point2D[4];
			p[0] = new Point2D(1.0*i,1.0*i);
			p[1] = new Point2D(5*i,1*i);
			p[2] = new Point2D(5*i,4*i);
			p[3] = new Point2D(1*i,4*i);
		assertEquals(1.0*i,p[0].getX(),0.01);
		assertEquals(1.0*i,p[0].getY(),0.01);
        assertEquals(5*i,p[1].getX(),0.01);
        assertEquals(1*i,p[1].getY(),0.01);
        assertEquals(5*i,p[2].getX(),0.01);
        assertEquals(4*i,p[2].getY(),0.01);
        assertEquals(1*i,p[3].getX(),0.01);
        assertEquals(4*i,p[3].getY(),0.01);}
	}
	
	@Test
	public void constructorTriangleTest(){
		Point2D[] p1 = new Point2D[3];
			p1[0] = new Point2D(3,3);
			p1[1] = new Point2D(6,3);
			p1[2] = new Point2D(4,8);
		assertEquals(3,p1[0].getX(),0.01);
		assertEquals(3,p1[0].getY(),0.01);
        assertEquals(6,p1[1].getX(),0.01);
        assertEquals(3,p1[1].getY(),0.01);
        assertEquals(4,p1[2].getX(),0.01);
        assertEquals(8,p1[2].getY(),0.01);
	}
	
	@Test
	public void getVertexRectangleTest(){
		Point2D[] p = new Point2D[4];
			p[0] = new Point2D(1.0,1.0);
			p[1] = new Point2D(5,1);
			p[2] = new Point2D(5,4);
			p[3] = new Point2D(1,4);
		rectangle = new Rectangle(4, p[0], p[1], p[2], p[3]);
		assertEquals(p[0],rectangle.getVertex(0));
		assertEquals(p[1],rectangle.getVertex(1));
		assertEquals(p[2],rectangle.getVertex(2));
		assertEquals(p[3],rectangle.getVertex(3));
		
		}
	
	@Test
	public void getVertexTriangleTest(){
		Point2D[] p1 = new Point2D[3];
			p1[0] = new Point2D(3,3);
			p1[1] = new Point2D(6,3);
			p1[2] = new Point2D(4,8);
		triangle = new Triangle(3, p1[0], p1[1], p1[2]);
		assertEquals(p1[0],triangle.getVertex(0));
		assertEquals(p1[1],triangle.getVertex(1));
		assertEquals(p1[2],triangle.getVertex(2));
	}
	
	@Test
	public void setVertexRectangleTest(){
		Point2D[] p = new Point2D[8];
			p[0] = new Point2D(1.0,1.0);
			p[1] = new Point2D(5,1);
			p[2] = new Point2D(5,4);
			p[3] = new Point2D(1,4);
			p[4] = new Point2D(4,8);
			p[5] = new Point2D(7,9);
		rectangle = new Rectangle(4, p[0], p[1], p[2], p[3]);
		rectangle.setVertex(0,4,8);
		rectangle.setVertex(1,7,9);
		assertEquals(p[4],rectangle.getVertex(0));
		assertEquals(p[5],rectangle.getVertex(1));
	}
	
	@Test
	public void setVertexTriangleTest(){
		Point2D[] p1 = new Point2D[5];
			p1[0] = new Point2D(3,3);
			p1[1] = new Point2D(6,3);
			p1[2] = new Point2D(4,8);
			p1[3] = new Point2D(4,8);
			p1[4] = new Point2D(7,9);
		triangle = new Triangle(3, p1[0], p1[1], p1[2]);
		triangle.setVertex(0,4,8);
		triangle.setVertex(1,7,9);
		assertEquals(p1[3],triangle.getVertex(0));
		assertEquals(p1[4],triangle.getVertex(1));
	}
	
	@Test
	public void areaRectangleTest(){
		Point2D[] p = new Point2D[4];
			p[0] = new Point2D(1.0,1.0);
			p[1] = new Point2D(5,1);
			p[2] = new Point2D(5,4);
			p[3] = new Point2D(1,4);
		rectangle = new Rectangle(4, p[0], p[1], p[2], p[3]);
		double length = 4;
		double width = 3;
		double area = 12;
		assertEquals(4,p[0].distance(p[1]),0.01);
		assertEquals(3,p[0].distance(p[3]),0.01);
		assertEquals(12,p[0].distance(p[1])*p[0].distance(p[3]),0.01);
	}
	
	@Test
	public void areaTriangleForConditionOneTest(){
		Point2D[] p1 = new Point2D[3];
			p1[0] = new Point2D(3,3);
			p1[1] = new Point2D(6,3);
			p1[2] = new Point2D(4,8);
		triangle = new Triangle(3, p1[0], p1[1], p1[2]);
		double base = 3;
		double height = 5;
		double area = 7.5;
		assertEquals(3,p1[0].distance(p1[1]),0.01);
		assertEquals(5,Math.abs(p1[0].getY()-p1[2].getY()),0.01);
		assertEquals(7.5,p1[0].distance(p1[1])*Math.abs(p1[0].getY()-p1[2].getY())/2,0.01);
	}
	
	@Test
	public void areaTriangleForConditionTwoTest(){
		Point2D[] p1 = new Point2D[3];
			p1[0] = new Point2D(3,3);
			p1[1] = new Point2D(4,8);
			p1[2] = new Point2D(6,3);
		triangle = new Triangle(3, p1[0], p1[1], p1[2]);
		double base = 3;
		double height = 5;
		double area = 7.5;
		assertEquals(3,p1[0].distance(p1[2]),0.01);
		assertEquals(5,Math.abs(p1[0].getY()-p1[1].getY()),0.01);
		assertEquals(7.5,p1[0].distance(p1[2])*Math.abs(p1[0].getY()-p1[1].getY())/2,0.01);
	}
	
	@Test
	public void perimeterRectangleTest(){
		Point2D[] p = new Point2D[4];
			p[0] = new Point2D(1.0,1.0);
			p[1] = new Point2D(5,1);
			p[2] = new Point2D(5,4);
			p[3] = new Point2D(1,4);
		rectangle = new Rectangle(4, p[0], p[1], p[2], p[3]);
		double length = 4;
		double width = 3;
		double perimeter = 14;
		assertEquals(4,p[0].distance(p[1]),0.01);
		assertEquals(3,p[0].distance(p[3]),0.01);
		assertEquals(14,(p[0].distance(p[1])+p[0].distance(p[3]))*2,0.01);
	}
	
	@Test
	public void perimeterTriangleTest(){
		Point2D[] p1 = new Point2D[3];
			p1[0] = new Point2D(3,3);
			p1[1] = new Point2D(6,3);
			p1[2] = new Point2D(2,6);
		triangle = new Triangle(3, p1[0], p1[1], p1[2]);
		double a = 3;
		double b = 5;
		double c = Math.sqrt(10);
		double perimeter = a+b+c;
		assertEquals(3,p1[0].distance(p1[1]),0.01);
		assertEquals(5,p1[1].distance(p1[2]),0.01);
		assertEquals(Math.sqrt(10),p1[2].distance(p1[0]),0.01);
		assertEquals(3+5+Math.sqrt(10),p1[0].distance(p1[1])+p1[1].distance(p1[2])+p1[2].distance(p1[0]),0.01);
	}
	
}
