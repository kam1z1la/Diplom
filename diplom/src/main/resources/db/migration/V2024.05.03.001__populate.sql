insert into role(name)
values ('ANONYMOUS'),
       ('USER'),
       ('ADMIN'),
       ('COURSE_OWNER'),
       ('EXPERT');

-- login admin, password admin
insert into public.user(first_name, last_name, mail ,password, phone_number)
select 'admin', '', 'testuser@gmail.com', '$2a$10$1i5mo49OJoBpEr9DTnYVvOmM0gqo1hg63syUP8lq6OEoGVjEYAYzq', '+3801234567890'
from role r where r.name='ADMIN';