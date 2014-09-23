import ij.IJ;
import ij.ImageJ;
import ij.ImagePlus;
import ij.gui.Toolbar;
import ij.plugin.PlugIn;

public class LiveWire1DTool_ extends LiveWireTool implements PlugIn {

	public LiveWire1DTool_() {
	}

	public static void main(final String[] args) {
		// set the plugins.dir property to make the plugin appear in the Plugins menu
		final Class<?> clazz = LiveWire1DTool_.class;
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
