import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("funkcion.txt"));
            ArrayList<LinearFunction> linearFunctions = new ArrayList<>();
            String line = null;

            while ((line = br.readLine()) != null) {
                LinearFunction lf = fromString(line);
                System.out.println(toString(lf));
                linearFunctions.add(lf);
            }
            br.close();

            BufferedWriter bw = new BufferedWriter(new FileWriter("count.txt"));
            bw.write(String.valueOf(linearFunctions.size()));
            bw.newLine();
            bw.close();

            BufferedWriter bww = new BufferedWriter(new FileWriter("unicate.txt"));
            int value = 0;
            ArrayList<LinearFunction> unique = new ArrayList<>();
            for (int i = 0; i < linearFunctions.size(); i++) {
                if (!contains(unique, linearFunctions.get(i))) unique.add(linearFunctions.get(i));
            }
            bww.write(String.valueOf(unique.size()));
            bww.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static LinearFunction fromString(String str) {
        int indexOfX = str.indexOf("x");
        int indexOfPlus = str.indexOf("+");
        LinearFunction lf = new LinearFunction();
        lf.a = Integer.parseInt(str.substring(indexOfX - 1, indexOfX));
        lf.b = Integer.parseInt(str.substring(indexOfPlus + 2));
        return lf;
    }

    public static String toString(LinearFunction lf) {
        return lf.a + ";" + lf.b;
    }

    public static boolean isOnlyOne(ArrayList<LinearFunction> linearFunctions, LinearFunction one, int j) {
        for (int i = 0; i < linearFunctions.size(); i++) {
            if (i != j && equals(linearFunctions.get(i), one)) return false;
        }
        return true;
    }

    public static boolean contains(ArrayList<LinearFunction> list, LinearFunction one) {
        for (int i = 0; i < list.size(); i++) {
            if (equals(list.get(i), one)) return true;
        }
        return false;
    }

    public static boolean equals(LinearFunction x, LinearFunction y) {
        return (x.a == y.a && x.b == y.b);
    }
}

