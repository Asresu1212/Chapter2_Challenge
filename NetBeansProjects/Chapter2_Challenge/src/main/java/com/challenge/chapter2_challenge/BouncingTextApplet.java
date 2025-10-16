import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class BouncingTextApplet extends Applet implements Runnable {
    private Thread animationThread;
    private int x = 0;
    private String name = "YourName"; // Replace with your actual name
    private boolean running = false;

    public void init() {
        setSize(400, 100);
        setBackground(Color.BLACK);
    }

    public void start() {
        if (animationThread == null) {
            running = true;
            animationThread = new Thread(this);
            animationThread.start();
        }
    }

    public void stop() {
        running = false;
        animationThread = null;
    }

    public void run() {
        while (running) {
            x += 5;
            if (x > getWidth()) {
                x = 0;
            }
            repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // Handle interruption
            }
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.GREEN);
        g.drawString(name, x, 50);
    }
}
