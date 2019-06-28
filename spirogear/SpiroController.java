import spirogear.MVC.mvc.Model;
import spirogear.MVC.mvc.Controller;
import spirogear.MVC.mvc.View;
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

	private boolean isMenuPopuping;

	private int pickingArea;

	public SpiroController() {
		super();
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
		// 左クリックの処理
		
  }else if (btn == MouseEvent.BUTTON3){
		Point aPoint = aMouseEvent.getPoint();
		this.showPopupMenu(aPoint, aMouseEvent);
		System.out.println("右クリック");
		System.out.println(aPoint);
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

	public void showPopupMenu(Point aPoint, MouseEvent aMouseEvent) {

		return;
	}

	public String toString() {
		return null;
	}

	private void whichPickingArea(Point aPoint) {

	}

}
