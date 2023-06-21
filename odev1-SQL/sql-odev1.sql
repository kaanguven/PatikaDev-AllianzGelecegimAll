
/*

Creating users table.

*/

CREATE TABLE users (
	user_id SERIAL PRIMARY KEY,
	username VARCHAR(50) UNIQUE NOT NULL,
	email VARCHAR(100) UNIQUE NOT NULL,
	creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	is_active BOOLEAN
);

/*

Creating "categories" table.


*/

CREATE TABLE categories (
  category_id SERIAL PRIMARY KEY,
  name VARCHAR(50) UNIQUE NOT NULL,
  creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


/*
Creating posts table.


*/

CREATE TABLE posts (
    post_id SERIAL PRIMARY KEY,
    user_id INTEGER NOT NULL,
    category_id INTEGER NOT NULL,
    title VARCHAR(50) NOT NULL,
    content TEXT NOT NULL,
    view_count INTEGER DEFAULT 0,
    creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_published BOOLEAN,
    FOREIGN KEY (user_id) REFERENCES users (user_id),
    FOREIGN KEY (category_id) REFERENCES categories (category_id)
);


/*
Creating comments table.



*/

CREATE TABLE comments (
  comment_id SERIAL PRIMARY KEY,
  post_id INTEGER REFERENCES posts(post_id) NOT NULL,
  user_id INTEGER REFERENCES users(user_id),
  comment TEXT NOT NULL
  CHECK (LENGTH(comment) > 0),
  creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  is_confirmed BOOLEAN
); 


/*

Adding data to the users table.

*/

insert into users (username, email, creation_date, is_active) values ('bgiurio0', 'fhammell0@1688.com', '2013-08-14 22:04:29', false);
insert into users (username, email, creation_date, is_active) values ('cbewshire1', 'lferriby1@ucoz.ru', '2011-09-02 09:13:06', false);
insert into users (username, email, creation_date, is_active) values ('okrause2', 'ebernth2@i2i.jp', '2019-06-15 11:34:54', false);
insert into users (username, email, creation_date, is_active) values ('mschindler3', 'acompford3@psu.edu', '2020-03-23 11:05:34', false);
insert into users (username, email, creation_date, is_active) values ('aravenhills4', 'mpauwel4@imgur.com', '2019-01-30 20:23:21', false);
insert into users (username, email, creation_date, is_active) values ('pmakiver5', 'jarnowicz5@apache.org', '2005-11-19 00:45:32', true);
insert into users (username, email, creation_date, is_active) values ('dhyland6', 'vsigne6@shop-pro.jp', '2017-02-02 10:07:00', true);
insert into users (username, email, creation_date, is_active) values ('ksalvage7', 'mmanketell7@reuters.com', '2019-05-20 05:20:51', false);
insert into users (username, email, creation_date, is_active) values ('ihalcro8', 'gocorrigane8@clickbank.net', '2009-02-04 09:09:27', true);
insert into users (username, email, creation_date, is_active) values ('wdevany9', 'tfrancesconi9@adobe.com', '2022-06-19 19:04:08', true);




/*


Adding data to the categories table.

*/

insert into categories (name, creation_date) values ('Comedy', '2018-06-12 20:41:48');
insert into categories (name, creation_date) values ('Drama', '2012-06-13 22:46:52');
insert into categories (name, creation_date) values ('Horror', '2012-10-06 03:23:23');
insert into categories (name, creation_date) values ('Documentary', '2012-09-07 22:47:49');

/*


Adding data to the posts table.

*/

insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (10, 2, 'Heiress, The', 'Love and Honor', 44, false, '2020-11-14 19:01:32');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (4, 1, 'Delicate Balance, A', 'KleinschlDer Film', 71, false, '2007-07-02 23:59:03');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (2, 1, 'That''s Entertainment', 'Bloodfist', 73, true, '2017-07-20 16:02:52');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (8, 3, 'Daddy Long Legs', 'Ticking Clock', 20, true, '2021-02-10 14:34:21');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (9, 2, 'Metropolis', 'The Paradigm', 92, false, '2013-01-29 15:58:37');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (4, 1, 'This Happy Breed', 'Kil Evil', 50, true, '2011-02-02 23:52:34');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (5, 2, 'Dust in then)', 'Dracula''s Daughter', 9, true, '2013-09-19 08:06:22');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (4, 4, 'Noi thelbinói)', 'Courier', 94, false, '2006-07-02 15:32:48');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (4, 4, 'Five Wives,Secretaries and Me', 'Day of the Jackal, The', 30, true, '2015-12-12 08:55:43');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (9, 4, 'Wrong Turnt for Dead', 'Room fo Brass, A', 84, true, '2010-05-30 06:04:31');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (3, 3, 'Transformeof the Moon', 'Fahrenheit 9/11', 95, true, '2001-07-02 07:47:13');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (10, 4, 'Child Bride', 'Powerightmares, The: The Rises of Fear', 43, true, '2001-11-09 16:38:00');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (1, 3, 'Pink Panrikes Again, The', 'Emperor', 31, false, '2017-12-12 22:37:41');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (9, 1, 'Lila Sa ça)', 'Head Office', 94, true, '2010-10-23 21:34:30');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (4, 1, 'Evil Aliens', 'Two Weenother Town', 100, true, '2015-02-05 00:15:42');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (8, 4, 'Zatoichi ôjiôichi 20', 'Goal! III', 37, true, '2010-06-07 04:02:48');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (10, 3, 'Philosophers, The Dark)', 'Waiting for Guffman', 12, false, '2017-08-23 22:08:52');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (9, 1, 'Road to Morocco', 'Lies and Illusions', 47, true, '2023-03-21 18:39:32');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (4, 3, 'Kermit''s Swamp Years', 'Amazing Spider-Man, The', 92, true, '2005-01-01 09:08:51');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (9, 1, 'Kauwboy', 'Fugitive Pieces', 72, false, '2004-07-14 13:28:14');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (1, 1, 'The Nutcracker Prince', 'Lili', 73, true, '2002-02-28 18:05:04');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (4, 3, 'Deal, The', 'Swimfan', 87, true, '2013-09-07 16:42:12');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (7, 2, 'Great Fre Nr. 7)', 'Hard Man, The', 19, true, '2022-08-03 08:32:56');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (6, 1, 'Scream 3', 'Thank You, Jeeves!', 60, true, '2023-01-10 16:34:26');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (6, 3, 'Young Unknowns, The', 'Tortilla Soup', 63, true, '2002-01-06 13:10:41');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (10, 4, 'Essential Killing', 'The Horribly Weapon', 50, false, '2023-04-12 16:41:50');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (2, 2, 'Tale of the Mummy', 'This Property is Condemned', 82, false, '2011-01-31 10:43:19');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (8, 3, 'What Just Happened', 'Blablablá', 50, true, '2023-03-05 17:25:21');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (5, 1, 'Mr. Mom', 'Lone Gold, The', 18, true, '2001-03-21 20:09:32');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (10, 4, 'Splice', 'Drowning by Numbers', 98, true, '2021-03-15 21:51:56');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (5, 4, 'Girl of the Golden West', 'Latitude Zer', 53, false, '2007-10-31 11:14:45');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (10, 2, 'Astronaut''s Wife, The', 'Dead Genesis', 12, false, '2013-09-01 12:54:39');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (1, 4, 'On the Ropes', 'Thampu', 3, true, '2019-12-27 12:00:15');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (7, 1, 'Quarantirminal', 'Galaxy of Terror (Quest)', 23, false, '2003-11-02 17:06:48');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (5, 3, 'Play it to the Bone', 'Tabloid', 43, false, '2007-05-02 08:25:56');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (6, 4, 'Whirlygirl', 'Dealer', 54, false, '2005-01-14 09:46:38');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (10, 3, 'Private Parts', 'Coup on (Clean Slate)', 100, false, '2009-10-29 19:45:33');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (3, 2, 'Undertaker and His Pals, The', 'Boom Town', 93, true, '2022-05-22 21:29:04');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (4, 4, 'Caiman, aimano)', 'Steamboat Round the Bend', 3, true, '2006-03-03 04:59:00');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (10, 2, 'Jerry Seinfeld: ''I''m Telme''', 'Fitna', 47, true, '2019-11-15 17:45:08');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (10, 3, 'Over the Edge', 'Requiem fo Heavyweight', 28, true, '2022-06-09 14:41:59');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (1, 4, 'Too Late Blues', 'Destinées, Les)', 38, false, '2023-03-31 16:46:42');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (5, 2, 'Ted Bundy', 'Forgenection', 12, false, '2007-10-02 13:23:58');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (9, 1, ' o'' Revolution', 'The Se Gloria', 93, false, '2008-08-20 23:25:06');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (9, 3, 'Knuckleball!', 'Perks of Belower, The', 98, true, '2001-09-22 07:23:20');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (10, 3, 'What Doesn''t Kill You', 'Chernobyl Diaries', 1, true, '2002-08-05 14:31:45');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (10, 4, 'Dating Games People Play', 'Rabbit Test', 70, true, '2017-06-06 19:02:03');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (8, 4, '1000 Journals', 'Theremin: Andyssey', 84, false, '2016-05-16 02:13:48');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (2, 1, 'Young Gods (Hymypoika)', 'Splatter University', 77, false, '2013-09-23 08:31:44');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (6, 2, 'Farewell, Hohes!)', 'The Man dn''t Die', 15, true, '2006-01-14 13:21:52');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (1, 2, 'Chalet Girl', 'Groundiracy, The', 37, false, '2001-03-03 03:20:41');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (8, 2, 'Achilleso kame', 'Manderlay', 79, false, '2018-09-07 15:05:59');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (4, 4, 'Late George Apley, The', 'See Heargrove', 98, true, '2010-05-09 15:32:51');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (5, 1, 'Santa Claus', 'Possessed', 87, false, '2004-05-10 08:31:39');
insert into posts (user_id, category_id, title, content, view_count, is_published, creation_date) values (9, 2, 'The Retrieval', 'Monkge, Les)', 12, false, '2006-11-05 17:12:50');


/*


Adding data to the comments table.

*/


insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (46, 6, 'Morbi a ipsum. Integer a nibh.', '2001-07-16 20:51:17', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (16, 4, 'Duis bibendum. Morbi non quam nec dui luctus rutrum.', '2006-05-18 04:34:18', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (25, 2, 'In congue.', '2014-12-31 01:57:20', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (51, 1, 'Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim.', '2012-05-14 13:31:07', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (3, 1, 'Integer tincidunt ante vel ipsum.', '2008-12-09 20:33:34', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (28, 8, 'Nullam sit amet turpis elementum ligula vehicula consequat.', '2010-04-19 07:40:05', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (4, null, 'Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh. Quisque id justo sit amet sapien dignissim vestibulum.', '2018-08-04 13:28:08', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (43, 8, 'Praesent blandit. Nam nulla.', '2006-06-08 22:47:20', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (2, 4, 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros.', '2002-11-29 20:46:50', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (10, 6, 'Donec quis orci eget orci vehicula condimentum. Curabitur in libero ut massa volutpat convallis.', '2018-01-01 04:43:00', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (34, 8, 'Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh. Quisque id justo sit amet sapien dignissim vestibulum.', '2011-03-21 03:37:11', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (19, null, 'In quis justo.', '2010-03-30 16:34:05', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (54, 8, 'Nullam molestie nibh in lectus. Pellentesque at nulla.', '2005-03-26 05:55:16', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (51, 6, 'Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi.', '2010-10-02 00:00:02', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (30, 6, 'Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis.', '2003-06-16 13:39:55', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (19, 7, 'Donec vitae nisi. Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla.', '2020-05-23 05:27:20', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (21, 2, 'Maecenas pulvinar lobortis est.', '2004-08-31 10:12:22', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (3, 8, 'Praesent blandit.', '2021-07-24 01:55:52', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (40, 1, 'Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi.', '2003-05-26 05:14:58', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (42, 5, 'Nam nulla. Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede.', '2004-01-06 08:19:55', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (7, 5, 'Praesent blandit.', '2001-07-26 14:09:16', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (27, null, 'Etiam vel augue.', '2002-05-06 21:17:46', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (2, 3, 'Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem.', '2006-07-21 07:58:47', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (48, 3, 'Curabitur convallis. Duis consequat dui nec nisi volutpat eleifend.', '2011-01-21 02:49:13', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (35, 9, 'Maecenas ut massa quis augue luctus tincidunt.', '2016-01-13 21:14:19', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (16, 7, 'Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim.', '2015-05-06 00:45:15', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (20, 5, 'Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci.', '2021-03-19 00:01:53', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (44, 1, 'Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl.', '2017-12-20 13:04:51', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (41, 9, 'Nullam porttitor lacus at turpis.', '2013-08-02 20:04:40', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (28, 9, 'Duis bibendum. Morbi non quam nec dui luctus rutrum.', '2007-06-30 16:40:01', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (43, null, 'Curabitur convallis.', '2000-03-08 05:53:13', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (14, 9, 'In quis justo.', '2008-10-14 23:10:34', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (42, 5, 'Pellentesque viverra pede ac diam.', '2001-11-03 12:46:23', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (24, 2, 'Aliquam sit amet diam in magna bibendum imperdiet.', '2019-09-19 03:49:37', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (4, 1, 'Aenean sit amet justo. Morbi ut odio.', '2017-09-19 15:40:12', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (18, 5, 'Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem. Integer tincidunt ante vel ipsum.', '2001-05-16 08:09:47', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (27, 1, 'Phasellus in felis.', '2006-10-13 07:05:58', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (43, 1, 'Integer tincidunt ante vel ipsum.', '2015-04-17 19:03:36', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (11, 10, 'Duis at velit eu est congue elementum. In hac habitasse platea dictumst.', '2011-06-10 19:33:41', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (6, 4, 'Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci.', '2013-02-23 03:35:51', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (1, 7, 'Nullam varius.', '2008-08-17 12:05:52', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (18, 9, 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros.', '2006-06-17 20:17:24', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (3, 5, 'Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien.', '2008-04-19 09:54:06', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (37, 10, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin interdum mauris non ligula pellentesque ultrices.', '2001-10-26 21:22:17', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (20, 3, 'Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros.', '2003-07-12 05:05:08', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (39, 2, 'Morbi ut odio. Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo.', '2008-06-29 16:18:26', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (27, 7, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', '2013-09-13 19:00:03', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (55, 6, 'Ut tellus.', '2014-03-24 07:17:14', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (22, 3, 'In hac habitasse platea dictumst. Etiam faucibus cursus urna.', '2020-11-13 07:40:56', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (30, 3, 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio.', '2014-07-09 07:11:39', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (35, 8, 'Nulla suscipit ligula in lacus.', '2005-12-06 21:11:19', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (52, 3, 'Nulla suscipit ligula in lacus.', '2017-05-26 13:48:58', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (7, 7, 'Morbi porttitor lorem id ligula.', '2015-05-14 13:16:17', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (23, 9, 'Pellentesque at nulla.', '2000-05-26 00:03:31', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (13, null, 'Proin eu mi.', '2021-09-27 01:05:21', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (37, 6, 'Nulla ut erat id mauris vulputate elementum. Nullam varius.', '2002-11-22 15:45:08', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (25, 10, 'Nulla ac enim. In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.', '2013-07-23 11:50:49', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (22, 5, 'Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem. Integer tincidunt ante vel ipsum.', '2002-03-31 08:51:39', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (46, 7, 'Morbi porttitor lorem id ligula.', '2016-10-23 04:52:50', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (44, 3, 'Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est.', '2003-09-25 16:32:06', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (26, 7, 'Suspendisse potenti.', '2022-04-15 01:13:28', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (37, 5, 'Proin at turpis a pede posuere nonummy.', '2010-07-20 22:22:50', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (27, 8, 'Suspendisse accumsan tortor quis turpis. Sed ante.', '2006-02-14 04:38:41', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (12, 9, 'Donec dapibus.', '2016-01-21 10:54:26', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (28, 4, 'Integer ac leo. Pellentesque ultrices mattis odio.', '2023-01-11 15:00:47', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (21, 4, 'Suspendisse potenti.', '2006-09-17 22:37:06', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (5, 8, 'Duis at velit eu est congue elementum.', '2004-01-21 14:38:32', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (44, 3, 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi.', '2014-10-19 22:23:11', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (34, 3, 'Praesent blandit lacinia erat.', '2012-02-04 23:32:26', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (16, 5, 'In sagittis dui vel nisl. Duis ac nibh.', '2002-09-12 18:22:13', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (29, 4, 'Proin interdum mauris non ligula pellentesque ultrices. Phasellus id sapien in sapien iaculis congue.', '2001-07-05 22:26:52', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (3, 4, 'Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.', '2006-03-29 02:06:52', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (41, 8, 'Nulla justo.', '2018-04-17 03:30:46', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (46, 8, 'Nullam varius. Nulla facilisi.', '2005-10-04 00:01:54', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (2, 3, 'Maecenas pulvinar lobortis est. Phasellus sit amet erat.', '2009-08-15 04:55:27', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (41, null, 'Praesent blandit. Nam nulla.', '2015-09-03 21:03:23', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (1, 9, 'Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus.', '2019-08-28 19:54:53', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (27, 6, 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi.', '2015-06-05 04:34:47', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (15, 2, 'Morbi porttitor lorem id ligula.', '2002-06-02 21:32:32', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (9, 3, 'Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien.', '2017-04-19 19:09:12', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (3, 1, 'Nulla nisl.', '2014-05-24 00:24:28', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (22, 3, 'Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo.', '2005-07-16 07:42:39', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (48, null, 'Fusce consequat.', '2008-02-21 16:01:09', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (41, 10, 'Nulla tellus.', '2015-12-03 12:17:43', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (51, 6, 'Pellentesque eget nunc.', '2002-10-01 12:00:50', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (29, 8, 'Sed sagittis.', '2002-10-21 15:35:15', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (55, 5, 'Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede. Morbi porttitor lorem id ligula.', '2020-06-24 21:15:21', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (20, 2, 'Nulla suscipit ligula in lacus.', '2011-03-12 07:26:14', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (4, 5, 'Nulla suscipit ligula in lacus.', '2007-07-17 09:20:52', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (7, 4, 'Curabitur in libero ut massa volutpat convallis. Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo.', '2015-08-23 19:31:28', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (15, 8, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin interdum mauris non ligula pellentesque ultrices.', '2002-02-27 19:32:56', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (4, 9, 'Suspendisse potenti. In eleifend quam a odio.', '2001-10-10 02:49:00', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (48, 9, 'Mauris sit amet eros.', '2017-10-12 12:58:31', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (28, 3, 'Nulla nisl. Nunc nisl.', '2013-02-04 03:52:12', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (44, 4, 'Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem.', '2022-12-18 20:11:13', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (31, 3, 'Maecenas tincidunt lacus at velit. Vivamus vel nulla eget eros elementum pellentesque.', '2021-06-21 11:38:03', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (44, 2, 'Nullam varius. Nulla facilisi.', '2013-09-01 02:37:09', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (24, 9, 'Nullam varius.', '2006-06-02 16:58:21', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (1, 4, 'Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus.', '2007-11-02 20:13:13', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (3, 8, 'Donec dapibus.', '2013-01-06 00:38:40', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (39, 8, 'Sed vel enim sit amet nunc viverra dapibus.', '2015-12-06 05:47:30', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (20, 2, 'Integer ac neque.', '2008-09-15 09:14:59', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (38, 8, 'Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo.', '2023-03-21 14:16:32', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (40, 6, 'Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis.', '2019-04-06 19:51:17', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (28, 5, 'Aliquam erat volutpat.', '2013-11-27 00:39:24', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (50, 3, 'Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue.', '2004-02-11 14:43:18', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (22, 5, 'Duis mattis egestas metus.', '2020-07-21 04:32:17', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (18, 3, 'In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.', '2023-01-15 20:46:30', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (17, 3, 'Pellentesque ultrices mattis odio. Donec vitae nisi.', '2019-04-25 18:50:50', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (33, 3, 'Vivamus vel nulla eget eros elementum pellentesque.', '2002-06-22 00:41:31', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (18, 6, 'Fusce consequat. Nulla nisl.', '2005-01-10 11:08:32', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (14, 5, 'Integer non velit.', '2017-10-15 00:09:40', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (41, 10, 'Nulla mollis molestie lorem.', '2001-07-10 18:15:29', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (54, 9, 'Proin eu mi. Nulla ac enim.', '2017-04-06 19:54:45', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (50, 7, 'Integer a nibh. In quis justo.', '2019-03-17 07:32:09', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (46, 8, 'Sed vel enim sit amet nunc viverra dapibus.', '2018-04-09 22:37:12', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (19, 4, 'Donec posuere metus vitae ipsum. Aliquam non mauris.', '2011-09-07 11:54:09', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (27, 6, 'Duis bibendum. Morbi non quam nec dui luctus rutrum.', '2014-09-17 09:41:54', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (52, 8, 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio.', '2012-05-03 06:44:58', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (40, 10, 'Nullam varius.', '2006-06-23 13:32:43', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (32, null, 'Etiam faucibus cursus urna.', '2011-02-21 22:21:31', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (30, 2, 'Aenean fermentum. Donec ut mauris eget massa tempor convallis.', '2001-04-27 18:19:33', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (31, 1, 'Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.', '2004-07-20 07:44:39', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (4, 5, 'Vivamus in felis eu sapien cursus vestibulum. Proin eu mi.', '2015-11-02 01:47:05', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (21, 9, 'Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci.', '2016-07-10 10:44:09', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (41, 7, 'Donec quis orci eget orci vehicula condimentum.', '2013-04-09 03:24:17', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (19, 9, 'Donec semper sapien a libero. Nam dui.', '2000-09-24 08:30:11', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (25, 2, 'Nulla tellus.', '2004-11-02 03:04:15', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (15, 5, 'Sed vel enim sit amet nunc viverra dapibus.', '2022-04-18 12:02:00', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (2, 9, 'Vivamus in felis eu sapien cursus vestibulum. Proin eu mi.', '2019-10-17 20:50:04', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (34, 6, 'Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla.', '2003-02-21 15:44:40', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (20, 7, 'Suspendisse potenti.', '2015-09-28 21:51:14', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (42, 4, 'Nam tristique tortor eu pede.', '2002-09-19 16:36:25', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (16, 3, 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est.', '2020-04-02 09:00:16', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (23, 1, 'In quis justo.', '2011-09-10 07:12:28', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (30, 1, 'Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat.', '2017-09-08 06:56:42', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (6, 3, 'Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl. Aenean lectus.', '2021-04-10 18:13:18', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (10, 1, 'Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem.', '2006-01-22 00:13:33', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (31, 4, 'Praesent lectus.', '2016-10-01 04:53:09', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (46, 2, 'In quis justo. Maecenas rhoncus aliquam lacus.', '2015-02-14 12:09:25', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (55, 9, 'Nulla justo.', '2015-02-02 18:46:14', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (45, null, 'Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo.', '2015-01-12 09:15:53', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (3, 1, 'Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem.', '2021-12-21 06:31:20', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (19, 1, 'Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat.', '2009-09-29 14:05:07', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (12, 3, 'Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh.', '2010-04-08 08:01:19', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (4, 10, 'Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros.', '2000-11-11 20:10:58', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (4, 7, 'Curabitur convallis. Duis consequat dui nec nisi volutpat eleifend.', '2020-03-07 14:36:10', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (48, 7, 'Fusce consequat. Nulla nisl.', '2020-07-08 15:54:42', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (24, 6, 'Duis consequat dui nec nisi volutpat eleifend. Donec ut dolor.', '2021-04-08 14:15:56', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (54, 5, 'Vestibulum rutrum rutrum neque. Aenean auctor gravida sem.', '2002-06-06 20:50:47', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (55, 3, 'Nulla suscipit ligula in lacus. Curabitur at ipsum ac tellus semper interdum.', '2011-03-30 07:54:02', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (29, 1, 'Suspendisse accumsan tortor quis turpis. Sed ante.', '2011-12-16 04:13:14', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (36, 9, 'Etiam pretium iaculis justo. In hac habitasse platea dictumst.', '2007-06-05 17:50:04', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (23, 5, 'Suspendisse accumsan tortor quis turpis.', '2007-09-26 03:49:05', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (2, 2, 'Ut tellus.', '2018-01-14 21:07:18', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (43, 6, 'Etiam justo.', '2007-11-02 02:14:16', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (51, 4, 'Duis ac nibh.', '2003-12-14 17:30:08', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (38, 1, 'Morbi non quam nec dui luctus rutrum. Nulla tellus.', '2009-07-20 17:30:47', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (10, 7, 'Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.', '2013-09-16 21:33:15', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (18, 3, 'Sed ante.', '2015-10-01 18:41:37', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (52, 8, 'Proin eu mi.', '2020-08-02 19:34:56', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (40, 2, 'Morbi quis tortor id nulla ultrices aliquet. Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo.', '2014-08-07 18:06:06', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (13, 10, 'Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci.', '2012-01-05 12:52:11', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (42, 5, 'Sed sagittis. Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci.', '2000-08-12 02:34:26', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (18, 6, 'Curabitur at ipsum ac tellus semper interdum.', '2000-09-20 03:49:09', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (18, 1, 'Nulla mollis molestie lorem. Quisque ut erat.', '2014-04-09 14:14:30', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (53, 5, 'Ut tellus.', '2022-11-29 06:12:16', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (51, 9, 'Duis ac nibh.', '2016-05-17 22:15:47', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (40, 7, 'Pellentesque eget nunc.', '2017-05-26 06:14:20', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (34, 5, 'In hac habitasse platea dictumst. Maecenas ut massa quis augue luctus tincidunt.', '2005-04-19 10:45:22', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (26, 6, 'Cras in purus eu magna vulputate luctus.', '2007-11-03 20:49:13', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (50, null, 'Pellentesque at nulla. Suspendisse potenti.', '2020-04-24 17:34:33', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (36, 10, 'In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.', '2017-01-20 16:00:12', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (31, 9, 'Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.', '2013-12-14 02:37:23', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (17, 3, 'Nullam varius. Nulla facilisi.', '2004-11-27 20:19:00', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (1, 1, 'Donec ut mauris eget massa tempor convallis.', '2017-10-01 15:16:37', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (31, 5, 'Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla. Nunc purus.', '2020-02-10 12:39:03', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (55, 1, 'Nunc rhoncus dui vel sem. Sed sagittis.', '2001-12-02 17:25:46', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (25, 3, 'Nulla mollis molestie lorem.', '2006-03-03 21:32:54', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (13, 7, 'Morbi a ipsum. Integer a nibh.', '2008-12-22 08:22:08', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (28, 2, 'Integer ac leo. Pellentesque ultrices mattis odio.', '2004-04-25 14:23:33', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (13, 9, 'Donec dapibus. Duis at velit eu est congue elementum.', '2004-09-26 00:45:28', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (15, 1, 'Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl. Aenean lectus.', '2008-08-14 23:56:15', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (35, 10, 'Maecenas pulvinar lobortis est. Phasellus sit amet erat.', '2017-08-01 04:58:29', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (20, null, 'Integer ac neque.', '2012-11-21 05:41:29', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (35, 10, 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', '2013-10-14 13:32:06', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (54, 5, 'Maecenas tincidunt lacus at velit. Vivamus vel nulla eget eros elementum pellentesque.', '2015-10-19 23:47:42', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (35, 1, 'Nunc purus.', '2009-04-11 16:45:27', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (23, 2, 'In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.', '2009-07-22 13:23:50', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (33, 8, 'Sed accumsan felis. Ut at dolor quis odio consequat varius.', '2003-08-01 08:14:19', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (29, 3, 'In quis justo. Maecenas rhoncus aliquam lacus.', '2018-10-02 19:55:00', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (46, 8, 'Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros. Vestibulum ac est lacinia nisi venenatis tristique.', '2005-06-15 04:00:19', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (10, 2, 'Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla.', '2020-03-15 15:20:12', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (20, null, 'Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa.', '2011-09-05 16:03:37', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (29, 3, 'Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus.', '2002-11-18 01:05:30', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (1, 5, 'Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue.', '2006-08-05 17:59:18', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (2, 10, 'Proin risus. Praesent lectus.', '2011-06-01 16:39:10', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (41, 7, 'Proin eu mi. Nulla ac enim.', '2019-10-16 13:52:37', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (42, 5, 'Donec dapibus.', '2015-11-30 04:49:23', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (3, 7, 'In blandit ultrices enim.', '2012-06-12 01:04:03', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (28, 6, 'Nulla nisl.', '2019-02-03 15:13:01', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (40, 1, 'Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus.', '2009-07-01 22:41:07', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (43, 5, 'Nulla mollis molestie lorem.', '2008-08-26 18:12:13', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (38, null, 'Vivamus vel nulla eget eros elementum pellentesque. Quisque porta volutpat erat.', '2023-02-28 04:33:52', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (30, 8, 'Sed accumsan felis. Ut at dolor quis odio consequat varius.', '2001-01-06 13:19:27', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (41, 10, 'Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante.', '2015-12-20 23:40:36', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (7, 4, 'Integer non velit.', '2007-01-07 17:35:20', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (45, 6, 'Cras in purus eu magna vulputate luctus. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.', '2015-05-06 08:55:06', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (10, 5, 'Pellentesque ultrices mattis odio.', '2018-08-27 06:21:36', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (15, 5, 'Aenean auctor gravida sem. Praesent id massa id nisl venenatis lacinia.', '2012-11-13 14:12:04', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (34, 5, 'Quisque arcu libero, rutrum ac, lobortis vel, dapibus at, diam.', '2003-03-01 20:54:42', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (42, 7, 'Nam nulla. Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede.', '2013-10-24 17:15:08', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (50, 10, 'In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante.', '2013-10-26 05:25:44', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (1, 1, 'Etiam justo.', '2007-02-27 23:26:48', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (26, 3, 'Curabitur in libero ut massa volutpat convallis.', '2014-12-19 01:08:00', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (8, 1, 'Nunc purus.', '2006-05-30 06:06:09', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (31, 8, 'Vivamus vel nulla eget eros elementum pellentesque.', '2013-08-15 06:57:21', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (21, 10, 'Nulla ac enim.', '2001-11-12 07:45:03', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (54, 3, 'Vivamus tortor. Duis mattis egestas metus.', '2005-10-14 17:27:18', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (39, 6, 'Integer tincidunt ante vel ipsum.', '2020-04-25 06:44:04', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (13, 2, 'Donec posuere metus vitae ipsum. Aliquam non mauris.', '2007-10-01 05:46:43', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (32, 10, 'Proin eu mi.', '2016-10-30 18:08:06', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (2, 8, 'Maecenas rhoncus aliquam lacus.', '2006-09-10 04:41:21', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (44, 6, 'Maecenas rhoncus aliquam lacus.', '2008-05-19 00:38:10', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (36, null, 'Mauris lacinia sapien quis libero.', '2020-06-27 18:17:21', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (41, 3, 'Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo. Maecenas pulvinar lobortis est.', '2000-11-10 02:29:34', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (30, 3, 'In est risus, auctor sed, tristique in, tempus sit amet, sem. Fusce consequat.', '2010-02-19 01:26:59', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (12, 5, 'In hac habitasse platea dictumst.', '2006-01-03 09:38:05', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (4, 3, 'Nulla justo.', '2016-09-14 00:23:51', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (16, 10, 'Quisque porta volutpat erat. Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla.', '2007-01-06 23:59:20', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (55, 4, 'Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci.', '2001-06-02 11:24:33', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (13, 1, 'Vivamus tortor.', '2003-11-18 19:34:20', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (8, 7, 'Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem.', '2003-12-13 12:21:22', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (55, 6, 'Aliquam quis turpis eget elit sodales scelerisque.', '2017-03-04 00:32:55', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (31, null, 'Phasellus sit amet erat.', '2013-01-24 10:44:18', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (8, 5, 'Morbi non quam nec dui luctus rutrum. Nulla tellus.', '2022-10-08 03:28:02', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (36, 4, 'Sed sagittis.', '2022-05-08 12:43:51', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (10, 7, 'Morbi porttitor lorem id ligula.', '2014-05-11 21:46:12', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (44, 1, 'Nulla mollis molestie lorem. Quisque ut erat.', '2018-07-18 06:37:29', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (23, null, 'Donec posuere metus vitae ipsum.', '2012-07-19 19:30:04', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (32, 5, 'Vivamus tortor. Duis mattis egestas metus.', '2019-08-30 19:11:38', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (55, 6, 'Nulla facilisi.', '2001-11-24 20:00:09', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (45, 8, 'Suspendisse potenti.', '2018-06-22 20:57:12', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (17, 8, 'Curabitur at ipsum ac tellus semper interdum.', '2016-10-26 11:56:22', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (27, 2, 'Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus.', '2014-05-28 16:50:18', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (10, 8, 'In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit.', '2015-08-20 20:32:34', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (49, 4, 'Donec dapibus.', '2020-10-29 17:30:29', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (13, 4, 'Praesent id massa id nisl venenatis lacinia.', '2016-01-11 21:32:45', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (30, 9, 'Integer tincidunt ante vel ipsum.', '2023-04-28 10:03:35', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (20, 4, 'In quis justo.', '2017-03-26 19:10:56', false);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (19, null, 'Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros.', '2009-07-25 16:02:12', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (39, 10, 'Suspendisse potenti.', '2013-09-12 22:50:36', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (31, 2, 'Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem.', '2003-12-05 10:06:26', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (43, 2, 'Donec quis orci eget orci vehicula condimentum.', '2022-05-29 06:21:36', true);
insert into comments (post_id, user_id, comment, creation_date, is_confirmed) values (52, 10, 'Donec dapibus.', '2019-05-13 13:37:40', true);



-- QUERIES

/*


1. Tüm blog yazılarının başlıkları, yazarları ve kategorileriyle birlikte getirin.

*/

SELECT posts.title, users.username, categories.name 
FROM posts
INNER JOIN categories ON posts.category_id = categories.category_id
INNER JOIN users ON posts.user_id = users.user_id;



/*


2. En son yayınlanan 5 blog yazısını başlıkları, yazarları ve yayın tarihleriyle birlikte alın.

*/

SELECT posts.title, users.username, posts.creation_date 
FROM posts
INNER JOIN users ON posts.user_id = users.user_id
WHERE posts.is_published = true
ORDER BY posts.creation_date DESC
LIMIT 5;

/*


3. Her blog yazısı için yorum sayısını gösterin.

*/

SELECT posts.title, COUNT(comments.post_id) 
FROM posts
LEFT JOIN comments ON posts.post_id = comments.post_id
GROUP BY posts.title;


/*


4. Tüm kayıtlı kullanıcıların kullanıcı adlarını ve e-posta adreslerini gösterin.

*/

SELECT username, email 
FROM users;


/*


5. En son 10 yorumu, ilgili gönderi başlıklarıyla birlikte alın.

*/


SELECT comments.comment, posts.title 
FROM comments
JOIN posts ON comments.post_id = posts.post_id
ORDER BY comments.creation_date DESC
LIMIT 10;

/*


6. Belirli bir kullanıcı tarafından yazılan tüm blog yazılarını bulun.

*/

SELECT users.username, posts.content 
FROM users
INNER JOIN posts ON users.user_id = posts.user_id
WHERE users.user_id = 1;




/*


7. Her kullanıcının yazdığı toplam gönderi sayısını alın.

*/

SELECT users.username, COUNT(posts.post_id) 
FROM posts
RIGHT JOIN users ON posts.user_id = users.user_id
GROUP BY users.username;


/*


8. Her kategoriyi, kategorideki gönderi sayısıyla birlikte gösterin.

*/

SELECT categories.name, COUNT(post_id) 
FROM posts
RIGHT JOIN categories ON posts.category_id = categories.category_id
GROUP BY categories.category_id;


/*


9. Gönderi sayısına göre en popüler kategoriyi bulun.

*/


SELECT categories.name, COUNT(posts.post_id)  
FROM posts
JOIN categories ON posts.category_id = categories.category_id
GROUP BY categories.name
ORDER BY COUNT(posts.post_id) DESC
LIMIT 1;


/*

10. Gönderilerindeki toplam görüntülenme sayısına göre en popüler kategoriyi bulun.

*/

SELECT categories.name, SUM(view_count) AS total_view 
FROM categories
JOIN posts ON categories.category_id = posts.category_id
GROUP BY name
ORDER BY total_view DESC
LIMIT 1;

/*

11. En fazla yoruma sahip gönderiyi alın.

*/

SELECT posts.title, COUNT(comment_id) 
FROM comments
JOIN posts ON comments.post_id = posts.post_id
GROUP BY posts.title
ORDER BY count DESC
LIMIT 1;



/*

12. Belirli bir gönderinin yazarının kullanıcı adını ve e-posta adresini gösterin.

*/

SELECT posts.content, users.username, users.email
FROM posts
INNER JOIN users ON posts.user_id = users.user_id
WHERE posts.post_id = 1;



/*

13. Başlık veya içeriklerinde belirli bir anahtar kelime bulunan tüm gönderileri bulun.

*/


SELECT * 
FROM posts
WHERE title ILIKE '%of%' OR content ILIKE '%of%';

/*

14. Belirli bir kullanıcının en son yorumunu gösterin.

*/

SELECT comment, users.username 
FROM comments
INNER JOIN users ON comments.user_id = users.user_id
WHERE users.user_id = 1
ORDER BY comments.creation_date DESC
LIMIT 1;

/*

15. Gönderi başına ortalama yorum sayısını bulun.

*/


SELECT AVG(sumComment)
FROM 
(SELECT post_id, COUNT(comments.comment_id) AS sumComment FROM comments
GROUP BY post_id) AS avgComment;

/*

16. Son 30 günde yayınlanan gönderileri gösterin.


*/

SELECT *
FROM posts
WHERE creation_date >= CURRENT_DATE - INTERVAL '30 DAYS';

/*

17. Belirli bir kullanıcının yaptığı yorumları alın.


*/

SELECT comment, user_id FROM comments
WHERE user_id = 1;

/*

18. Belirli bir kategoriye ait tüm gönderileri bulun.


*/

SELECT * FROM posts
WHERE category_id = 1;

/*


19. 5'ten az yazıya sahip kategorileri bulun.

*/

SELECT categories.name, COUNT(posts.category_id) 
FROM posts
RIGHT JOIN categories ON posts.category_id = categories.category_id
GROUP BY categories.name  
HAVING COUNT(posts.category_id) < 5;



/*


20. Hem bir yazı hem de bir yoruma sahip olan kullanıcıları gösterin.

*/

SELECT users.*
FROM users
WHERE users.user_id IN (
SELECT posts.user_id
FROM posts
GROUP BY posts.user_id
HAVING COUNT(*) = 1
)
AND users.user_id IN (
SELECT comments.user_id
FROM comments
GROUP BY comments.user_id
HAVING COUNT(*) = 1
);



/*


21. En az 2 farklı yazıya yorum yapmış kullanıcıları alın.


*/

SELECT users.username
FROM users
WHERE users.user_id IN (
SELECT user_id
FROM comments
GROUP BY user_id
HAVING COUNT(post_id) >= 2);




/*


22. En az 3 yazıya sahip kategorileri görüntüleyin.


*/

SELECT categories.name
FROM categories
WHERE categories.category_id IN (
SELECT category_id
FROM posts
GROUP BY category_id
HAVING COUNT(*) >= 3);

/*


23. 5'ten fazla blog yazısı yazan yazarları bulun.


*/

SELECT users.username
FROM users
WHERE users.user_id IN (
SELECT user_id
FROM posts
GROUP BY user_id
HAVING COUNT(*) > 5);

/*


24. Bir blog yazısı yazmış veya bir yorum yapmış kullanıcıların e-posta adreslerini
görüntüleyin. (UNION kullanarak)


*/

SELECT email
FROM users
JOIN posts ON posts.user_id = users.user_id
GROUP BY users.user_id
HAVING COUNT(posts.post_id) >= 1
UNION
SELECT email
FROM users
JOIN comments ON comments.user_id = users.user_id
GROUP BY users.user_id
HAVING COUNT(comments.comment_id) >= 1;

/*


25. Bir blog yazısı yazmış ancak hiç yorum yapmamış yazarları bulun.


*/

SELECT users.email 
FROM users
WHERE (SELECT COUNT(*) FROM posts WHERE users.user_id = posts.user_id) > 0
AND
(SELECT COUNT(*) FROM comments WHERE users.user_id = comments.user_id)  0