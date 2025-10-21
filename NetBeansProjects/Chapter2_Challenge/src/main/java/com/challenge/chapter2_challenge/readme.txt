   BouncingTextApplet is a simple Java applet that demonstrates basic animation using the AWT (java.awt) library. The applet displays a text string (default: "YourName") that continuously moves horizontally across the screen, creating a smooth “bouncing text” effect.

Features

Simple and lightweight Java animation.

Demonstrates thread-based animation using Runnable.

Customizable background and text color.

Easy to modify text and animation speed.

How It Works

The applet starts a new thread when loaded (start() method).

The run() method updates the x-coordinate of the text periodically.

Each update triggers repaint(), causing the text to appear to move.

When the text moves off the right edge, it reappears from the left.

Code Structure
public class BouncingTextApplet extends Applet implements Runnable {
    private Thread animationThread;
    private int x = 0;
    private String name = "YourName"; // Change this to your name
    private boolean running = false;
    
    // init(): sets size and background
    // start(): begins the animation thread
    // stop(): stops the thread
    // run(): updates position and repaints
    // paint(): draws the text
}

Running the Applet
Option 1: Using Applet Viewer

Save the file as BouncingTextApplet.java.

Compile it:

javac BouncingTextApplet.java
appletviewer.html