import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateProfile extends JFrame{
    private JPanel rootPanel;
    private JButton submitButton;
    private JTextField firstNameTextField;
    private JTextField lastNameTextField;
    private JTextField addressTextField;
    private JTextField phoneTextField;
    private JTextField tripCostTextField;
    private JComboBox travelTypeComboBox;
    private JComboBox paymentTypeComboBox;
    private JButton goBackButton;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel addressLabel;
    private JLabel phoneLabel;
    private JLabel tripCostLabel;
    private JLabel travelTypeLabel;
    private JLabel paymentTypeLabel;

    private String travAgentID;
    private TravProfDB database;
    private String fileName;

    public CreateProfile(TravProfDB _database, String _fileName, String _travAgentID) throws Exception {
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

        //submit button action listener
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //get all the appropriate information from the text fields
                String firstName = firstNameTextField.getText();
                String lastName = lastNameTextField.getText();
                String address = addressTextField.getText();
                String phone = phoneTextField.getText();
                float tripCost = Float.parseFloat(tripCostTextField.getText());
                String travelType = String.valueOf(travelTypeComboBox.getSelectedItem());
                String paymentType = String.valueOf(paymentTypeComboBox.getSelectedItem());

                //create the new traveler profile object
                TravelProf newTravProf = new TravelProf(travAgentID, firstName, lastName, address, phone, tripCost,
                                                        travelType, paymentType, null);

                //insert the new traveler profile object into the database array
                database.insertNewProfile(newTravProf);

                //try to save the database array into a .ser file
                try {
                    database.writeAllTravProf(fileName);
                    JOptionPane.showMessageDialog(null,
                            "Traveler Profile Successfully Saved");

                    //go back to main menu after successfully saving traveler profile
                    try {
                        new MainMenu(database, fileName, travAgentID);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    dispose();
                } catch (Exception e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null,
                            "There Was An Error Saving");
                }

            }
        });



        //go back to the main menu
        goBackButton.addActionListener(new ActionListener() {
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
