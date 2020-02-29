package cyberpunk.abilities;

import cyberpunk.skills.BasicSkills;

import java.util.HashMap;

public final class Abilities {
  public static HashMap<Ability, Float> putPointsToAbilities(
    Ability[] abilities,
    float[] abilitiesSkillPoints
  ) {
    HashMap<Ability, Float> abilitiesMap = new HashMap<>();

    int i = 0;
    for (float skillPoint: abilitiesSkillPoints) {
      abilitiesMap.put(abilities[i], skillPoint);
      i++;
    }

    return abilitiesMap;
  }
}