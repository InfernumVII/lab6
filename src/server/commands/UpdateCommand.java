package server.commands;

import java.util.StringJoiner;

import client.commands.utility.ArgHandler;
import client.commands.utility.ConsoleInputHandler;
import collection.Color;
import collection.Coordinates;
import collection.Dragon;
import collection.Dragon.Builder;
import collection.DragonCharacter;
import collection.DragonHead;
import collection.DragonType;
import network.models.UpdateCommandArgs;
import server.managers.ServerCommandManager;
import server.managers.DragonManager;
import server.managers.exceptions.DragonFindException;


/**
 * Команда для обновления значения элемента коллекции по его ID.
 * Реализует интерфейс {@link Command}.
 */
public class UpdateCommand implements Command {
    private DragonManager dragonManager;

    /**
     * Конструктор команды UpdateCommand.
     *
     * @param dragonManager объект {@link DragonManager} для управления командами.
     */
    public UpdateCommand(DragonManager dragonManager){
        this.dragonManager = dragonManager;
    }

    /**
     * Проверяет, имеет ли команда аргументы.
     *
     * @return возвращает {@code true}, так как команда требует ID дракона в качестве аргумента.
     */
    @Override
    public boolean isHasArgs(){
        return true;
    }

    /**
     * Выполняет команду обновления дракона по его ID.
     *
     * @param arg строка, содержащая ID дракона.
     */
    @Override
    public Object execute(Object argument){
        Dragon arg = (Dragon) argument;
        int id = arg.getId();

        Dragon dragon;
        try {
            dragon = dragonManager.returnDragonById(id);
        } catch (DragonFindException e) {
            return e.getMessage();
        }
        
        dragon.setName(arg.getName());
        dragon.setCoordinates(arg.getCoordinates());
        dragon.setAge(arg.getAge());
        dragon.setColor(arg.getColor());
        dragon.setType(arg.getType());
        dragon.setCharacter(arg.getCharacter());
        dragon.setHead(arg.getHead());

        return String.format("Дракон с ID-%d успешно обновлён!", id);
    }

    @Override
    public String getDescription(){
        return "обновить значение элемента коллекции, id которого равен заданному";
    }

    @Override
    public String stringArgument(){
        return "id";
    }
    
}
