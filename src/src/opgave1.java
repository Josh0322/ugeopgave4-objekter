 class Student {
        String name;
        int age;

         Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        void printInfo() {
            System.out.println(name + " er " + age + " år");

        }
    }

    Student findOldest(Student[] students) {
            Student oldest = students[0];

            for (Student s : students) {
                if (s.age > oldest.age) {
                    oldest = s;
                }
            }

            return oldest;
        }

        void main() {
            Student s1 = new Student("Josh", 22);
            Student s2 = new Student("Peter", 20);
            Student s3 = new Student("John", 24);

            Student[] students = {s1, s2, s3};

            System.out.println("Alle studerende:");

            for (Student s : students) {
                s.printInfo();
            }

            Student oldest = findOldest(students);
            System.out.println("Ældste studerende:");
            oldest.printInfo();

        }


