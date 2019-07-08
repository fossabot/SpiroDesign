<<<<<<< HEAD:spiroDesign/PinionGear.java
package spiroDesign;

import MVC.mvc.Model;
import MVC.mvc.Controller;
import MVC.mvc.View;
import Cons.cons.Cons;
import java.awt.Color;
import Cons.cons.Symbol;
=======
import spirogear.MVC.mvc.Model;
import spirogear.MVC.mvc.Controller;
import spirogear.MVC.mvc.View;
import java.awt.Color;
>>>>>>> fb0df58abbc56e609afbd7b9363cccd9d39489ed:spirogear/PinionGear.java
import java.awt.Rectangle;
import java.util.Hashtable;
import java.awt.geom.Point2D;

public class PinionGear extends SpiroGear {

	private Point2D.Double penPosition;

	private Color penColor;

	private int penNib;

	private Double degrees;

	public PinionGear() {
		super();
<<<<<<< HEAD:spiroDesign/PinionGear.java
		// Point2D.Double firstPoint = new Point2D.Double(700,150);
		this.center(425.0,240.0);
		this.radius(25.0);
		this.degrees = 0.0;
=======
		Point2D.Double firstPoint = new Point2D.Double(700,150);
		this.penPosition = new Point2D.Double(590, 340);
		this.center(firstPoint,25.0);
>>>>>>> fb0df58abbc56e609afbd7b9363cccd9d39489ed:spirogear/PinionGear.java
	}

	// public PinionGear(Cons aList) {
	//
	// }
<<<<<<< HEAD:spiroDesign/PinionGear.java

=======
>>>>>>> fb0df58abbc56e609afbd7b9363cccd9d39489ed:spirogear/PinionGear.java

	public PinionGear(Double p, Double r, Double uv) {

	}

	public PinionGear(Double p, Double r, Double uv, Color c, int n) {

	}

	public PinionGear(Double p, Double r, Double uv, Color c, int n, Double d) {

	}

	public Double bottom() {
		return null;
	}

	public Double degrees() {
		degrees -= 1;
		return degrees;
	}

	// public Hashtable<Symbol,Object> fromList(Cons aList) {
	// 	return null;
	// }

	public Double left() {
		return null;
	}

	public Color penColor() {
		return null;
	}

	public void penColor(Color aColor) {

	}

	public int penNib() {
		return 0;
	}

	public void penNib(int anlnteger) {

	}

	public Point2D.Double penPosition() {
		return this.penPosition;
	}

	public void penPosition(Double x, Double y) {

	}

	public Rectangle penRectangle() {
		return null;
	}

	public Double right() {
		return null;
	}

	public Double top() {
		return null;
	}

}
