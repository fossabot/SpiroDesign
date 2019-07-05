import MVC.mvc.Model;
import MVC.mvc.Controller;
import MVC.mvc.View;
// import javafx.beans.binding.BooleanBinding;
import Cons.cons.Cons;
import java.awt.Point;
import java.awt.Color;
import Cons.cons.Symbol;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.JColorChooser;
import javax.swing.JComponent;


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

	private Color spiroColor;

	private Thread thread;

	public SpiroModel() {
		super();
		this.isAnimated = false;
		this.tickTime = 500;
		this.thread = new Thread();
		this.isRainbow = false;
		this.spiroColor = Color.black;
		// this.spiroGear = new SpiroGear();
}

	public void SpiroModel(Cons aList) {

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

		/**
	 * 初期化する。
	 */
	private void initialize()
	{
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

	public Hashtable<Symbol,Object> fromList(Cons aList) {
		return null;
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
		spiroColor = new Color(spiroColor.getRed()+1, spiroColor.getGreen()+1, spiroColor.getBlue()+1);
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
}

public void spiroStop() {
		this.isAnimated = false;
}

	public void spurCenter(Point aPoint) {

	}

	public Double spurDegrees(double pinionDegrees) {
		return null;
	}

	public SpurGear spurGear() {
		return null;
	}

	public void spurRadius(Point aPoint) {

	}

	public Cons toList() {
		return null;
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
