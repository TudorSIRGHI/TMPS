# Author: Sirghi Tudor

----

# Topic: *Creational Design Patterns*
## Objectives:
&ensp; &ensp; __1. Study and understand the Creational Design Patterns.__

&ensp; &ensp; __2. Choose a domain, define its main classes/models/entities and choose the appropriate instantiation mechanisms.__

&ensp; &ensp; __3. Use some creational design patterns for object instantiation in a sample project.__

## Some Theory:
&ensp; &ensp; Creational design patterns are a category of design patterns that focus on the process of object creation. They provide a way to create objects in a flexible and controlled manner, while decoupling the client code from the specifics of object creation. Creational design patterns address common problems encountered in object creation, such as how to create objects with different initialization parameters, how to create objects based on certain conditions, or how to ensure that only a single instance of an object is created. There are several creational design patterns that have their own strengths and weaknesses. Each of it is best suited for solving specific problems related to object creation. By using creational design patterns, developers can improve the flexibility, maintainability, and scalability of their code.

&ensp; &ensp; Some examples of this kind of design patterns are:

* Singleton
* Builder
* Prototype
* Object Pooling
* Factory Method
* Abstract Factory

## Implementation

* Introduction

I decided to implement Singleton, Builder, Prototype and Factory design principles.
I created a java program where there is a Farm and it is shown its farmers. Also, farmer has their own list of abilities.

* Snippets from your files.

* Singleton Principle:

```java
public class School {
    private static School school;
    private String name;

    private School() {
    }

    public static School getInstance() {
        if (school == null) {
            school = new School();
        }
        return school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

* Prototype Principle:

```java
@Override
public Object clone() throws CloneNotSupportedException {
        List<String> tempOblig = new ArrayList<String>(this.getSchoolTeaches());
        String tempFullName = this.getFullName();
        int tempSalary = this.getSalary();
        School tempDepartment = this.getSchool();
        return new TeacherBuilder()
        .setSalary(tempSalary)
        .setSchool(tempDepartment)
        .setSchoolTeaches(tempOblig)
        .setFullName(tempFullName)
        .build();
        }
```

* Builder Principle:

```java
public static class TeacherBuilder {
    private List<String> schoolTeaches;
    private String fullName;
    private int salary;
    private School school;

    public TeacherBuilder setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public TeacherBuilder setSalary(int salary) {
        this.salary = salary;
        return this;
    }

    public TeacherBuilder setSchoolTeaches(List<String> schoolTeaches) {
        this.schoolTeaches = schoolTeaches;
        return this;
    }

    public TeacherBuilder setSchool(School school) {
        this.school = school;
        return this;
    }

    public Teacher build() {
        return new Teacher(this);
    }
}
```

* Factory Principle:

```java
public class SchoolTypeFactory {
    public SchoolType chooseSchoolType(String schoolType)
    {
        if (schoolType == null || schoolType.isEmpty())
            return null;
        return switch (schoolType) {
            case "P" -> new PrimarySchool();
            case "L" -> new Lyceum();
            case "G" -> new Gymnasium();
            default -> throw new IllegalArgumentException("Unknown schoolType " + schoolType);
        };
    }
}
```

Main Class:

```java
 public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        School school = School.getInstance();
        school.setName("Ion Creanga");
        School school1 = School.getInstance();
        System.out.println("School name is " + school.getName());
        Teacher teacher = new Teacher.TeacherBuilder()
                .setSchoolTeaches(new ArrayList<>())
                .setSalary(200)
                .setSchool(school)
                .setFullName("Maria")
                .build();

        SchoolTypeFactory schoolTypeFactory = new SchoolTypeFactory();
        SchoolType lyceum = schoolTypeFactory.chooseSchoolType("L");
        SchoolType gymnasium = schoolTypeFactory.chooseSchoolType("G");
        SchoolType primarySchool = schoolTypeFactory.chooseSchoolType("P");
        teacher.schoolType(lyceum);
        teacher.schoolType(gymnasium);

        Teacher teacher2 = (Teacher) teacher.clone();
        Teacher teacher3 = (Teacher) teacher.clone();
        teacher3.schoolType(primarySchool);
        Teacher teacher4 = (Teacher) teacher.clone();
        teacher4.deleteObligation(lyceum);

        System.out.println(teacher2.getSchoolTeaches());
        System.out.println(teacher3.getSchoolTeaches());
        System.out.println(teacher4.getSchoolTeaches());
    }
}
```
## Conclusion
To sum up, I have created a simple code that implement the 4 design patterns that I choosed.
In my code I managed to implement somehow 4 creational design patterns. Moreover, I managed not only to copy and use them,
but also to connect 2 patterns in one class.