import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Inventory extends DefaultTableModel {
    static ArrayList<Item> itemArray = new ArrayList<Item>();
 //   public List<Object[]> tableData;
    public String[] columnName = {"ID", "Title", "Creator", "Type", "Rental Time", "Is available?"};
    Class[] type = { Integer.class, String.class, String.class, Enum.class, Integer.class, Boolean.class};
    DefaultTableModel tableModel = new DefaultTableModel(columnName,0);

    void addItem(Item i){

        if(!i.getCreator().matches("^[a-zA-Z\\s]+")) {
           // throw new InvalidInputException();
        }
        else {
            itemArray.add(i);
            //model.addRow(new Object[] {s.getYear(),s.getName(),s.getNationality(),s.getAge(),s.getId(),s.getGender()});
            System.out.println("Item added  to the inventory: "+i.getTitle());
            toTable();

        }
    }

    void toTable(){
        for (int i = 0; i < itemArray.size(); i++) {
            tableModel.removeRow(i);
        Object[] obj = {itemArray.get(i).getId(), itemArray.get(i).getTitle(), itemArray.get(i).getCreator(), itemArray.get(i).getType(), itemArray.get(i).getRentalTime(), itemArray.get(i).isRented()};
        tableModel.addRow(obj);

        }
    }
//
//    @Override
//    public int getColumnCount() {
//        // TODO Auto-generated method stub
//        return columnName.length;
//    }
//
//    @Override
//    public int getRowCount() {
//        // TODO Auto-generated method stub
//        return tableData.size();
//    }
//
//    @Override
//    public Object getValueAt (int arg0, int arg1) {
//        // TODO Auto-generated method stub
//        return tableData.get(arg0)[arg1];
//    }
//
//    public boolean isCellEditable (int row, int col){
//        if (col < 2) return false;
//        else return true;
//    }
//
//    public void setValueAt (Object Value, int row, int col) {
//        tableData.get(row)[col] = Value;
//        fireTableCellUpdated (row, col);
//    }

    void removeItem(Item i){
        int j = itemArray.indexOf(i);
        itemArray.remove(i);
        tableModel.removeRow(j);
    }

    public void Save(ArrayList<Item> itemArray){
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("itemList.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(itemArray);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }

    }

    public void Load () {
        try {
            FileInputStream fileIn = new FileInputStream("itemList.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            itemArray = (ArrayList<Item>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Items not found");
            c.printStackTrace();
            return;
        }
    }

}
