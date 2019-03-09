public class Person implements Comparable<Person>{

    private final int id;
    private final String name;


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public Person(int age, String name) {
        this.id = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return Integer.compare(getId(), o.getId());
    }
}
