import java.awt.Graphics;
import javax.swing.JFrame;
import spirogear.MVC.mvc.Model;
import spirogear.MVC.mvc.Controller;
import spirogear.MVC.mvc.View;

public class SpiroView extends View {

	public SpiroView(SpiroModel aModel, SpiroController aController) {
		super(aModel, aController);
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
		aGraphics.drawOval(10, 10, 100, 50);
  	aGraphics.drawArc(20, 20, 120, 70, 45, 180);
	}

	public void paintComponent(Graphics aGraphics) {

	}

	public String toString() {
		return null;
	}

}
