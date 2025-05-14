package Final;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Screen extends JPanel implements KeyListener, MouseMotionListener, MouseWheelListener {

    double sleepTime = 1000 / 60, lastRefresh = 0;
    static double[] viewFrom = new double[] { 7, 7, 1 };
    static double[] viewTo = new double[] { 1,1,0 };
    static ArrayList<DPoly> dPolygons = new ArrayList<DPoly>();
    static ArrayList<testGeometry> shapes = new ArrayList<testGeometry>();
    static ArrayList<Rectangle> colRects = new ArrayList<Rectangle>();
    int[] newOrder;
    boolean[] keys = new boolean[6];
    static double zoom = 1000, minZoom = 500, maxZoom = 2500, mouseX = 0, mouseY = -100, moveSpeed = 2;
    double vertLook = 0, horLook = 0, horRotSpd = 900, vertRotSpd = 2200;
    boolean gravity = false;

    public Screen() {
        this.addMouseMotionListener(this);
        this.addKeyListener(this);
        this.addMouseWheelListener(this);
        setFocusable(true);
        invisibleMouse();
        
        makeWorld();
    }

    public void paintComponent(Graphics g) {
        g.setColor(new Color(140, 180, 180));
        g.fillRect(0, 0, (int)Main.screenSize.getWidth(), (int)Main.screenSize.getHeight());
        
        controls();
        PointCalc.setStartingInfo();
        setOrder();
        for (int i = 0; i < shapes.size(); i++) {
            shapes.get(i).updatePoly();
        }

        for (int i = 0; i < dPolygons.size(); i++) {
            
            dPolygons.get(i).updatePolygon();
        }
        
        for (int i = 0; i < newOrder.length; i++) {
            dPolygons.get(newOrder[i]).drawablePolygon.drawPolygon(g);

        }
        g.drawString(System.currentTimeMillis() + "", 20, 20);
        updateView();
        sleepAndRefresh();
    }

    void sleepAndRefresh() {
        while (true) {
            if (System.currentTimeMillis() - lastRefresh > sleepTime) {
                repaint();
                break;
            } else {
                try {
                    Thread.sleep((long) sleepTime - ((long) (System.currentTimeMillis() - lastRefresh)));
                } catch (Exception e) {

                }
            }
        }lastRefresh = System.currentTimeMillis();
                
    }

    void makeWorld() {
        shapes.add(new testGeometry(0, 0, 0, 5, 5, 5, Color.gray));
        shapes.add(new testGeometry(0,0, 0, 10, 10, 0, Color.green));

        for (int i = -10; i < 10; i++) {
            for (int j = -10; j < 10; j++) {
                shapes.add(new testGeometry(i,0, 0, 1, 1, 0, Color.green));
                shapes.add(new testGeometry(0, i, 0, 1, 1, 0, Color.red));
            }
            
            
        }
        
    }

    void setOrder()
	{
		double[] k = new double[dPolygons.size()];
		newOrder = new int[dPolygons.size()];
		
		for(int i = 0; i < dPolygons.size(); i++)
		{
			k[i] = dPolygons.get(i).avgDist;	
			newOrder[i] = i;
		}
		
	    double temp;
	    int tempr;	    
		for (int a = 0; a < k.length-1; a++)
			for (int b = 0; b < k.length-1; b++)
				if(k[b] < k[b + 1])
				{
					temp = k[b];
					tempr = newOrder[b];
					newOrder[b] = newOrder[b + 1];
					k[b] = k[b + 1];
					   
					newOrder[b + 1] = tempr;
					k[b + 1] = temp;
				}
	}

    void controls() {
        Vector viewVector = new Vector(viewTo[0] - viewFrom[0], viewTo[1] - viewFrom[1], viewTo[2] - viewFrom[2]);
        double moveX = 0, moveY = 0, moveZ = 0;
        Vector vertVector = new Vector(0, 0, 1);
        Vector sideVector = viewVector.crossProduct(vertVector);

		if(keys[0]) {
			moveX += viewVector.x;
            moveY += viewVector.y;
            moveZ += viewVector.z;
		}
		
		if(keys[2]) {
			moveX -= viewVector.x;
            moveY -= viewVector.y;
            moveZ -= viewVector.z;
		}
    
        if(keys[1]) {
			moveX += sideVector.x;
            moveY += sideVector.y;
            moveZ += sideVector.z;
		}

        if(keys[3]) {
			moveX -= sideVector.x;
            moveY -= sideVector.y;
            moveZ -= sideVector.z;
		}

        if(keys[4]) {
			moveZ += 1;
		}
        if(keys[5])
		{
			moveZ -= 1;
		}

        Vector moveVector = new Vector(moveX, moveY, moveZ);
        moveTo(viewFrom[0] + moveVector.x*moveSpeed, viewFrom[1] + moveVector.y*moveSpeed, viewFrom[2] + moveVector.z*moveSpeed);
    }

    boolean collisionDetection() {
        
        return(false);
    }

    void moveTo(double x, double y, double z) {
        viewFrom[0] = x;
        viewFrom[1] = y;
        viewFrom[2] = z;

        // if (!collisionDetection()) {
        //     viewFrom[2]--;
        // }
        
        updateView();
    }

    void updateView() {
        double r= Math.sqrt(1 - vertLook*vertLook);

        viewTo[0] = viewFrom[0] + r * Math.cos(horLook);
        viewTo[1] = viewFrom[1] + r * Math.sin(horLook);
        viewTo[2] = viewFrom[2] + vertLook;
    }

    public void mouseWheelMoved(MouseWheelEvent e) {
        if (e.getUnitsToScroll() > 0) {
            if (zoom > minZoom) {
                zoom -= 25 * e.getUnitsToScroll();
            }

        } else {
            if (zoom < maxZoom) {
                zoom -= 25 * e.getUnitsToScroll();
            }
        }
    }

    public void mouseDragged(MouseEvent e) {
        MouseMovement(e.getX(), e.getY());
        mouseX = e.getX();
        mouseY = e.getY();
        centerMouse();
        
    }

    public void mouseMoved(MouseEvent e) {
        MouseMovement(e.getX(), e.getY());
        mouseX = e.getX();
        mouseY = e.getY();
        centerMouse();
    }

    void MouseMovement(double newMX, double newMY) {
        double dx = newMX - Main.screenSize.getWidth()/2;
        double dy = newMY - Main.screenSize.getHeight()/2;
        dy *= 6 - Math.abs(vertLook) * 5;
        vertLook -= dy/vertRotSpd;
        horLook += dx/horRotSpd;

        if (vertLook > .999) {
            vertLook = .999;
        }
        if (vertLook < -.999) {
            vertLook = -.999;
        }
        updateView();
    }

    public void centerMouse() {
        try {
            Robot r = new Robot();
            r.mouseMove((int)Main.screenSize.getWidth()/2, (int)Main.screenSize.getHeight()/2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void invisibleMouse() {
        Toolkit tools = Toolkit.getDefaultToolkit();
        BufferedImage cursorImage = new BufferedImage(1, 1, BufferedImage.TRANSLUCENT);
        Cursor invCursor = tools.createCustomCursor(cursorImage, new Point(0, 0), "InvisibleCursor");

        setCursor(invCursor);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            keys[0] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            keys[1] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            keys[2] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            keys[3] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            keys[4] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
            keys[5] = true;
        }
         
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            keys[0] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            keys[1] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            keys[2] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            keys[3] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            keys[4] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
            keys[5] = false;
        }
    }

    public void keyTyped(KeyEvent e) {

    }

}
