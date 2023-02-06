package DB;
import java.util.ArrayList;
import java.util.HashMap;

import Core.Achievement;
import Core.Action;
import Core.HomeWork;
import Core.User;

/**
 * Описание базы данных
 */
public class Db {
    public HashMap<String, User> users;
    public HashMap<Integer, HomeWork> homeWorks;
    public ArrayList<Achievement> achievements;
    public HashMap<String, Action> actions;
}