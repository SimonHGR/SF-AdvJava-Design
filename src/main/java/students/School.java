package students;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

// Predicate<Student> :)
interface CriterionStudent {
  boolean test(Student s);
}

public class School {

  public static void showAll(List<?> ls, PrintStream out) {
    for (Object s : ls) {
      out.println("> " + s);
    }
  }

  // concurrency question??
  private static double smartnessThreshold = 3.0;
  public static void setSmartnessThreshold(double smartnessThreshold) {
    School.smartnessThreshold = smartnessThreshold;
  }

  public static List<Student> getSmartStudents(
      List<Student> ls) {
//  public static List<Student> getSmartStudents(
//      List<Student> ls, double threshold) {
    List<Student> rv = new ArrayList<>();
    for (Student s : ls) {
      if (s.getGpa() > smartnessThreshold) {
        rv.add(s);
      }
    }
    return(rv);
  }

  public static List<Student> getEnthusiasticStudents(
      List<Student> ls, int threshold) {
    List<Student> rv = new ArrayList<>();
    for (Student s : ls) {
      if (s.getCourses().size() > threshold) {
        rv.add(s);
      }
    }
    return(rv);
  }

//  public static List<Student> getSmartStudents(List<Student> ls) {
//    List<Student> rv = new ArrayList<>();
//    for (Student s : ls) {
//      if (s.getGpa() > 3.0) {
//        rv.add(s);
//      }
//    }
//    return(rv);
//  }
//
//  public static void showSmartStudents(List<Student> ls) {
//    for (Student s : ls) {
//      if (!(s.getGpa() > 3.0)) {
//        ls.remove(s);  // NO NO NO!!!
//      }
//    }
//  }
//  public static void showSmartStudents(List<Student> ls) {
//    for (Student s : ls) {
//      if (s.getGpa() > 3.0) {
//        System.out.println("> " + s);
//      }
//    }
//  }

  public static void main(String[] args) {
    List<Student> roster = List.of(
        new Student("Fred", 3.2, "Math", "Physics"),
        new Student("Jim", 2.2, "Journalism"),
        new Student("Sheila", 3.9,
            "Math", "Physics", "Quantum Mechanics", "Astro physics")
    );

    System.out.println("Marketing...");
//    showAll(getSmartStudents(roster, 3.0), System.out);
    showAll(getSmartStudents(roster), System.out);
    System.out.println("Professors...");
    School.setSmartnessThreshold(3.5);
    showAll(getSmartStudents(roster), System.out);
  }
}
