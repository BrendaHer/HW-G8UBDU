import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

import static javax.swing.SwingConstants.CENTER;

public class Window extends JFrame implements ActionListener {

    /* ---------- INITIALIZATIONS ---------- */

    JFrame menu = new JFrame();

    Rentals rent;
    Inventory inv ;
    RegisteredMembers regMem ;
    Member mem;


    //mainMenu:

    JButton membersButton;
    JButton itemButton;
    JButton rentalsButton;
    JButton addButton;
    JButton removeButton;


    //addNewItem:

    JButton SubmitItem;
    JComboBox<String> chooseType;
    JLabel itemLabel;
    JTextField title;
    JTextField creator;
    JTextField rentalTime;
    JTextField id;

    //addNewMember:
    JButton SubmitMember;
    JComboBox<String> chooseMemberType;
    JLabel memberLabel;
    JTextField name;
    JTextField studentID;
    JTextField debt;

    //addNewRental:
    JButton SubmitRental;
    JComboBox<String> chooseMember;
    JComboBox<String> chooseItem;





    //other
    JPanel container;
    JPanel mainMenu;
    JPanel addNewMember;
    JPanel addNewItem;
    JPanel addNewRental;
    JScrollPane pane;


    /* ----------CONSTRUCTOR---------- */
    public Window() {
        rent = new Rentals();
        inv = new Inventory();
        regMem = new RegisteredMembers();

        mem = new Member(Membership.STANDARD,"ALICE", 1, 12345);
        regMem.addMember(mem);

        CardLayout card = new CardLayout();
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Library... or is it?");
        this.setSize(1280,720);
        container = new JPanel();
        container.setLayout(card);
        mainMenu = new JPanel();
        addNewMember = new JPanel();
        addNewItem = new JPanel();
        addNewRental = new JPanel();
        pane = new JScrollPane();


//        mainMenu.setLayout(new BorderLayout());
//        container.setLayout(new BorderLayout());
//        addNewItem.setLayout(new BorderLayout());
//        addNewMember.setLayout(new BorderLayout());
//        addNewRental.setLayout(new BorderLayout());
//        pane.setLayout(new ScrollPaneLayout());

        this.add(container);

        JTable inventoryTable = new JTable(inv.tableModel);
        JTable rentalTable = new JTable(rent.tableModel);
        JTable memberTable = new JTable(regMem.tableModel);

        JScrollPane scrollpane = new JScrollPane();
        scrollpane.getViewport().add(memberTable);
        scrollpane.getViewport().add(inventoryTable);
        scrollpane.getViewport().add(rentalTable);
        scrollpane.setViewportView(memberTable);
        mainMenu.add(scrollpane);


        String[] memNames = new String[regMem.registeredMembers.size()];
        String[] itemNames = new String[inv.itemArray.size()];

        for (int i = 0; i < regMem.registeredMembers.size(); i++) {
            memNames[i] = regMem.registeredMembers.get(i).getName();
        }

        for (int i = 0; i < inv.itemArray.size(); i++) {
            itemNames[i] =  inv.itemArray.get(i).getTitle();
        }





        container.add(mainMenu, "main");
        container.add(addNewItem, "item");
        container.add(addNewMember,"member");
        container.add(addNewRental, "rental");


        /*---------- mainMenu ----------*/
        membersButton = new JButton("Members");
        itemButton = new JButton("Items");
        rentalsButton = new JButton("Rentals");
        addButton = new JButton("Add");
        removeButton = new JButton("Remove");

        mainMenu.add(membersButton);
        mainMenu.add(itemButton);
        mainMenu.add(rentalsButton);
        mainMenu.add(addButton);
        mainMenu.add(removeButton);
        mainMenu.add(pane);

        membersButton.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent arg0) {
                scrollpane.setViewportView(memberTable);

            }

        });
        rentalsButton.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent arg0) {
            scrollpane.setViewportView(rentalTable);
            }

        });
        itemButton.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent arg0) {
            scrollpane.setViewportView(inventoryTable);
            }

        });

        mainMenu.add(memberTable);
        mainMenu.add(rentalTable);
        mainMenu.add(inventoryTable);
        mainMenu.add(membersButton);
        mainMenu.add(itemButton);
        mainMenu.add(rentalsButton);
        mainMenu.add(addButton);
        mainMenu.add(removeButton);




        /*---------- addNewMember ----------*/
        SubmitMember = new JButton("Register");
        chooseMemberType = new JComboBox(Membership.values());
        studentID = new JTextField();
        name = new JTextField();

        /*---------- addNewItem ----------*/
        SubmitItem = new JButton("Add Item");
        chooseType = new JComboBox(ItemType.values());
        title = new JTextField();
        creator = new JTextField();
        rentalTime = new JTextField();
        id = new JTextField();

//         void initComponents(){
//            this.setLayout(new BorderLayout());
//            Container pane = this.getContentPane();
//            JTable table = new JTable(inv);
//
//            JScrollPane scrollpane = new JScrollPane();
//            scrollpane.getViewport().add(table);
//            pane.add(scrollpane, BorderLayout.CENTER);
//
//        }

        /*---------- addNewRental ----------*/
        JButton SubmitRental;
        chooseMember = new JComboBox();
        JComboBox<String> chooseItem;


        this.setVisible(true);
    }




    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
