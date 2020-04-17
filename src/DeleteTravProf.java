import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteTravProf extends JFrame{
    private JPanel rootPanel;
    private JLabel deleteProfLabel;
    private JTextField lastNameTextField;
    private JButton deleteButton;
    private JButton backButton;

    private String travAgentID;
    private String fileName;
    private TravProfDB database;

    public DeleteTravProf(TravProfDB _database, String _fileName, String _travAgentID) throws Exception {
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

        //try to delete the Traveler Profile
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String lastName = lastNameTextField.getText();
                boolean result = database.deleteProfile(travAgentID, lastName);
                if (!result) {
                    JOptionPane.showMessageDialog(null,"Traveler Profile Does Not Exist");
                } else {
                    JOptionPane.showMessageDialog(null,"Traveler Profile Successfully deleted");

                    try {
                        database.writeAllTravProf(fileName);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
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
