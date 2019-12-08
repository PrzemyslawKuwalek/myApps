package sample;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {

    JTextField textMail = new JTextField(15);
    JPanel panel = new JPanel( );
    JButton sendMail = new JButton( );


    Frame() {

        super("Podaj maila");
        this.setBounds(300, 300, 350, 350);


        panel.add(textMail);
        panel.add(sendMail);
        sendMail.setText("Send");

        this.add(panel);


        this.getContentPane( );
        this.setDefaultCloseOperation(3);
        pack( );


        //masage.showConfirmDialog(rootPane,"Dziekujemy , Twoje dane są bezpieczne", JOptionPane.OK_OPTION);

        sendMail.addActionListener(new ActionListener( ) {
            @Override
            public void actionPerformed(ActionEvent e) {
                String domena[] = {".pl", ".com", "eu"};
                boolean inCorrect = false;


                for (int i = 0; i < domena.length; i++) {

                    if (textMail.getText( ).contains("@") && textMail.getText( ).contains(domena[i])) {

                        Storage storage = new Storage(textMail.getText( ));
                        textMail.setText("");
                        JOptionPane.showConfirmDialog(rootPane, "Yours email its save in my hand", "confirmation of subscription", JOptionPane.CLOSED_OPTION);
                        break;
                    } else
                        inCorrect = true;
                }

                if (inCorrect)
                    JOptionPane.showConfirmDialog(rootPane, "Yours email itn`t correct. Please try again", "confirmation of subscription", JOptionPane.CLOSED_OPTION);


            }
        });

    }

}
