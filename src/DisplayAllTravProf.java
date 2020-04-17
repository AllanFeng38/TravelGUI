import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayAllTravProf extends JFrame{
    private JPanel rootPanel;
    private JButton backButton;
    private JTextArea travProfTextArea;

    private String travAgentID;
    private TravProfDB database;
    private String fileName;

    public DisplayAllTravProf(TravProfDB _database, String _fileName, String _travAgentID) throws Exception {
        this.travAgentID = _travAgentID;
        this.database = _database;
        this.fileName = _fileName;
        this.database.initializeDatabase(_fileName);

        add(rootPanel);
        setTitle("ITS");
        setVisible(true);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //make the text inside the JTextArea uneditable
        travProfTextArea.setEditable(false);

        //main loop to display all the traveler profiles
        TravelProf travelProf = database.findFirstProfile();
        if (travelProf == null) {
            travProfTextArea.append("No Traveler Profile in Database\n");
        }

        while (travelProf != null) {
            displayTravProf(travelProf, travProfTextArea);
            travProfTextArea.append("----------------------\n");
            travelProf = database.findNextProfile();
        }

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

    //display the traveler profile information
    public void displayTravProf(TravelProf travelProf, JTextArea travProfTextArea) {
        travProfTextArea.append("First Name: " + travelProf.getFirstName() + "\n");
        travProfTextArea.append("Last Name: " + travelProf.getLastName() + "\n");
        travProfTextArea.append("Address: " + travelProf.getAddress() + "\n");
        travProfTextArea.append("Phone: " + travelProf.getPhone() + "\n");
        travProfTextArea.append("Trip Cost: " + travelProf.getTripCost() + "\n");
        travProfTextArea.append("Travel Type: " + travelProf.getTravelType() + "\n");
        travProfTextArea.append("Payment Type: " + travelProf.getPaymentType() + "\n");
    }
}
