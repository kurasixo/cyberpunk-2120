package cyberpunk.Models.Abilities;

import cyberpunk.Models.Skills.BasicSkill;


public class Ability extends UniqueAbility {
  BasicSkill basicSkill;

  public Ability(
    String name,
    String description,
    BasicSkill basicSkill
  ) {
    super(name, description);
    this.basicSkill = basicSkill;
  }

  public BasicSkill getBasicSkill() {
    return basicSkill;
  }

  @Override
  public String toString() {
    return this.name;
  }
}
