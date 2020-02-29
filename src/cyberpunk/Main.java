package cyberpunk;

import cyberpunk.abilities.Ability;
import cyberpunk.personage.Personage;
import cyberpunk.personage.CharClasses;
import cyberpunk.skills.BasicSkills;


class App {
  public static void main(String[] args) {
    String name = "Satsugai";
    float[] skillPoints = {6, 9, 9, 9, 9, 9, 9, 3};
    float[] abilitiesSkillPoints = {9};
    Ability[] abilities = {new Ability("Rifle", "Rifle to shoot", BasicSkills.BasicReflex)};

    Personage Satsugai = new Personage(
      name,
      CharClasses.soloClass,
      9,
      skillPoints,
      abilitiesSkillPoints,
      abilities
    );

    System.out.println(Satsugai);
  }
}

