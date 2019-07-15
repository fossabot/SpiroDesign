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

	/**
	 * 
	 */
	private Point2D.Double center;

	/**
	 * 
	 */
	private Double radius;

	/**
	 * 
	 */
	public SpiroGear() {

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
		//System.out.println(radius);
		return;
	}

}
