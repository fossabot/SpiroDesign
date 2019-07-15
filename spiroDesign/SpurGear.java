package spiroDesign;

import MVC.mvc.Model;
import MVC.mvc.Controller;
import MVC.mvc.View;
import Cons.cons.Cons;
import java.awt.Point;
import java.awt.geom.Point2D;

public class SpurGear extends SpiroGear {

	/**
	 * 
	 * @return
	 */
	public SpurGear() {
		super();
		Point2D.Double spurFirstPoint = new Point2D.Double(400,240);
		this.initialize(spurFirstPoint,100.0);
		return;
	}
}
