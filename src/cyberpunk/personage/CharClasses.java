package cyberpunk.personage;

import cyberpunk.abilities.UniqueAbilities;

public class CharClasses {
  public static CharClass soloClass = new CharClass("Solo", UniqueAbilities.solo);
  public static CharClass rockerBoyClass = new CharClass("RockerBoy", UniqueAbilities.rockerBoy);
  public static CharClass netrunnerClass = new CharClass("Netrunner", UniqueAbilities.netrunner);
  public static CharClass techieClass = new CharClass("Techie", UniqueAbilities.techie);
  public static CharClass medTechClass = new CharClass("MedTech", UniqueAbilities.medTech);
  public static CharClass mediaClass = new CharClass("Media", UniqueAbilities.media);
  public static CharClass copClass = new CharClass("Cop", UniqueAbilities.cop);
  public static CharClass copropateClass = new CharClass("Corporate", UniqueAbilities.copropate);
  public static CharClass fixerClass = new CharClass("Fixer", UniqueAbilities.fixer);
  public static CharClass nomadClass = new CharClass("Nomad", UniqueAbilities.nomad);
}
