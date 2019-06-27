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

	}

	public void paintComponent(Graphics aGraphics) {
		int aX=this.getWidth();
		int aY=this.getHeight();
		int spurRadius=200;
		aGraphics.drawOval(aX/2-spurRadius/2, aY/2-spurRadius/2, spurRadius, spurRadius);
	}

	public String toString() {
		return null;
	}

}
