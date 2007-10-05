import ij.IJ;
import ij.ImagePlus;
import ij.Macro;
import ij.gui.Toolbar;
import ij.plugin.MacroInstaller;

import java.awt.event.MouseListener;

import livewire.LiveWire;

public class LiveWireTool {

	public static int toolID = 0;

	public static int getToolID() {
		return toolID;
	}
	
	public String kindSpecifier() {
		return "line";
	}
	
	public void run(String arg) {
		String options = Macro.getOptions();
		ImagePlus image = IJ.getImage();
		LiveWire wire = null;
		boolean hasLiveWire = false;
		int x = -1;
		int y = -1;
		if (options != null && !options.contains("x0") && !options.equals("options ")) {
			// called from toolsets macro, get x and y to set the first point 
			x = this.getXOption(options);
			y = this.getYOption(options);
		}
		if (options != null && !options.contains("x0")) {
			Macro.setOptions(null);
		}
		MouseListener[] listener = image.getCanvas().getMouseListeners();
		for (int i=0; i<listener.length; i++) {
			if (listener[i].getClass().getName().contains("LiveWire")){
				wire = (LiveWire) listener[i];
				hasLiveWire=true;
				if (wire.isArea() && !this.isArea() || !wire.isArea() && this.isArea()) {
					image.getCanvas().removeMouseListener(wire);
					image.getCanvas().removeMouseMotionListener(wire);
					image.getWindow().removeWindowListener(wire);
					hasLiveWire = false;
				}
			}
		}
		if (options==null ) {	// the plugin has been called directly, not from the macro or toolset macro
			boolean change = true;
			if (this.isArea() && Toolbar.getToolId()==Toolbar.getInstance().getToolId("LiveWire 2d Tool")) change=false;
			if (!this.isArea() && Toolbar.getToolId()==Toolbar.getInstance().getToolId("LiveWire 1d Tool")) change=false;
			if (change) {
				String path = IJ.getDirectory("macros")+"toolsets/"+"Tracing"+".txt";
				new MacroInstaller().run(path);
			}
			int id = -1;
			if (isArea()) id = Toolbar.getInstance().getToolId("LiveWire 2d Tool");
			else id = Toolbar.getInstance().getToolId("LiveWire 1d Tool");
			options = "";
			IJ.setTool(id);
		}
		if (!hasLiveWire) {
			wire = new LiveWire();
			wire.setup(kindSpecifier(), image);
			wire.run(image.getProcessor());
			if (x!=-1) wire.handleMouseButton1Pressed(x, y);
		}
		if (options.equals("options ")) {
			wire.getFrame().setVisible(true);
		}
	}

	protected int getYOption(String options) {
		String[] theOptions = options.split(" ");
		String yOption = theOptions[1];
		int result = Integer.parseInt(yOption.split("=")[1]);
		return result;
	}

	protected int getXOption(String options) {
		String[] theOptions = options.split(" ");
		String xOption = theOptions[0];
		int result = Integer.parseInt(xOption.split("=")[1]);
		return result;
	}

	public boolean isArea() {
		return false;
	}
}
