package comprog_proj;

import java.util.Scanner;
public class studentsystem {
    public static void main (String[]args){
        Scanner s = new Scanner (System.in);
        
        String[] students = new String[10];
        double[] grades = new double[10];
        
        double computed = 0;
        int numchoice;
        
        System.out.println("||| Welcome to Student Grade System |||");
        System.out.println("\nPlease input your students' name and their grades.\n");
        
        for (int i = 0; i < 10; i++){ 
            System.out.println("________");
            System.out.println("\nStudent No. " + (i + 1));
            System.out.println("________");
            
            System.out.print("\nName of Student " + (i + 1) + ": ");
            students[i] = s.nextLine();
            System.out.print(students[i] + "'s grade" + "(Student " + (i + 1) + ")" + " is: ");
            grades[i] = s.nextDouble();
            s.nextLine();     
            
            computed = computed + grades[i];
        }
        
        System.out.println("________\n");
        System.out.println("--- Summary of Records ---\n");
        for (int i = 0; i < 10; i++){
            if (grades[i] >= 75.0) {
               System.out.println("Student No. " + (i + 1) + " " +students[i] + "          ||          " + "Computed Grade: " + grades[i] + " PASSED");
            } else {
                System.out.println("Student No. " + (i + 1) + " " +students[i] + "          ||          " + "Computed Grade: " + grades[i] + " FAILED");
            }
             
        }
        
        System.out.print("\nDo you want to get their average grade?(Y/N) ");
        char ans = s.next().toUpperCase().charAt(0);
        
        if (ans == 'Y'){
            System.out.println("\nStudents' Average is: " + (computed  / 10));
        }
        
        System.out.print("\nDo you want to see the records in ascending order? (Y/N)  ");
        char ans2 = s.next().toUpperCase().charAt(0);
            
        if (ans2 == 'Y') {
            for (int i = 0; i < grades.length - 1; i++) {
                for (int j = 0; j < grades.length - i - 1; j++) {
                    if (grades[j] > grades[j + 1]) {
                        double tpgrade = grades[j];
                        grades[j] = grades[j + 1];
                        grades[j + 1] = tpgrade;
                        
                        String tpname = students[j];
                        students[j] = students[j + 1];
                        students[j + 1] = tpname;
                    }
                }
            }
                System.out.println("\n--- Records Sorted by Grade (Ascending) ---\n");
                for (int i = 0; i < 10; i++) {
                    System.out.println(students[i] + ": " + grades[i]);
                }
                System.out.println("\nProceeding to more options...");
        } else {
            System.out.println("\nProceeding to more options...");
            for (int i = 0; i < grades.length - 1; i++) {
                for (int j = 0; j < grades.length - i - 1; j++) {
                    if (grades[j] > grades[j + 1]) {
                        double tpgrade = grades[j];
                        grades[j] = grades[j + 1];
                        grades[j + 1] = tpgrade;
                        
                        String tpname = students[j];
                        students[j] = students[j + 1];
                        students[j + 1] = tpname;
                    }
                }
            }
        }
        
        do {
            System.out.println("\n||| More Options |||\n");
            System.out.println("[1] Search for students");
            System.out.println("[2] List of students in ascending order.");
            System.out.println("[3] Exit Program");
            System.out.print("What else do you want to perform? (1-3) ");
            
            numchoice = s.nextInt();
            s.nextLine(); 

            if (numchoice == 1) {
                System.out.print("\nSearch for student (Must be Exact): ");
                String namesearch = s.nextLine();
                boolean pair = false;
                
                for (int i = 0; i < students.length; i++) {
                    if (students[i].equalsIgnoreCase(namesearch)) {
                        System.out.println("\nStudent Found!");
                        System.out.println("Student no. " + (i + 1) + ": " + students[i] + "'s grade is " + grades[i]);
                        pair = true;
                        break;
                    }
                } 
                
                if (!pair) { 
                    System.out.println("Student not found in the records.");
                }

            } else if (numchoice == 2) { 
                System.out.println("\n--- Current Student List ---");
                for (int i = 0; i < 10; i++) {
                    System.out.println(students[i] + ": " + grades[i]);
                }
            } else if (numchoice == 3) {
                System.out.println("\nExiting Program... Thank you!");
            } else {
                System.out.println("\nInvalid choice. Please try again.");
            }

        } while (numchoice != 3);
        
        s.close();
    }
}
