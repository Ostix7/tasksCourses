public class Main {

    public static void main(String[] args) {
        Student student = new Student(21, "Bob", "IPZ");
        StudentActivity studentBobActivity = new StudentActivity(student, 3, 2);

        student.setAge(10);
        student.setName("Bobi");

        System.out.println(studentBobActivity.getStudent());
        System.out.println(student);

        studentBobActivity=studentBobActivity.setMark(123);
        System.out.println(studentBobActivity.getAvarageMark());


    }

}

