package org.jedi_bachelor;

abstract class AbstractTuringMachine {
    int controlHead; // индекс, на котором стоит управляющая головка
    Alphabet[] tape;
    State state;

    public void addOperation() {

    }

    public Alphabet[] getTape() {
        return this.tape;
    }
}
