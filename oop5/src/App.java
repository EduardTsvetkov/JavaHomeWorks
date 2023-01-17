public class App {
    public static void main(String[] args) throws Exception {
        
        DbApi dbApi = new DbApi("users.txt", "hworks.txt", "achievements.txt");
        Db db = dbApi.getDb();

        
    }
}
