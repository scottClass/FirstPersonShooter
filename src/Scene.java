
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Scott
 */
public class Scene {

    private String imagePath;
    private BufferedImage image;
    private char direction;
    private String location;
    private boolean frontBlocked;

    private Scene left;
    private Scene right;
    private Scene forward;

    public Scene(String location, String picture, boolean frontBlocked, char direction) {
        this.imagePath = picture;
        this.direction = direction;
        this.frontBlocked = frontBlocked;
        this.location = location;
    }

    /**
     *
     * @param s the scene to set as the left.
     */
    public void setLeft(Scene s) {
        this.left = s;
    }

    /**
     * @param s the scene to set as the left.
     */
    public void setRight(Scene s) {
        this.right = s;
    }

    /**
     *
     * @param s the scene to set forward.
     */
    public void setForward(Scene s) {
        this.forward = s;
    }

    /**
     *
     * @return the scene that is forward to the current one.
     */
    public Scene getForward() {
        return forward;
    }

    /**
     *
     * @return the scene that is to the right of the current one.
     */
    public Scene getRight() {
        return right;
    }

    /**
     *
     * @return the scene that is to the left of the current scene
     */
    public Scene getLeft() {
        return left;
    }

    /**
     * Gets the image from the scene.
     *
     * @return the image.
     */
    public BufferedImage getImage() {
        if (image == null) {
            try {
                image = ImageIO.read(new File("images\\" + imagePath));
            } catch (IOException ex) {
                Logger.getLogger(Scene.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return image;
    }

    /**
     * Gets the name of the image.
     *
     * @return the name of the image.
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * Checks if the front is blocked
     *
     * @return if front is blocked
     */
    public boolean isBlocked() {
        return frontBlocked;
    }

}
