import fiji.Debug;

public class TestDrive {
	public static void main(String... args) {
		final String clownPath =
				System.getProperty("user.home") + "/Desktop/Fiji.app/samples/clown.jpg";
		Debug.runFilter(clownPath, "LiveWire2DTool", "");
	}
}
