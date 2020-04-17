import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindTravSearch extends JFrame {
    private JPanel rootPanel;
    private JLabel lastNameLabel;
    private JTextField lastNameTextField;
    private JButton findButton;
    private JButton backButton;

    private String travAgentID;
    private String fileName;
    private TravProfDB database;

    public FindTravSearch(TravProfDB _database, String _fileName, String _travAgentID) throws Exception {
        this.travAgentID = _travAgentID;
        this.database = _database;
        this.fileName = _fileName;
        this.database.initializeDatabase(_fileName);

        add(rootPanel);
        setVisible(true);
        setTitle("ITS");
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        //find the trav prof
        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String lastName = lastNameTextField.getText();
                TravelProf travelProf = database.findProfile(travAgentID, lastName);

                if (travelProf == null) {
                    JOptionPane.showMessageDialog(null,"Traveler Profile Not Found");
                } else {
                    DisplayTravProf.main(travelProf);
                }
            }
        });

        lastNameTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String lastName = lastNameTextField.getText();
                TravelProf travelProf = database.findProfile(travAgentID, lastName);

                if (travelProf == null) {
                    JOptionPane.showMessageDialog(null,"Traveler Profile Not Found");
                } else {
                    DisplayTravProf.main(travelProf);
                }
            }
        });

        //go back to the main menu
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    new MainMenu(database, fileName, travAgentID);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                dispose();
            }
        });


    }
}
