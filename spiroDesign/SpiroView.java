package spiroDesign;

import java.awt.Point;
import java.awt.Graphics;
import javax.swing.JFrame;
import MVC.mvc.Model;
import MVC.mvc.Controller;
import MVC.mvc.View;
import java.awt.event.MouseEvent;
import javax.swing.JPopupMenu;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.geom.Point2D;
import java.lang.Math;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.Color;

/**
 * ビュー。表示まわりを専門に行う。
 */
@SuppressWarnings("serial")
public class SpiroView extends View {

	/**
	 * 情報を握っているModelのインスタンスを束縛する。
	 */
	protected SpiroModel smodel;

	/**
	 * 制御を司るControllerのインスタンスを束縛する。
	 */
	protected SpiroController scontroller;

	/**
	 * 回転半径
	 */
	public double rotationRadian = 0;

	/**
	 * バッファーイメージ
	 */
	private BufferedImage buffimg;

	/**
	 * TODO: この変数名じゃ何か分からないからあとで変える。
	 */
	private Graphics bfg;

	/**
	 * penとpiniongearの中心の距離
	 */
	private double distansePentoPiniongearcenter;

	/**
	 * penとpiniongearの中心の角度
	 */
	private double radianPentoPiniongearcenter;

	/**
	 * スクロール量としてPointのインスタンスを束縛する。
	 */
	private Point offset;

	/**
	 * メニューが押されたというマウスイベントを伝える。
	 */
	public MouseEvent MenuMouseEvent;

	/**
	 * インスタンスを生成して応答する。
	 * 指定されたモデルの依存物となり、モデルとコントローラとビューを設定する。
	 * 変数の初期化もする。
	 * @param aModel このビューのモデル
	 * @param aController このビューのコントローラ
	 */
	public SpiroView(SpiroModel aModel, SpiroController aController) {
		super(aModel, aController);
		this.smodel = aModel;
		this.smodel.addDependent(this);
		this.scontroller = aController;
		this.scontroller.setModel(this.smodel);
		this.scontroller.setView(this);
		this.initialize();
		return;
	}

	/**
	 * 各変数を初期化する。
	 */
	public void initialize() {
		buffimg = new BufferedImage(800,600,BufferedImage.TYPE_INT_RGB);
		bfg = buffimg.createGraphics();
		bfg.setColor(Color.WHITE);
		bfg.fillRect(0, 0, 800, 600);
		return;
	}

	/**
	 * スパーギアの描画
	 * @param aGraphics グラフィックス・コンテキスト
	 * @param aX スパーギアのx座標
	 * @param aY　スパーギアのy座標
	 */
	public void displaySpurGear(Graphics aGraphics, int aX, int aY) {
		double spurRadius = this.smodel.spurSendRadius(); // スパーギアの半径
		aGraphics.drawOval((int)(aX-spurRadius), (int)(aY-spurRadius), (int)(spurRadius*2.0), (int)(spurRadius*2.0));
		return;
	}

	/**
	 * ピニオンギアの描画
	 * @param aGraphics グラフィックス・コンテキスト
	 * @param aX ピニオンギアのx座標
	 * @param aY ピニオンギアのy座標
	 */
	public void displayPinionGear(Graphics aGraphics, int aX, int aY) {
		double pinionRadius = this.smodel.pinionSendRadius(); // ピニオンギアの半径
		// int pinionX = (int)(spurCenter.x + spurRadius - pinionRadius + (spurRadius - pinionRadius) * Math.cos(this.rotationRadian * Math.PI / 180.0));
		// int pinionY = (int)(spurCenter.y + spurRadius - pinionRadius + (spurRadius - pinionRadius) * Math.sin((this.rotationRadian + 180.0) * Math.PI / 180.0));
		// int pinionWidth = (int)(2.0*pinionRadius);
		// int pinionHeight = (int)(2.0*pinionRadius);
		aGraphics.drawOval((int)(aX-pinionRadius),(int)(aY-pinionRadius), (int)(2.0*pinionRadius), (int)(2.0*pinionRadius));
		return;
	}

/**
 * ピニオンペンの軌跡の表示 グラフィックス・コンテキスト
 * @param aGraphics
 * @param aX
 * @param aY
 */
	public void displayPinionPen(Graphics aGraphics, int aX, int aY) {

	}
	
