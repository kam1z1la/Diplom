WITH new_users AS (
    INSERT INTO public.user(first_name, last_name, mail, password, phone_number)
        VALUES
            ('Анастасія', 'Бречко', 'testuser1@gmail.com', '$2a$10$1i5mo49OJoBpEr9DTnYVvOmM0gqo1hg63syUP8lq6OEoGVjEYAYzq', '+3805434567890'),
            ('Артур', 'Пройдаков', 'testuser2@gmail.com', '$2a$10$1i5mo49OJoBpEr9DTnYVvOmM0gqo1hg63syUP8lq6OEoGVjEYAYzq', '+3801764567890'),
            ('Катерина', 'Блізнюк', 'testuser3@gmail.com', '$2a$10$1i5mo49OJoBpEr9DTnYVvOmM0gqo1hg63syUP8lq6OEoGVjEYAYzq', '+3800234567890')
        RETURNING id
)

INSERT INTO user_role(user_id, role_id)
SELECT new_users.id, r.id
FROM new_users JOIN role r ON r.name = 'EXPERT';