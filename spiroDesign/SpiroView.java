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
		double spurRadius = this.smodel.spurGetRadius();
		aGraphics.setColor(Color.black);
		aGraphics.drawOval(aX, aY, (int)(spurRadius*2.0), (int)(spurRadius*2.0));
		//spurGearの描画位置
		aGraphics.setColor(this.smodel.spiroColor);
		aGraphics.fillRect((int)(aX - 5), (int)((aY + spurRadius) - 5), 10, 10);
		//追加＿spurGearの中心の描画
		aGraphics.setColor(this.smodel.spiroColor);
		aGraphics.fillRect((int)((aX + spurRadius) - 5), (int)((aY + spurRadius) - 5), 10, 10);
		return;
	}

	/**
	 * ピニオンギアの描画
	 * @param aGraphics グラフィックス・コンテキスト
	 * @param aX ピニオンギアのx座標
	 * @param aY ピニオンギアのy座標
	 */
	public void displayPinionGear(Graphics aGraphics, int aX, int aY) {
		double pinionRadius = this.smodel.pinionGetRadius();
		aGraphics.setColor(Color.black);
		aGraphics.drawOval(aX, aY, (int)(2.0*pinionRadius), (int)(2*pinionRadius));
	return;
	}

/**
 * ピニオンペンの軌跡の表示 グラフィックス・コンテキスト
 * @param aGraphics
 * @param aX
 * @param aY
 */
	public void displayPinionPen(Graphics aGraphics, int aX, int aY) {
		aGraphics.fillRect(aX,aY,this.smodel.pinionGear().penNib(),this.smodel.pinionGear().penNib());
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
		Point2D.Double spurCenter = this.smodel.spurGetCenter();	// スパーギアの中心
		double spurRadius = this.smodel.spurGetRadius(); // スパーギアの半径
		Point2D.Double pinionCenter = this.smodel.pinionGetCenter(); // ピニオンギアの中心
		double pinionRadius = this.smodel.pinionGetRadius(); // ピニオンギアの半径
		Point2D.Double penPosition = this.smodel.pinionGetCenter(); // ペンの位置
		aGraphics.setColor(Color.white); // 背景色を設定
		aGraphics.fillRect(0, 0, width, height); // 背景を塗る

		// バッファーイメージを表示
		aGraphics.drawImage(this.buffimg, 0, 0, this);
		//spurGearの描画
		double sx = (double)spurCenter.x;
		double sy = (double)spurCenter.y;
		this.displaySpurGear(aGraphics, (int)sx, (int)sy);
		//aGraphics.drawOval((int)spurCenter.x, (int)spurCenter.y, (int)(spurRadius*2.0), (int)(spurRadius*2.0));
		//pinionGearの描画
		double px = spurCenter.x + spurRadius - pinionRadius + (spurRadius - pinionRadius) * Math.cos(rotation_radian * Math.PI / 180.0);
		double py = spurCenter.y + spurRadius - pinionRadius + (spurRadius - pinionRadius) * Math.sin((rotation_radian + 180.0) * Math.PI / 180.0);
		this.displayPinionGear(aGraphics, (int)px, (int)py);
		//aGraphics.drawOval((int)x, (int)y, (int)(2.0*pinionRadius), (int)(2*pinionRadius));
		this.smodel.pinionCenter(px,py);

		// ピニオンギアとの距離と角度を計算
		if (rotation_radian == 0) {
			distanse_PentoPiniongearcenter = Math.sqrt(Math.pow(penPosition.x - (spurCenter.x + spurRadius + (int)((spurRadius - pinionRadius) * Math.cos(rotation_radian * Math.PI / 180))), 2) + Math.pow(penPosition.y - (spurCenter.y + spurRadius + (int)((spurRadius - pinionRadius) * Math.sin((rotation_radian + 180) * Math.PI / 180))), 2));
			radian_PentoPiniongearcenter = 0 - Math.atan2(penPosition.y - (spurCenter.y + spurRadius + (int)((spurRadius - pinionRadius) * Math.sin((rotation_radian + 180) * Math.PI / 180))), 0 - (penPosition.x - (spurCenter.x + spurRadius + (int)((spurRadius - pinionRadius) * Math.cos(rotation_radian * Math.PI / 180)))));
			// System.out.println(radian_PentoPiniongearcenter);
			// System.out.println(radian_PentoPiniongearcenter * 180 / Math.PI);
		} else {
			radian_PentoPiniongearcenter += 1 * Math.PI / 180;
		}

		//penの描画
		aGraphics.setColor(this.smodel.pinionGear().penColor());
		double penx = spurCenter.x + spurRadius + (spurRadius - pinionRadius) * Math.cos(rotation_radian * Math.PI / 180) + distanse_PentoPiniongearcenter * Math.cos((spurRadius - pinionRadius) * (radian_PentoPiniongearcenter) / pinionRadius);
		double peny = spurCenter.y + spurRadius + (spurRadius - pinionRadius) * Math.sin((rotation_radian + 180) * Math.PI / 180) - distanse_PentoPiniongearcenter * Math.sin((spurRadius - pinionRadius) * (radian_PentoPiniongearcenter) / pinionRadius);
		this.displayPinionPen(aGraphics, (int)penx, (int)peny);
		this.smodel.pinionPen(penx,peny);

		//spurGearの描画位置
		aGraphics.setColor(this.smodel.pinionGear().penColor());
		aGraphics.fillRect((int)spurCenter.x - 5, (int)(spurCenter.y + spurRadius) - 5, this.smodel.pinionGear().penNib(), this.smodel.pinionGear().penNib());

		//追加＿spurGearの中心の描画
		aGraphics.setColor(this.smodel.pinionGear().penColor());
		aGraphics.fillRect((int)(spurCenter.x + spurRadius) - 5, (int)(spurCenter.y + spurRadius) - 5, this.smodel.pinionGear().penNib(), this.smodel.pinionGear().penNib());
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
