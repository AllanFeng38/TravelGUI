import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class updateTravAttribute extends JFrame{
    private JPanel rootPanel;
    private JLabel lastNameLabel;
    private JLabel updateAttributeLabel;
    private JTextField updateAttributeInputTextField;
    private JButton submitButton;

    private String travAgentID;
    private TravProfDB database;
    private String fileName;
    private String updateChoice;

    public updateTravAttribute(TravProfDB _database, String _fileName, String _travAgentID, TravelProf travelProf, String _updateChoice) throws Exception {
        this.travAgentID = _travAgentID;
        this.database = _database;
        this.fileName = _fileName;
        this.database.initializeDatabase(_fileName);
        this.updateChoice = _updateChoice;

        add(rootPanel);
        setTitle("ITS");
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        lastNameLabel.setText(travelProf.getLastName());
        updateAttributeLabel.setText("New" + this.updateChoice);

        String updatedInfo = updateAttributeInputTextField.getText();

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                switch (updateChoice) {
                    case "First Name":
                        travelProf.updateFirstName(updatedInfo);
                        JOptionPane.showMessageDialog(null,updateChoice + " Successfully Updated");
                        dispose();
                        break;
                    case "Last Name":
                        travelProf.updateLastName(updatedInfo);
                        JOptionPane.showMessageDialog(null,updateChoice + " Successfully Updated");
                        dispose();
                        break;
                    case "Address":
                        travelProf.updateAddress(updatedInfo);
                        JOptionPane.showMessageDialog(null,updateChoice + " Successfully Updated");
                        dispose();
                        break;
                    case "Phone":
                        travelProf.updatePhone(updatedInfo);
                        JOptionPane.showMessageDialog(null,updateChoice + " Successfully Updated");
                        dispose();
                        break;
                    case "Trip Cost":
                        travelProf.updateTripCost(Float.parseFloat(updatedInfo));
                        JOptionPane.showMessageDialog(null,updateChoice + " Successfully Updated");
                        dispose();
                        break;
                    case "Payment Type":
                        travelProf.updatePaymentType(updatedInfo);
                        JOptionPane.showMessageDialog(null,updateChoice + " Successfully Updated");
                        dispose();
                        break;
                    default:
                        break;
                }

            }
        });


        database.writeAllTravProf(fileName);

    }
}
