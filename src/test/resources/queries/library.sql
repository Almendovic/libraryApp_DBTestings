




select count(*) from books;

select count(*) from book_borrow
where is_returned=0;

select name from book_categories;


select name,isbn,author,description,year from books
where name='Agile Testing';


SELECT * from book_borrow
where is_returned=0;

select full_name from  users
where email='librarian43@library';


select status from users
where status ='INACTIVE';

SELECT status from users;

select name from book_categories;