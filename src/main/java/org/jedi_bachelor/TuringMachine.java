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
        boolean isComplete = false;

        while(!isComplete) {
            if (this.state == State.S0) {
                if(this.tape[controlHead] != Alphabet.M0 && controlHead != 0) {
                    controlHead++;
                } else if(this.tape[controlHead] == Alphabet.M0) {
                    this.state = State.S1;
                    controlHead--;
                } else {
                    isComplete = true;
                }
            } else { // Если состояние s1 - состояние переноса
                switch(this.tape[controlHead]) {
                    case N0:
                        this.tape[controlHead] = Alphabet.N1;
                        this.state = State.S0;
                        isComplete = true;
                        break;
                    case N1:
                        this.tape[controlHead] = Alphabet.N2;
                        this.state = State.S0;
                        isComplete = true;
                        break;
                    case N2:
                        this.tape[controlHead] = Alphabet.N0;
                        controlHead--;
                        break;
                    case M0:
                        this.state = State.S0;
                        isComplete = true;
                        break;
                }
            }

        }
    }
}
