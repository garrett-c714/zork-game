public class Spell extends Item {
  private String incantation;

  public Spell(String n, String d, Room r, int w, String inc) {
    super(n, d, r, w);
    this.incantation = inc;
  }
  @Override
  public String getIncantation() {
    return incantation;
  }
}