CREATE OR REPLACE FUNCTION idCategoryByName(c_name VARCHAR)
    RETURNS INT AS $$
DECLARE
    c_id INT;
BEGIN
    SELECT id INTO c_id FROM category WHERE name = c_name;
    RETURN c_id;
END;
$$ LANGUAGE plpgsql;


INSERT INTO category (name) VALUES ('Освіта');

INSERT INTO course (name, description, category_id, course_cover, is_paid, price)
VALUES
    ('Спочатку людина',
     'Онлайн-курс про безбар’єрність у закладах охорони здоров’я...',
     idCategoryByName('Підвищення кваліфікації'), 'cover_url_1', false, 0.0),

    ('Зростайте з Google: програма для малих бізнесів',
     'Онлайн-програма від Google...',
     idCategoryByName('IT'), 'cover_url_2', false, 0.0),

    ('Літні пригоди без шкоди: Як провести безпековий урок для підлітків',
     'Навчальні матеріали...',
     idCategoryByName('Підвищення кваліфікації'), 'cover_url_3', false, 0.0),

    ('Народжені серцем: курс про усиновлення',
     'Онлайн-курс для тих, хто замислюється про усиновлення...',
     idCategoryByName('Підвищення кваліфікації'), 'cover_url_4', false, 0.0),

    ('Мовити.Мотиви',
     'Онлайн-курс про українську мову...',
     idCategoryByName('Освіта'), 'cover_url_5', false, 0.0),

    ('Виведіть свій бізнес на міжнародний ринок',
     'Онлайн-курс від Google...',
     idCategoryByName('Підвищення кваліфікації'), 'cover_url_6', false, 0.0);
