import javax.swing.*;
import java.awt.event.*;

public class DisplayTravProf extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JLabel firstNameLabel;
    private JLabel lastNameLabel;
    private JLabel addressLabel;
    private JLabel phoneLabel;
    private JLabel tripCostLabel;
    private JLabel travelTypeLabel;
    private JLabel paymentTypeLabel;

    private TravelProf travProf;

    public DisplayTravProf(TravelProf _travProf) {
        this.travProf = _travProf;

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        //set the dialog to display the traveler profile information
        firstNameLabel.setText(travProf.getFirstName());
        lastNameLabel.setText(travProf.getLastName());
        addressLabel.setText(travProf.getAddress());
        phoneLabel.setText(travProf.getPhone());
        tripCostLabel.setText(Float.toString(travProf.getTripCost()));
        travelTypeLabel.setText(travProf.getTravelType());
        paymentTypeLabel.setText(travProf.getPaymentType());



        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

    }

    private void onOK() {
        // add your code here
        dispose();
    }


    public static void main(TravelProf travelProf) {
        DisplayTravProf dialog = new DisplayTravProf(travelProf);
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
}
