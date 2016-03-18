import java.io.File;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
/**
 * 
 * @author eyez
 *
 */
public class SimpleButtonFileDialog{
	private JComponent parent;
	private static final long serialVersionUID = -7420046733606681888L;
	/**
	 * 
	 * @param Center_piece
	 */
	public SimpleButtonFileDialog(JComponent Center_piece) {
		parent = Center_piece;
	}
	/**
	 * Opens prompt window that allows the user to navigate through files to the
	 * desired file to Load from
	 * 
	 * @return
	 */
	public File toLoadFile() {
		JFileChooser fileFinder = new JFileChooser();
		fileFinder.setCurrentDirectory(new File(System.getProperty("user.home")));

		if (fileFinder.showOpenDialog(parent) == JFileChooser.APPROVE_OPTION)
			return fileFinder.getSelectedFile();
		else
			return null;
	}

	/**
	 * Opens prompt window that allows the user to navigate through files to the
	 * desired file to save to
	 * 
	 * @param extension_types
	 * @param description
	 * @return
	 */
	public File toLoadFile(String[] extension_types, String description) {
		JFileChooser fileFinder = new JFileChooser();
		fileFinder.addChoosableFileFilter(new SimpleFileFilter(extension_types, description));
		fileFinder.setCurrentDirectory(new File(System.getProperty("user.home")));

		if (fileFinder.showOpenDialog(parent) == JFileChooser.APPROVE_OPTION)
			return fileFinder.getSelectedFile();
		else
			return null;
	}
	/**
	 * Opens prompt window that allows the user to navigate through files to the
	 * desired file to Load from
	 * 
	 * @param extension_types
	 * @param description
	 * @return
	 */
	public File toLoadFile(String[][] extension_types, String[] description) {
		if (extension_types.length != description.length)
			return null;

		JFileChooser fileFinder = new JFileChooser();
		fileFinder.setCurrentDirectory(new File(System.getProperty("user.home")));
		for (int i = 0; i < description.length; i++)
			fileFinder.addChoosableFileFilter(new SimpleFileFilter(extension_types[i], description[i]));

		if (fileFinder.showOpenDialog(parent) == JFileChooser.APPROVE_OPTION)
			return fileFinder.getSelectedFile();
		else
			return null;
	}
	/**
	 * Opens prompt window that allows the user to navigate through files to the
	 * desired file to save to
	 * 
	 * @return Path of the user Selected file
	 */
	public File toSaveFile() {
		JFileChooser fileFinder = new JFileChooser();
		fileFinder.setCurrentDirectory(new File(System.getProperty("user.home")));

		if (fileFinder.showSaveDialog(parent) == JFileChooser.APPROVE_OPTION) {
			return fileFinder.getSelectedFile();
		} else {
			return null;
		}
	}
	/**
	 * Opens prompt window that allows the user to navigate through files to the
	 * desired file to save to
	 * 
	 * @param extension_types
	 * @param description
	 * @return
	 */
	public File toSaveFile(String[] extension_types, String description) {
		JFileChooser fileFinder = new JFileChooser();
		fileFinder.addChoosableFileFilter(new SimpleFileFilter(extension_types, description));
		fileFinder.setCurrentDirectory(new File(System.getProperty("user.home")));

		if (fileFinder.showSaveDialog(parent) == JFileChooser.APPROVE_OPTION)
			return fileFinder.getSelectedFile();
		else
			return null;
	}
	/**
	 * Opens prompt window that allows the user to navigate through files to the
	 * desired file to save to
	 * 
	 * @param extension_types
	 * @param description
	 * @return
	 */
	public File toSaveFile(String[][] extension_types, String[] description) {
		if (extension_types.length != description.length)
			return null;

		JFileChooser fileFinder = new JFileChooser();
		fileFinder.setCurrentDirectory(new File(System.getProperty("user.home")));
		for (int i = 0; i < description.length; i++)
			fileFinder.addChoosableFileFilter(new SimpleFileFilter(extension_types[i], description[i]));

		if (fileFinder.showSaveDialog(parent) == JFileChooser.APPROVE_OPTION)
			return fileFinder.getSelectedFile();
		else
			return null;
	}
}

/**
 * 
 * @author eyez
 */
class SimpleFileFilter extends FileFilter {

	String[] extensions;

	String description;

	/**
	 * 
	 * @param ext
	 */
	public SimpleFileFilter(String ext) {
		this(new String[] { ext }, null);
	}

	/**
	 * 
	 * @param exts
	 * @param descr
	 */
	public SimpleFileFilter(String[] exts, String descr) {
		// Clone and lowercase the extensions
		extensions = new String[exts.length];
		for (int i = exts.length - 1; i >= 0; i--) {
			extensions[i] = exts[i].toLowerCase();
		}
		// Make sure we have a valid (if simplistic) description
		description = (descr == null ? exts[0] + " files" : descr);
	}
	/**
	 * 
	 */
	public boolean accept(File f) {
		// We always allow directories, regardless of their extension
		if (f.isDirectory()) {
			return true;
		}

		// Ok, it's a regular file, so check the extension
		String name = f.getName().toLowerCase();
		for (int i = extensions.length - 1; i >= 0; i--) {
			if (name.endsWith(extensions[i])) {
				return true;
			}
		}
		return false;
	}
	/**
	 */
	public String getDescription() {
		return description;
	}
}