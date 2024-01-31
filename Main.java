class Main {
    public static void main(String args[]) {
        // "java Main -c (complete) (n)"
        // "java Main -c (complete) -b (bipartate) (A,B)"
        if(args.length < 2) {
            System.out.println("Improper usage");
            return;
        }

        if(args[0].equals("-c")) {
            if(args[1].equals("-b") ) {
                if(args.length != 3) {
                    System.out.println("Improper usage");
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
        }
    }
}