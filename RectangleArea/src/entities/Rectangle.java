package entities;

public class Rectangle {
	public double widht;
	public double height;
	
	public double area() {
		return widht * height;
	}
	
	public double perimeter() {
		return 2 * widht + 2 * height;
	}
	
	public double diagonal() {
		return Math.sqrt(Math.pow(widht, 2) + Math.pow(height, 2));
	}

}
