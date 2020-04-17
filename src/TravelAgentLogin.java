import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TravelAgentLogin extends JFrame{
    private JPanel rootPanel;
    private JTextField travAgentIDTextField;
    private JButton loginButton;

    public TravelAgentLogin() {
        add(rootPanel);
        setTitle("ITS");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //action listener if the user chooses to hit the enter key
        travAgentIDTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //get the travel agent ID from the user
                String travAgentID = travAgentIDTextField.getText();
                System.out.println(travAgentID);

                try {
                    new MainMenu(null ,"testDatabase", travAgentID);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                dispose();
            }
        });

        //set action listener for login button that leads to main menu
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //get the travel agent ID from the user
                String travAgentID = travAgentIDTextField.getText();
                System.out.println(travAgentID);

                try {
                    new MainMenu(null ,"testDatabase", travAgentID);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                dispose();
            }
        });
    }
}
