package org.jedi_bachelor;

public enum Alphabet {
    M0, // "пробел"
    N0, // число 0
    N1, // число 1
    N2; // число 2

    public String toString() {
        String res = "";
        switch(this) {
            case M0:
                res = "m0";
                break;
            case N0:
                res = "0";
                break;
            case N1:
                res = "1";
                break;
            case N2:
                res = "2";
                break;
        }
        return res;
    }
}
