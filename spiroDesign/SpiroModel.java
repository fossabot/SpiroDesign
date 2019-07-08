package spiroDesign;

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

	/**
	 * SpurGearを束縛する
	 */
	private SpurGear spurGear;

	/**
	 * PinionGearを束縛する
	 */
	private PinionGear pinionGear;

	/**
	 * 
	 */
	private boolean isInscribe;

	/**
	 * レインボーかどうか
	 */
	public boolean isRainbow;

	/**
	 * 
	 */
	private DesignLocus designLocus;

	/**
	 * 動いているか
	 */
	private boolean isAnimated;

	/**
	 * 描画間隔を制御する
	 */
	private int tickTime;

	/**
	 * ピニオンギアの角度
	 */
	private Double pinionDegrees;

	/**
	 * スパーギアの角度
	 */
	private Double spurDegrees;

	/**
	 * 
	 */
	private ArrayList<DesignLocus> designLoci;

	/**
	 * 
	 */
	private SpiroIO spiroIO;

	/**
	 * 
	 */
	private SpiroGear spiroGear;

	/**
	 * 線の色
	 */
	public Color spiroColor;

	/**
	 * スレッド
	 */
	private Thread thread;

	/**
	 * 初期化
	 */
	public SpiroModel() {
		super();
		this.spiroGear = new SpiroGear();
		this.spurGear = new SpurGear();
		this.pinionGear = new PinionGear();
		this.initialize();
	}

	/**
	 * 変数の初期化
	 */
	public void initialize(){
		this.isAnimated = false;
		this.tickTime = 500;
		this.thread = new Thread(this);
		this.isRainbow = false;
		this.isAnimated = false;
		this.spiroColor = new Color(0,0,0);
		this.spurDegrees = 0.0;
		return;
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
	 * 
	 * @return
	 */
	public DesignLocus designLocus() {
		return null;
	}

	/**
	 * 
	 * @return
	 */
	public ArrayList<DesignLocus> designLoci() {
		return null;
	}

	/**
	 * 
	 * @return
	 */
	public PinionGear firstPinionGear() {
		return null;
	}

	/**
	 * 
	 * @return
	 */
	public void flush() {

	}

	/**
	 * 
	 * @return
	 */
	public boolean isAnimated() {
		return this.isAnimated;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isCircumscribe() {
		return false;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isEditable() {
		return false;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isInscribe() {
		return false;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isRainbow() {
		return this.isRainbow;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isStopped() {
		return false;
	}

	/**
	 * 
	 * @return
	 */
	public PinionGear lastPinionGear() {
		return null;
	}

	/**
	 * 
	 * @return
	 */
	public SpiroModel open() {
		return null;
	}

	/**
	 * 
	 * @param aModel
	 * @return
	 */
	public SpiroModel open(SpiroModel aModel) {
		return null;
	}

	/**
	 * 
	 * @return
	 */
	public void perform() {

	}

	/**
	 * 
	 * @param aPoint
	 */
	public void pinionFirstCenter(Point aPoint) {
		Double x = Double.valueOf(aPoint.x);
		Double y = Double.valueOf(aPoint.y);
		this.pinionGear.center(x*2.0,x*2.0);
		this.pinionRadius(aPoint);
		this.pinionFirstPen(x,y);
		return;
	}

	/**
	 * 
	 * @param x
	 * @param y
	 */
	public void pinionCenter(double x, double y) {
		Double px = Double.valueOf(x);
		Double py = Double.valueOf(y);
		this.pinionGear.center2(x,y);
		return;
	}

	/**
	 * スパーギアとピニオンギアの中心を結んだ線の角度
	 * @param spurDegrees
	 * @return
	 */
	public Double pinionDegrees(double spurDegrees) {
		pinionDegrees = this.pinionGear.degrees();
		return pinionDegrees;
	}

	/**
	 * ピニオンギアを返す
	 * @return
	 */
	public PinionGear pinionGear() {
		return this.pinionGear;
	}

	/**
	 * 
	 * @param x
	 * @param y
	 */
	public void pinionFirstPen(Double x, Double y) {
		Point2D.Double pen = this.pinionGetCenter();
		this.pinionGear.penPosition(pen.x+x, pen.y+y);
		return;
	}

	/**
	 * 
	 * @param x
	 * @param y
	 */
	public void pinionPen(double x, double y) {
		Double penx = Double.valueOf(x);
		Double peny = Double.valueOf(y);
		this.pinionGear.penPosition(penx, peny);
		return;
	}

	/**
	 * 
	 * @param aPoint
	 */
	public void pinionRadius(Point aPoint) {
		double x = (double)aPoint.x;
		this.pinionGear.radius(x);
		return;
	}

	/**
	 * スレッドで用いる
	 * @return
	 */
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

	/**
	 * 初期化
	 * @return
	 */
	public void spiroClear() {
		this.initialize();
		return;
	}

	/**
	 * 
	 * @param aView
	 */
	public void spiroCircumscribe(View aView) {

	}

	/**
	 * ペンの色を変更
	 * @param aView
	 */
	public void spiroColor(View aView) {
		Color color = JColorChooser.showDialog(aView, "color picker", Color.white);

		if(color != null){
			isRainbow = false;
			this.pinionGear.penColor(color);
		}
		return;
	}

	/**
	 * ペンの色をレインボーに
	 * @return
	 */
	public void spiroRainbow() {
		this.isRainbow = true;
		int r = this.pinionGear.penColor().getRed();
		int b = this.pinionGear.penColor().getGreen();
		int g = this.pinionGear.penColor().getBlue();
		if(r == 255 && g >= 0 && g < 255 && b == 0){ this.pinionGear.penColor(new Color(r, g+1, b)); }
		else if(r > 0 && r <= 255 && g == 255 && b == 0){ this.pinionGear.penColor(new Color(r-1, g, b)); }
		else if(r == 0 && g == 255 && b >= 0 && b < 255){ this.pinionGear.penColor(new Color(r, g, b+1)); }
		else if(r == 0 && g <= 255 && g > 0 && b == 255){ this.pinionGear.penColor(new Color(r, g-1, b)); }
		else if(r >= 0 && r < 255 && g == 0 && b == 255){ this.pinionGear.penColor(new Color(r+1, g, b)); }
		else if(r == 255 && g == 0 && b <= 255 && b > 0){ this.pinionGear.penColor(new Color(r, g, b-1)); }

		return;
	}

	/**
	 * 
	 * @param aView
	 */
	public void spiroDive(View aView) {

	}

	/**
	 * 
	 * @param aView
	 */
	public void spiroInscribe(View aView) {

	}

	/**
	 * 
	 * @return
	 */
	public SpiroModel spiroNew() {
		return null;
	}

	/**
	 * ペンの太さ？
	 * @param aView
	 */
	public void spiroNib(View aView) {

	}

	/**
	 * 
	 * @param aView
	 */
	public void spiroOpen(View aView) {

	}

	/**
	 * 
	 * @param aView
	 */
	public void spiroSave(View aView) {

	}

	/**
	 * スピードを下げる
	 * @return
	 */
	public void spiroSpeedDown() {
		this.tickTime += 10;
		return;

	}

	/**
	 * スピードをあげる
	 * @return
	 */
	public void spiroSpeedUp() {
		if(this.tickTime > 10) this.tickTime -= 10;
		return;
	}


	/**
	 * 回転スタート
	 * @return
	 */
	public void spiroStart() {
		this.isAnimated = true;
		thread.start();
		return;
}

/**
 * 回転ストップ
 * @return
 */
public void spiroStop() {
		this.isAnimated = false;
		this.thread = new Thread(this);
		return;
}

/**
 * スパーギアの中心
 * @param aPoint
 */
	public void spurCenter(Point aPoint) {
		Double x = Double.valueOf(aPoint.x);
		Double y = Double.valueOf(aPoint.y);
		this.spurGear.center(x,y);
		this.spurRadius(aPoint);
		return;
	}

	/**
	 * スパーギアの中心を計算する
	 * 半径は変えない
	 * @param aPoint
	 */
	public void spurPosition(Point aPoint) {
		Double x = Double.valueOf(aPoint.x);
		Double y = Double.valueOf(aPoint.y);
		this.spurGear.center(x,y);
		return;
	}

	/**
	 * スパーギアの角度？
	 * @return
	 */
	public Double spurDegrees() {
		if(isAnimated) spurDegrees -= 1;
		return spurDegrees;
	}

	/**
	 * スパーギア
	 * @return
	 */
	public SpurGear spurGear() {
		return spurGear;
	}

	/**
	 * スパーギアの半径
	 * @param aPoint
	 */
	public void spurRadius(Point aPoint) {
		double x = (double)aPoint.x;
		this.spurGear.radius(x);
		return;
	}

	/**
	 * スパーギアの中心を取得する
	 * @return
	 */
	public Point2D.Double spurGetCenter() {
		Point2D.Double center = this.spurGear.center();
		return center;
	}

	/**
	 * スパーギアの半径を取得する
	 * @return
	 */
	public Double spurGetRadius() {
		Double radius = this.spurGear.radius();
		return radius;
	}

	/**
	 * ピニオンギアの中心座標を取得する
	 * @return
	 */
	public Point2D.Double pinionGetCenter() {
		Point2D.Double center = this.pinionGear.center();
		return center;
	}

	/**
	 * ピニオンギアの半径を取得
	 * @return
	 */
	public Double pinionGetRadius() {
		Double radius = this.pinionGear.radius();
		return radius;
	}

	/**
	 * ペンの位置を取得
	 * @return
	 */
	public Point2D.Double penGetPosition(){
		Point2D.Double penPosition = this.pinionGear.penPosition();
		return penPosition;
	}

	/**
	 * 
	 * @return
	 */
	public String toString() {
		return null;
	}

	/**
	 * 
	 * @return
	 */
	public void underConstruction() {
		return;
	}

	/**
	 * 
	 * @param aView
	 */
	public void underConstruction(View aView) {

	}

	/**
	 * 
	 * @param aView
	 * @param aString
	 */
	public void warn(View aView, String aString) {

	}

}
