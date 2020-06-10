package epicoweo.jnfx.lib;

import java.io.File;
import java.io.FileNotFoundException;

public class LoadedFile extends File {
    
    private static final long serialVersionUID = 1L;

    private final String path;
    private final String name;

    private final boolean isEmpty;

    public LoadedFile(String name, String path) throws FileNotFoundException {
        super(path);

        if(!this.exists()) {
            throw new FileNotFoundException("The file '" + path + "' does not exist!");
        }

        this.path = path;
        this.name = name;

        if(this.list().length != 0) {
            this.isEmpty = false;
        } else {
            this.isEmpty = true;
        }
    }

    public String getPath() {
        return path;
    }
    public String getName() {
        return name;
    }
    public boolean isEmpty() {
        return isEmpty;
    }
}