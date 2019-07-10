package spiroDesign;

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
		///System.out.println("test");
		// this.center = new Point2D.Double(400.0, 240.0);
		// this.radius = 0.0;
	}

	public SpiroGear(Double x, Double y) {
	}

	public SpiroGear(Double x, Double y, Double r) {

	}

	 //public SpiroGear(Double p, Double r) {
//
	 //}

	public SpiroGear(Double r) {

	}

	/**
	 * 初期化
	 * @param firstPoint
	 * @param firstRadius
	 */
	public void initialize(Point2D.Double firstPoint, Double firstRadius) {
		this.center = firstPoint;
		this.radius = firstRadius;
	}

	public Double bottom() {
		return null;
	}

	public Rectangle bottomRectangle() {
		return null;
	}

	/**
	 * なんのセンター
	 * スパーギアのセンター
	 * @return
	 */
	public Point2D.Double center() {
		return this.center;
	}

	/**
	* スパーギアのセンター
	* @param x
	* @param y
	*/
	public void center(Double x, Double y) {
		this.center = new Point2D.Double(x,y);
		return;
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

	/**
	 * 半径を返す
	 * @return
	 */
	public Double radius() {
		return this.radius;
	}

	/**
	 * 半径を決める
	 * @param r
	 */
	public void radius(Double r) {
		this.radius = r;
		System.out.println(radius);
		return;
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
