package DbInit;
import DB.Db;

/**
 * Получение базы данных
 */
public class Loader {
    public Db db;
    private String pathUsers = "users.txt";
    private String pathHworks = "hworks.txt";
    private String pathAchievements = "achievements.txt";

    /**
     * Конструктор БД
     * @param pathUsers - путь к файлу с пользователями
     * @param pathHworks - путь к файлу с домашними заданиями
     * @param pathAchievements - путь к файлу с достижениями
     */
    public Loader(String pathUsers, String pathHworks, String pathAchievements) {
        this.pathUsers = pathUsers;
        this.pathHworks = pathHworks;
        this.pathAchievements = pathAchievements;
    }

    /**
     * Метод инициализирует БД (получает данные из файлов)
     */
    public void initDb() {
        db = new Db();
        db.users = UsersParser.getUsers(pathUsers);
        db.homeWorks = HomeWorkParser.getHomeWorks(pathHworks);
        db.achievements = AchievementsParser.getAchievements(pathAchievements);

    }

    public Db getDb() {
        return db;
    }

}