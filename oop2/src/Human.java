public class Human {
    String firstName;
    String lastName;
    String gender;
    String age;
    /**
     * Конструктор человека
     * @param _firstName
     * @param _lastName
     * @param _gender
     * @param _age
     */
    Human(String _firstName, String _lastName, String _gender, String _age){
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.gender = _gender;
        this.age = _age;
    }
}