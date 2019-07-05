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

public class SpiroController extends Controller implements ActionListener {

	private int pickingArea;

		/**
	 * 情報を握っているModelのインスタンスを束縛する。
	 */
	protected Model model;

	/**
	 * 表示を司るViewのインスタンスを束縛する。
	 */
	protected View view;

	protected SpiroView sview;

	protected SpiroModel smodel;

	public SpiroController() {
		super();
		this.model = null;
		this.view = null;
		this.sview = null;
		this.smodel = null;
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

		// 右クリックが行われた際、その座標を獲得してその位置にメニューを表示するようViewに依頼する。
		if (aMouseEvent.getButton() == MouseEvent.BUTTON3){
			this.sview.isMenuPopuping = true;
			this.sview.MenuMouseEvent = aMouseEvent;
			this.sview.showPopupMenu();
			return;	
			}
	}

	public void mouseDragged(MouseEvent aMouseEvent) {

	}

	public void mouseMoved(MouseEvent aMouseEvent) {

	}

	public void mousePressed(MouseEvent aMouseEvent) {

	}

	public void mouseReleased(MouseEvent aMouseEvent) {

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

	}

}
