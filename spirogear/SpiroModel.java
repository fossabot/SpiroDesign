import spirogear.MVC.mvc.Model;
import spirogear.MVC.mvc.Controller;
import spirogear.MVC.mvc.View;
import spirogear.Cons.cons.Cons;
import java.awt.Point;
import spirogear.Cons.cons.Symbol;
import java.util.ArrayList;
import java.util.Hashtable;

public class SpiroModel extends Model implements Runnable {

	private SpurGear spurGear;

	private PinionGear pinionGear;

	private boolean isInscribe;

	private boolean isRainbow;

	private DesignLocus designLocus;

	private boolean isAnimated;

	private int tickTime;

	private Double pinionDegrees;

	private ArrayList<DesignLocus> designLoci;

	private SpiroIO spiroIO;

	public SpiroModel() {
		super();
	}

	public void SpiroModel(Cons aList) {

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

	}

	public void spiroClear() {

	}

	public void spiroCircumscribe(View aView) {

	}

	public void spiroColor(View aView) {

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

	public void spiroRainbow(View aView) {

	}

	public void spiroSave(View aView) {

	}

	public void spiroSpeedDown() {

	}

	public void spiroSpeedUp() {

	}

	public void spiroStart() {

	}

	public void spiroStop() {

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
