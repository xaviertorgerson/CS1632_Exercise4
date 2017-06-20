public class Cat {

    private int id;
    private String name;
    private double cost;
    private int customerId;

    //Default constructor
    public Cat() {
      id = 0;
      name = "";
      cost = 0.0;
      customerId = 0;
    }

    public Cat(int newId, String newName, double newCost) {
      setId(newId);
      setName(newName);
      setCost(newCost);
    }

    public int getId() {
      return this.id;
    }

    public String getName() {
      return this.name;
    }

    public double getCost() {
      return this.cost;
    }

    public int getCustomerId() {
      return this.customerId;
    }

    public void setId(int newId) {
      this.id = newId;
    }

    public void setName(String newName) {
      this.name = newName;
    }

    public void setCost(double newCost) {
      this.cost = newCost;
    }

    public boolean rentCat(int newCustomerId) {
      if(this.customerId == 0) {
        this.customerId = newCustomerId;
        return true;
      }

      return false;
    }

    public boolean returnCat() {
      if(this.customerId != 0) {
        this.customerId = 0;
        return true;
      }

      return false;
    }

    public String toString() {
      return "ID " + getId() + ". " + getName() + ": " + getCost();
    }

}
