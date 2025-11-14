USE springProject;

INSERT INTO Category (CategoryId, CategoryName, tasks)
VALUES
(1, 'Work', 'Work-related tasks'),
(2, 'Personal', 'Personal errands and chores'),
(3, 'Health', 'Fitness and medical tasks'),
(4, 'Learning', 'Education and self-improvement'),
(5, 'Home', 'Household maintenance tasks'),
(6, 'Finance', 'Money and budget planning');

INSERT INTO Task (TaskID, Title, TaskDescription, dueDate, priority, completed, catergory_id)
VALUES
(1,  'Finish API Module', 'Complete CRUD for task endpoints', '2025-02-15', 'High', FALSE, 1),
(2,  'Team Meeting Prep', 'Prepare slides for sprint review', '2025-02-10', 'Medium', FALSE, 1),
(3,  'Email Follow-Up', 'Respond to pending client emails', '2025-02-09', 'Low', FALSE, 1),

(4,  'Buy Groceries', 'Weekly grocery shopping', '2025-02-08', 'Low', FALSE, 2),
(5,  'Clean the Car', 'Wash and vacuum interior', '2025-02-12', 'Medium', FALSE, 2),
(6,  'Plan Weekend Trip', 'Choose location and book hotel', '2025-02-20', 'Low', FALSE, 2),

(7,  'Gym Workout', '45-minute strength session', '2025-02-07', 'Medium', TRUE, 3),
(8,  'Doctor Appointment', 'Routine health check-up', '2025-02-12', 'High', FALSE, 3),
(9,  'Buy Vitamins', 'Restock daily supplements', '2025-02-14', 'Low', FALSE, 3),

(10, 'Read Spring Boot Docs', 'Study JPA relationships and queries', '2025-02-22', 'Medium', FALSE, 4),
(11, 'Complete Java Course', 'Finish module 5 assessments', '2025-02-18', 'High', FALSE, 4),
(12, 'Practice Algorithms', 'Solve 5 LeetCode questions', '2025-02-11', 'Medium', FALSE, 4),

(13, 'Fix Kitchen Sink', 'Repair slow water leak', '2025-02-16', 'High', FALSE, 5),
(14, 'Laundry', 'Wash and fold clothes', '2025-02-08', 'Low', TRUE, 5),
(15, 'Clean Living Room', 'Vacuum and organize shelves', '2025-02-09', 'Low', FALSE, 5),

(16, 'Budget Review', 'Go over monthly expenses', '2025-02-10', 'Medium', FALSE, 6),
(17, 'Pay Electricity Bill', 'Monthly bill payment', '2025-02-13', 'High', FALSE, 6),
(18, 'Update Investment Tracker', 'Record new stock transactions', '2025-02-19', 'Low', FALSE, 6),

(19, 'Write Blog Post', 'Draft article on productivity', '2025-02-17', 'Medium', FALSE, 1),
(20, 'Organize Desk', 'Declutter and sort documents', '2025-02-08', 'Low', TRUE, 2);

