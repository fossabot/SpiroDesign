package spiroDesign;

import MVC.mvc.Model;
import MVC.mvc.Controller;
import MVC.mvc.View;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.event.MouseInputAdapter;
import java.awt.geom.Point2D;

public class SpiroController extends Controller implements ActionListener {

	private int pickingArea;

		/**/
	 //* 情報を握っているModelのインスタンスを束縛する。
	 //*/
	protected Model model;

	/**
	 * 表示を司るViewのインスタンスを束縛する。
	 */
	protected View view;

	/**
	 * 情報を握っているModelのインスタンスを束縛する。
	 */
	protected SpiroModel smodel;

	private Point spiroprevious = new Point(0,0);

	private Point spirocurrent = new Point(0,0);

	/**
	 * 表示を司るViewのインスタンスを束縛する。
	 */
	protected SpiroView sview;

	public SpiroController() {
		super();
		this.model = null;
		this.view = null;
		this.sview = null;
		this.smodel = new SpiroModel();
		this.spiroprevious = new Point(0,0);
		this.spirocurrent = new Point(0,0);
		return;
	}

	public void actionPerformed(ActionEvent anActionEvent) {

	}

	public Point convertViewPointToModelPoint(Point aPoint) {
		return null;
	}

	/**
	 * 右クリックが行われた際、その座標を獲得してその位置にメニューを表示するようViewに依頼する。
	 * @param aMouseEvent
	 */
	public void mouseClicked(MouseEvent aMouseEvent) {
		int btn = aMouseEvent.getButton();

		if (btn == MouseEvent.BUTTON1){
			Point aPoint = aMouseEvent.getPoint();
			System.out.println("左クリック");
      System.out.println(aPoint);
    }

		// 右クリックが行われた際、その座標を獲得してその位置にメニューを表示するようViewに依頼する。
		if (btn == MouseEvent.BUTTON3){
			this.sview.MenuMouseEvent = aMouseEvent;
			this.sview.showPopupMenu();
			return;
			}
	}

	public void mouseDragged(MouseEvent aMouseEvent) {
		Cursor aCursor = Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR);
		Component aComponent = (Component)aMouseEvent.getSource();
		aComponent.setCursor(aCursor);
		System.out.println("d");
		this.spiroprevious = this.spirocurrent;
		this.spirocurrent = aMouseEvent.getPoint();
		this.whichPickingArea(this.spirocurrent);
		Integer x = this.spirocurrent.x - this.spiroprevious.x;
		Integer y = this.spirocurrent.y - this.spiroprevious.y;
		Point aPoint = new Point(x, y);
		this.scrollBy(aPoint, aMouseEvent);
		this.spiroprevious = this.spirocurrent;
		return;
	}

	public void mouseMoved(MouseEvent aMouseEvent) {

	}

	public void mousePressed(MouseEvent aMouseEvent) {
		System.out.println("p");
		this.spiroprevious = this.spirocurrent;
	}

	public void mouseReleased(MouseEvent aMouseEvent) {
		// Cursor aCursor = Cursor.getDefaultCursor();
		// Component aComponent = (Component)aMouseEvent.getSource();
		// aComponent.setCursor(aCursor);
		// this.spirocurrent = aMouseEvent.getPoint();
		// this.spiroprevious = this.spirocurrent;
		// return;
	}



	/**
	 * 指定されたモデルをインスタンス変数modelに設定する。
	 * @param aModel このコントローラのモデル
	 */
	public void setModel(SpiroModel aModel)
	{
		this.smodel = aModel;
		return;
	}

		/**
	 * 指定されたビューをインスタンス変数viewに設定し、
	 * ビューのマウスのリスナおよびモーションリスナそしてホイールリスナをこのコントローラにする。
	 * @param aView このコントローラのビュー
	 */
	public void setView(SpiroView aView)
	{
		this.sview = aView;
		this.sview.addMouseListener(this);
		this.sview.addMouseMotionListener(this);
		this.sview.addMouseWheelListener(this);
		return;
	}


	public String toString() {
		StringBuffer aBuffer = new StringBuffer();
		Class<?> aClass = this.getClass();
		aBuffer.append(aClass.getName());
		aBuffer.append("[model=");
		aBuffer.append(this.smodel);
		aBuffer.append(",view=");
		aBuffer.append(this.sview);
		aBuffer.append("]");
		return aBuffer.toString();	}

	private void whichPickingArea(Point aPoint) {
		Point2D.Double spurCenter = this.smodel.spurGetCenter();
		Double spurRadius = this.smodel.spurGetRadius();
		Point2D.Double pinionCenter = this.smodel.pinionGetCenter();
		Double pinionRadius = this.smodel.pinionGetRadius();
		Point2D.Double penPosition = this.smodel.penGetPosition();
		Integer x = this.spirocurrent.x - this.spiroprevious.x;
		Integer y = this.spirocurrent.y - this.spiroprevious.y;
		Point movePoint = new Point(x,y);
		System.out.println(pinionCenter.x);
		if((spurCenter.x+5>=aPoint.x)&&(spurCenter.x-5<=aPoint.x)&&(spurCenter.y+spurRadius+5>=aPoint.y)&&(spurCenter.y+spurRadius-5<=aPoint.y)){
			this.smodel.spurRadius(movePoint);
		}else if((spurCenter.x+spurRadius+5>=aPoint.x)&&(spurCenter.x+spurRadius-5<=aPoint.x)&&(spurCenter.y+spurRadius+5>=aPoint.y)&&(spurCenter.y+spurRadius-5<=aPoint.y)){
			this.smodel.spurPosition(movePoint);
		}else if((pinionCenter.x+pinionRadius+5>=aPoint.x)&&(pinionCenter.x+pinionRadius-5<=aPoint.x)&&(pinionCenter.y+pinionRadius*2.0+5>=aPoint.y)&&(pinionCenter.y+pinionRadius*2.0-5<=aPoint.y)){
			this.smodel.pinionFirstCenter(movePoint);
		}else if((penPosition.x+5>=aPoint.x)&&(penPosition.x-5<=aPoint.x)&&(penPosition.y+5>=aPoint.y)&&(penPosition.y-5<=aPoint.y)){
			this.smodel.pinionFirstPen(movePoint.x, movePoint.y);
		}
		return;
	}

}
