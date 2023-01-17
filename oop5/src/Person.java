abstract public class Person {
    protected String firstName;
    protected String lastName;
    protected int birthYear;


    public Person(String firstName, String lastName, int birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d", firstName, lastName, birthYear);
    }

}