	/**
	 * デザインの軌跡たちの表示？
	 * @param aGraphics グラフィックス・コンテキスト
	 * @param aX
	 * @param aY
	 */
	public void displayDesignLoci(Graphics aGraphics, int aX, int aY) {

	}

	/**
	 * デザインの軌跡の表示？
	 * @param aGraphics グラフィックス・コンテキスト
	 * @param aX
	 * @param aY
	 */
	public void displayDesignLocus(Graphics aGraphics, int aX, int aY) {

	}

	/**
	 * デザインの軌跡の表示？
	 * @param aGraphics グラフィックス・コンテキスト
	 * @param aX
	 * @param aY
	 * @param designLocus
	 */
	public void displayDesignLocus(Graphics aGraphics, int aX, int aY, DesignLocus designLocus) {

	}


		/**
	 * 指定されたグラフィクスにモデルの内容物を描画する。
	 * @param aGraphics グラフィックス・コンテキスト
	 */
	public void paintComponent(Graphics aGraphics) {
		// ウィンドウの大きさを取得しておく
		Integer width = this.getWidth();
		Integer height = this.getHeight();
		Point2D.Double spurCenter = this.smodel.spurSendCenter();	// スパーギアの中心
		double spurRadius = this.smodel.spurSendRadius(); // スパーギアの半径
		Point2D.Double pinionCenter = this.smodel.pinionSendCenter(); // ピニオンギアの中心
		double pinionRadius = this.smodel.pinionSendRadius(); // ピニオンギアの半径
		Point2D.Double penPosition = this.smodel.pinionSendCenter(); // ペンの位置
		aGraphics.setColor(Color.white); // 背景色を設定
		aGraphics.fillRect(0, 0, width, height); // 背景を塗る
		aGraphics.setColor(Color.black); // 黒色で描画
		// バッファーした画像を表示
		aGraphics.drawImage(this.buffimg, 0, 0, this);
		//spurGearの描画
		this.displaySpurGear(aGraphics, (int)spurCenter.x, (int)spurCenter.y);
		//pinionGearの描画
		this.displayPinionGear(aGraphics, (int)pinionCenter.x, (int)pinionCenter.y);
		// aGraphics.drawOval((int)(spurCenter.x + spurRadius - pinionRadius + (spurRadius - pinionRadius) * Math.cos(rotationRadian * Math.PI / 180.0)), (int)(spurCenter.y + spurRadius - pinionRadius + (spurRadius - pinionRadius) * Math.sin((rotationRadian + 180.0) * Math.PI / 180.0)), (int)(2.0*pinionRadius), (int)(2*pinionRadius));

		// ピニオンギアとの距離と角度を計算
		if (rotationRadian == 0) {
			distansePentoPiniongearcenter = Math.sqrt(Math.pow(penPosition.x - pinionRadius, 2.0) + Math.pow(penPosition.y - pinionRadius, 2.0));
			radianPentoPiniongearcenter = Math.atan2((spurCenter.x + spurRadius - pinionRadius + (spurRadius - pinionRadius) * Math.cos(rotationRadian * Math.PI / 180.0) + penPosition.x) - (spurCenter.x + spurRadius - pinionRadius + (spurRadius - pinionRadius) * Math.cos((rotationRadian + 180.0) * Math.PI / 180.0)) + pinionRadius, (spurCenter.y + spurRadius - pinionRadius + (int)((spurRadius - pinionRadius) * Math.sin((rotationRadian + 180.0) * Math.PI / 180.0)) + penPosition.x) - (spurCenter.y + spurRadius - pinionRadius + (spurRadius - pinionRadius) * Math.sin((rotationRadian + 180.0) * Math.PI / 180.0)) + pinionRadius);
		} else {
			radianPentoPiniongearcenter += 1;
		}

		//拡大するときの四角
		Color color = this.smodel.pinionGear().penColor();
		aGraphics.setColor(color);
		aGraphics.fillRect((int)spurCenter.x - 5, (int)(spurCenter.y + spurRadius) - 5, 10, 10);

		// TODO: 式が間違っているため変更する
		aGraphics.fillRect((int)(spurCenter.x + spurRadius + (spurRadius - pinionRadius) * Math.cos(radianPentoPiniongearcenter * Math.PI / 180.0) + distansePentoPiniongearcenter * Math.cos((spurRadius - pinionRadius) * (radianPentoPiniongearcenter * Math.PI / 180.0) / pinionRadius)), (int)(spurCenter.y + spurRadius + (spurRadius - pinionRadius) * Math.sin(radianPentoPiniongearcenter * Math.PI / 180.0) - distansePentoPiniongearcenter * Math.sin((spurRadius - pinionRadius) * (radianPentoPiniongearcenter * Math.PI / 180.0) / pinionRadius)), this.smodel.pinionGear().penNib(), this.smodel.pinionGear().penNib());
		bfg.setColor(color);
		bfg.fillOval((int)(spurCenter.x + spurRadius + (spurRadius - pinionRadius) * Math.cos(radianPentoPiniongearcenter * Math.PI / 180.0) + distansePentoPiniongearcenter * Math.cos((spurRadius - pinionRadius) * (radianPentoPiniongearcenter * Math.PI / 180.0) / pinionRadius)), (int)(spurCenter.y + spurRadius + (spurRadius - pinionRadius) * Math.sin(radianPentoPiniongearcenter * Math.PI / 180.0) - distansePentoPiniongearcenter * Math.sin((spurRadius - pinionRadius) * (radianPentoPiniongearcenter * Math.PI / 180.0) / pinionRadius)), this.smodel.pinionGear().penNib(), this.smodel.pinionGear().penNib());

		// ピニオンギアの回転角度
		rotationRadian -= 1;
	}

