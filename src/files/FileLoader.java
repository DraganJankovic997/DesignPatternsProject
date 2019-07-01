package files;

import java.io.File;

public class FileLoader implements AssetLoader {

	private AssetLoader assetLoader;
	
	public FileLoader(AssetLoader al) {
		this.assetLoader = al;
	}
	@Override
	public void loadFile(File file) {
		assetLoader.loadFile(file);
	}

	@Override
	public void saveFile(File file) {
		assetLoader.saveFile(file);
	}

}
