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

	public void mouseClicked(MouseEvent aMouseEvent) {
		super.mouseClicked(aMouseEvent);
		return;
	}

	public void mouseDragged(MouseEvent aMouseEvent) {
		Cursor aCursor = Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR);
		Component aComponent = (Component)aMouseEvent.getSource();
		aComponent.setCursor(aCursor);
		this.current = aMouseEvent.getPoint();
		Integer x = this.current.x - this.previous.x;
		Integer y = this.current.y - this.previous.y;
		Point aPoint = new Point(x, y);
		SpiroModel SpiroModel = new SpiroModel();
		SpiroModel.spurCenter(aPoint);
		this.previous = this.current;
		return;
		// Cursor aCursor = Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR);
		// Component aComponent = (Component)aMouseEvent.getSource();
		// aComponent.setCursor(aCursor);
		// Point aPoint = aMouseEvent.getPoint();
		// System.out.println(aPoint);
	}

	public void mouseMoved(MouseEvent aMouseEvent) {

	}

	public void mousePressed(MouseEvent aMouseEvent) {

	}

	public void mouseReleased(MouseEvent aMouseEvent) {

	}

	public void showPopupMenu(MouseEvent aMouseEvent) {

	}

	public String toString() {
		return null;
	}

	private void whichPickingArea(Point aPoint) {

	}

}
