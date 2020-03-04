package cyberpunk.GameEngine;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Entry extends Canvas {
  private Graphics g;

  public Entry() {
    CyberpunkObjectHandler handler = new CyberpunkObjectHandler();

    createWindow();
    createGraphics();

    GameLoop gameLoop = new GameLoop(handler, g);
    gameLoop.start();
  }

  private void createWindow() {
//    JFrame frame = new JFrame("Cyberpunk-2120");
  }

  private void createGraphics() {
    BufferStrategy bs = this.getBufferStrategy();
    if (bs == null) {
      this.createBufferStrategy(1);
      return;
    }

    Graphics g = bs.getDrawGraphics();
    g.dispose();
    bs.show();

    this.g = g;
  }
}
