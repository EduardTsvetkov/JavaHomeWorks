package Core;

/**
 * Персона (человек)
 */
abstract public class Person {
    protected String firstName;
    protected String lastName;
    protected int birthYear;

    /**
     * Конструктор персоны
     * @param firstName - имя
     * @param lastName - фамилия
     * @param birthYear - год рождения
     */
    public Person(String firstName, String lastName, int birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d", lastName, firstName, birthYear);
    }

}