public class Item {


    String title;
    String creator;
    ItemType type;
    int rentalTime;
    int id;
    boolean isRented = false;

    Item(String title, String creator, ItemType type, int rentalTime, int id){
        this.creator = creator;
        this.id= id;
        this.type=type;
        this.title=title;
        this.rentalTime=rentalTime;

    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public int getRentalTime() {
        return rentalTime;
    }

    public void setRentalTime(int rentalTime) {
        this.rentalTime = rentalTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }


}
