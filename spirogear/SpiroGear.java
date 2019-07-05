import MVC.mvc.Model;
import MVC.mvc.Controller;
import MVC.mvc.View;
import Cons.cons.Cons;
import Cons.cons.Symbol;
import java.awt.Rectangle;
import java.util.Hashtable;
import java.awt.Point;
import java.awt.geom.Point2D;

public class SpiroGear extends Object {

	private Point2D.Double center;

	private Double radius;

	public SpiroGear() {
		//System.out.println("test");
	}

	public SpiroGear(Double x, Double y) {
	}

	public SpiroGear(Double x, Double y, Double r) {

	}

	 //public SpiroGear(Double p, Double r) {

	 //}

	public SpiroGear(Double r) {

	}

	public Double bottom() {
		return null;
	}

	public Rectangle bottomRectangle() {
		return null;
	}

	public Point2D.Double center() {
		return this.center;
	}

	public void center(Point2D.Double x, Double y) {
		this.center = x;
		this.radius = y;
	}

	public Rectangle centerRectangle() {
		return null;
	}

	public Double circumference() {
		return null;
	}

	// public Hashtable<Symbol,Object> fromList(Cons aList) {
	// 	return null;
	// }

	public Double left() {
		return null;
	}

	public Rectangle leftRectangle() {
		return null;
	}

	public Double radius() {
		return this.radius;
	}

	public void radius(Double r) {
		this.radius = this.radius+r;
		if(this.radius<50){
			this.radius=50.0;
		}
		System.out.println(radius);
	}

	public Double right() {
		return null;
	}

	public Rectangle rightRectangle() {
		return null;
	}

	public Double rotate(Double point, Double degrees) {
		return null;
	}

	public Double rotate(Double point, Double degrees, Double around) {
		return null;
	}

	public Double top() {
		return null;
	}

	public Rectangle topRectangle() {
		return null;
	}

	public Rectangle toRectangle(Double aPoint, Double expandedAmount) {
		return null;
	}

	// public Cons toList() {
	// 	return null;
	// }

	public String toString() {
		return null;
	}

}
