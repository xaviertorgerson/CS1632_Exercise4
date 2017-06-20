public class Customer {

    private int id;
    private String name;

    public Customer() {
      id = 0;
      name = "";
    }

    public Customer(int newId, String newName) {
      setId(newId);
      setName(newName);
    }

    public int getId() {
      return this.id;
    }

    public String getName() {
      return this.name;
    }

    public void setId(int newId) {
      this.id = newId;
    }

    public void setName(String newName) {
      this.name = newName;
    }

    public String toString() {
      return "Customer Id " + getId() + ". " + getName();
    }
    
}
