import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.ArrayList;

public class RegisteredMembers extends DefaultTableModel {
    static ArrayList<Member> registeredMembers = new ArrayList<Member>();
    String[] columnName = {"Type","Name","Debt","Student Card"};
    DefaultTableModel tableModel = new DefaultTableModel(columnName,0);
    int addMember(Member m){
        for(int i = 0; i<registeredMembers.size(); i++) {
            if (m.studentCard == registeredMembers.get(i).getStudentCard());
            System.out.println("Already registered");
            //throw new InvalidInputException();
            return 0;

        }
        registeredMembers.add(m);
        toTable();
        return 1;
    }

    void removeMember(Member m){
        registeredMembers.remove(m);
        tableModel.removeRow(registeredMembers.indexOf(m));
        }

    void toTable(){

        for (int j = 0; j < registeredMembers.size(); j++) {
        //    tableModel.removeRow(j);
            Object[] obj = {registeredMembers.get(j).getMemType(), registeredMembers.get(j).getName(), registeredMembers.get(j).getDebt(), registeredMembers.get(j).getStudentCard()};
            tableModel.addRow(obj);
        }
    }


    public void Save(ArrayList<Member> memberList){
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("memberList.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(memberList);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }

    }

    public void Load () {
        try {
            FileInputStream fileIn = new FileInputStream("memberList.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            registeredMembers = (ArrayList<Member>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Members not found");
            c.printStackTrace();
            return;
        }
    }
}
