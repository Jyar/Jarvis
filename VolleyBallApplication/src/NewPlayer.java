
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class NewPlayer extends JFrame {

    private static String nameT;
    private static String gameT;
    private static String dateT;

    // private boolean isPlayerLabero;

    public static String getNameT() {
        return nameT;
    }

    public static String getGameT() {
        return gameT;
    }

    public static String getDateT() {
        return dateT;
    }

    public NewPlayer() {
        super("New Player Input");

        JPanel newPlayerPanel = new JPanel();

        add(newPlayerPanel);

        JTextField name = new JTextField(" Replace with player's name", 15);
        newPlayerPanel.add(name);

        JTextField date = new JTextField(
                " Replace with Date in xx/xx/xxxx format", 25);
        newPlayerPanel.add(date);

        JTextField oTeam = new JTextField(" Replace with Opposing Team", 20);
        newPlayerPanel.add(oTeam);

        JButton next = new JButton("Next");
        newPlayerPanel.add(next);
        //
        // JLabel isLabero = new JLabel("Is this player a Labero?");
        // newPlayerPanel.add(isLabero);
        //
        // JCheckBox isL = new JCheckBox();
        // newPlayerPanel.add(isL);
        //

        next.addActionListener(new ActionListener() {

            @SuppressWarnings("static-access")
            @Override
            public void actionPerformed(ActionEvent e) {
                dateT = date.getText();

                if (correctDate()) {

                    if (name.getText() != null) {
                        nameT = name.getText();
                    }
                    else
                        nameT = "";

                    if (date.getText() != null) {
                        dateT = date.getText();
                    }
                    else
                        dateT = "";

                    if (oTeam.getText() != null) {
                        gameT = oTeam.getText();
                    }
                    else
                        gameT = "";

                    StatisticsPage statisticsFrame = new StatisticsPage();

                    statisticsFrame.main(null);
                    // System.exit(0);
                    dispose();
                }
                else
                    JOptionPane.showMessageDialog(NewPlayer.this,
                            new JLabel("<html>" + "Incorrect Date" + "<br>"
                                    + "Please use Date in xx/xx/xxxx format"
                                    + "</html>"),
                            "Message", JOptionPane.ERROR_MESSAGE);
            }

        });

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public boolean correctDate() {
        if (dateT.length() >= 6) {
            if (dateT.charAt(2) == '/' && dateT.charAt(5) == '/') {
                return true;
            }
        }

        return false;
    }

    // public boolean getLabero(){
    // return isPlayerLabero;
    // }

    public static void main(String[] args) {
        JFrame frame = new NewPlayer();
        frame.setVisible(true);
        frame.setSize(325, 200);
    }
}
