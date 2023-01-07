public class Human {
    public String firstName;
    public String lastName;
    public String gender;
    public int birthYear;

    /**
     * Конструктор человека
     * @param firstName - имя
     * @param lastName - фамилия
     * @param gender - пол (м/ж)
     * @param birthYear - год рождения
     */
    Human(String firstName, String lastName, String gender, int birthYear){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthYear = birthYear;
    }


    @Override
    public String toString() {
        return String.format("%s %s %d", firstName, lastName, birthYear);
    }

}