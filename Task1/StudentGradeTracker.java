// TASK:1

// StudentGradeTracker

/*Develop a program that allows a teacher to enter
students' grades and compute their average,
highest, and lowest scores. You can use arrays or
ArrayLists to store the student data.
import java.util.*;*/

class StudentGradeTracker{
    List<student> list = new LinkedList<>();             //students data
    HashMap<String,student> hmap = new HashMap<>();      // maps student rollno -> student information
    float classavg = 0;                                  // stores class average
    float[] markavg = new float[5];                      // class average of student marks
    float[] max = new float[5];
    float[] min = new float[5];
    static String[] maxmark = new String[5];
    String[] minmark = new String[5];
    StudentGradeTracker(){
        for(int i=0; i<5; i++){
            max[i] = Float.MIN_VALUE;
        }
        for(int i=0; i<5; i++){
            min[i] = Float.MAX_VALUE;
        }
    }
    void StudentInput(String rollno , String name , float[] mark){
        student newstudent = new student(rollno,name,mark);
        list.add(newstudent);
        hmap.put(rollno,newstudent);
    }
    void ComputeAvg(){
        int nofstudents = list.size();
        for(int i=0; i<nofstudents; i++){
            markavg[0] += list.get(i).mark[0];
            markavg[1] += list.get(i).mark[1];
            markavg[2] += list.get(i).mark[2];
            markavg[3] += list.get(i).mark[3];
            markavg[4] += list.get(i).mark[4];
            if(list.get(i).mark[0]>max[0]){
                maxmark[0] = list.get(i).name;
                max[0] = list.get(i).mark[0];

            }
            if(list.get(i).mark[1]>max[1]){
                maxmark[1] = list.get(i).name;
                max[1] = list.get(i).mark[1];
            }
            if(list.get(i).mark[2]>max[2]){
                maxmark[2] = list.get(i).name;
                max[2] = list.get(i).mark[2];
            }
            if(list.get(i).mark[3]>max[3]){
                maxmark[3] = list.get(i).name;
                max[3] = list.get(i).mark[3];
            }
            if(list.get(i).mark[4]>max[4]){
                maxmark[4] = list.get(i).name;
                max[4] = list.get(i).mark[4];
    
            }
            if(list.get(i).mark[0]<min[0]){
                minmark[0] = list.get(i).name;
                min[0] = list.get(i).mark[0];
    
            }
            if(list.get(i).mark[0]<min[1]){
                minmark[1] = list.get(i).name;
                min[1] = list.get(i).mark[1];
    
            }
            if(list.get(i).mark[0]<min[2]){
                minmark[2] = list.get(i).name;
                min[2] = list.get(i).mark[2];
    
            }
            if(list.get(i).mark[0]<min[3]){
                minmark[3] = list.get(i).name;
                min[3] = list.get(i).mark[3];
    
            }
            if(list.get(i).mark[0]<min[4]){
                minmark[4] = list.get(i).name;
                min[4] = list.get(i).mark[4];
    
            }
            classavg += list.get(i).stuavg;
        }
        markavg[0] /= nofstudents;
        markavg[1] /= nofstudents;
        markavg[2] /= nofstudents;
        markavg[3] /= nofstudents;
        markavg[4] /= nofstudents;
        classavg /= nofstudents;
    }
    String findsub(int idx){
        switch(idx){
            case 0 : return "English";
            case 1 : return "Mathematics";
            case 2 : return "Physics";
            case 3 : return "Chemistry";
            default : return "Computer Science";
        }
    }
    public class student{
        String rollno;
        String name;
        float[] mark = new float[5];
        float stuavg = 0;
        int higscoresub = -1;
        float max = Float.MIN_VALUE;
        int sum = 0;
        student(String rollno,String name,float[] mark){
            this.rollno = rollno;
            this.name = name;
            for(int i=0; i<5; i++){
                this.mark[i] = mark[i];
                this.stuavg += mark[i];
                this.sum += mark[i];
            }
            this.stuavg = this.stuavg/5;
            for(int i=0; i<5; i++){
                if(mark[i]>max){
                    max = mark[i];
                    higscoresub = i;
                }
            }
        }
    }
    public static void main(String[] args){
        try(Scanner scn = new Scanner(System.in)){
            StudentGradeTracker student = new StudentGradeTracker();
            System.out.println("STUDENT GRADES TRACKER: ");
            System.out.print("Enter number of records for the student: ");
            int studentcount = scn.nextInt();
            for(int i=0; i<studentcount;i++){
                System.out.print("Roll No. : ");
                String rollno = scn.next();
                System.out.print("Name : ");
                String name = scn.next();
                float[] mark = new float[5];
                System.out.println("Enter Marks : ");
                for(int j=0; j<5; j++){
                    if(j==0) System.out.print("English : ");
                    else if(j==1) System.out.print("Mathematics : ");
                    else if(j==2) System.out.print("Physics : ");
                    else if(j==3) System.out.print("Chemistry : ");
                    else if(j==4) System.out.print("Computer Science : ");
                    mark[j] = scn.nextFloat();
                }
                System.out.println();
                student.StudentInput(rollno,name,mark);
            }
            student.ComputeAvg();
            //To calculate class Average...
            System.out.println("Class Average "+student.classavg);
            //To calculate student with maximum mark for different subjects...
            System.out.println("Student with maximum marks in English is "+StudentGradeTracker.maxmark[0]);
            System.out.println("Student with maximum marks in Mathematics is "+StudentGradeTracker.maxmark[1]);
            System.out.println("Student with maximum marks in Physics is "+StudentGradeTracker.maxmark[2]);
            System.out.println("Student with maximum marks in Chemistry is "+StudentGradeTracker.maxmark[3]);
            System.out.println("Student with maximum marks in Computer Science is "+StudentGradeTracker.maxmark[4]);
            //To find maximum scoring subject for a given Roll no. ...
            System.out.println("Enter roll no of the student for finding maximum scoring subject: ");
            String num = scn.next();
            System.out.println("Maximum scoring subject for rollno "+num+" is "+student.findsub(student.hmap.get(num).higscoresub));
            num=scn.next();   
            //To calculate average score for a given student Roll no. .....
            System.out.print("Enter roll no of the student for finding average scoring subject : ");
            System.out.print("Average score for rollno "+num+" is "+student.hmap.get(num).stuavg);
        }catch(NullPointerException e){
            
        }
        
    }
}   
