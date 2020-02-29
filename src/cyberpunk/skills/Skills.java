package cyberpunk.skills;

import java.util.Arrays;
import java.util.HashMap;

import static cyberpunk.skills.BasicSkills.*;

public final class Skills {
  private static BasicSkill[] basicSkillsArray = new BasicSkill[8];

  private static void fillBasicSkillArray() {
    basicSkillsArray[0] = BasicIntellect;
    basicSkillsArray[1] = BasicReflex;
    basicSkillsArray[2] = BasicCool;
    basicSkillsArray[3] = BasicAttractive;
    basicSkillsArray[4] = BasicLuck;
    basicSkillsArray[5] = BasicMove;
    basicSkillsArray[6] = BasicBody;
    basicSkillsArray[7] = BasicEmpathy;
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
