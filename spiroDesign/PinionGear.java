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

/**
 * ピニオンギア周りの制御を行う
 */
public class PinionGear extends SpiroGear {

	/**
	 * 
	 */
	private Point2D.Double penPosition;

	/**
	 * ペンの色
	 */
	private Color penColor;

	/**
	 * ペンの太さ
	 */
	private int penNib;

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
	 * 現在の色を返す
	 * @return
	 */
	public Color penColor() {
		return this.penColor;
	}

	/**
	 * 色を変更する
	 * @param aColor 変える色
	 */
	public void penColor(Color aColor) {
		this.penColor = aColor;
		return;
	}

	/**
	 * ペンの太さを返す
	 * @return
	 */
	public int penNib() {
		return this.penNib;
	}

	/**
	 * ペンの太さを変更する
	 * @param anlnteger ペンの変化量
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
