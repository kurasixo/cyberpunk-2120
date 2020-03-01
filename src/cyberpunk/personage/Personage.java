package cyberpunk.personage;

import cyberpunk.abilities.*;
import cyberpunk.skills.BasicSkill;
import cyberpunk.skills.BasicSkills;
import cyberpunk.skills.Skills;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

interface AbstractPersonage {
  float getSkillPoints(Ability ability);
  float getSkillPoints(BasicSkill basicSkill);
}

public class Personage implements AbstractPersonage {
  String name;
  int healhPoints = 12;
  CharClass charClass;
  HashMap<BasicSkill, Float> skills;
  HashMap<Ability, Float> abilities;

  public Personage(
    String name,
    CharClass charClass,
    float uniqueAbilityPoints,

    float[] skillPoints,
    float[] abilitiesSkillPoints,
    Ability[] abilities
  ) {
    this.name = name;
    this.charClass = charClass;

    this.skills = Skills.putPointsToSkills(skillPoints);
    this.abilities = Abilities.putPointsToAbilities(abilities, abilitiesSkillPoints);

    uniqueToSimpleAbilities(
      charClass.getUniqueAbility(),
      uniqueAbilityPoints
    );
  }

  private void uniqueToSimpleAbilities(
    UniqueAbility uniqueAbility,
    float uniqueAbilityPoints
  ) {
    Ability uniqueAbilityAsSimple = new Ability(
      uniqueAbility.getName(),
      uniqueAbility.getDescription(),
      BasicSkills.NullSkill
    );

    this.abilities.put(uniqueAbilityAsSimple, uniqueAbilityPoints);
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

  private static <K, V>String getStringByHashMap(String stringStart, HashMap<K, V> hashMap) {
    StringBuilder resultString = new StringBuilder();

    resultString.append(stringStart);

    for (K key : hashMap.keySet()) {
      resultString
        .append("\n")
        .append(key.toString())
        .append(": ")
        .append(hashMap.get(key));
    }

    return resultString.toString();
  }

  @Override
  public String toString() {
    String skillsString = getStringByHashMap("Skills: ", this.skills);
    String abilitiesString = getStringByHashMap("Abilities: ", this.abilities);

    return
      "Name: " +
        this.name +
        "\n" +
        this.charClass.toString() +
        "\n" +
        "\n" +
        skillsString +
        "\n" +
        "\n" +
        abilitiesString;
  }
}
