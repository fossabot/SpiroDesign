import java.util.ArrayList;
import java.lang.Math;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import spirogear.MVC.mvc.Model;
import spirogear.MVC.mvc.Controller;
import spirogear.MVC.mvc.View;

public class SpiroView extends View {
	double rotation_radian = 0;
	BufferedImage buffimg;
	Graphics bfg;
	double distanse_PentoPiniongearcenter; //penとpiniongearの中心の距離
	double radian_PentoPiniongearcenter; //penとpiniongearの中心の角度

	public SpiroView(SpiroModel aModel, SpiroController aController) {
		super(aModel, aController);
		buffimg = new BufferedImage(800,600,BufferedImage.TYPE_INT_RGB);
		bfg = buffimg.createGraphics();
		bfg.setColor(new Color(255, 255, 255));
		bfg.fillRect(0, 0, 800, 600);
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
<<<<<<< HEAD
		Integer width;
		Integer height;
		Integer x = 300;
		Integer y = 150;
		Integer spur_r = 121; //spurgearの半径
		Integer pinion_r = 42; //piniongearの半径
		Integer pen_x = 515;
		Integer pen_y = 304;

		width = this.getWidth();
		height = this.getHeight();
		aGraphics.setColor(Color.white);
		aGraphics.fillRect(0, 0, width, height);
		aGraphics.setColor(Color.black);

		aGraphics.drawImage(buffimg, 0, 0, this);
		//spurGearの描画
		aGraphics.drawOval(x, y, 2*spur_r, 2*spur_r);
		//pinionGearの描画
		aGraphics.drawOval(x + spur_r - pinion_r + (int)((spur_r - pinion_r) * Math.cos(rotation_radian * Math.PI / 180)), y + spur_r - pinion_r + (int)((spur_r - pinion_r) * Math.sin((rotation_radian + 180) * Math.PI / 180)), 2*pinion_r, 2*pinion_r);

		if (rotation_radian == 0) {
			distanse_PentoPiniongearcenter = Math.sqrt(Math.pow(pen_x - (x + spur_r + (int)((spur_r - pinion_r) * Math.cos(rotation_radian * Math.PI / 180))), 2) + Math.pow(pen_y - (y + spur_r + (int)((spur_r - pinion_r) * Math.sin((rotation_radian + 180) * Math.PI / 180))), 2));
			//distanse_PentoPiniongearcenter = 50;
			//radian_PentoPiniongearcenter = Math.atan2((x + spur_r - pinion_r + (int)((spur_r - pinion_r) * Math.cos(rotation_radian * Math.PI / 180)) + pen_x) - (x + spur_r - pinion_r + (int)((spur_r - pinion_r) * Math.cos((rotation_radian + 180) * Math.PI / 180)) + pinion_r), (y + spur_r - pinion_r + (int)((spur_r - pinion_r) * Math.sin((rotation_radian + 180) * Math.PI / 180)) + pen_y) - (y + spur_r - pinion_r + (int)((spur_r - pinion_r) * Math.sin((rotation_radian + 180) * Math.PI / 180)) + pinion_r));
			radian_PentoPiniongearcenter = Math.atan2(pen_y - (y + spur_r + (int)((spur_r - pinion_r) * Math.sin((rotation_radian + 180) * Math.PI / 180))), pen_x - (x + spur_r + (int)((spur_r - pinion_r) * Math.cos(rotation_radian * Math.PI / 180))));
			System.out.println(radian_PentoPiniongearcenter);
		} else {
			radian_PentoPiniongearcenter += 1 * Math.PI / 180;
		}

    //penの描画
		aGraphics.setColor(Color.red);
		aGraphics.fillRect(x + spur_r + (int)((spur_r - pinion_r) * Math.cos(rotation_radian * Math.PI / 180) + distanse_PentoPiniongearcenter * Math.cos((spur_r - pinion_r) * (radian_PentoPiniongearcenter) / pinion_r)), y + spur_r + (int)((spur_r - pinion_r) * Math.sin((rotation_radian + 180) * Math.PI / 180) - distanse_PentoPiniongearcenter * Math.sin((spur_r - pinion_r) * (radian_PentoPiniongearcenter) / pinion_r)), 5, 5);

		//spurgearの左端
		aGraphics.fillRect(x - 5, y + spur_r - 5, 10, 10);

		bfg.setColor(Color.black);
		bfg.fillOval(x + spur_r + (int)((spur_r - pinion_r) * Math.cos(rotation_radian * Math.PI / 180) + distanse_PentoPiniongearcenter * Math.cos((spur_r - pinion_r) * (radian_PentoPiniongearcenter) / pinion_r)), y + spur_r + (int)((spur_r - pinion_r) * Math.sin((rotation_radian + 180) * Math.PI / 180) - distanse_PentoPiniongearcenter * Math.sin((spur_r - pinion_r) * (radian_PentoPiniongearcenter) / pinion_r)), 3, 3);

		rotation_radian -= 1;
=======
		int aX=this.getWidth();
		int aY=this.getHeight();
		int spurRadius=200;
		aGraphics.drawOval(aX/2-spurRadius/2, aY/2-spurRadius/2, spurRadius, spurRadius);
>>>>>>> 511f3e45910631b94569e9b7966eae3bffdc628d
	}

	public String toString() {
		return null;
	}

}
