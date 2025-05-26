package org.jedi_bachelor;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Пример ленты
        Alphabet[] tape = new Alphabet[8];
        tape[0] = Alphabet.M0;
        tape[1] = Alphabet.N0;
        for(int i = 2; i < tape.length - 1; i++) {
            tape[i] = Alphabet.N1;
        }
        tape[7] = Alphabet.M0;

        /*
        Блок сравнения
         */

        System.out.println(Arrays.toString(tape));

        TuringMachine turingMachine = new TuringMachine(3, tape, State.S0);
        int countOfOperations = 0;
        while(countOfOperations != 25) {
            turingMachine.addOperation();
            System.out.println(Arrays.toString(turingMachine.getTape()));
            countOfOperations++;
        }
    }
}