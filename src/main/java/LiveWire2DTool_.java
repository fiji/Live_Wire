import ij.IJ;
import ij.ImageJ;
import ij.ImagePlus;
import ij.gui.Toolbar;
import ij.plugin.PlugIn;

public class LiveWire2DTool_ extends LiveWireTool implements PlugIn {

	public String kindSpecifier() {
		return "area";
	}

	public boolean isArea() {
		return true;
	}
}
