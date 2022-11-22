import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char c;
        String[] m;
        if (str.contains("+")) {
            m = str.split(" \\+ ");
            c = '+';
        } else if (str.contains("-")) {
            m = str.split(" - ");
            c = '-';
        } else if (str.contains("*")) {
            m = str.split(" \\* ");
            c = '*';
        } else if (str.contains("/")) {
            m = str.split(" / ");
            c = '/';
        } else {
            throw new Exception("Некорректный знак действия");
        }

        char one = m[0].charAt(0);
        char two = m[0].charAt(m[0].length() - 1);
        char four = m[1].charAt(0);
        char five = m[1].charAt(m[1].length() - 1);

        if (c == '*' || c == '/') {
            if (m[1].contains("\"")) throw new Exception("Строчку можно делить или умножать только на число");
        }
        for (int i = 0; i < m.length; i++) {
            m[i] = m[i].replace("\"", "");
        }
        if (c == '+') {
            if (m[0].length() - 1 <= 10 && m[1].length() - 1 <= 10) {
                if (one == '\"' && two == '\"' && four == '\"' && five == '\"') {
                    writeInQuotes(m[0] + m[1]);
                } else {
                    throw new Exception("Строка принимается только в кавычках");
                }
            } else {
                throw new Exception("Калькулятор принимает на вход числа от 1 до 10 ключительно и строки длинной не более 10 символов");
            }
        } else if (c == '*') {
            if (m[0].length() - 1 <= 10 && (Integer.parseInt(m[1]) <= 10 && Integer.parseInt(m[1]) > 0)) {
                if (one == '\"' && two == '\"') {
                    int x = Integer.parseInt(m[1]);
                    writeInQuotes(String.valueOf(m[0]).repeat(Math.max(0, x)));
                } else {
                    throw new Exception("Строка принимается только в кавычках");
                }
            } else {
                throw new Exception("Калькулятор принимает на вход числа от 1 до 10 ключительно и строки длинной не более 10 символов");
            }
        } else if (c == '-') {
            if (m[0].length() - 1 <= 10 && m[1].length() - 1 <= 10) {
                if (one == '\"' && two == '\"' && four == '\"' && five == '\"') {
                    String y = m[0].replace(m[1], "");
                    writeInQuotes(y);
                } else {
                    throw new Exception("Строка принимается только в кавычках");
                }
            } else {
                throw new Exception("Калькулятор принимает на вход числа от 1 до 10 ключительно и строки длинной не более 10 символов");
            }
        } else {
            if (m[0].length() - 1 <= 10 && (Integer.parseInt(m[1]) <= 10 && Integer.parseInt(m[1]) > 0)) {
                if (one == '\"' && two == '\"') {
                    int z = m[0].length() / Integer.parseInt(m[1]);
                    String res = m[0].substring(0, z);
                    writeInQuotes(res);
                } else {
                    throw new Exception("Строка принимается только в кавычках");
                }
            } else {
                throw new Exception("Калькулятор принимает на вход числа от 1 до 10 ключительно и строки длинной не более 10 символов");
            }
        }
    }

    private static void writeInQuotes(String s) {
        if (s.length() <= 40) {
            System.out.println("\"" + s + "\"");
        } else {
            String dot = s.substring(0, 40);
            String ellipsis = "...";
            System.out.println("\"" + dot + ellipsis + "\"");
        }
    }
}