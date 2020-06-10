package test;

import java.io.File;
import java.io.FileNotFoundException;

import epicoweo.jnfx.lib.JnFX;

public class Main {

    public static final String mainDir = System.getProperty("user.dir");
    public static void main(String[] args) {
        try{
            JnFX jnFX = new JnFX();
            jnFX.deleteFile(new File(mainDir + "\\sup"));
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}