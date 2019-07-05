import java.awt.Point;
import java.awt.Graphics;
import javax.swing.JFrame;
import MVC.mvc.Model;
import MVC.mvc.Controller;
import MVC.mvc.View;
import java.awt.event.MouseEvent;
import javax.swing.JPopupMenu;
import javax.swing.JMenu;

// import com.sun.xml.internal.ws.api.Component;

import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class SpiroView extends View {

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
		int aX=this.getWidth();
		int aY=this.getHeight();
		int spurRadius=200;
		aGraphics.drawOval(aX/2-spurRadius/2, aY/2-spurRadius/2, spurRadius, spurRadius);
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
				// 色を指定するメニュー
				JMenu colorMenu = new JMenu("color");
				JMenuItem pickerMenuItem = new JMenuItem("picker");
				JMenuItem rainbowMenuItem = new JMenuItem("rainbow");
				colorMenu.add(pickerMenuItem);
				colorMenu.add(rainbowMenuItem);
				pickerMenuItem.addActionListener(action);
				rainbowMenuItem.addActionListener(action);
				popup.add(colorMenu);
				// 線を太くする
				JMenuItem thickMenuItem = new JMenuItem("thick");
				thickMenuItem.addActionListener(action);
				popup.add(thickMenuItem);
				// 線を細くする
				JMenuItem thinMenuItem = new JMenuItem("thin");
				thinMenuItem.addActionListener(action);
				popup.add(thinMenuItem);
			}
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
