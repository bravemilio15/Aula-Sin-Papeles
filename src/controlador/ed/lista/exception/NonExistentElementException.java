package controlador.ed.lista.exception;

public class NonExistentElementException extends Exception{

    public NonExistentElementException() {
        super("This element doesn't exist in the list");
    }

}
