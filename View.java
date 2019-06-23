import java.awt.Point;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import java.awt.Color;

public class View {

	private Controller controller;

	private Model model;

	public View(Model aModel)
	{
		super();
		this.model = aModel;
		this.model.addDependent(this);
		this.controller = new Controller();
		this.controller.setModel(this.model);
		this.controller.setView(this);
		this.offset = new Point(0, 0);
		return;
	}

}
