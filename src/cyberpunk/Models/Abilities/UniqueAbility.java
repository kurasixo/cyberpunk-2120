package cyberpunk.Models.Abilities;

public class UniqueAbility {
  String name;
  String description;

  public UniqueAbility(
    String name,
    String description
  ) {
    this.name = name;
    this.description = description;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }
}
