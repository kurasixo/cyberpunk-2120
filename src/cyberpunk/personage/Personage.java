package cyberpunk.personage;

public class Personage {
  String name;
  Stats stats;
  CharClass charClass;
  Ability[] abilities;

  public Personage(
    String name,
    Stats stats,
    CharClass charClass,
    Ability[] abilities
  ) {
    this.name = name;
    this.stats = stats;
    this.charClass = charClass;
    this.abilities = abilities;

    System.out.println("create char");
  }

  @Override
  public String toString() {
    return "Hi, I am Satsugai";
  }
}
