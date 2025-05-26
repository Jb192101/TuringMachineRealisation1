package org.jedi_bachelor;

/*
Реализация машины Тьюринга для увеличения на единицу числа, представленного
в троичной системе счисления
 */

public class TuringMachine extends AbstractTuringMachine {
    public TuringMachine(int _ch, Alphabet[] _tape, State _state) {
        this.controlHead = _ch;
        this.tape = _tape;
        this.state = _state;
    }

    @Override
    public void addOperation() {
        int countOfOperation = 0;
        int isSecondS0 = 0;

        State prevState = State.S0;
        Alphabet prevAlpha = this.tape[controlHead];

        while (isSecondS0 != 2) {
            if (this.state == State.S0 && controlHead > 0) {
                isSecondS0++;
                System.out.println(isSecondS0);
                switch (this.tape[controlHead]) {
                    case N0:
                        prevAlpha = Alphabet.N0;
                        prevState = this.state;

                        controlHead++;
                        this.state = State.S2;
                        countOfOperation++;
                        printTabuling("R", this.tape[controlHead], countOfOperation, prevState, prevAlpha);
                        break;
                    case N1:
                        prevAlpha = Alphabet.N1;
                        prevState = this.state;

                        controlHead++;
                        this.state = State.S2;
                        countOfOperation++;
                        printTabuling("R", this.tape[controlHead], countOfOperation, prevState, prevAlpha);
                        break;
                    case N2:
                        prevAlpha = Alphabet.N2;
                        prevState = this.state;

                        controlHead++;
                        this.state = State.S2;
                        countOfOperation++;
                        printTabuling("R", this.tape[controlHead], countOfOperation, prevState, prevAlpha);
                        break;
                    case M0:
                        prevAlpha = Alphabet.M0;
                        prevState = this.state;

                        this.state = State.S1;
                        controlHead--;
                        countOfOperation++;
                        printTabuling("L", this.tape[controlHead], countOfOperation, prevState, prevAlpha);
                        break;
                }
            } else if (this.state == State.S1) { // Если состояние s1 - состояние переноса
                switch (this.tape[controlHead]) {
                    case N0:
                        prevAlpha = Alphabet.N0;
                        prevState = this.state;

                        this.tape[controlHead] = Alphabet.N1;
                        this.state = State.S0;
                        countOfOperation++;
                        printTabuling("N", this.tape[controlHead], countOfOperation, prevState, prevAlpha);
                        break;
                    case N1:
                        prevAlpha = Alphabet.N1;
                        prevState = this.state;

                        this.tape[controlHead] = Alphabet.N2;
                        this.state = State.S0;
                        countOfOperation++;
                        printTabuling("N", this.tape[controlHead], countOfOperation, prevState, prevAlpha);
                        break;
                    case N2:
                        prevAlpha = Alphabet.N2;
                        prevState = this.state;

                        this.tape[controlHead] = Alphabet.N0;
                        controlHead--;
                        countOfOperation++;
                        printTabuling("L", this.tape[controlHead], countOfOperation, prevState, prevAlpha);
                        break;
                    case M0:
                        prevAlpha = Alphabet.M0;
                        prevState = this.state;

                        this.tape[controlHead] = Alphabet.N1;
                        this.state = State.S0;
                        countOfOperation++;
                        printTabuling("N", this.tape[controlHead], countOfOperation, prevState, prevAlpha);
                        break;
                }
            } else if (this.state == State.S2) {
                switch (this.tape[controlHead]) {
                    case N0:
                        prevAlpha = Alphabet.N0;
                        prevState = this.state;

                        this.controlHead++;
                        countOfOperation++;
                        printTabuling("R", this.tape[controlHead], countOfOperation, prevState, prevAlpha);
                        break;
                    case N1:
                        prevAlpha = Alphabet.N1;
                        prevState = this.state;

                        this.controlHead++;
                        countOfOperation++;
                        printTabuling("R", this.tape[controlHead], countOfOperation, prevState, prevAlpha);
                        break;
                    case N2:
                        prevAlpha = Alphabet.N2;
                        prevState = this.state;

                        this.controlHead++;
                        countOfOperation++;
                        printTabuling("R", this.tape[controlHead], countOfOperation, prevState, prevAlpha);
                        break;
                    case M0:
                        prevAlpha = Alphabet.M0;
                        prevState = this.state;

                        this.state = State.S1;
                        this.controlHead--;
                        countOfOperation++;
                        printTabuling("L", this.tape[controlHead], countOfOperation, prevState, prevAlpha);
                        break;
                }
            } else {
                break;
            }
        }
    }

    private void printTabuling(String _shift, Alphabet _newA, int _countOfOp, State _state, Alphabet _alpha) {
        System.out.println("T" + _countOfOp + ": " +
        _alpha + "," + _state +
                " -> "
        + _newA + "," + _shift + "," + this.state);
    }
}
