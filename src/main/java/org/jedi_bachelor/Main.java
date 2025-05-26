package org.jedi_bachelor;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Пример ленты
        Alphabet[] tape = new Alphabet[8];
        tape[0] = Alphabet.M0;
        tape[1] = Alphabet.N2;
        for(int i = 2; i < tape.length - 2; i++) {
            tape[i] = Alphabet.N2;
        }
        tape[6] = Alphabet.N2;
        tape[7] = Alphabet.M0;

        /*
        Блок сравнения
         */

        System.out.println(Arrays.toString(tape));

        TuringMachine turingMachine = new TuringMachine(4, tape, State.S0);
        turingMachine.addOperation();
        System.out.println(Arrays.toString(turingMachine.getTape()));
    }
}