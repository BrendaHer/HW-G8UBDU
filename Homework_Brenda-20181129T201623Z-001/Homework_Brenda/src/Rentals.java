import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.ArrayList;

public class Rentals extends DefaultTableModel {
    String[] columnName = {"Item", "Member", "Deadline", "Active"};
    DefaultTableModel tableModel = new DefaultTableModel(columnName,0);
    static ArrayList<Rentals> rentalList = new ArrayList<Rentals>();
    Item i;
    Member m;
    int deadline;
    boolean isActive;

    Rentals(){}

    Rentals (Item i, Member m){
        this.i = i;
        this.m = m;
        deadline = i.getRentalTime();
        i.setRented(true);
        m.borrowedItems.add(i);
        isActive=true;
        toTable();
    }

    void returnRental(Rentals R){
        R.i.setRented(false);
        if(R.getDeadline()<0)
            R.m.setDebt(R.m.getDebt()+1);
        R.m.borrowedItems.remove(R.i);
        R.isActive=false;
        toTable();
    }

    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

     void extendTime(Rentals R){
        if(R.getDeadline()>=0) {
            if(R.m.getMemType()==Membership.STANDARD)
                R.setDeadline(R.getDeadline()+(R.i.getRentalTime()*1));

            else if(R.m.getMemType()==Membership.ADVANCED)
                R.setDeadline(R.getDeadline()+(R.i.getRentalTime()*3));

            else if(R.m.getMemType()==Membership.ELITE)
                R.setDeadline(R.getDeadline()+(R.i.getRentalTime()*10));
        }
    }

    void toTable(){

        for (int j = 0; j < rentalList.size(); j++) {
            tableModel.removeRow(j);
            Object[] obj = {rentalList.get(j).i.getTitle(), rentalList.get(j).m.getName(), rentalList.get(j).getDeadline(), rentalList.get(j).isActive};
            tableModel.addRow(obj);

        }
    }


    public void Save(ArrayList<Rentals> rentalList){
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("rentalsList.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(rentalList);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public void Load () {
        try {
            FileInputStream fileIn = new FileInputStream("rentalsList.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            rentalList = (ArrayList<Rentals>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Rentals not found");
            c.printStackTrace();
            return;
        }
    }

}
