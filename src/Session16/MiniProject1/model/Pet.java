package Session16.MiniProject1.model;

public class Pet {
    private String id;
    private String name;
    private String species;
    private double price;
    private String ownerId; // ma khach hang so huu

    public Pet(String id, String name, String species, double price) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.price = price;
        this.ownerId = null;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public double getPrice() {
        return price;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
        String owner = (ownerId != null) ? " | owner= " + ownerId : " | owner= (chua co)";
        return "Pet: id= " + id + " | name= " + name + " | species= " + species + " | price= " + price + owner;
    }
}
