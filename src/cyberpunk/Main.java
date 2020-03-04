package cyberpunk;

import cyberpunk.GameEngine.Entry;
import cyberpunk.Models.Abilities.Ability;
import cyberpunk.Models.Skills.BasicSkills;

import cyberpunk.Models.Personage.Personage;
import cyberpunk.Models.Personage.CharClasses;


class App {
  public static void main(String[] args) {
    String name = "Satsugai";
    float[] skillPoints = {6, 9, 9, 9, 9, 9, 9, 3};
    float[] abilitiesSkillPoints = {9};

    Ability[] abilities = {
      new Ability("Rifle", "Rifle to shoot", BasicSkills.Reflex)
    };

    Personage Satsugai = new Personage(
      name,
      CharClasses.soloClass,
      9,
      skillPoints,
      abilitiesSkillPoints,
      abilities
    );

    new Entry();

    System.out.println(Satsugai.getSkillPoints(BasicSkills.Body));
  }
}

