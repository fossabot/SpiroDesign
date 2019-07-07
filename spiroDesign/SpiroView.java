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

@SuppressWarnings("serial")
public class SpiroView extends View {
	double rotation_radian = 0;
	BufferedImage buffimg;
	Graphics bfg;
	double distanse_PentoPiniongearcenter; //penとpiniongearの中心の距離
	double radian_PentoPiniongearcenter; //penとpiniongearの中心の角度
	// private SpiroModel spiroModel = new SpiroModel();

	protected Model model;

	/**
	 * 制御を司るControllerのインスタンスを束縛する。
	 */
	protected Controller controller;

	/**
	 * スクロール量としてPointのインスタンスを束縛する。
	 */
	private Point offset;

	protected SpiroController scontroller;

	protected SpiroModel smodel;

	public MouseEvent MenuMouseEvent;

	public boolean isMenuPopuping = false;

	public boolean isMove = false;

	public int lineSize;

	public SpiroView(SpiroModel aModel, SpiroController aController) {
		super(aModel, aController);
		this.smodel = aModel;
		this.smodel.addDependent(this);
		this.scontroller = aController;
		this.scontroller.setModel(this.smodel);
		this.scontroller.setView(this);
		this.lineSize = 10;
		buffimg = new BufferedImage(800,600,BufferedImage.TYPE_INT_RGB);
		bfg = buffimg.createGraphics();
		bfg.setColor(new Color(255, 255, 255));
		bfg.fillRect(0, 0, 800, 600);
		return;
	}

	public void displayPinionGear(Graphics aGraphics, int aX, int aY) {

	}

	public void displayPinionPen(Graphics aGraphics, int aX, int aY) {

	}

	public void displayDesignLoci(Graphics aGraphics, int aX, int aY) {

	}

	public void displayDesignLocus(Graphics aGraphics, int aX, int aY) {

	}

	public void displayDesignLocus(Graphics aGraphics, int aX, int aY, DesignLocus designLocus) {

	}

	public void displaySpurGear(Graphics aGraphics, int aX, int aY) {

	}

	
	public void paintComponent(Graphics aGraphics) {
		Integer width = this.getWidth();
		Integer height = this.getHeight();
		Point2D.Double spurCenter = this.smodel.spurSendCenter();
		double spurRadius = this.smodel.spurSendRadius();
		Point2D.Double pinionCenter = this.smodel.pinionSendCenter();
		double pinionRadius = this.smodel.pinionSendRadius();
		Point2D.Double penPosition = this.smodel.pinionSendCenter();
		aGraphics.setColor(Color.white);
		aGraphics.fillRect(0, 0, width, height);
		aGraphics.setColor(Color.black);

		aGraphics.drawImage(buffimg, 0, 0, this);
		//spurGearの描画
		aGraphics.drawOval((int)spurCenter.x, (int)spurCenter.y, (int)(spurRadius*2.0), (int)(spurRadius*2.0));
		//pinionGearの描画
		aGraphics.drawOval((int)(spurCenter.x + spurRadius - pinionRadius + (spurRadius - pinionRadius) * Math.cos(rotation_radian * Math.PI / 180.0)), (int)(spurCenter.y + spurRadius - pinionRadius + (spurRadius - pinionRadius) * Math.sin((rotation_radian + 180.0) * Math.PI / 180.0)), (int)(2.0*pinionRadius), (int)(2*pinionRadius));

		if (rotation_radian == 0) {
			distanse_PentoPiniongearcenter = Math.sqrt(Math.pow(penPosition.x - pinionRadius, 2.0) + Math.pow(penPosition.y - pinionRadius, 2.0));
			radian_PentoPiniongearcenter = Math.atan2((spurCenter.x + spurRadius - pinionRadius + (spurRadius - pinionRadius) * Math.cos(rotation_radian * Math.PI / 180.0) + penPosition.x) - (spurCenter.x + spurRadius - pinionRadius + (spurRadius - pinionRadius) * Math.cos((rotation_radian + 180.0) * Math.PI / 180.0)) + pinionRadius, (spurCenter.y + spurRadius - pinionRadius + (int)((spurRadius - pinionRadius) * Math.sin((rotation_radian + 180.0) * Math.PI / 180.0)) + penPosition.x) - (spurCenter.y + spurRadius - pinionRadius + (spurRadius - pinionRadius) * Math.sin((rotation_radian + 180.0) * Math.PI / 180.0)) + pinionRadius);
		} else {
			radian_PentoPiniongearcenter += 1;
		}

		//penの描画
		Color color = this.smodel.spiroColor;
		aGraphics.setColor(color);
		aGraphics.fillRect((int)spurCenter.x - 5, (int)(spurCenter.y + spurRadius) - 5, 10, 10);

		//のちに変更
		aGraphics.fillRect((int)(spurCenter.x + spurRadius + (spurRadius - pinionRadius) * Math.cos(radian_PentoPiniongearcenter * Math.PI / 180.0) + distanse_PentoPiniongearcenter * Math.cos((spurRadius - pinionRadius) * (radian_PentoPiniongearcenter * Math.PI / 180.0) / pinionRadius)), (int)(spurCenter.y + spurRadius + (spurRadius - pinionRadius) * Math.sin(radian_PentoPiniongearcenter * Math.PI / 180.0) - distanse_PentoPiniongearcenter * Math.sin((spurRadius - pinionRadius) * (radian_PentoPiniongearcenter * Math.PI / 180.0) / pinionRadius)), this.lineSize, this.lineSize);
		bfg.setColor(color);
		bfg.fillOval((int)(spurCenter.x + spurRadius + (spurRadius - pinionRadius) * Math.cos(radian_PentoPiniongearcenter * Math.PI / 180.0) + distanse_PentoPiniongearcenter * Math.cos((spurRadius - pinionRadius) * (radian_PentoPiniongearcenter * Math.PI / 180.0) / pinionRadius)), (int)(spurCenter.y + spurRadius + (spurRadius - pinionRadius) * Math.sin(radian_PentoPiniongearcenter * Math.PI / 180.0) - distanse_PentoPiniongearcenter * Math.sin((spurRadius - pinionRadius) * (radian_PentoPiniongearcenter * Math.PI / 180.0) / pinionRadius)), this.lineSize, this.lineSize);

		rotation_radian -= 1;
	}

	public void showPopupMenu() 
	{
		if(isMenuPopuping){
			JPopupMenu popup = new JPopupMenu();
			MenuItemAction action = new MenuItemAction(this, smodel);

			if(isMove){
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
				// 線を太くする
				JMenuItem thickMenuItem = new JMenuItem("thick");
				thickMenuItem.addActionListener(action);
				popup.add(thickMenuItem);
				// 線を細くする
				JMenuItem thinMenuItem = new JMenuItem("thin");
				thinMenuItem.addActionListener(action);
				popup.add(thinMenuItem);
			}
			popup.addSeparator();
			// 速さを指定する
			JMenuItem speedupMenuItem = new JMenuItem("speed up");
			speedupMenuItem.addActionListener(action);
			popup.add(speedupMenuItem);
			JMenuItem speeddownMenuItem = new JMenuItem("speed down");
			speeddownMenuItem.addActionListener(action);
			popup.add(speeddownMenuItem);
			

			popup.show(MenuMouseEvent.getComponent(),MenuMouseEvent.getX(),MenuMouseEvent.getY());
		}	
		return;
	}





	public String toString() {
		return null;
	}

}
