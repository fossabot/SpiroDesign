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
	 * spurGearとpinionGearの座標
	 */
	private Point2D.Double center;

	/**
	 * spurGearとpinionGearの半径
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
	 * spurGearとpinionGearの座標を返す
	 * @return
	 */
	public Point2D.Double center() {
		return this.center;
	}

	/**
	* spurGearとpinionGearの座標を更新する
	* @param x　更新する座標のx座標
	* @param y　更新する座標のy座標
	*/
	public void center(Double x, Double y) {
		this.center = new Point2D.Double(x,y);
		return;
	}

	/**
	 * spurGearとpinionGearの半径を返す
	 * @return
	 */
	public Double radius() {
		return this.radius;
	}

	/**
	 * spurGearとpinionGearの半径を返す
	 * @param r　更新する半径
	 */
	public void radius(Double r) {
		this.radius = r;
		return;
	}

}
