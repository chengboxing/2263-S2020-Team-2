package isu.gui;

import java.util.EventObject;

public class dialogEvent extends EventObject {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public dialogEvent(Object source) {
        super(source);
    }
}
