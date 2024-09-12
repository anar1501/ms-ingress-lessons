package creational.builder;

public class Person {
    private String name;
    private String surname;
    private int age;

    Person(final String name, final String surname, final int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public static PersonBuilder builder() {
        return new PersonBuilder();
    }

    public static class PersonBuilder {
        private String name;
        private String surname;
        private int age;

        PersonBuilder() {
        }

        public PersonBuilder name(final String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder surname(final String surname) {
            this.surname = surname;
            return this;
        }

        public PersonBuilder age(final int age) {
            this.age = age;
            return this;
        }

        public Person build() {
            return new Person(this.name, this.surname, this.age);
        }

        public String toString() {
            return "Person.PersonBuilder(name=" + this.name + ", surname=" + this.surname + ", age=" + this.age + ")";
        }
    }
}
