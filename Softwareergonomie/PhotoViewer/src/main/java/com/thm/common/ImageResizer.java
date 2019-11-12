package com.thm.common;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * This program demonstrates how to resize an image.
 *
 * @author www.codejava.net
 *
 */
public class ImageResizer {

    /**
     * Resizes an image to a absolute width and height (the image may not be
     * proportional)
     * @param inputImagePath Path of the original image
     * @param outputImagePath Path to save the resized image
     * @param scaledWidth absolute width in pixels
     * @param scaledHeight absolute height in pixels
     * @throws IOException
     */
    public static void resize(File inputFile, int scaledHeight)
            throws IOException {
        BufferedImage inputImage = ImageIO.read(inputFile);

        double ratio = (double)inputImage.getWidth() / inputImage.getHeight();
        int scaledWidth = (int) (ratio * scaledHeight);

        // creates output image
        BufferedImage outputImage = new BufferedImage(scaledWidth,
                scaledHeight, inputImage.getType());

        // scales the input image to the output image
        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
        g2d.dispose();

        // extracts extension of output file
        String outputImagePath = inputFile.getParent() + "/compressed/" + inputFile.getName();

        // writes to output file
        ImageIO.write(outputImage, "jpg", new File(outputImagePath));
    }



    /**
     * Test resizing images
     */
    public static void main(String[] args) throws IOException {
        File dir = new File("C:\\Users\\dstah\\Programming\\Studium\\Softwareergonomie\\PhotoViewer\\wallpaper");
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                if(child.getName().contains(".jpg")) {
                    resize(child, 200);
                }
            }
        } else {
            // Handle the case where dir is not really a directory.
            // Checking dir.isDirectory() above would not be sufficient
            // to avoid race conditions with another process that deletes
            // directories.
        }
    }

}
