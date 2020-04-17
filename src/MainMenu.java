import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {

    private JLabel MainMenuLabel;
    private JPanel rootPanel;
    private JButton selectButton;
    private JRadioButton createProfileRadioButton;
    private JRadioButton deleteProfileRadioButton;
    private JRadioButton updateProfileRadioButton;
    private JRadioButton findDisplayProfileRadioButton;
    private JRadioButton displayAllProfilesRadioButton;
    private JButton logOutButton;

    private String travAgentID;
    private String fileName;
    private TravProfDB database;

    public MainMenu(TravProfDB _database, String _fileName, String _travAgentID) throws Exception {
        this.fileName = _fileName;
        this.travAgentID = _travAgentID;
        if (database != null) {
            this.database = _database;
        } else {
            this.database = new TravProfDB(fileName);
        }
        this.database.initializeDatabase(fileName);

        //set visible
        setVisible(true);
        //add the panel to the frame
        add(rootPanel);
        setTitle("ITS");
        setSize(400, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //create a new group of buttons and add the buttons to it
        //this makes it so only one radio button can be chosen
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(createProfileRadioButton);
        buttonGroup.add(deleteProfileRadioButton);
        buttonGroup.add(updateProfileRadioButton);
        buttonGroup.add(findDisplayProfileRadioButton);
        buttonGroup.add(displayAllProfilesRadioButton);

        //the user's choice
        final String[] choice = {null};

        //action listener if user picks create profile
        createProfileRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                choice[0] = "createProfile";
            }
        });

        //action listener if user picks delete profile
        deleteProfileRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                choice[0] = "deleteProfile";
            }
        });

        //action listener if user picks update profile
        updateProfileRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                choice[0] = "updateProfile";
            }
        });

        //action listener if user picks find profile
        findDisplayProfileRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                choice[0] = "findDisplayProfile";
            }
        });

        //action listener if user picks display all profile
        displayAllProfilesRadioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                choice[0] = "displayAllProfile";
            }
        });

        //action listener for log out button
        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new TravelAgentLogin();
                dispose();
            }
        });

        //action listener for the select the button
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //pull up the appropriate frame/window based on user's choice
                switch (choice[0]) {
                    case "createProfile":
                        try {
                            new CreateProfile(database, fileName, travAgentID);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        dispose();
                        break;
                    case "deleteProfile":
                        try {
                            new DeleteTravProf(database, fileName, travAgentID);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        dispose();
                        break;
                    case "updateProfile":
                        try {
                            new UpdateTravProf(database, fileName, travAgentID);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        dispose();
                        break;
                    case "findDisplayProfile":
                        try {
                            new FindTravSearch(database, fileName, travAgentID);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        dispose();
                        break;
                    case "displayAllProfile":
                        try {
                            new DisplayAllTravProf(database, fileName, travAgentID);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        dispose();
;                       break;
                    default:
                        System.out.println("xd");

                }
            }
        });
    }
}
