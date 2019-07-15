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

/**
 * モデル。データ管理を専門に行う。
 */
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
	 * レインボーかどうかを判定する
	 */
	public boolean isRainbow;

	/**
	 * ペンの軌跡をリセットするかどうか
	 */
	public boolean isClear;

	/**
	 *
	 */
	public boolean isClear;

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
	 * ピニオンギアの中心とペンとの距離
	 */
	 private double penRadius;

	/**
	 *
	 */
	private SpiroGear spiroGear;


	//imageの描画位置
	private Point imagePosition;


	//imageの描画位置
	private Point imagePosition;


	//imageの描画位置
	private Point imagePosition;

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
		this.tickTime = 10;
		this.thread = new Thread(this);
		this.isRainbow = false;
		this.isAnimated = false;
		this.isClear = false;
		this.spiroColor = new Color(0,0,0);
		this.spurDegrees = 0.0;
		this.pinionDegrees = 0.0;
		this.penRadius = 0.0;
		this.imagePosition = new Point(0,0);
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


	public PinionGear firstPinionGear() {
		return null;
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
	 */
	 public boolean isClear(){
		 return this.isClear;
	 }

	/**
	 *
	 * isAnimatedの状態を返す
	 * @return isAnimated アニメーションをするかどうか判定する
	 */
	 public boolean isClear(){
		 return this.isClear;
	 }

	/**
	 * siClearの状態を返す
	 * @return isClear 軌跡を消すかどうか判定する
 	 */
	 public boolean isClear(){
		 return this.isClear;
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
	 * @param aPoint
	 * ドラッグの移動距離によりピニオンギアを移動させる
	 * @param aPoint ドラッグの移動量
	 */
	public void pinionFirstCenter(Point aPoint) {
		Point2D.Double spurCenter = this.spurGetCenter();
		Point2D.Double previousPinioncenter = pinionGetCenter();
		Point2D.Double currentPinioncenter;
		double previousPinionRadius = pinionGetRadius();
		double currentPinionRadius;
		Double x = Double.valueOf(aPoint.x);
  	Double y = Double.valueOf(aPoint.y);

  	this.pinionGear.center(this.pinionGetCenter().x + x,this.pinionGetCenter().y + x);
  	this.pinionRadius(aPoint);
		this.pinionCenter(spurCenter.x, spurCenter.y);
		currentPinioncenter = pinionGetCenter();
		currentPinionRadius = pinionGetRadius();

		this.pinionFirstPen((currentPinioncenter.x + currentPinionRadius) - (previousPinioncenter.x + previousPinionRadius), (currentPinioncenter.y + currentPinionRadius) - (previousPinioncenter.y + previousPinionRadius));
  	return;
	}

	/**
	 * ピニオンギアの中心を求める
	 * @param x スパーギアのx座標
	 * @param y スパーギアのy座標
	 */
	public void pinionCenter(double x, double y) {
		double spurRadius = this.spurGetRadius();
		double pinionRadius = this.pinionGetRadius();

		Double pinionCenterX = Double.valueOf(x + spurRadius - pinionRadius + (spurRadius - pinionRadius) * Math.cos(spurDegrees * Math.PI / 180.0));
		Double pinionCenterY = Double.valueOf(y + spurRadius - pinionRadius + (spurRadius - pinionRadius) * Math.sin((spurDegrees + 180.0) * Math.PI / 180.0));
		this.pinionGear.center(pinionCenterX, pinionCenterY);
		return;
	}

	/**
	 * ペンとピニオンギアの中心を結んだ線の角度
	 * @param spurDegrees
	 * @return
	 * isAnimatedがfalseの時にペンとピニオンギアの中心を結んだ線の角度を求める
	 * @return pinionDegrees ペンとピニオンギアの中心を結んだ線の角度
	 */
	public Double pinionDegrees() {
		Point2D.Double pinionCenter = this.pinionGetCenter();
		Point2D.Double penPosition = this.penGetPosition();
		double pinionRadius = this.pinionGetRadius();
		if (!isAnimated) {
			this.pinionDegrees = 0 - Math.atan2(penPosition.y - (pinionCenter.y + pinionRadius), penPosition.x - (pinionCenter.x + pinionRadius));
		}
		return this.pinionDegrees;
	}

	/**
	 * isAnimatedがfalseの時にペンとピニオンギアの中心との距離を求める
	 * @return penRadius ペンとピニオンギアの中心との距離
	 */
	public double penRadius() {
		Point2D.Double pinionCenter = this.pinionGetCenter();
		Point2D.Double penPosition = this.penGetPosition();
		double pinionRadius = this.pinionGetRadius();
		if (!isAnimated) {
			this.penRadius = Math.sqrt(Math.pow(penPosition.x - (pinionCenter.x + pinionRadius), 2) + Math.pow(penPosition.y - (pinionCenter.y + pinionRadius), 2));
		}

		return this.penRadius;
	}

	/**
	 * ピニオンギアを返す
	 * @return pinionGear
	 */
	public PinionGear pinionGear() {
		return this.pinionGear;
	}

	/**
	 * ペンを移動量ぶんだけ移動させる
	 * @param moveX ペンのx方向の移動量
	 * @param moveY ペンのy方向の移動量
	 */
	public void pinionFirstPen(double moveX, double moveY) {
		Double x = Double.valueOf(moveX);
		Double y = Double.valueOf(moveY);
		Point2D.Double pen = this.penGetPosition();
		if(this.penRadius >= this.pinionGetRadius()){
			x = -x;
			y = -y;
		}
		this.pinionGear.penPosition(pen.x+x, pen.y+y);
		this.pinionDegrees();
		this.penRadius();
		return;
	}

	/**
	 * isAnimatedがtrueの時にペンの位置を求める
	 * @param x ピニオンギアの中心のx座標
	 * @param y ピニオンギアの中心のy座標
	 */
	public void pinionPen(double x, double y) {
		double spurRadius = this.spurGetRadius();
		double pinionRadius = this.pinionGetRadius();
		Point2D.Double pinionCenter = this.pinionGetCenter();
		double penPositionX = this.penGetPosition().x;
		double penPositionY = this.penGetPosition().y;

		if(isAnimated){
			this.pinionDegrees += 1 * Math.PI / 180 * (spurRadius - pinionRadius) / pinionRadius;
			penPositionX = pinionCenter.x + pinionRadius + this.penRadius * Math.cos(this.pinionDegrees);
			penPositionY = pinionCenter.y + pinionRadius - this.penRadius * Math.sin(this.pinionDegrees);
		}
		this.pinionGear.penPosition(penPositionX, penPositionY);
		return;
	}

	/**
	 * ピニオンギアの半径を更新する
	 * @param aPoint 移動量
	 */
	public void pinionRadius(Point aPoint) {
		double x = (double)aPoint.x;
		double spurRadius = this.spurGetRadius();
		double pinionRadius = this.pinionGetRadius();
		if(pinionRadius - x < 25){
			pinionRadius = 25.0;
			this.pinionGear.radius(pinionRadius);
		}else if(pinionRadius - x > spurRadius - 10){
			pinionRadius = spurRadius - 10;
			this.pinionGear.radius(pinionRadius);
		}else{
			this.pinionGear.radius(pinionRadius - x);
		}
		return;
	}

	/**
	 * アニメーションを行う
	 */
	public void run() {

		this.isAnimated = true;
		this.isClear = false;

		while(isAnimated){
				try
				{

						Thread.sleep(tickTime);
						if(this.isRainbow()){
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
	 * 軌跡の描画を消す
	 */
	public void spiroClear() {
		this.isClear = true;
		super.changed();
		return;
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
		int g = this.pinionGear.penColor().getGreen();
		int b = this.pinionGear.penColor().getBlue();
		if(r == 255 && (g >= 0 && g < 255) && b == 0){ this.pinionGear.penColor(new Color(r, g+1, b)); }
		else if((r > 0 && r <= 255) && g == 255 && b == 0){ this.pinionGear.penColor(new Color(r-1, g, b)); }
		else if(r == 0 && g == 255 && (b >= 0 && b < 255)){ this.pinionGear.penColor(new Color(r, g, b+1)); }
		else if(r == 0 && (g <= 255 && g > 0) && b == 255){ this.pinionGear.penColor(new Color(r, g-1, b)); }
		else if((r >= 0 && r < 255) && g == 0 && b == 255){ this.pinionGear.penColor(new Color(r+1, g, b)); }
		else if(r == 255 && g == 0 && (b <= 255 && b > 0)){ this.pinionGear.penColor(new Color(r, g, b-1)); }

		return;
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
		Point2D.Double center = this.spurGetCenter();
		this.spurGear.center(center.x+x,center.y+x);
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
		Point2D.Double center = this.spurGetCenter();
		this.spurGear.center(center.x+x,center.y+y);
		this.pinionFirstPen(aPoint.x,aPoint.y);
		return;
	}

	/**
	 * スパーギアの中心とピニオンギアの中心との角度
	 * @return spurDegrees スパーギアの角度
	 */
	public Double spurDegrees() {
		if(isAnimated) this.spurDegrees -= 1;
		return this.spurDegrees;
	}

	/**
	 * スパーギア
	 * @return
	 */
	public SpurGear spurGear() {
		return spurGear;
	}

	/**
	 * スパーギアの中心とピニオンギアの中心との角度を計算し、ピニオンギアの位置を移動
	 * @param aPoint
	 */
	public void spurFirstDegrees(Point aPoint) {
		Point2D.Double spurCenter = this.spurGetCenter();
		Point2D.Double previousPinioncenter = pinionGetCenter();
		Point2D.Double currentPinioncenter;

		if ((0 <= this.spurDegrees * Math.PI / 180.0) && (this.spurDegrees * Math.PI / 180.0 < Math.PI / 2)) {
			if (0 < aPoint.x || 0 < aPoint.y) {
				this.spurDegrees -= 0.6;
			} else if (0 > aPoint.x || 0 > aPoint.y) {
				this.spurDegrees += 0.6;
			}
		} else if ((Math.PI / 2 <= this.spurDegrees * Math.PI / 180.0) && (this.spurDegrees * Math.PI / 180.0 < Math.PI)) {
			if (0 < aPoint.x || 0 > aPoint.y) {
				this.spurDegrees -= 0.6;
			} else if (0 > aPoint.x || 0 < aPoint.y) {
				this.spurDegrees += 0.6;
			}
		} else if ((Math.PI <= this.spurDegrees * Math.PI / 180.0) && (this.spurDegrees * Math.PI / 180.0 < Math.PI * 3 / 2)) {
			if (0 > aPoint.x || 0 > aPoint.y) {
				this.spurDegrees -= 0.6;
			} else if (0 < aPoint.x || 0 < aPoint.y) {
				this.spurDegrees += 0.6;
			}
		} else if ((Math.PI * 3 / 2 <= this.spurDegrees * Math.PI / 180.0) && (this.spurDegrees * Math.PI / 180.0 < 2 * Math.PI)) {
			if (0 > aPoint.x || 0 < aPoint.y) {
				this.spurDegrees -= 0.6;
			} else if (0 < aPoint.x || 0 > aPoint.y) {
				this.spurDegrees += 0.6;
			}
		}
		if (this.spurDegrees < 0) this.spurDegrees += 360;
		if (this.spurDegrees >= 360) this.spurDegrees -= 360;

		this.pinionCenter(spurCenter.x, spurCenter.y);
		currentPinioncenter = pinionGetCenter();

		this.pinionFirstPen(currentPinioncenter.x - previousPinioncenter.x, currentPinioncenter.y - previousPinioncenter.y);
		return;
	}

	/**
	 * スパーギアの半径
	 * @param aPoint
	 */
	public void spurRadius(Point aPoint) {
		Point2D.Double spurCenter = this.spurGetCenter();
		Point2D.Double previousPinioncenter = pinionGetCenter();
		Point2D.Double currentPinioncenter;
		double x = (double)aPoint.x;
		double spurRadius = this.spurGetRadius();
		double pinionRadius = this.pinionGetRadius();
		// this.penRadius();
		if(spurRadius - x <= pinionRadius){

	  }else if(spurRadius - x <= 50){
			spurRadius = 50.0;
			this.spurGear.radius(spurRadius);
		}else{
			this.spurGear.radius(spurRadius - x);
			this.spurCenter(aPoint);
			this.pinionCenter(spurCenter.x, spurCenter.y);
			currentPinioncenter = pinionGetCenter();

			this.pinionFirstPen(currentPinioncenter.x - previousPinioncenter.x, currentPinioncenter.y - previousPinioncenter.y);
		}
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

	public void imageMovedPosition(Point aPoint){
		this.imagePosition = new Point(this.imagePosition.x + aPoint.x,this.imagePosition.y + aPoint.y);
		return;
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
	 * 軌跡の座標を取得
	 * @return
	 */
	public Point imageGetPosition(){
		return this.imagePosition;
	}

	/**
	 *
	 * @return
	 */
	public String toString() {
		return null;
	}

}
