import java.util.ArrayList;

public class Member {

    Membership memType;
    String name;
    ArrayList<Item> borrowedItems;
    ArrayList<String> history;
    int debt = 0;
    int studentCard;

    Member (Membership memType, String name, int debt, int studentCard){
        this.memType = memType;
        this.name = name;
        this.debt = debt;
        this.studentCard = studentCard;
    }


    public int getDebt() {
        return debt;
    }

    public void setDebt(int debt) {
        this.debt = debt;
    }


    public Membership getMemType() {
        return memType;
    }

    public void setMemType(Membership memType) {
        this.memType = memType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentCard() {
        return studentCard;
    }

    public void setStudentCard(int studentCard) {
        this.studentCard = studentCard;
    }

    public ArrayList<String> getHistory() {
        return history;
    }




}
