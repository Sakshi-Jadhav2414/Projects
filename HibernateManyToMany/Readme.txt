3) Many to Many --->

        a. bidirectional/unidirectional - Many to Many ---> ( Student <----> Courses )

Where multiple entities from one table can be associated with multiple entities from another table.

Taking an example of Student and Course:

One Student can enroll in many Courses.
One Course can have many Students.

In Many-To-Many mapping:
- Both entity classes hold collection references of each other (Bidirectional)
OR
- Only one entity holds reference (Unidirectional)

Hibernate creates an extra junction/intermediate table automatically to maintain the relationship.

------------------------------------------------------------

Syntax:

@Entity
@ManyToMany(cascade = CascadeType.ALL)

@JoinTable(
        name = "student_course",

        joinColumns =
        @JoinColumn(name = "student_id"),

        inverseJoinColumns =
        @JoinColumn(name = "course_id")
)

------------------------------------------------------------

In Student Entity:

@ManyToMany(cascade = CascadeType.ALL)

@JoinTable(
        name = "student_course",

        joinColumns =
        @JoinColumn(name = "student_id"),

        inverseJoinColumns =
        @JoinColumn(name = "course_id")
)

private List<Course> courses =
        new ArrayList<>();

Here:
- student_course is the junction table.
- student_id refers to Student table PK.
- course_id refers to Course table PK.

------------------------------------------------------------

Database Tables:

1. students
2. courses
3. student_course

student_course table stores relationship between both tables.

------------------------------------------------------------

Cascade:

If we save Student entity,
associated Course entities also get saved automatically.

Without cascade:
we have to save Student and Course separately.

With cascade:
Hibernate automatically saves associated entities.

------------------------------------------------------------

Cascade Types:

Persist --> Save child when saving parent

Merge --> Update child when updating parent

Remove --> Delete child when deleting parent

All --> Includes all above operations

------------------------------------------------------------

Example:

Student student1 =
        new Student("Vishal");

Course course1 =
        new Course("Java");

Course course2 =
        new Course("Hibernate");

student1.addCourse(course1);

student1.addCourse(course2);

session.persist(student1);

Hibernate automatically:
1. saves Student
2. saves Courses
3. inserts records into student_course table

------------------------------------------------------------

Important Notes:

@ManyToMany
used when many records relate to many records.

@JoinTable
creates intermediate/junction table.

joinColumns
represents current entity foreign key.

inverseJoinColumns
represents associated entity foreign key.

Foreign keys are stored inside junction table.

------------------------------------------------------------

Example of Junction Table:

student_course

student_id     course_id
--------------------------------
1              1
1              2
2              2
2              3

This table manages many-to-many relationships.