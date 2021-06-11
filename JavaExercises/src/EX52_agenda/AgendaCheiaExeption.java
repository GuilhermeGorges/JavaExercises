
package EX52_agenda;

/**
 *
 * @author Gui e Di
 */
public class AgendaCheiaExeption extends Exception {

    @Override
    public String getMessage() {        
        return "Agenda já está Cheia";
    }      
    
}
