//CP1340 Lab 1 - Arrays and Strings
//Student: Cade Molloy - 20175269
//Due Date: October 4th, 2022
//Prof: Branko Cirovic

import java.util.*;
import java.io.*;

public class Lab12 {
    
    public static void main(String[] args) throws IOException {

        FileReader file = new FileReader("lab12.asm");
        BufferedReader reader = new BufferedReader(file);
        String text = "";
        String line = reader.readLine();
        
        while(line != null) {
            text += line;
            line = reader.readLine();
        }
        
        String source = text;
        parse(source);
    }

    public static String readFile(String filename) throws IOException {

        File f = new File(filename);
        int size = (int)f.length();
        char[] data = new char[size];

        FileReader fr = new FileReader(f);
        fr.read(data);
        fr.close();
        return new String(data);
    }

    public static void parse(String source) {
        StringTokenizer st = new StringTokenizer(source);
        int i = 1;

        while(st.hasMoreTokens()) {
            String token = st.nextToken();
            System.out.println(i + ": " + token);

            if(isPseudoOpCode(token)) {
                System.out.println("Pseudo OpCode\n");
            }
            i++;

            if(isOpCode(token)) {
                System.out.println("OpCode\n");
            }
            i++;

            if(isOperand(token)) {
                System.out.println("Operand\n");
            }
            i++;

            if(isLabel(token)) {
                System.out.println("Label\n");
            }
            i++;

            if(isNumber(token)) {
                System.out.println("Number\n");
            }
        }
    }

    public static boolean isPseudoOpCode(String s) {
        boolean answer = false;
        switch(s) {
            case ".begin" : answer = true; break;
            case ".data" : answer = true; break;
            case ".end" : answer = true; break;
            default: answer = false;
        }
        return answer;
    }

    public static boolean isOpCode(String s) {
        boolean answer = false;
        switch (s) {
            case "LOAD" : answer = true; break;
            case "STORE" : answer = true; break;
            case "CLEAR" : answer = true; break;
            case "ADD" : answer = true; break;
            case "INCREMENT" : answer = true; break;
            case "SUBTRACT" : answer = true; break;
            case "DECREMENT" : answer = true; break;
            case "COMPARE" : answer = true; break;
            case "JUMP" : answer = true; break;
            case "JUMPGT" : answer = true; break;
            case "JUMPEQ" : answer = true; break;
            case "JUMPLT" : answer = true; break;
            case "JUMPNEQ" : answer = true; break;
            case "IN" : answer = true; break;
            case "OUT" : answer = true; break;
            case "HALT" : answer = true; break;
            default: answer = false;
        }
        return answer;
    }

    public static boolean isOperand(String s) {
        boolean answer = false;
        int size = s.length();
        char data = ' ';

        for(int i = 0; i < size; i++) {
            data = s.charAt(i);
            
            if(isLetter(data) && !isOpCode(s)) {
                answer = true;
            }

            else {
                answer = false;
                break;
            }
        }
        return answer;
    }

    public static boolean isLabel(String s) {
        boolean answer = false;
        int size = s.length();
        char data = s.charAt(size-1);
        String first = s.substring(0,size-1);

        if(data == ':' && isOperand(first)) {
            answer = true;
        }

        else {
            answer = false;
        }
        return answer;
    }

    public static boolean isNumber(String s) {
        boolean answer = false;
        int size = s.length();
        char data = ' ';

        for(int i = 0; i < size; i++) {
            data = s.charAt(i);
            
            if(isDigit(data)) {
                answer = true;
            }

            else {
                answer = false;
                break;
            }
        }
        return answer;
    }

    public static boolean isLetter(char c) {
        boolean answer = false;

        if((c >= 'a' && c <= 'z')||(c >= 'A' && c <= 'Z')) {
            answer = true;
        }
        return answer;
    }

    public static boolean isDigit(char c) {
        boolean answer = false;

        if(c >= '0' && c <= '9') {
            answer = true;
        }
        return answer;
    }
    
}
