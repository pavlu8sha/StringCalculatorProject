import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char c;
        String[] m;
        if (str.contains(" + ")) {
            m = str.split("\\+");
            c = '+';
        } else if (str.contains(" - ")) {
            m = str.split("-");
            c = '-';
        } else if (str.contains(" * ")) {
            m = str.split("\\*");
            c = '*';
        } else if (str.contains(" / ")) {
            m = str.split(" / ");
            c = '/';
        } else {
            throw new Exception("Некорректный знак действия");
        }
        if (c == '*' || c == '/') {
            if (m[1].contains("\"")) throw new Exception("Строчку  можно делить или умножать только на число");
        }
        for (int i = 0; i < m.length; i++) {
            m[i] = m[i].replace("\"", "");
        }
        if (c == '+') {
            writeInQuotes(m[0] + m[1]);
        } else if (c == '*') {
            int x = Integer.parseInt(m[1]); // так нельзя длинна строки это .length()
            writeInQuotes(String.valueOf(m[0]).repeat(Math.max(0, x)));
        } else if (c == '-') {
            int y = m[0].indexOf(m[0]);
            if (y == -1) {
                writeInQuotes(m[0]);
            } else {
                String res = m[0].substring(0, y);
                res += m[0].substring(y + m[1].length());
                writeInQuotes(res);
            }
        } else {
            int z = m[0].length() / Integer.parseInt(m[1]);
            String res = m[0].substring(0, z);
            writeInQuotes(res);
        }
    }
     private static void writeInQuotes(String s) {
        System.out.println("\"" + s + "\"");
    }
}
