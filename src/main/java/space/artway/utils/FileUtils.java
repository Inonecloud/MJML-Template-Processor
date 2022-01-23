package space.artway.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {

    private FileUtils(){

    }

    public static String readFileAsString(String path){
        try {
            return  Files.readString(Paths.get(ClassLoader.getSystemResource(path).toURI()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}
