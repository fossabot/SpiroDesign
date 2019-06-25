import java.awt.Graphics;
import javax.swing.JFrame;

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
		aGraphics.drawOval(aX, aY, 100, 100);
	}

	public void paintComponent(Graphics aGraphics) {

	}

	public String toString() {
		return null;
	}

}
