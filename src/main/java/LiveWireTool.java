import ij.IJ;
import ij.ImagePlus;
import ij.gui.Toolbar;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import livewire.LiveWire;

public class LiveWireTool implements MouseListener {
	boolean hasLiveWire = false;
	LiveWire wire = null;
	ImagePlus image = null;

	public String kindSpecifier() {
		return "line";
	}

	public void run(String arg) {

		image = IJ.getImage();

		MouseListener[] listener = image.getCanvas().getMouseListeners();
		for (int i=0; i<listener.length; i++) {
			if(listener[i] instanceof LiveWireTool) {
				hasLiveWire = true;
			}
		}

		Toolbar.getInstance().setTool(12);
		if(!hasLiveWire)
			image.getCanvas().addMouseListener(this);

	}

	public boolean isArea() {
		return false;
	}

	public void mouseClicked(MouseEvent mouseEvent) {
		if(!hasLiveWire)
		{
			hasLiveWire = true;
			int x = mouseEvent.getX();
			int y = mouseEvent.getY();

			wire = new LiveWire();
			wire.setup(kindSpecifier(), image);
			wire.setXY(x, y);
			wire.run(image.getProcessor());
			wire.handleMouseButton1Pressed(x, y);

			wire.getFrame().setVisible(true);
			image.getCanvas().removeMouseListener(this);
		}
	}

	public void mousePressed(MouseEvent mouseEvent) {

	}

	public void mouseReleased(MouseEvent mouseEvent) {

	}

	public void mouseEntered(MouseEvent mouseEvent) {

	}

	public void mouseExited(MouseEvent mouseEvent) {

	}
}
