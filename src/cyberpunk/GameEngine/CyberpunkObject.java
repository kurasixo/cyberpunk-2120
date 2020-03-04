package cyberpunk.GameEngine;

import java.awt.*;

public abstract class CyberpunkObject {
  protected int x, y;
  protected GameId gameId;

  public CyberpunkObject(int x, int y, GameId gameId) {
    this.x = x;
    this.y = y;

    this.gameId = gameId;
  }

  public void tick() { }

  public void render(Graphics g) { }
}
