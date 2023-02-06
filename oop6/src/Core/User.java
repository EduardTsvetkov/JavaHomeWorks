package Core;
import DB.AccountType;

/**
 * Пользователь системы (наследник персоны)
 */
public class User extends Person {
    // private String login;
    private String password;
    private AccountType type;

    /**
     * Конструктор "пользователя"
     * @param firstName - имя
     * @param lastName - фамилия
     * @param birthYear - год рождения
     * @param password - пароль
     * @param type - тип учетной записи
     */
    public User(String firstName, String lastName, int birthYear, 
                String password, AccountType type) {
        super(firstName, lastName, birthYear);            
        this.password = password;
        this.type = type; 
    }


    /**
     * Метод возвращает пароль пользователя
     * @return - пароль
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Метод устанавливает пароль пользователю
     * @param password - пароль
     */
    public void setPassword(String password) {
        this.password = password;
    }
  
    /**
     * Метод возвращает тип пользователя
     * @return - тип пользователя
     */
    public AccountType getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d, %s", 
                             super.lastName, super.firstName, super.birthYear, type);
    }


}