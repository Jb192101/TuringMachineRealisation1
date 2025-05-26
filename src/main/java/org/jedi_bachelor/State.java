package org.jedi_bachelor;

public enum State {
    S0, // машина включена
    S1, // состояние замены
    S2, // enter
    S3;

    public String toString() {
        String res = "";
        switch (this) {
            case S0:
                res = "S0";
                break;
            case S1:
                res = "S1";
                break;
            case S2:
                res = "S2";
                break;
            case S3:
                res = "S3";
                break;
        }

        return res;
    }
}