	/**
	 * メニューにそれぞれの項目を設置し表示する。
	 */
	public void showPopupMenu() 
	{
			JPopupMenu popup = new JPopupMenu();
			MenuItemAction action = new MenuItemAction(this, smodel);

			if(this.smodel.isAnimated()){
				JMenuItem stopMenuItem = new JMenuItem("stop");
				stopMenuItem.addActionListener(action);
				popup.add(stopMenuItem);

			}
			else {
				JMenuItem startMenuItem = new JMenuItem("start");
				startMenuItem.addActionListener(action);
				popup.add(startMenuItem);
				JMenuItem clearMenuItem = new JMenuItem("clear");
				clearMenuItem.addActionListener(action);
				popup.add(clearMenuItem);
				popup.addSeparator();
				// 色を指定するメニュー
				JMenu colorMenu = new JMenu("color");
				JMenuItem pickerMenuItem = new JMenuItem("picker");
				JMenuItem rainbowMenuItem = new JMenuItem("rainbow");
				colorMenu.add(pickerMenuItem);
				colorMenu.add(rainbowMenuItem);
				pickerMenuItem.addActionListener(action);
				rainbowMenuItem.addActionListener(action);
				popup.add(colorMenu);
				popup.addSeparator();
				// 線を太くするメニュー
				JMenuItem thickMenuItem = new JMenuItem("thick");
				thickMenuItem.addActionListener(action);
				popup.add(thickMenuItem);
				// 線を細くするメニュー
				JMenuItem thinMenuItem = new JMenuItem("thin");
				thinMenuItem.addActionListener(action);
				popup.add(thinMenuItem);
			}
			popup.addSeparator();
			// 速さを指定するメニュー
			JMenuItem speedupMenuItem = new JMenuItem("speed up");
			speedupMenuItem.addActionListener(action);
			popup.add(speedupMenuItem);
			JMenuItem speeddownMenuItem = new JMenuItem("speed down");
			speeddownMenuItem.addActionListener(action);
			popup.add(speeddownMenuItem);
			
			popup.show(MenuMouseEvent.getComponent(),MenuMouseEvent.getX(),MenuMouseEvent.getY());
		return;
	}

	/**
	 * このインスタンスを文字列にして応答する。
	 * @return 自分自身を表す文字列
	 */
	public String toString()
	{
		StringBuffer aBuffer = new StringBuffer();
		Class<?> aClass = this.getClass();
		aBuffer.append(aClass.getName());
		aBuffer.append("[model=");
		aBuffer.append(this.smodel);
		aBuffer.append("]");
		return aBuffer.toString();
	}

}
