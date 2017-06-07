
package Controller;

import java.awt.Color;
import static java.awt.Color.green;

public class Casella {
    public Color colore = green;
    public boolean libera;
    Casella(boolean l, Color c) {
        libera = l;
        colore = c;
    }
    Casella(boolean l) {
        libera = l;
    }
}