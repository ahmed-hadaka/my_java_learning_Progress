
public class Student extends Persone{
    private int study_Level;
    private String specialization;
    private float GPA;

    public Student() {
        study_Level = 8;
        specialization = "native";
        GPA = 4.3f;
}
public Student(String Name,int Age,String Address,String Nationality,int study_level,String specialization,Float GPA ) {
    super(Name, Age, Address, Nationality);
    this.study_Level = study_level;
    this.specialization = specialization;
    this.GPA = GPA;
}

    public void set_study_Level(int study_Level) {
        this.study_Level= study_Level;
    }
    public void set_specialization(String specialization) {                     
        this.specialization= specialization;
    }

    public void set_GPA(int GPA) {
        this.GPA = GPA;
    }
    public int get_study_Level() {
         return study_Level;
    }
    public String get_specialization() {                     
    return specialization;
    }
    public float get_GPA() {
        return GPA ;
    }
    
}
