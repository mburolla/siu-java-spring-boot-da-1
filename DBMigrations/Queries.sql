/*
 * File: Queries.sql
 * Auth: Martin Burolla
 * Date: 12/18/20201
 */

select * from bookstore;
select * from bookstore_book;
select * from book;
select * from manager;

select *
from bookstore_book bsb
  join book b on b.book_id = bsb.book_id
  join bookstore bs on bsb.bookstore_id = bs.bookstore_id
where bs.bookstore_id = 1;
