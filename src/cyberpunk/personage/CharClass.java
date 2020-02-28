package cyberpunk.personage;

public class CharClass {
  String className;
  Ability uniqueAbility;

  public CharClass(
    String className,
    Ability uniqueAbility
  ) {
    this.className = className;
    this.uniqueAbility = uniqueAbility;
  }
}