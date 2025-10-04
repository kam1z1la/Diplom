CREATE OR REPLACE FUNCTION idCourseByName(c_name VARCHAR)
    RETURNS INT AS $$
DECLARE
    c_id INT;
BEGIN
    SELECT id INTO c_id FROM course WHERE name = c_name;
    RETURN c_id;
END;
$$ LANGUAGE plpgsql;


UPDATE course
SET course_cover = '/assets/road.png'
WHERE id = idCourseByName('Виведіть свій бізнес на міжнародний ринок');

UPDATE course
SET course_cover = '/assets/mova.png'
WHERE id = idCourseByName('Мовити.Мотиви');

UPDATE course
SET course_cover = '/assets/face.png'
WHERE id = idCourseByName('Народжені серцем: курс про усиновлення');

UPDATE course
SET course_cover = '/assets/map.png'
WHERE id = idCourseByName('Літні пригоди без шкоди: Як провести безпековий урок для підлітків');

UPDATE course
SET course_cover = '/assets/spochatku-lyudyna.png'
WHERE id = idCourseByName('Спочатку людина');

UPDATE course
SET course_cover = '/assets/drone.png'
WHERE id = idCourseByName('Зростайте з Google: програма для малих бізнесів');
