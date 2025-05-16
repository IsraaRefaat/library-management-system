-- ===========================
-- 📚 Sample Data for Library Management System
-- ===========================

-- Insert Sample Publishers
INSERT INTO publisher (name, email, phone, address) VALUES
                                                        ('O''Reilly Media', 'info@oreilly.com', '+1234567890', '1005 Gravenstein Highway North, Sebastopol, CA'),
                                                        ('Pearson Education', 'contact@pearson.com', '+1234567891', '221B Baker Street, London');

-- Insert Sample Authors
INSERT INTO author (name, email, phone) VALUES
                                            ('Robert C. Martin', 'unclebob@example.com', '0123456789'),
                                            ('Martin Fowler', 'mfowler@example.com', '0123456790');

-- Insert Sample Categories
INSERT INTO category (name) VALUES
                                ('Software Engineering'),
                                ('Programming'),
                                ('Design Patterns');

-- Insert Sample Books
INSERT INTO book (title, isbn, edition, publication_year, language, summary, cover_image_url, publisher_id)
VALUES
    ('Clean Code', '9780132350884', 1, 2008, 'English', 'A handbook of agile software craftsmanship.', 'https://example.com/images/clean-code.jpg', 1),
    ('Refactoring', '9780134757599', 2, 2018, 'English', 'Improving the design of existing code.', 'https://example.com/images/refactoring.jpg', 2);

-- Map Books to Authors
INSERT INTO author_book (author_id, book_id) VALUES
                                                 (1, 1),
                                                 (2, 2);

-- Map Books to Categories
INSERT INTO book_category (book_id, category_id) VALUES
                                                     (1, 1),
                                                     (1, 2),
                                                     (2, 2),
                                                     (2, 3);

-- Insert Sample Members
INSERT INTO member (name, email, phone, address) VALUES
                                                     ('Esraa Kassem', 'esraa@example.com', '01012345678', '123 Library Street, Cairo'),
                                                     ('Ahmed Youssef', 'ahmed@example.com', '01087654321', '456 Reading Blvd, Alexandria');

-- Insert Sample Users (Use hashed passwords if applicable in production)
INSERT INTO users (name, password, email, role) VALUES
                                                    ('admin', 'admin123', 'admin@example.com', 'ADMIN'),
                                                    ('sami', 'sami123', 'sami@example.com', 'LIBRARIAN');

-- Insert Sample Borrow Transactions
INSERT INTO borrowing_transaction (book_id, member_id, borrowed_by_user_id, notes)
VALUES
    (1, 1, 2, 'Handled by librarian Sami'),
    (2, 2, 2, 'Borrowed for weekend reading');
