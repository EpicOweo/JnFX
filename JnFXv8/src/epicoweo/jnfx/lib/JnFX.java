package epicoweo.jnfx.lib;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class JnFX {

    public HashMap<String, LoadedFile> loadedFiles = new HashMap<String, LoadedFile>();

    public JnFX() {

    }

    public void loadFile(String name, String path) throws FileNotFoundException {
        LoadedFile file = new LoadedFile(name, path);
        loadedFiles.put(name, file);
    }

    public LoadedFile getFile(String name) {
        return loadedFiles.get(name);
    }

    public void createFile(String path) {
        File file = new File(path);
        if(file.exists()) {
            System.out.println("File already exists!");
            return;
        }
        file.mkdirs();
    }

    public void createFile(String path, boolean loadFile, String name) throws FileNotFoundException {
        createFile(path);
        if(loadFile == true) loadFile(name, path);
    }

    public void deleteFile(File file) throws FileNotFoundException {
        if(file.exists()) {
            file.delete();
        } else {
            throw new FileNotFoundException("File does not exist!");
        }
    }

    public void renameFile(File file, String name) {
        String filenameArr[] = file.getAbsolutePath().split("(\\.+)$");
        File dest = new File(file.getAbsolutePath().substring(filenameArr[filenameArr.length-1].length()) + name);
        file.renameTo(dest);
    }
}