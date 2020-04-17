import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateTravProf extends JFrame{
    private JPanel rootPanel;
    private JTextField lastNameTextField;
    private JComboBox updateChoiceComboBox;
    private JButton updateButton;
    private JButton backButton;

    private String travAgentID;
    private TravProfDB database;
    private String fileName;

    public UpdateTravProf(TravProfDB _database, String _fileName, String _travAgentID) throws Exception {
        this.travAgentID = _travAgentID;
        this.database = _database;
        this.fileName = _fileName;
        this.database.initializeDatabase(_fileName);

        add(rootPanel);
        setTitle("ITS");
        setSize(400, 500);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //action listener for update button
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String lastName = lastNameTextField.getText();
                String updateChoice = String.valueOf(updateChoiceComboBox.getSelectedItem());

                TravelProf travelProf = database.findProfile(travAgentID, lastName);
                if (travelProf == null) {
                    JOptionPane.showMessageDialog(null,"Traveler Profile Not Found");
                } else {
                    try {
                        new updateTravAttribute(database, fileName, travAgentID, travelProf, updateChoice);
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
