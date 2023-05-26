package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MorseFileDecoder {

    private static final Map<String, String> MORSE_CODE_MAP = new HashMap<>();

    static {
        MORSE_CODE_MAP.put(".-", "A");
        MORSE_CODE_MAP.put("-...", "B");
        MORSE_CODE_MAP.put("-.-.", "C");
        MORSE_CODE_MAP.put("-..", "D");
        MORSE_CODE_MAP.put(".", "E");
        MORSE_CODE_MAP.put("..-.", "F");
        MORSE_CODE_MAP.put("--.", "G");
        MORSE_CODE_MAP.put("....", "H");
        MORSE_CODE_MAP.put("..", "I");
        MORSE_CODE_MAP.put(".---", "J");
        MORSE_CODE_MAP.put("-.-", "K");
        MORSE_CODE_MAP.put(".-..", "L");
        MORSE_CODE_MAP.put("--", "M");
        MORSE_CODE_MAP.put("-.", "N");
        MORSE_CODE_MAP.put("---", "O");
        MORSE_CODE_MAP.put(".--.", "P");
        MORSE_CODE_MAP.put("--.-", "Q");
        MORSE_CODE_MAP.put(".-.", "R");
        MORSE_CODE_MAP.put("...", "S");
        MORSE_CODE_MAP.put("-", "T");
        MORSE_CODE_MAP.put("..-", "U");
        MORSE_CODE_MAP.put("...-", "V");
        MORSE_CODE_MAP.put(".--", "W");
        MORSE_CODE_MAP.put("-..-", "X");
        MORSE_CODE_MAP.put("-.--", "Y");
        MORSE_CODE_MAP.put("--..", "Z");
        MORSE_CODE_MAP.put(".----", "1");
        MORSE_CODE_MAP.put("..---", "2");
        MORSE_CODE_MAP.put("...--", "3");
        MORSE_CODE_MAP.put("....-", "4");
        MORSE_CODE_MAP.put(".....", "5");
        MORSE_CODE_MAP.put("-....", "6");
        MORSE_CODE_MAP.put("--...", "7");
        MORSE_CODE_MAP.put("---..", "8");
        MORSE_CODE_MAP.put("----.", "9");
        MORSE_CODE_MAP.put("-----", "0");
        MORSE_CODE_MAP.put(".-.-", "Ä");

        MORSE_CODE_MAP.put("--.--", "Ñ");
        MORSE_CODE_MAP.put("---.", "Ö");
        MORSE_CODE_MAP.put("..--", "Ü");
        MORSE_CODE_MAP.put(".--.-", "Á");
        MORSE_CODE_MAP.put("----", "É");
        MORSE_CODE_MAP.put("..-..", "È");
        MORSE_CODE_MAP.put("-.-..", "Ç");
        MORSE_CODE_MAP.put("---...", "Ô");
        MORSE_CODE_MAP.put("--..--", ",");
    }

    public static void main(String[] args) {
        String inputFilePath = "input_morse.txt";
        String outputFilePath = "output_decoded.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String decoded = morseDecoder(line);
                writer.write(line + " -> " + decoded);
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String morseDecoder(String morseCode) {
        StringBuilder decodedMessage = new StringBuilder();
        String[] words = morseCode.trim().split(" {3}");

        for (String word : words) {
            String[] letters = word.split(" ");
            for (String letter : letters) {
                String decodedLetter = MORSE_CODE_MAP.get(letter);
                if (decodedLetter != null) {
                    decodedMessage.append(decodedLetter);
                } else {
                    decodedMessage.append(" ");
                }
            }
            decodedMessage.append(" ");
        }

        return decodedMessage.toString().trim();
    }

}
