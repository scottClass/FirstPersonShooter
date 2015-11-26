
import java.awt.AWTException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Scott
 */
public class Game {

    /**
     * Runs the game
     *
     * @throws AWTException because of robot in GameWindow
     */
    private void run() throws AWTException {
        Scene s = new Scene("a", "IMG_001", true, 'f');
        s.getImage();
        GameWindow window = new GameWindow(s);

        boolean done = false;
        while (!done) {
            window.repaint();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @param args the command line arguments
     * @throws java.awt.AWTException
     */
    public static void main(String[] args) throws AWTException {
        Game main = new Game();
        main.run();
    }

}
