package cyberpunk.GameEngine;

import java.awt.*;
import java.util.LinkedList;


// Singletone
public class CyberpunkObjectHandler extends Canvas {
  LinkedList<CyberpunkObject> cyberpunkObjects;

  public CyberpunkObjectHandler() {
    this.cyberpunkObjects = new LinkedList<>();
  }

  public void addCyberpunkObject(CyberpunkObject cyberpunkObject) {
    this.cyberpunkObjects.add(cyberpunkObject);
  }

  public void removeCyberpunkObject(CyberpunkObject cyberpunkObject) {
    this.cyberpunkObjects.remove(cyberpunkObject);
  }

  public void tick() {
    for (CyberpunkObject cyberpunkObject : this.cyberpunkObjects) {
      cyberpunkObject.tick();
    }
  }

  public void render(Graphics g) {
    for (CyberpunkObject cyberpunkObject : this.cyberpunkObjects) {
      cyberpunkObject.render(g);
    }
  }
}
