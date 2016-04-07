package halcyon.demo;

import halcyon.model.list.HalcyonNodeRepository;
import halcyon.model.node.HalcyonNode;
import halcyon.view.ViewManager;
import halcyon.window.control.ControlWindowBase;
import halcyon.window.toolbar.ToolbarInterface;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * Control type Toolbar window
 */
public class DemoToolbarWindow extends ControlWindowBase implements
																												ToolbarInterface
{
	final private HalcyonNodeRepository nodes;

	public DemoToolbarWindow(final ViewManager manager)
	{
		super(new VBox());
		getDockTitleBar().setVisible(false);

		nodes = manager.getNodes();

		setTitle("Demo Toolbar");

		final VBox box = (VBox) getContents();

		Button btn = new Button("Add Camera-1");
		btn.setOnAction(e -> {
			final HalcyonNode n = new HalcyonNode("Camera-1", HalcyonNodeTypeExample.ONE);
			final VBox cameraPanel = new VBox();

			cameraPanel.getChildren().add(new Button("Test Button 1"));
			cameraPanel.getChildren().add(new Button("Test Button 2"));
			cameraPanel.getChildren().add(new Button("Test Button 3"));
			cameraPanel.getChildren().add(new Button("Test Button 4"));

			n.setPanel(cameraPanel);

			nodes.add(n);
		});

		box.getChildren().add(btn);

		btn = new Button("Add Laser-1");
		btn.setOnAction(e -> {
			final HalcyonNode n = new HalcyonNode("Laser-1", HalcyonNodeTypeExample.TWO);
			final VBox laserPanel = new VBox();

			laserPanel.getChildren().add(new Label("Label1"));
			laserPanel.getChildren().add(new TextField("TextField1"));
			laserPanel.getChildren().add(new Label("Label2"));
			laserPanel.getChildren().add(new TextField("TextField2"));

			n.setPanel(laserPanel);

			nodes.add(n);
		});

		box.getChildren().add(btn);

		btn = new Button("Add Laser-2");
		btn.setOnAction(e -> {
			final HalcyonNode n = HalcyonNode.wrap(	"Laser-2",
																							HalcyonNodeTypeExample.ONE,
																							new VBox());
			nodes.add(n);
		});

		box.getChildren().add(btn);

		btn = new Button("Test Std Out");
		btn.setOnAction(e -> {

			for (int i = 0; i < 2000; i++)
			{
				System.out.println("" + i + " " + "Console Test");
			}

		});

		box.getChildren().add(btn);

		btn = new Button("Test Std Err");
		btn.setOnAction(e -> {

			for (int i = 0; i < 2000; i++)
			{
				System.err.println("" + i + " " + "Console Test");
			}

		});

		box.getChildren().add(btn);

		// Wavelength color check
		btn = new Button("488");
		btn.setStyle("-fx-background-color: #0FAFF0");
		box.getChildren().add(btn);
	}
}