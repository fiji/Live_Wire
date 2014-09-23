import ij.IJ;
import ij.ImageJ;
import ij.ImagePlus;
import ij.gui.Toolbar;
import ij.plugin.PlugIn;

public class LiveWire2DTool_ extends LiveWireTool implements PlugIn {

	public LiveWire2DTool_() {
	}

	public String kindSpecifier() {
		return "area";
	}

	public boolean isArea() {
		return true;
	}


	public static void main(final String[] args) {
		// set the plugins.dir property to make the plugin appear in the Plugins menu
		final Class<?> clazz = LiveWire2DTool_.class;
		final String url = clazz.getResource("/" + clazz.getName().replace('.', '/') + ".class").toString();
		final String pluginsDir = url.substring(5, url.length() - clazz.getName().length() - 6);
		System.setProperty("plugins.dir", pluginsDir);

		// start ImageJ
		new ImageJ();

		// open the Clown sample
		final ImagePlus image = IJ.openImage(args[0]);
		image.show();

		// run the plugin
		IJ.runPlugIn(clazz.getName(), "");
	}
}
