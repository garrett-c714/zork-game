public class Item {
  private String name;
  private String description;
  private Room room;
  private int weight;
  
  public Item(String n, String d, Room r, int w) {
    this.name = n;
    this.description = d;
    this.room = r;
    weight = w;
  }

  public Room getRoom()
  {
    return room;
  }
  public void setRoom(Room r)
  {
    room = r;
  }
  public String getName()
  {
    return name;
  }
  public String getDescription()
  {
    return description;
  }
  public String getIncantation() {
    return "peanut butter";
  }
  public int getWeight()
  {
    return weight;
  }
}