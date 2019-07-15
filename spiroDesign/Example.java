package spiroDesign;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import MVC.mvc.Model;
import MVC.mvc.Controller;
import MVC.mvc.View;

public class Example extends Object {

	public static void main(String[] argements) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Robot aRobot = null;
		try
		{
			aRobot = new Robot();
		}
		catch (Exception anException)
		{
			System.err.println(anException);
			throw new RuntimeException(anException.toString());
		}
		BufferedImage anImage = aRobot.createScreenCapture(new Rectangle(screenSize));

		//コントローラを作る。
		SpiroController aController = new SpiroController();

		// ウィンドウのサイズを決め、モデルを作る。
		Dimension aDimension = new Dimension(800, 600);
		SpiroModel aModel = new SpiroModel();

		// MVCの出現数から、最初のウィンドウの出現位置を計算する。
		Integer howMany = 1; // MVCの出現回数
		Point offsetPoint = new Point(80, 60); // ウィンドウを出現させる時のオフセット(ズレ：ずらし)
		Integer width = aDimension.width + (offsetPoint.x * (howMany - 1));
		Integer height = aDimension.height + (offsetPoint.y * (howMany - 1));
		Integer x = (screenSize.width / 2) - (width / 2);
		Integer y = (screenSize.height / 2) - (height / 2);
		Point displayPoint = new Point(x, y);


		// 上記のモデルのビューとコンピュローラのペアを作り、ウィンドウに乗せる。
		SpiroView aView = new SpiroView(aModel, aController);
		JFrame aWindow = new JFrame("spirodesign");
		aWindow.getContentPane().add(aView);

		// 高さはタイトルバーの高さを考慮してウィンドウの大きさを決定する。
		Integer titleBarHeight = aWindow.getInsets().top;
		aWindow.setSize(800, 600);

		// ウィンドウに各種の設定を行って出現させる。
		aWindow.setMinimumSize(new Dimension(400, 300 + titleBarHeight));
		aWindow.setResizable(true);
		aWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		x = displayPoint.x + offsetPoint.x;
		y = displayPoint.y + offsetPoint.y;
		aWindow.setLocation(x, y);
		aWindow.setVisible(true);
		aWindow.toFront();

		return;
	}

}
