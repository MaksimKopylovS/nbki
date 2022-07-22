package org.nbki.task.one;

public class TaskOne {

    public String replace(String str, char find, char replace){

        char[] masChar = str.toCharArray();
        char[] replaceNew = new char[masChar.length];

        for (int i = 0; i < masChar.length; i++){
            if (masChar[i] == find){
               replaceNew[i] = replace;
            }else {
                replaceNew[i] = masChar[i];
            }
        }

        return new String(replaceNew);
    }
}
