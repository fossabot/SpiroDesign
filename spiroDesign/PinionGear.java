package spiroDesign;

import MVC.mvc.Model;
import MVC.mvc.Controller;
import MVC.mvc.View;
import Cons.cons.Cons;
import java.awt.Color;
import Cons.cons.Symbol;
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
		Point2D.Double firstPoint = new Point2D.Double(700,150);
		this.center(firstPoint,25.0);
	}

	// public PinionGear(Cons aList) {
	//
	// }

	
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
		return null;
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

	public Cons toList() {
		return null;
	}

}
