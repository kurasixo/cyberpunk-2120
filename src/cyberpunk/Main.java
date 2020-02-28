package cyberpunk;

import cyberpunk.personage.*;


class App {
  public static void main(String[] args) {
  String name = "Satsugai";
    Ability soloUniqueAbility = new Ability("Combat Sense", "Combat Sense");
    CharClass charClass = new CharClass("Solo", soloUniqueAbility);
    Stats stats = new Stats(6, 9, 9, 9, 9, 9, 9, 3);
    Ability[] abilities = new Ability[30];
    Personage Satsugai = new Personage(name, stats, charClass, abilities);

    System.out.println(Satsugai);
  }
}

