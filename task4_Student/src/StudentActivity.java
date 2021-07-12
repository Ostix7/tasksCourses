/***
 * Imutable class
 * @author Eugenyi
 */

public final class StudentActivity {
    private final Student student;
    private final int avarageMark;
    private final   int yearOfStudy;

    public StudentActivity(Student student, int avarageMark, int yearOfStudy) {
        this.student = (Student) student.clone();
        this.avarageMark = avarageMark;
        this.yearOfStudy = yearOfStudy;
    }

    public Student getStudent() {
        return (Student) student.clone();
    }

    public int getAvarageMark() {
        return avarageMark;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public StudentActivity setStudent(Student student){
        return new StudentActivity(student, this.avarageMark, this.yearOfStudy);
    }
    public StudentActivity setMark(int mark){
        return new StudentActivity(this.student, mark, this.yearOfStudy);
    }
    public StudentActivity setYear(int year){
        return new StudentActivity(this.student, this.avarageMark, year);
    }
}
