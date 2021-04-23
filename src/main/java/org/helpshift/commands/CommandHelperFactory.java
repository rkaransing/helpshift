package org.helpshift.commands;

import org.helpshift.services.TrieInsertionService;
import org.helpshift.services.TriePrintingService;
import org.helpshift.services.TrieSearchingService;
import org.helpshift.services.TrieService;

/**
 * CommandHelperFactory helps us to decide what is the
 * input command and get its related methods.
 *
 * We are taking help of Singleton as well as Factory Design pattern here.
 *
 * @author Karansing Rajput
 * @version 1.0
 * @since 2021-04-21
 */
public class CommandHelperFactory {

    public enum COMMAND {INSERT, RETRIEVE, DISPLAY_CURRENT_STATE}

    private static CommandHelperFactory instance = new CommandHelperFactory();

    private CommandHelperFactory(){

    }

    public static CommandHelperFactory getInstance(){
        if(instance == null)
            instance = new CommandHelperFactory();
        return instance;
    }

    public TrieService getService(String command) throws Exception{
        if(command.equalsIgnoreCase(COMMAND.INSERT.name())){
            return new TrieInsertionService();
        }else if(command.equalsIgnoreCase(COMMAND.RETRIEVE.name())){
            return new TrieSearchingService();
        }else if(command.equalsIgnoreCase(COMMAND.DISPLAY_CURRENT_STATE.name())){
            return new TriePrintingService();
        }
        throw new Exception("Invalid Command  : " + command);
    }

}
