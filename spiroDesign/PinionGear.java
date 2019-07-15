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

	/**
	 * 
	 */
	private Point2D.Double penPosition;

	/**
	 * 
	 */
	private Color penColor;

	/**
	 * 
	 */
	private int penNib;

	/**
	 * 
	 */
	private Double degrees;

	/**
	 * 
	 */
	public PinionGear() {
		super();
		Point2D.Double pinionFirstPoint = new Point2D.Double(700,150);
		this.initialize(pinionFirstPoint,25.0);
		this.penPosition = new Point2D.Double(590,340);
		this.degrees = 0.0;
		this.penColor = new Color(0,0,0);
		this.penNib = 10;
	}

	/**
	 * 
	 * @return
	 */
	public Double degrees() {
		degrees -= 1;
		return degrees;
	}

	/**
	 * 
	 * @return
	 */
	public Color penColor() {
		return this.penColor;
	}

	/**
	 * 
	 * @param aColor
	 */
	public void penColor(Color aColor) {
		this.penColor = aColor;
		return;
	}

	/**
	 * 
	 * @return
	 */
	public int penNib() {
		return this.penNib;
	}

	/**
	 * 
	 * @param anlnteger
	 */
	public void penNib(int anlnteger) {
		this.penNib += anlnteger;
		return;
	}

	/**
	 * 
	 * @return
	 */
	public Point2D.Double penPosition() {
		return this.penPosition;
	}

	/**
	 * 
	 * @param x
	 * @param y
	 */
	public void penPosition(Double x, Double y) {
		this.penPosition = new Point2D.Double(x,y);
	}
}
