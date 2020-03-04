package cyberpunk.Models.Personage;

import java.util.HashMap;

import cyberpunk.GameEngine.GameId;
import cyberpunk.Models.Abilities.*;
import cyberpunk.Models.Skills.Skills;
import cyberpunk.Models.Skills.BasicSkill;
import cyberpunk.Models.Skills.BasicSkills;
import cyberpunk.Models.Inventory.Inventory;

import cyberpunk.GameEngine.CyberpunkObject;


interface AbstractPersonage {
  int maxHealthPoints = 12;
  int minHealthPoints = -28;

  float getSkillPoints(Ability ability);
  float getSkillPoints(BasicSkill basicSkill);

  void getDamage(float damage);
}

// rename
interface withDamage {
  public void doDamage(float damage);
}

public class Personage extends CyberpunkObject implements AbstractPersonage, withDamage {
  String name;
  CharClass charClass;

  boolean isInConsciousness = true;
  int healhPoints = this.maxHealthPoints;

  float money = 0;

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
    super(0,0, GameId.PLAYER);
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

  @Override
  public void getDamage(float damage) {
    // deal with counting damage
  }

  @Override
  public void doDamage(float damage) {
    // deal with counting damage
  }
}
