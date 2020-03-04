package cyberpunk.Models.Inventory;

public final class Item {
  ItemType itemType;
  String name;
  String description;
  float weight;

  public Item(String name) {
    this.name = name;
  }

  public float getWeight() {
    return weight;
  }

  public ItemType getItemType() {
    return itemType;
  }

  @Override
  public String toString() {
    return this.name;
  }
}
