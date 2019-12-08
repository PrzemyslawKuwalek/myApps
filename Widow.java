import javax.swing.*;
import java.awt.event.ActionEvent;

public class Widow extends JFrame {
    private JButton bSave;
    private JButton bDelate;
    private JButton bZeap;

    private JMenuBar menuBar = new JMenuBar( );

    private JList list = new JList( );


    public Widow() {
        this.setTitle("Save");
        this.setBounds(250, 300, 250, 300);
        this.setJMenuBar(menuBar);


        JMenu menu = menuBar.add(new JMenu("MENU"));

        Action actionSave = new Actioner("Save", "Save focus file" , "Ctrl S", new ImageIcon("dodaj.png"));
        Action actionDelate = new Actioner("Delate", "Delete focus file" , "Ctrl D", new ImageIcon("usun.png"));
        Action actionZip = new Actioner("Zip", "Zepping focus file" , "Ctrl Z");


        bSave = new JButton(actionSave);
        bDelate = new JButton(actionDelate);
        bZeap = new JButton(actionZip);

        list.setBorder(BorderFactory.createEtchedBorder( ));


        JMenuItem menuSave = menu.add(actionSave);
        JMenuItem menuDelate = menu.add(actionDelate);
        JMenuItem menuZip = menu.add(actionZip);


        GroupLayout layout = new GroupLayout(this.getContentPane( ));

        layout.setAutoCreateContainerGaps(true);
        layout.setAutoCreateGaps(true);


        layout.setHorizontalGroup(layout.createSequentialGroup( )
                .addComponent(list, 100, 150, Short.MAX_VALUE)
                .addContainerGap(50, 150)
                .addGroup(
                        layout.createParallelGroup( )
                                .addComponent(bSave)
                                .addComponent(bDelate)
                                .addComponent(bZeap)
                ));


        layout.setVerticalGroup(layout.createParallelGroup( )
                .addComponent(list, 100, 150, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup( )
                        .addComponent(bSave)
                        .addComponent(bDelate)
                        .addGap(25, 40, Short.MAX_VALUE)
                        .addComponent(bZeap)

                ));

        this.getContentPane( ).setLayout(layout);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pack( );


    }

    public static void main(String[] args) {
        new Widow( ).setVisible(true);
    }

    private class Actioner extends AbstractAction {
        public Actioner(String name, String opis, String shortKey) {
            this.putValue(Action.NAME, name);
            this.putValue(Action.SHORT_DESCRIPTION, opis);
            this.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(shortKey));
        }

        public Actioner(String name, String opis, String shortKey, Icon icona) {
            this(name, opis, shortKey);
            this.putValue(Action.SMALL_ICON, icona);
        }


        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }


}
