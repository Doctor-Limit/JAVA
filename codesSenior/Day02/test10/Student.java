package Day02.test10;

/**
 * ********概述：
 */
public class Student  {
    private String name;
    private int score;
    private int id;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public Student(String name,int score,int id){
        this.id=id;
        this.name=name;
        this.score=score;
    }

    @Override
    public String toString() {
        return name;
    }
}
