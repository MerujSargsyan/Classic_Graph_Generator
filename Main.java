import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Main {
    public static void main(String args[]) {
        // "java Main -c (complete) (n)"
        // "java Main -c (complete) -b (bipartate) (A,B)"
        initWindow();
        /*if(args.length == 0) {
            System.out.println("Improper usage type -h for help");
            return;
        }
        if(args[0].equals("-c")) {
            if(args[1].equals("-b") ) {
                if(args.length != 3) {
                    System.out.println("Improper usage type -h for help");
                    return;
                }
                try {
                    int A = Integer.parseInt(args[2].substring(0, 1));
                    int B = Integer.parseInt(args[2].substring(2, 3));
                    new CompleteBipartiteGraph(A,B);
                } catch(Exception ex) {
                    System.out.println("Input error");
                }
                
            } else {
                try {
                    int n = Integer.parseInt(args[1]);
                     new CompleteGraph(n);
                } catch(Exception ex) {
                    System.out.println("Please enter a number");
                    return;
                }
            }
        } else if(args[0].equals("-h")) {
            System.out.println("Usage:");
            System.out.println("Complete graph of n: '-c {number}");
            System.out.println("Complete Bipartite Graph of (A,B):" + 
                "'-c -b {number1},{number2}");
        }*/
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
        switch(inputType) {
            case "complete":
                new CompleteGraph(Integer.parseInt(inputNum));
                break;
            case "complete bipartite":
                try {
                    new CompleteBipartiteGraph(Integer.parseInt(inputNum), Integer.parseInt(inputNum));
                } catch(Exception ex) {
                    System.out.println("Error");
                }
                break;
        }
    }
}
