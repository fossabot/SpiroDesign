import MVC.mvc.Model;
import MVC.mvc.Controller;
import MVC.mvc.View;
import Cons.cons.Cons;
import java.awt.Point;
import java.awt.Color;
import Cons.cons.Symbol;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.JColorChooser;
import javax.swing.JComponent;
import java.awt.geom.Point2D;

public class SpiroModel extends Model implements Runnable {

	private SpurGear spurGear;

	private PinionGear pinionGear;

	private boolean isInscribe;

	public boolean isRainbow;

	private DesignLocus designLocus;

	private boolean isAnimated;

	private int tickTime;

	private Double pinionDegrees;

	private ArrayList<DesignLocus> designLoci;

	private SpiroIO spiroIO;

	private SpiroGear spiroGear;

	public Color spiroColor;

	private Thread thread;

	public SpiroModel() {
		super();
		this.spiroGear = new SpiroGear();
		this.spurGear = new SpurGear();
		this.pinionGear = new PinionGear();
		this.isAnimated = false;
		this.tickTime = 500;
		this.thread = new Thread(this);
		this.isRainbow = false;
		this.spiroColor = new Color(0,0,0);
		// this.spiroGear = new SpiroGear();
}

		/**
	 * 指定されたビューを依存物に設定する。
	 * @param aView このモデルの依存物となるビュー
	 */
	public void addDependent(View aView)
	{
		this.dependents.add(aView);
		return;
	}

	public DesignLocus designLocus() {
		return null;
	}

	public ArrayList<DesignLocus> designLoci() {
		return null;
	}

	public PinionGear firstPinionGear() {
		return null;
	}

	public void flush() {

	}

	public boolean isAnimated() {
		return false;
	}

	public boolean isCircumscribe() {
		return false;
	}

	public boolean isEditable() {
		return false;
	}

	public boolean isInscribe() {
		return false;
	}

	public boolean isRainbow() {
		return false;
	}

	public boolean isStopped() {
		return false;
	}

	public PinionGear lastPinionGear() {
		return null;
	}

	public SpiroModel open() {
		return null;
	}

	public SpiroModel open(SpiroModel aModel) {
		return null;
	}

	public void perform() {

	}

	public void pinionCenter(Point aPoint) {

	}

	public Double pinionDegrees(double spurDegrees) {
		return null;
	}

	public PinionGear pinionGear() {
		return null;
	}

	public void pinionPen(Point aPoint) {

	}

	public void pinionRadius(Point aPoint) {

	}

	public void run() {

		this.isAnimated = true;

		while(isAnimated){
				try
				{

						Thread.sleep(tickTime);
						if(isRainbow = true){
							spiroRainbow();
						}

				}
				catch (InterruptedException anException)
				{
						System.err.println(anException);
						throw new RuntimeException(anException.toString());
				}
				super.changed();
		}
		return;
}

	public void spiroClear() {

	}

	public void spiroCircumscribe(View aView) {

	}

	public void spiroColor(View aView) {
		Color color = JColorChooser.showDialog(aView, "color picker", Color.white);

		if(color != null){
			isRainbow = false;
			spiroColor = color;
		}
		return;
	}

	public void spiroDive(View aView) {

	}

	public void spiroInscribe(View aView) {

	}

	public SpiroModel spiroNew() {
		return null;
	}

	public void spiroNib(View aView) {

	}

	public void spiroOpen(View aView) {

	}

	public void spiroRainbow() {
		int r = spiroColor.getRed();
		int g = spiroColor.getGreen();
		int b = spiroColor.getBlue();
		if(r == 255 && g >= 0 && g < 255 && b == 0){ spiroColor = new Color(r, g+1, b); }
		else if(r > 0 && r <= 255 && g == 255 && b == 0){ spiroColor = new Color(r-1, g, b); }
		else if(r == 0 && g == 255 && b >= 0 && b < 255){ spiroColor = new Color(r, g, b+1); }
		else if(r == 0 && g <= 255 && g > 0 && b == 255){ spiroColor = new Color(r, g-1, b); }
		else if(r >= 0 && r < 255 && g == 0 && b == 255){ spiroColor = new Color(r+1, g, b); }
		else if(r == 255 && g == 0 && b <= 255 && b > 0){ spiroColor = new Color(r, g, b-1); }

		return;
	}

	public void spiroSave(View aView) {

	}

	public void spiroSpeedDown() {
		tickTime += 100;
		return;

	}

	public void spiroSpeedUp() {
		if(tickTime > 100) tickTime -= 100;
		return;
	}

	public void spiroStart() {
		thread.start();
		return;
}

public void spiroStop() {
		this.isAnimated = false;
		this.thread = new Thread(this);
		return;
}

	public void spurCenter(Point aPoint) {
		Double x = Double.valueOf(aPoint.x);
		Double y = Double.valueOf(aPoint.y);
		//this.spiroGear.center(x,y);
		this.spurRadius(aPoint);
		return;
	}

	public Double spurDegrees(double pinionDegrees) {
		return null;
	}

	public SpurGear spurGear() {
		return null;
	}

	public void spurRadius(Point aPoint) {
		double x = (double)aPoint.x;
		this.spurGear.radius(x);
		return;
	}

	public Point2D.Double spurSendCenter() {
		Point2D.Double center = this.spurGear.center();
		return center;
	}

	public Double spurSendRadius() {
		Double radius = this.spurGear.radius();
		return radius;
	}

	public Point2D.Double pinionSendCenter() {
		Point2D.Double center = this.pinionGear.center();
		return center;
	}

	public Double pinionSendRadius() {
		Double radius = this.pinionGear.radius();
		return radius;
	}

	public Point2D.Double sendpenPosition(){
		Point2D.Double penPosition = this.pinionGear.penPosition();
		return penPosition;
	}

	public String toString() {
		return null;
	}

	public void underConstruction() {

	}

	public void underConstruction(View aView) {

	}

	public void warn(View aView, String aString) {

	}

}
