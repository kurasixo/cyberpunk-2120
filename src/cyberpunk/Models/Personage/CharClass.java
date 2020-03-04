package cyberpunk.Models.Personage;

import cyberpunk.Models.Abilities.UniqueAbility;

public final class CharClass {
  String className;
  UniqueAbility uniqueAbility;

  public CharClass(
    String className,
    UniqueAbility uniqueAbility
  ) {
    this.className = className;
    this.uniqueAbility = uniqueAbility;
  }

  public UniqueAbility getUniqueAbility() {
    return uniqueAbility;
  }

  @Override
  public String toString() {
    return
      "Class: " +
        this.className +
        "\n" +
        "Unique ability: " +
        this.uniqueAbility.getName();
  }
}