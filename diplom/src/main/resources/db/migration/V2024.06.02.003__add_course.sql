INSERT INTO course (name, description, category_id, course_cover, is_paid)
SELECT
'Інженерний курс «Народний FPV»',
'Курс створено фахівцями волонтерського проєкту Victory Drones та вітчизняного виробника дронів Vyriy Drone -Started - Feb 2, 2024 15:00 +03',
c.id, '', false
FROM category c WHERE c.name = 'Інженерія';