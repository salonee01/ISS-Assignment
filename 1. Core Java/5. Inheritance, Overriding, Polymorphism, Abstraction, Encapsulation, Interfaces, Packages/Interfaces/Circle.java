
public class Circle implements Area {
	final double pi = 3.14;
	int radius;
	Circle(int radius){
		this.radius = radius;
	}
	@Override
	public double calculateArea() {
		return pi * radius * radius;
	}
	
	public static void main(String args[]) {
		Circle circle = new Circle(7);
		System.out.println("The area of the circle is " + circle.calculateArea());
	}

}
