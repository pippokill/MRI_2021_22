/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.uniba.it.mri2122.tika;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;

/**
 *
 * @author pierpaolo
 */
public class TikaExtractor {

    private static Tika tika;

    private static void process(File file) throws IOException, TikaException {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            for (File f : listFiles) {
                process(f);
            }
        } else {
            if (file.isFile() && !file.getName().toLowerCase().endsWith(".txt")) {
                System.out.println("Process file: " + file.getAbsolutePath());
                String text = tika.parseToString(new FileInputStream(file));
                int idx = file.getName().lastIndexOf('.');
                if (idx < 0) {
                    idx = file.getName().length();
                }
                FileWriter writer = new FileWriter(file.getParent() + "/" + file.getName().substring(0, idx) + "_tika.txt");
                writer.append(text);
                writer.close();
            }
        }
    }

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws org.apache.tika.exception.TikaException
     */
    public static void main(String[] args) throws IOException, TikaException {
        //class for accessing Tika functionalities: provides simple methods for many common parsing and type detection operations.
        tika = new Tika();
        process(new File(args[0]));
    }

}
