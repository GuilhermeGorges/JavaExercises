
package ex50.agenda;

public class AgendaCheiaExeption extends Exception {

    @Override
    public String getMessage() {        
        return "Agenda já está Cheia";
    }      
    
}
