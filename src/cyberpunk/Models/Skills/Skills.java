package cyberpunk.Models.Skills;

import java.util.HashMap;

import static cyberpunk.Models.Skills.BasicSkills.*;

public final class Skills {
  private static BasicSkill[] basicSkillsArray = new BasicSkill[8];

  private static void fillBasicSkillArray() {
    basicSkillsArray[0] = Intellect;
    basicSkillsArray[1] = Reflex;
    basicSkillsArray[2] = Cool;
    basicSkillsArray[3] = Attractive;
    basicSkillsArray[4] = Luck;
    basicSkillsArray[5] = Move;
    basicSkillsArray[6] = Body;
    basicSkillsArray[7] = Empathy;
  }

  public static HashMap<BasicSkill, Float> putPointsToSkills(float[] skillPoints) {
    fillBasicSkillArray();
    HashMap<BasicSkill, Float> skillsMap = new HashMap<>();

    int i = 0;
    for (float skillPoint: skillPoints) {
      skillsMap.put(basicSkillsArray[i], skillPoint);
      i++;
    }

    return skillsMap;
  }
}
