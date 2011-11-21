/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ict306lab.MikeHan.majorassignment.ass02;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
 *
 * @author mmhan
 */
public class FileHelper {
    
    public static boolean exists(String filename){
        File f = new File(filename);
        return f.exists();
    }
    
    public static boolean isReadable(String filename) throws IOException{
        FileReader fr = new FileReader(filename);
        return true;
    }
    public static boolean isReadableImage(String filename) throws IOException{
        File input = new File(filename);
        BufferedImage img = ImageIO.read(input);       
        return true;
    }
    public static boolean isWritable(String filename) throws IOException{
        FileWriter fw = new FileWriter(filename);
        return true;
    }
    
}
