package cyberpunk.personage;

import cyberpunk.abilities.*;
import cyberpunk.inventory.Inventory;
import cyberpunk.skills.BasicSkill;
import cyberpunk.skills.BasicSkills;
import cyberpunk.skills.Skills;

import java.util.HashMap;

interface AbstractPersonage {
  float getSkillPoints(Ability ability);
  float getSkillPoints(BasicSkill basicSkill);
}

public class Personage implements AbstractPersonage {
  String name;
  CharClass charClass;

  int healhPoints = 12;
  boolean isInConsciousness = true;

  HashMap<BasicSkill, Float> skills;
  HashMap<Ability, Float> abilities;

  Inventory inventory;

  public Personage(
    String name,
    CharClass charClass,
    float uniqueAbilitySkillPoints,

    float[] skillPoints,
    float[] simpleAbilitiesSkillPoints,
    Ability[] simpleAbilities
  ) {
    this.name = name;
    this.charClass = charClass;

    this.skills = Skills.putPointsToSkills(skillPoints);
    this.abilities = this.mergeUniqueAndSimpleAbilities(
      simpleAbilities,
      simpleAbilitiesSkillPoints,

      charClass.getUniqueAbility(),
      uniqueAbilitySkillPoints
    );

    this.inventory = new Inventory();
  }

  private HashMap<Ability, Float> mergeUniqueAndSimpleAbilities(
    Ability[] simpleAbilities,
    float[] simpleAbilitiesSkillPoints,

    UniqueAbility uniqueAbility,
    float uniqueAbilitySkillPoints
  ) {
    HashMap<Ability, Float> abilities = new HashMap<>(
      Abilities.putPointsToAbilities(simpleAbilities, simpleAbilitiesSkillPoints)
    );

    Ability uniqueAbilityAsSimple = new Ability(
      uniqueAbility.getName(),
      uniqueAbility.getDescription(),
      BasicSkills.NullSkill
    );

    abilities.put(uniqueAbilityAsSimple, uniqueAbilitySkillPoints);
    return abilities;
  }

  @Override
  public float getSkillPoints(Ability ability) {
    float basicSkillPoints = this.skills.get(ability.getBasicSkill());
    if (this.abilities.containsKey(ability)) {
      return this.abilities.get(ability) + basicSkillPoints;
    }

    return basicSkillPoints;
  }

  @Override
  public float getSkillPoints(BasicSkill basicSkill) {
    return this.skills.get(basicSkill);
  }

  private void doDamage(float damage) {

  }
}
