package cyberpunk.GameEngine;


import java.awt.*;
import java.awt.image.BufferStrategy;

// Singletone
public class GameLoop implements Runnable {
  private Graphics g;

  private Thread uiThread;
  static boolean running = false;

  private CyberpunkObjectHandler handler;

  public GameLoop(CyberpunkObjectHandler handler, Graphics g) {
    this.g = g;
    this.handler = handler;
  }

  public void run() {
    long initialTime = System.nanoTime();
    final double timeU = 1000000000 / 60;
    final double timeF = 1000000000 / 60;
    double deltaU = 0, deltaF = 0;

    while (running) {
      long currentTime = System.nanoTime();
      deltaU += (currentTime - initialTime) / timeU;
      deltaF += (currentTime - initialTime) / timeF;
      initialTime = currentTime;

      if (deltaU >= 1) {
        handler.tick();
        deltaU--;
      }

      if (deltaF >= 1) {
        render();
        deltaF--;
      }
    }
  }

  public void tick() {
    handler.tick();
  }

  public void render() {
    handler.render(this.g);
  }

  public synchronized void start() {
    uiThread = new Thread(this);
    uiThread.start();
    running = true;
  }

  public synchronized void stop() {
    try {
      uiThread.join();
      running = false;
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
