
import java.awt.AWTException;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JComponent;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Scott
 */
public class GameWindow extends JComponent implements KeyListener, MouseListener, MouseMotionListener{
    private JFrame window;
    
    private int SCREEN_HIEGHT;
    private int SCREEN_WIDTH;
    private final int IMAGE_HEIGHT;
    
    private int centerX;
    private int centerY;
    private int hDisplacement;
    
    private Scene currentScene;
    
    private boolean inGame;
    private boolean escapeDown;
    
    private Cursor invisibleCursor = Toolkit.getDefaultToolkit().createCustomCursor(
            Toolkit.getDefaultToolkit().getImage(""),
            new Point(0, 0),
            "invisible");
    private Robot robot;
    
    public GameWindow(Scene s) throws AWTException {
        hDisplacement = 0;
        SCREEN_WIDTH = 1265;
        SCREEN_HIEGHT = 945;
        centerX = SCREEN_WIDTH / 2;
        centerY = SCREEN_HIEGHT / 2;
        IMAGE_HEIGHT = (int)(SCREEN_HIEGHT*0.9);
        
        currentScene = s;
        inGame = true;
        
        window = new JFrame("Game");
        window.add(this);
        window.setVisible(true);
        window.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HIEGHT));
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        robot = new Robot();
        
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        window.addKeyListener(this);
        hideCursor();
        centerMouse();
    }
    
    public void setScene(Scene s) {
        currentScene = s;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(currentScene.getImage(), -hDisplacement, (SCREEN_HIEGHT-IMAGE_HEIGHT)/2, SCREEN_WIDTH, IMAGE_HEIGHT, null);
        g.drawImage(currentScene.getLeft().getImage(), -hDisplacement-SCREEN_WIDTH, (SCREEN_HIEGHT-IMAGE_HEIGHT)/2, SCREEN_WIDTH, IMAGE_HEIGHT, null);
        g.drawImage(currentScene.getRight().getImage(), -hDisplacement+SCREEN_WIDTH, (SCREEN_HIEGHT-IMAGE_HEIGHT)/2, SCREEN_WIDTH, IMAGE_HEIGHT, null);
    }
    
    
    /**
     * hide cursor in window
     */
    private void hideCursor()
    {
        // set the current cursor to the invisible cursor image, which is simply an invisible image
        this.setCursor(invisibleCursor);
    }
    
    /**
     * shows the cursor for pausing.
     */
    private void showCursor()
    {
        // sets the cursor to the default cursor image (probably the white arrow)
        this.setCursor(Cursor.getDefaultCursor());
    }
    
    /**
     * centers the mouse in the window.
     */
    public void centerMouse()
    {
        // sets the mouse location to the middle of the screen but offset due to the actual
        // screen picture being slightly offset due to the window border and actual physical location on the screen
        robot.mouseMove((int)this.getLocationOnScreen().getX() + centerX, (int)this.getLocationOnScreen().getY() + centerY);
    }
    
    /**
     * Displays the mouse.
     */
    public void displayMouse() {
        if(inGame) {
            centerMouse();
            
        }
    }

    @Override
    public void keyTyped(KeyEvent k) {
    }

    @Override
    public void keyPressed(KeyEvent k) {
        int KeyCode = k.getKeyCode();
        if (KeyCode == KeyEvent.VK_W && inGame) {
            
        } else if (KeyCode == KeyEvent.VK_A && inGame) {
            
        } else if (KeyCode == KeyEvent.VK_S && inGame) {
            
        } else if (KeyCode == KeyEvent.VK_D && inGame) {
            
        } else if (KeyCode == KeyEvent.VK_ESCAPE) {
            if(!escapeDown) {
                inGame = inGame ? false: true;
                if(inGame) {
                    hideCursor();
                } else {
                    showCursor();
                }
            }
            escapeDown = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent k) {
        int KeyCode = k.getKeyCode();
        if(KeyCode == KeyEvent.VK_ESCAPE) {
            escapeDown = false;
        } 
    }

    @Override
    public void mouseClicked(MouseEvent m) {
        if(inGame) {
            System.out.println(m.getClickCount());
        }
    }

    @Override
    public void mousePressed(MouseEvent m) {
    }

    @Override
    public void mouseReleased(MouseEvent m) {
    }

    @Override
    public void mouseEntered(MouseEvent m) {
    }

    @Override
    public void mouseExited(MouseEvent m) {
    }

    @Override
    public void mouseDragged(MouseEvent m) {
    }

    @Override
    public void mouseMoved(MouseEvent m) {
        if (inGame)
        {
            hDisplacement += m.getX() - centerX;
            centerMouse();
        }
    }
}
