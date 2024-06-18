import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Main {
    public static void main(String args[]) {
        initWindow();
    }

    public static void initWindow() {
        JFrame window = new JFrame("Classic Graph Gen");
        window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
        window.setSize(250, 200);
        window.setLayout(new BorderLayout());
        window.setResizable(false);

        JComboBox jcb = new JComboBox(new String[]{"complete", "complete bipartite"});

        JTextField jtf = new JTextField();

        JButton jb = new JButton("Submit");
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputType = (String)jcb.getSelectedItem();
                String inputNum = jtf.getText();

                parseInput(inputType, inputNum);
            }
            
        });

        window.add(jcb, BorderLayout.NORTH);
        window.add(jtf, BorderLayout.CENTER);
        window.add(jb, BorderLayout.SOUTH);
        window.setVisible(true);
    }

    public static void parseInput(String inputType, String inputNum) {

        try {
            switch(inputType) {
                case "complete":
                    new CompleteGraph(Integer.parseInt(inputNum));
                    break;
                case "complete bipartite":
                    String g1 = inputNum.substring(0, inputNum.indexOf(","));
                    String g2 = inputNum.substring(inputNum.indexOf(",") + 1, inputNum.length());
                    new CompleteBipartiteGraph(Integer.parseInt(g1), Integer.parseInt(g2));
                
                break;
            }
        } catch(Exception ex) {
            String errorMessage = "Usage: \n" + "Complete Graph: Enter a number of vertecies only\n" +
                "Complete Bipartite: Enter two numbers A and B in the format: A,B"; 
            JOptionPane.showMessageDialog(null, errorMessage);
        }
    }
}
