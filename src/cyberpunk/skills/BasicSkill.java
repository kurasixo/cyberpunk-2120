package cyberpunk.skills;

public class BasicSkill {
  String name;
  String description;

  public BasicSkill(String name, String description) {
    this.name = name;
    this.description = description;
  }

  @Override
  public String toString() {
    return this.name;
  }
}
