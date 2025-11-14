INSERT INTO category (name) VALUES
('Work'),
('Personal'),
('Health'),
('Learning'),
('Home'),
('Finance');

INSERT INTO task (title, description, due_date, priority, completed, category_id) VALUES
('Finish API Module', 'Complete CRUD for task endpoints', '2025-02-15', 'HIGH', FALSE, 1),
('Team Meeting Prep', 'Prepare slides for sprint review', '2025-02-10', 'MEDIUM', FALSE, 1),
('Email Follow-Up', 'Respond to pending client emails', '2025-02-09', 'LOW', FALSE, 1),

('Buy Groceries', 'Weekly grocery shopping', '2025-02-08', 'LOW', FALSE, 2),
('Clean the Car', 'Wash and vacuum interior', '2025-02-12', 'MEDIUM', FALSE, 2),
('Plan Weekend Trip', 'Choose location and book hotel', '2025-02-20', 'LOW', FALSE, 2),

('Gym Workout', '45-minute strength session', '2025-02-07', 'MEDIUM', TRUE, 3),
('Doctor Appointment', 'Routine health check-up', '2025-02-12', 'HIGH', FALSE, 3),
('Buy Vitamins', 'Restock daily supplements', '2025-02-14', 'LOW', FALSE, 3),

('Read Spring Boot Docs', 'Study JPA relationships and queries', '2025-02-22', 'MEDIUM', FALSE, 4),
('Complete Java Course', 'Finish module 5 assessments', '2025-02-18', 'HIGH', FALSE, 4),
('Practice Algorithms', 'Solve 5 LeetCode questions', '2025-02-11', 'MEDIUM', FALSE, 4),

('Fix Kitchen Sink', 'Repair slow water leak', '2025-02-16', 'HIGH', FALSE, 5),
('Laundry', 'Wash and fold clothes', '2025-02-08', 'LOW', TRUE, 5),
('Clean Living Room', 'Vacuum and organize shelves', '2025-02-09', 'LOW', FALSE, 5),

('Budget Review', 'Go over monthly expenses', '2025-02-10', 'MEDIUM', FALSE, 6),
('Pay Electricity Bill', 'Monthly bill payment', '2025-02-13', 'HIGH', FALSE, 6),
('Update Investment Tracker', 'Record new stock transactions', '2025-02-19', 'LOW', FALSE, 6),

('Write Blog Post', 'Draft article on productivity', '2025-02-17', 'MEDIUM', FALSE, 1),
('Organize Desk', 'Declutter and sort documents', '2025-02-08', 'LOW', TRUE, 2);
