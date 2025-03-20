package server.commands;
import java.util.StringJoiner;

import client.commands.utility.ConsoleInputHandler;
import collection.Dragon;
import server.managers.DragonManager;

/**
 * Команда для вывода всех элементов коллекции в строковом представлении.
 * Реализует интерфейс {@link Command}.
 */
public class ShowCommand implements Command {
    private DragonManager dragonManager;

    public ShowCommand(DragonManager dragonManager) {
        this.dragonManager = dragonManager;
    }

    @Override
    public boolean isHasArgs(){
        return false;
    }

    @Override
    public Object execute(Object arg){
        return dragonManager.getSortedDragons();
    }

    @Override
    public String getDescription(){
        return "вывести в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
    
}
