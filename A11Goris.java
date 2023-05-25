//Michell Goris

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


public class A11Goris {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Ask user for the amount of students that they wish to input
        System.out.print("How many students are there: ");
        //Store the students inside of numbeOfStudents
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine();

        //Check for number of students, if there is less than one return an error
        if (numberOfStudents < 1){
            System.out.println("ERROR! Invalid amount of students. Please Enter atleast one.");
            return;
        }

        //Create array for the amount of students stated above
        PhysEd[] students = new PhysEd[numberOfStudents];
        int index = 0;

        //Loop until all information has been filled
        while (index < numberOfStudents){
            //Ask  user to enter information
            System.out.print("Scores can range from 100 to -10. Please only input number scores (Ex. 10 not ten) and seperate the information with a space not a comma. ");
            System.out.print("Please enter student Name, strength, speed, and intelligence: ");
            //Read the input information
            String name = scanner.next();
            int strength = scanner.nextInt();
            int speed = scanner.nextInt();
            int intelligence = scanner.nextInt();
            scanner.nextLine();

            try{
                PhysEd student = new PhysEd(name,speed,strength,intelligence);
                //check for duplicate
                boolean sameScore = false;
                for (int i=0;i<index;i++){
                    if (students[i].equalScores(student)){
                        System.out.println("ERROR! Duplicates have been found. Students cannot share all three qualities." );
                        sameScore = true;
                        break;
                    }
                }

                if (!sameScore)
                    students[index++] = student;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                System.out.println("Student not entered. Please make entry again.");
            }

        }

        //Sorting for Rope Climb:
        //Us comparator for ease to sort the objects
        Arrays.sort(students, new Comparator<PhysEd>() {
            @Override
            public int compare(PhysEd o1, PhysEd o2) {
                //Check for data and sort based on importance, if same, then sort using the different data. All must not be the same
                //Compare o2 and o1 for order.
                if (o1.getStrength() == o2.getStrength()){
                    if (o1.getSpeed() == o2.getSpeed()){
                        return Integer.compare(o2.getIntelligence(),o1.getIntelligence());
                    }else{
                        return Integer.compare(o2.getSpeed(),o1.getSpeed());
                    }
                }else {
                    return Integer.compare(o2.getStrength(), o1.getStrength());
                }
            }
        });

        //Print the result.
        System.out.print("Rope Climb: ");
        for (PhysEd student: students){
            System.out.print(student.getName()+ " ");
        }
        System.out.println();

        //Sorting for freeze tag:
        //Same as above
        Arrays.sort(students, new Comparator<PhysEd>() {
            @Override
            public int compare(PhysEd o1, PhysEd o2) {
                if (o1.getSpeed() == o2.getSpeed()){
                    if (o1.getIntelligence() == o2.getIntelligence()){
                        return Integer.compare(o2.getStrength(),o1.getStrength());
                    }else{
                        return Integer.compare(o2.getIntelligence(),o1.getIntelligence());
                    }
                }else {
                    return Integer.compare(o2.getSpeed(), o1.getSpeed());
                }
            }
        });
        System.out.print("Freeze Tag: ");
        for (PhysEd student: students){
            System.out.print(student.getName()+ " ");
        }
        System.out.println();
        
        //Sorting for Programming
        //Same as above
        Arrays.sort(students, new Comparator<PhysEd>() {
            @Override
            public int compare(PhysEd o1, PhysEd o2) {
                if (o1.getIntelligence() == o2.getIntelligence()){
                    if (o1.getSpeed() == o2.getSpeed()){
                        return Integer.compare(o2.getStrength(),o1.getStrength());
                    }else{
                        return Integer.compare(o2.getSpeed(),o1.getSpeed());
                    }
                }else {
                    return Integer.compare(o2.getIntelligence(), o1.getIntelligence());
                }
            }
        });
        System.out.print("Programming: ");
        for (PhysEd student: students){
            System.out.print(student.getName() + " ");
        }
        System.out.println();
    }
}
