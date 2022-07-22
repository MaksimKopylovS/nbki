package org.nbki.task.two;

public class TaskTwo {

    public int stringToInt(String s) {
        int num = 0;
        int pos = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            num += (s.charAt(i) - '0') * pos;
            pos *= 10;
        }
        return num;
    }

    public double stringToDouble(String str) {
        double num = 0;
        double num2 = 0;
        int idForDot = str.indexOf('.');
        String st;

        if (idForDot != -1) {
            st = str.substring(0, idForDot);
            for (int i = str.length() - 1; i >= idForDot + 1; i--) {
                num2 = (num2 + str.charAt(i) - '0') / 10;
            }
        } else {
            st = str;
        }

        for (int i = 0; i < st.length(); i++) {
            num *= 10;
            num += st.charAt(i) - '0';
        }

        return num + num2;
    }
}
