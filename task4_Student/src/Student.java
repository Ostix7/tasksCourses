import java.util.Objects;

public class Student implements Cloneable {
    private int age;
    private String name;
    private String group;

    public Student(int age, String name, String group) {
        this.age = age;
        this.name = name;
        this.group = group;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else if (obj instanceof Student) {
            Student student = (Student) obj;
            return this.name.equals(student.name) &&
                    this.age == student.age && this.group.equals(student.group);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = name == null ? 0 : name.hashCode();
        result += 31 * age;
        result += group == null ? 0 : group.hashCode();
        return result;
    }


    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("no Cloneable found!");
        }
    }
}
