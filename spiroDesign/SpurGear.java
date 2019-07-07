package spiroDesign;

import MVC.mvc.Model;
import MVC.mvc.Controller;
import MVC.mvc.View;
import Cons.cons.Cons;
import java.awt.Point;
import java.awt.geom.Point2D;

public class SpurGear extends SpiroGear {

	public SpurGear() {
		super();
		Point2D.Double firstPoint = new Point2D.Double(400,240);
		this.center(firstPoint,100.0);
	}

	// public SpurGear(Cons aList) {
	//
	// }

	/**
	 * 
	 * @param p
	 * @param r
	 */
	public SpurGear(Double p, Double r) {

	}

}
