import { Injectable } from '@angular/core';
import { Comments } from './comment';
import { UserService } from 'src/app/user/user.service';
import { Users } from 'src/app/user/user-list/user';
@Injectable({
  providedIn: 'root'
})
export class CommentService {

  constructor() { }

  private commentList : Comments[] = [
    {
      comment_id: 1,
      post_id: 46,
      user_id: 6,
      comment: "Morbi a ipsum. Integer a nibh.",
      creation_date: "2001-07-16 20:51:17",
      is_confirmed: false
    },
    {
      comment_id: 2,
      post_id: 16,
      user_id: 4,
      comment: "Duis bibendum. Morbi non quam nec dui luctus rutrum.",
      creation_date: "2006-05-18 04:34:18",
      is_confirmed: false
    },
    {
      comment_id: 3,
      post_id: 25,
      user_id: 2,
      comment: "In congue.",
      creation_date: "2014-12-31 01:57:20",
      is_confirmed: true
    },
    {
      comment_id: 4,
      post_id: 51,
      user_id: 1,
      comment: "Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim.",
      creation_date: "2012-05-14 13:31:07",
      is_confirmed: true
    },
    {
      comment_id: 5,
      post_id: 3,
      user_id: 1,
      comment: "Integer tincidunt ante vel ipsum.",
      creation_date: "2008-12-09 20:33:34",
      is_confirmed: true
    },
    {
      comment_id: 6,
      post_id: 28,
      user_id: 8,
      comment: "Nullam sit amet turpis elementum ligula vehicula consequat.",
      creation_date: "2010-04-19 07:40:05",
      is_confirmed: true
    },
    {
      comment_id: 7,
      post_id: 4,
      user_id: "NULL",
      comment: "Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh. Quisque id justo sit amet sapien dignissim vestibulum.",
      creation_date: "2018-08-04 13:28:08",
      is_confirmed: false
    },
    {
      comment_id: 8,
      post_id: 43,
      user_id: 8,
      comment: "Praesent blandit. Nam nulla.",
      creation_date: "2006-06-08 22:47:20",
      is_confirmed: false
    },
    {
      comment_id: 9,
      post_id: 2,
      user_id: 4,
      comment: "Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros.",
      creation_date: "2002-11-29 20:46:50",
      is_confirmed: false
    },
    {
      comment_id: 10,
      post_id: 10,
      user_id: 6,
      comment: "Donec quis orci eget orci vehicula condimentum. Curabitur in libero ut massa volutpat convallis.",
      creation_date: "2018-01-01 04:43:00",
      is_confirmed: false
    },
    {
      comment_id: 11,
      post_id: 34,
      user_id: 8,
      comment: "Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh. Quisque id justo sit amet sapien dignissim vestibulum.",
      creation_date: "2011-03-21 03:37:11",
      is_confirmed: true
    },
    {
      comment_id: 12,
      post_id: 19,
      user_id: "NULL",
      comment: "In quis justo.",
      creation_date: "2010-03-30 16:34:05",
      is_confirmed: true
    },
    {
      comment_id: 13,
      post_id: 54,
      user_id: 8,
      comment: "Nullam molestie nibh in lectus. Pellentesque at nulla.",
      creation_date: "2005-03-26 05:55:16",
      is_confirmed: false
    },
    {
      comment_id: 14,
      post_id: 51,
      user_id: 6,
      comment: "Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi.",
      creation_date: "2010-10-02 00:00:02",
      is_confirmed: true
    },
    {
      comment_id: 15,
      post_id: 30,
      user_id: 6,
      comment: "Nullam orci pede, venenatis non, sodales sed, tincidunt eu, felis.",
      creation_date: "2003-06-16 13:39:55",
      is_confirmed: false
    },
    {
      comment_id: 16,
      post_id: 19,
      user_id: 7,
      comment: "Donec vitae nisi. Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla.",
      creation_date: "2020-05-23 05:27:20",
      is_confirmed: true
    },
    {
      comment_id: 17,
      post_id: 21,
      user_id: 2,
      comment: "Maecenas pulvinar lobortis est.",
      creation_date: "2004-08-31 10:12:22",
      is_confirmed: false
    },
    {
      comment_id: 18,
      post_id: 3,
      user_id: 8,
      comment: "Praesent blandit.",
      creation_date: "2021-07-24 01:55:52",
      is_confirmed: true
    },
    {
      comment_id: 19,
      post_id: 40,
      user_id: 1,
      comment: "Donec diam neque, vestibulum eget, vulputate ut, ultrices vel, augue. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi.",
      creation_date: "2003-05-26 05:14:58",
      is_confirmed: false
    },
    {
      comment_id: 20,
      post_id: 42,
      user_id: 5,
      comment: "Nam nulla. Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede.",
      creation_date: "2004-01-06 08:19:55",
      is_confirmed: false
    },
    {
      comment_id: 21,
      post_id: 7,
      user_id: 5,
      comment: "Praesent blandit.",
      creation_date: "2001-07-26 14:09:16",
      is_confirmed: false
    },
    {
      comment_id: 22,
      post_id: 27,
      user_id: "NULL",
      comment: "Etiam vel augue.",
      creation_date: "2002-05-06 21:17:46",
      is_confirmed: true
    },
    {
      comment_id: 23,
      post_id: 2,
      user_id: 3,
      comment: "Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem.",
      creation_date: "2006-07-21 07:58:47",
      is_confirmed: false
    },
    {
      comment_id: 24,
      post_id: 48,
      user_id: 3,
      comment: "Curabitur convallis. Duis consequat dui nec nisi volutpat eleifend.",
      creation_date: "2011-01-21 02:49:13",
      is_confirmed: true
    },
    {
      comment_id: 25,
      post_id: 35,
      user_id: 9,
      comment: "Maecenas ut massa quis augue luctus tincidunt.",
      creation_date: "2016-01-13 21:14:19",
      is_confirmed: true
    },
    {
      comment_id: 26,
      post_id: 16,
      user_id: 7,
      comment: "Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim.",
      creation_date: "2015-05-06 00:45:15",
      is_confirmed: true
    },
    {
      comment_id: 27,
      post_id: 20,
      user_id: 5,
      comment: "Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci.",
      creation_date: "2021-03-19 00:01:53",
      is_confirmed: true
    },
    {
      comment_id: 28,
      post_id: 44,
      user_id: 1,
      comment: "Fusce posuere felis sed lacus. Morbi sem mauris, laoreet ut, rhoncus aliquet, pulvinar sed, nisl.",
      creation_date: "2017-12-20 13:04:51",
      is_confirmed: true
    },
    {
      comment_id: 29,
      post_id: 41,
      user_id: 9,
      comment: "Nullam porttitor lacus at turpis.",
      creation_date: "2013-08-02 20:04:40",
      is_confirmed: false
    },
    {
      comment_id: 30,
      post_id: 28,
      user_id: 9,
      comment: "Duis bibendum. Morbi non quam nec dui luctus rutrum.",
      creation_date: "2007-06-30 16:40:01",
      is_confirmed: true
    },
    {
      comment_id: 31,
      post_id: 43,
      user_id: "NULL",
      comment: "Curabitur convallis.",
      creation_date: "2000-03-08 05:53:13",
      is_confirmed: false
    },
    {
      comment_id: 32,
      post_id: 14,
      user_id: 9,
      comment: "In quis justo.",
      creation_date: "2008-10-14 23:10:34",
      is_confirmed: true
    },
    {
      comment_id: 33,
      post_id: 42,
      user_id: 5,
      comment: "Pellentesque viverra pede ac diam.",
      creation_date: "2001-11-03 12:46:23",
      is_confirmed: true
    },
    {
      comment_id: 34,
      post_id: 24,
      user_id: 2,
      comment: "Aliquam sit amet diam in magna bibendum imperdiet.",
      creation_date: "2019-09-19 03:49:37",
      is_confirmed: false
    },
    {
      comment_id: 35,
      post_id: 4,
      user_id: 1,
      comment: "Aenean sit amet justo. Morbi ut odio.",
      creation_date: "2017-09-19 15:40:12",
      is_confirmed: false
    },
    {
      comment_id: 36,
      post_id: 18,
      user_id: 5,
      comment: "Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem. Integer tincidunt ante vel ipsum.",
      creation_date: "2001-05-16 08:09:47",
      is_confirmed: false
    },
    {
      comment_id: 37,
      post_id: 27,
      user_id: 1,
      comment: "Phasellus in felis.",
      creation_date: "2006-10-13 07:05:58",
      is_confirmed: true
    },
    {
      comment_id: 38,
      post_id: 43,
      user_id: 1,
      comment: "Integer tincidunt ante vel ipsum.",
      creation_date: "2015-04-17 19:03:36",
      is_confirmed: false
    },
    {
      comment_id: 39,
      post_id: 11,
      user_id: 10,
      comment: "Duis at velit eu est congue elementum. In hac habitasse platea dictumst.",
      creation_date: "2011-06-10 19:33:41",
      is_confirmed: true
    },
    {
      comment_id: 40,
      post_id: 6,
      user_id: 4,
      comment: "Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci.",
      creation_date: "2013-02-23 03:35:51",
      is_confirmed: true
    },
    {
      comment_id: 41,
      post_id: 1,
      user_id: 7,
      comment: "Nullam varius.",
      creation_date: "2008-08-17 12:05:52",
      is_confirmed: false
    },
    {
      comment_id: 42,
      post_id: 18,
      user_id: 9,
      comment: "Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros.",
      creation_date: "2006-06-17 20:17:24",
      is_confirmed: false
    },
    {
      comment_id: 43,
      post_id: 3,
      user_id: 5,
      comment: "Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien.",
      creation_date: "2008-04-19 09:54:06",
      is_confirmed: true
    },
    {
      comment_id: 44,
      post_id: 37,
      user_id: 10,
      comment: "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin interdum mauris non ligula pellentesque ultrices.",
      creation_date: "2001-10-26 21:22:17",
      is_confirmed: true
    },
    {
      comment_id: 45,
      post_id: 20,
      user_id: 3,
      comment: "Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros.",
      creation_date: "2003-07-12 05:05:08",
      is_confirmed: true
    },
    {
      comment_id: 46,
      post_id: 39,
      user_id: 2,
      comment: "Morbi ut odio. Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo.",
      creation_date: "2008-06-29 16:18:26",
      is_confirmed: true
    },
    {
      comment_id: 47,
      post_id: 27,
      user_id: 7,
      comment: "Lorem ipsum dolor sit amet, consectetuer adipiscing elit.",
      creation_date: "2013-09-13 19:00:03",
      is_confirmed: true
    },
    {
      comment_id: 48,
      post_id: 55,
      user_id: 6,
      comment: "Ut tellus.",
      creation_date: "2014-03-24 07:17:14",
      is_confirmed: true
    },
    {
      comment_id: 49,
      post_id: 22,
      user_id: 3,
      comment: "In hac habitasse platea dictumst. Etiam faucibus cursus urna.",
      creation_date: "2020-11-13 07:40:56",
      is_confirmed: true
    },
    {
      comment_id: 50,
      post_id: 30,
      user_id: 3,
      comment: "Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio.",
      creation_date: "2014-07-09 07:11:39",
      is_confirmed: false
    },
    {
      comment_id: 51,
      post_id: 35,
      user_id: 8,
      comment: "Nulla suscipit ligula in lacus.",
      creation_date: "2005-12-06 21:11:19",
      is_confirmed: false
    },
    {
      comment_id: 52,
      post_id: 52,
      user_id: 3,
      comment: "Nulla suscipit ligula in lacus.",
      creation_date: "2017-05-26 13:48:58",
      is_confirmed: true
    },
    {
      comment_id: 53,
      post_id: 7,
      user_id: 7,
      comment: "Morbi porttitor lorem id ligula.",
      creation_date: "2015-05-14 13:16:17",
      is_confirmed: false
    },
    {
      comment_id: 54,
      post_id: 23,
      user_id: 9,
      comment: "Pellentesque at nulla.",
      creation_date: "2000-05-26 00:03:31",
      is_confirmed: false
    },
    {
      comment_id: 55,
      post_id: 13,
      user_id: "NULL",
      comment: "Proin eu mi.",
      creation_date: "2021-09-27 01:05:21",
      is_confirmed: true
    },
    {
      comment_id: 56,
      post_id: 37,
      user_id: 6,
      comment: "Nulla ut erat id mauris vulputate elementum. Nullam varius.",
      creation_date: "2002-11-22 15:45:08",
      is_confirmed: false
    },
    {
      comment_id: 57,
      post_id: 25,
      user_id: 10,
      comment: "Nulla ac enim. In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.",
      creation_date: "2013-07-23 11:50:49",
      is_confirmed: false
    },
    {
      comment_id: 58,
      post_id: 22,
      user_id: 5,
      comment: "Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem. Integer tincidunt ante vel ipsum.",
      creation_date: "2002-03-31 08:51:39",
      is_confirmed: false
    },
    {
      comment_id: 59,
      post_id: 46,
      user_id: 7,
      comment: "Morbi porttitor lorem id ligula.",
      creation_date: "2016-10-23 04:52:50",
      is_confirmed: false
    },
    {
      comment_id: 60,
      post_id: 44,
      user_id: 3,
      comment: "Quisque id justo sit amet sapien dignissim vestibulum. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est.",
      creation_date: "2003-09-25 16:32:06",
      is_confirmed: false
    },
    {
      comment_id: 61,
      post_id: 26,
      user_id: 7,
      comment: "Suspendisse potenti.",
      creation_date: "2022-04-15 01:13:28",
      is_confirmed: false
    },
    {
      comment_id: 62,
      post_id: 37,
      user_id: 5,
      comment: "Proin at turpis a pede posuere nonummy.",
      creation_date: "2010-07-20 22:22:50",
      is_confirmed: false
    },
    {
      comment_id: 63,
      post_id: 27,
      user_id: 8,
      comment: "Suspendisse accumsan tortor quis turpis. Sed ante.",
      creation_date: "2006-02-14 04:38:41",
      is_confirmed: false
    },
    {
      comment_id: 64,
      post_id: 12,
      user_id: 9,
      comment: "Donec dapibus.",
      creation_date: "2016-01-21 10:54:26",
      is_confirmed: false
    },
    {
      comment_id: 65,
      post_id: 28,
      user_id: 4,
      comment: "Integer ac leo. Pellentesque ultrices mattis odio.",
      creation_date: "2023-01-11 15:00:47",
      is_confirmed: true
    },
    {
      comment_id: 66,
      post_id: 21,
      user_id: 4,
      comment: "Suspendisse potenti.",
      creation_date: "2006-09-17 22:37:06",
      is_confirmed: true
    },
    {
      comment_id: 67,
      post_id: 5,
      user_id: 8,
      comment: "Duis at velit eu est congue elementum.",
      creation_date: "2004-01-21 14:38:32",
      is_confirmed: false
    },
    {
      comment_id: 68,
      post_id: 44,
      user_id: 3,
      comment: "Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi.",
      creation_date: "2014-10-19 22:23:11",
      is_confirmed: false
    },
    {
      comment_id: 69,
      post_id: 34,
      user_id: 3,
      comment: "Praesent blandit lacinia erat.",
      creation_date: "2012-02-04 23:32:26",
      is_confirmed: false
    },
    {
      comment_id: 70,
      post_id: 16,
      user_id: 5,
      comment: "In sagittis dui vel nisl. Duis ac nibh.",
      creation_date: "2002-09-12 18:22:13",
      is_confirmed: false
    },
    {
      comment_id: 71,
      post_id: 29,
      user_id: 4,
      comment: "Proin interdum mauris non ligula pellentesque ultrices. Phasellus id sapien in sapien iaculis congue.",
      creation_date: "2001-07-05 22:26:52",
      is_confirmed: false
    },
    {
      comment_id: 72,
      post_id: 3,
      user_id: 4,
      comment: "Vivamus vestibulum sagittis sapien. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.",
      creation_date: "2006-03-29 02:06:52",
      is_confirmed: true
    },
    {
      comment_id: 73,
      post_id: 41,
      user_id: 8,
      comment: "Nulla justo.",
      creation_date: "2018-04-17 03:30:46",
      is_confirmed: true
    },
    {
      comment_id: 74,
      post_id: 46,
      user_id: 8,
      comment: "Nullam varius. Nulla facilisi.",
      creation_date: "2005-10-04 00:01:54",
      is_confirmed: true
    },
    {
      comment_id: 75,
      post_id: 2,
      user_id: 3,
      comment: "Maecenas pulvinar lobortis est. Phasellus sit amet erat.",
      creation_date: "2009-08-15 04:55:27",
      is_confirmed: false
    },
    {
      comment_id: 76,
      post_id: 41,
      user_id: "NULL",
      comment: "Praesent blandit. Nam nulla.",
      creation_date: "2015-09-03 21:03:23",
      is_confirmed: false
    },
    {
      comment_id: 77,
      post_id: 1,
      user_id: 9,
      comment: "Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus.",
      creation_date: "2019-08-28 19:54:53",
      is_confirmed: false
    },
    {
      comment_id: 78,
      post_id: 27,
      user_id: 6,
      comment: "Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Donec pharetra, magna vestibulum aliquet ultrices, erat tortor sollicitudin mi, sit amet lobortis sapien sapien non mi.",
      creation_date: "2015-06-05 04:34:47",
      is_confirmed: false
    },
    {
      comment_id: 79,
      post_id: 15,
      user_id: 2,
      comment: "Morbi porttitor lorem id ligula.",
      creation_date: "2002-06-02 21:32:32",
      is_confirmed: false
    },
    {
      comment_id: 80,
      post_id: 9,
      user_id: 3,
      comment: "Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis sapien.",
      creation_date: "2017-04-19 19:09:12",
      is_confirmed: true
    },
    {
      comment_id: 81,
      post_id: 3,
      user_id: 1,
      comment: "Nulla nisl.",
      creation_date: "2014-05-24 00:24:28",
      is_confirmed: false
    },
    {
      comment_id: 82,
      post_id: 22,
      user_id: 3,
      comment: "Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante. Nulla justo.",
      creation_date: "2005-07-16 07:42:39",
      is_confirmed: true
    },
    {
      comment_id: 83,
      post_id: 48,
      user_id: "NULL",
      comment: "Fusce consequat.",
      creation_date: "2008-02-21 16:01:09",
      is_confirmed: true
    },
    {
      comment_id: 84,
      post_id: 41,
      user_id: 10,
      comment: "Nulla tellus.",
      creation_date: "2015-12-03 12:17:43",
      is_confirmed: true
    },
    {
      comment_id: 85,
      post_id: 51,
      user_id: 6,
      comment: "Pellentesque eget nunc.",
      creation_date: "2002-10-01 12:00:50",
      is_confirmed: false
    },
    {
      comment_id: 86,
      post_id: 29,
      user_id: 8,
      comment: "Sed sagittis.",
      creation_date: "2002-10-21 15:35:15",
      is_confirmed: true
    },
    {
      comment_id: 87,
      post_id: 55,
      user_id: 5,
      comment: "Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede. Morbi porttitor lorem id ligula.",
      creation_date: "2020-06-24 21:15:21",
      is_confirmed: true
    },
    {
      comment_id: 88,
      post_id: 20,
      user_id: 2,
      comment: "Nulla suscipit ligula in lacus.",
      creation_date: "2011-03-12 07:26:14",
      is_confirmed: true
    },
    {
      comment_id: 89,
      post_id: 4,
      user_id: 5,
      comment: "Nulla suscipit ligula in lacus.",
      creation_date: "2007-07-17 09:20:52",
      is_confirmed: false
    },
    {
      comment_id: 90,
      post_id: 7,
      user_id: 4,
      comment: "Curabitur in libero ut massa volutpat convallis. Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo.",
      creation_date: "2015-08-23 19:31:28",
      is_confirmed: false
    },
    {
      comment_id: 91,
      post_id: 15,
      user_id: 8,
      comment: "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin interdum mauris non ligula pellentesque ultrices.",
      creation_date: "2002-02-27 19:32:56",
      is_confirmed: false
    },
    {
      comment_id: 92,
      post_id: 4,
      user_id: 9,
      comment: "Suspendisse potenti. In eleifend quam a odio.",
      creation_date: "2001-10-10 02:49:00",
      is_confirmed: false
    },
    {
      comment_id: 93,
      post_id: 48,
      user_id: 9,
      comment: "Mauris sit amet eros.",
      creation_date: "2017-10-12 12:58:31",
      is_confirmed: false
    },
    {
      comment_id: 94,
      post_id: 28,
      user_id: 3,
      comment: "Nulla nisl. Nunc nisl.",
      creation_date: "2013-02-04 03:52:12",
      is_confirmed: true
    },
    {
      comment_id: 95,
      post_id: 44,
      user_id: 4,
      comment: "Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem.",
      creation_date: "2022-12-18 20:11:13",
      is_confirmed: false
    },
    {
      comment_id: 96,
      post_id: 31,
      user_id: 3,
      comment: "Maecenas tincidunt lacus at velit. Vivamus vel nulla eget eros elementum pellentesque.",
      creation_date: "2021-06-21 11:38:03",
      is_confirmed: false
    },
    {
      comment_id: 97,
      post_id: 44,
      user_id: 2,
      comment: "Nullam varius. Nulla facilisi.",
      creation_date: "2013-09-01 02:37:09",
      is_confirmed: false
    },
    {
      comment_id: 98,
      post_id: 24,
      user_id: 9,
      comment: "Nullam varius.",
      creation_date: "2006-06-02 16:58:21",
      is_confirmed: true
    },
    {
      comment_id: 99,
      post_id: 1,
      user_id: 4,
      comment: "Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus.",
      creation_date: "2007-11-02 20:13:13",
      is_confirmed: true
    },
    {
      comment_id: 100,
      post_id: 3,
      user_id: 8,
      comment: "Donec dapibus.",
      creation_date: "2013-01-06 00:38:40",
      is_confirmed: false
    },
    {
      comment_id: 101,
      post_id: 39,
      user_id: 8,
      comment: "Sed vel enim sit amet nunc viverra dapibus.",
      creation_date: "2015-12-06 05:47:30",
      is_confirmed: true
    },
    {
      comment_id: 102,
      post_id: 20,
      user_id: 2,
      comment: "Integer ac neque.",
      creation_date: "2008-09-15 09:14:59",
      is_confirmed: false
    },
    {
      comment_id: 103,
      post_id: 38,
      user_id: 8,
      comment: "Praesent id massa id nisl venenatis lacinia. Aenean sit amet justo.",
      creation_date: "2023-03-21 14:16:32",
      is_confirmed: true
    },
    {
      comment_id: 104,
      post_id: 40,
      user_id: 6,
      comment: "Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis.",
      creation_date: "2019-04-06 19:51:17",
      is_confirmed: true
    },
    {
      comment_id: 105,
      post_id: 28,
      user_id: 5,
      comment: "Aliquam erat volutpat.",
      creation_date: "2013-11-27 00:39:24",
      is_confirmed: true
    },
    {
      comment_id: 106,
      post_id: 50,
      user_id: 3,
      comment: "Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue.",
      creation_date: "2004-02-11 14:43:18",
      is_confirmed: false
    },
    {
      comment_id: 107,
      post_id: 22,
      user_id: 5,
      comment: "Duis mattis egestas metus.",
      creation_date: "2020-07-21 04:32:17",
      is_confirmed: false
    },
    {
      comment_id: 108,
      post_id: 18,
      user_id: 3,
      comment: "In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.",
      creation_date: "2023-01-15 20:46:30",
      is_confirmed: true
    },
    {
      comment_id: 109,
      post_id: 17,
      user_id: 3,
      comment: "Pellentesque ultrices mattis odio. Donec vitae nisi.",
      creation_date: "2019-04-25 18:50:50",
      is_confirmed: false
    },
    {
      comment_id: 110,
      post_id: 33,
      user_id: 3,
      comment: "Vivamus vel nulla eget eros elementum pellentesque.",
      creation_date: "2002-06-22 00:41:31",
      is_confirmed: false
    },
    {
      comment_id: 111,
      post_id: 18,
      user_id: 6,
      comment: "Fusce consequat. Nulla nisl.",
      creation_date: "2005-01-10 11:08:32",
      is_confirmed: true
    },
    {
      comment_id: 112,
      post_id: 14,
      user_id: 5,
      comment: "Integer non velit.",
      creation_date: "2017-10-15 00:09:40",
      is_confirmed: true
    },
    {
      comment_id: 113,
      post_id: 41,
      user_id: 10,
      comment: "Nulla mollis molestie lorem.",
      creation_date: "2001-07-10 18:15:29",
      is_confirmed: false
    },
    {
      comment_id: 114,
      post_id: 54,
      user_id: 9,
      comment: "Proin eu mi. Nulla ac enim.",
      creation_date: "2017-04-06 19:54:45",
      is_confirmed: false
    },
    {
      comment_id: 115,
      post_id: 50,
      user_id: 7,
      comment: "Integer a nibh. In quis justo.",
      creation_date: "2019-03-17 07:32:09",
      is_confirmed: true
    },
    {
      comment_id: 116,
      post_id: 46,
      user_id: 8,
      comment: "Sed vel enim sit amet nunc viverra dapibus.",
      creation_date: "2018-04-09 22:37:12",
      is_confirmed: true
    },
    {
      comment_id: 117,
      post_id: 19,
      user_id: 4,
      comment: "Donec posuere metus vitae ipsum. Aliquam non mauris.",
      creation_date: "2011-09-07 11:54:09",
      is_confirmed: true
    },
    {
      comment_id: 118,
      post_id: 27,
      user_id: 6,
      comment: "Duis bibendum. Morbi non quam nec dui luctus rutrum.",
      creation_date: "2014-09-17 09:41:54",
      is_confirmed: false
    },
    {
      comment_id: 119,
      post_id: 52,
      user_id: 8,
      comment: "Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio.",
      creation_date: "2012-05-03 06:44:58",
      is_confirmed: true
    },
    {
      comment_id: 120,
      post_id: 40,
      user_id: 10,
      comment: "Nullam varius.",
      creation_date: "2006-06-23 13:32:43",
      is_confirmed: true
    },
    {
      comment_id: 121,
      post_id: 32,
      user_id: "NULL",
      comment: "Etiam faucibus cursus urna.",
      creation_date: "2011-02-21 22:21:31",
      is_confirmed: false
    },
    {
      comment_id: 122,
      post_id: 30,
      user_id: 2,
      comment: "Aenean fermentum. Donec ut mauris eget massa tempor convallis.",
      creation_date: "2001-04-27 18:19:33",
      is_confirmed: false
    },
    {
      comment_id: 123,
      post_id: 31,
      user_id: 1,
      comment: "Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.",
      creation_date: "2004-07-20 07:44:39",
      is_confirmed: true
    },
    {
      comment_id: 124,
      post_id: 4,
      user_id: 5,
      comment: "Vivamus in felis eu sapien cursus vestibulum. Proin eu mi.",
      creation_date: "2015-11-02 01:47:05",
      is_confirmed: false
    },
    {
      comment_id: 125,
      post_id: 21,
      user_id: 9,
      comment: "Mauris enim leo, rhoncus sed, vestibulum sit amet, cursus id, turpis. Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci.",
      creation_date: "2016-07-10 10:44:09",
      is_confirmed: true
    },
    {
      comment_id: 126,
      post_id: 41,
      user_id: 7,
      comment: "Donec quis orci eget orci vehicula condimentum.",
      creation_date: "2013-04-09 03:24:17",
      is_confirmed: false
    },
    {
      comment_id: 127,
      post_id: 19,
      user_id: 9,
      comment: "Donec semper sapien a libero. Nam dui.",
      creation_date: "2000-09-24 08:30:11",
      is_confirmed: true
    },
    {
      comment_id: 128,
      post_id: 25,
      user_id: 2,
      comment: "Nulla tellus.",
      creation_date: "2004-11-02 03:04:15",
      is_confirmed: true
    },
    {
      comment_id: 129,
      post_id: 15,
      user_id: 5,
      comment: "Sed vel enim sit amet nunc viverra dapibus.",
      creation_date: "2022-04-18 12:02:00",
      is_confirmed: true
    },
    {
      comment_id: 130,
      post_id: 2,
      user_id: 9,
      comment: "Vivamus in felis eu sapien cursus vestibulum. Proin eu mi.",
      creation_date: "2019-10-17 20:50:04",
      is_confirmed: false
    },
    {
      comment_id: 131,
      post_id: 34,
      user_id: 6,
      comment: "Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla.",
      creation_date: "2003-02-21 15:44:40",
      is_confirmed: true
    },
    {
      comment_id: 132,
      post_id: 20,
      user_id: 7,
      comment: "Suspendisse potenti.",
      creation_date: "2015-09-28 21:51:14",
      is_confirmed: false
    },
    {
      comment_id: 133,
      post_id: 42,
      user_id: 4,
      comment: "Nam tristique tortor eu pede.",
      creation_date: "2002-09-19 16:36:25",
      is_confirmed: true
    },
    {
      comment_id: 134,
      post_id: 16,
      user_id: 3,
      comment: "Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est.",
      creation_date: "2020-04-02 09:00:16",
      is_confirmed: false
    },
    {
      comment_id: 135,
      post_id: 23,
      user_id: 1,
      comment: "In quis justo.",
      creation_date: "2011-09-10 07:12:28",
      is_confirmed: true
    },
    {
      comment_id: 136,
      post_id: 30,
      user_id: 1,
      comment: "Integer tincidunt ante vel ipsum. Praesent blandit lacinia erat.",
      creation_date: "2017-09-08 06:56:42",
      is_confirmed: true
    },
    {
      comment_id: 137,
      post_id: 6,
      user_id: 3,
      comment: "Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl. Aenean lectus.",
      creation_date: "2021-04-10 18:13:18",
      is_confirmed: true
    },
    {
      comment_id: 138,
      post_id: 10,
      user_id: 1,
      comment: "Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem.",
      creation_date: "2006-01-22 00:13:33",
      is_confirmed: true
    },
    {
      comment_id: 139,
      post_id: 31,
      user_id: 4,
      comment: "Praesent lectus.",
      creation_date: "2016-10-01 04:53:09",
      is_confirmed: true
    },
    {
      comment_id: 140,
      post_id: 46,
      user_id: 2,
      comment: "In quis justo. Maecenas rhoncus aliquam lacus.",
      creation_date: "2015-02-14 12:09:25",
      is_confirmed: false
    },
    {
      comment_id: 141,
      post_id: 55,
      user_id: 9,
      comment: "Nulla justo.",
      creation_date: "2015-02-02 18:46:14",
      is_confirmed: true
    },
    {
      comment_id: 142,
      post_id: 45,
      user_id: "NULL",
      comment: "Cras mi pede, malesuada in, imperdiet et, commodo vulputate, justo.",
      creation_date: "2015-01-12 09:15:53",
      is_confirmed: false
    },
    {
      comment_id: 143,
      post_id: 3,
      user_id: 1,
      comment: "Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem.",
      creation_date: "2021-12-21 06:31:20",
      is_confirmed: true
    },
    {
      comment_id: 144,
      post_id: 19,
      user_id: 1,
      comment: "Praesent blandit lacinia erat. Vestibulum sed magna at nunc commodo placerat.",
      creation_date: "2009-09-29 14:05:07",
      is_confirmed: true
    },
    {
      comment_id: 145,
      post_id: 12,
      user_id: 3,
      comment: "Nulla neque libero, convallis eget, eleifend luctus, ultricies eu, nibh.",
      creation_date: "2010-04-08 08:01:19",
      is_confirmed: true
    },
    {
      comment_id: 146,
      post_id: 4,
      user_id: 10,
      comment: "Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros.",
      creation_date: "2000-11-11 20:10:58",
      is_confirmed: true
    },
    {
      comment_id: 147,
      post_id: 4,
      user_id: 7,
      comment: "Curabitur convallis. Duis consequat dui nec nisi volutpat eleifend.",
      creation_date: "2020-03-07 14:36:10",
      is_confirmed: true
    },
    {
      comment_id: 148,
      post_id: 48,
      user_id: 7,
      comment: "Fusce consequat. Nulla nisl.",
      creation_date: "2020-07-08 15:54:42",
      is_confirmed: true
    },
    {
      comment_id: 149,
      post_id: 24,
      user_id: 6,
      comment: "Duis consequat dui nec nisi volutpat eleifend. Donec ut dolor.",
      creation_date: "2021-04-08 14:15:56",
      is_confirmed: true
    },
    {
      comment_id: 150,
      post_id: 54,
      user_id: 5,
      comment: "Vestibulum rutrum rutrum neque. Aenean auctor gravida sem.",
      creation_date: "2002-06-06 20:50:47",
      is_confirmed: true
    },
    {
      comment_id: 151,
      post_id: 55,
      user_id: 3,
      comment: "Nulla suscipit ligula in lacus. Curabitur at ipsum ac tellus semper interdum.",
      creation_date: "2011-03-30 07:54:02",
      is_confirmed: true
    },
    {
      comment_id: 152,
      post_id: 29,
      user_id: 1,
      comment: "Suspendisse accumsan tortor quis turpis. Sed ante.",
      creation_date: "2011-12-16 04:13:14",
      is_confirmed: true
    },
    {
      comment_id: 153,
      post_id: 36,
      user_id: 9,
      comment: "Etiam pretium iaculis justo. In hac habitasse platea dictumst.",
      creation_date: "2007-06-05 17:50:04",
      is_confirmed: false
    },
    {
      comment_id: 154,
      post_id: 23,
      user_id: 5,
      comment: "Suspendisse accumsan tortor quis turpis.",
      creation_date: "2007-09-26 03:49:05",
      is_confirmed: false
    },
    {
      comment_id: 155,
      post_id: 2,
      user_id: 2,
      comment: "Ut tellus.",
      creation_date: "2018-01-14 21:07:18",
      is_confirmed: true
    },
    {
      comment_id: 156,
      post_id: 43,
      user_id: 6,
      comment: "Etiam justo.",
      creation_date: "2007-11-02 02:14:16",
      is_confirmed: false
    },
    {
      comment_id: 157,
      post_id: 51,
      user_id: 4,
      comment: "Duis ac nibh.",
      creation_date: "2003-12-14 17:30:08",
      is_confirmed: false
    },
    {
      comment_id: 158,
      post_id: 38,
      user_id: 1,
      comment: "Morbi non quam nec dui luctus rutrum. Nulla tellus.",
      creation_date: "2009-07-20 17:30:47",
      is_confirmed: false
    },
    {
      comment_id: 159,
      post_id: 10,
      user_id: 7,
      comment: "Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.",
      creation_date: "2013-09-16 21:33:15",
      is_confirmed: true
    },
    {
      comment_id: 160,
      post_id: 18,
      user_id: 3,
      comment: "Sed ante.",
      creation_date: "2015-10-01 18:41:37",
      is_confirmed: false
    },
    {
      comment_id: 161,
      post_id: 52,
      user_id: 8,
      comment: "Proin eu mi.",
      creation_date: "2020-08-02 19:34:56",
      is_confirmed: true
    },
    {
      comment_id: 162,
      post_id: 40,
      user_id: 2,
      comment: "Morbi quis tortor id nulla ultrices aliquet. Maecenas leo odio, condimentum id, luctus nec, molestie sed, justo.",
      creation_date: "2014-08-07 18:06:06",
      is_confirmed: false
    },
    {
      comment_id: 163,
      post_id: 13,
      user_id: 10,
      comment: "Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci.",
      creation_date: "2012-01-05 12:52:11",
      is_confirmed: false
    },
    {
      comment_id: 164,
      post_id: 42,
      user_id: 5,
      comment: "Sed sagittis. Nam congue, risus semper porta volutpat, quam pede lobortis ligula, sit amet eleifend pede libero quis orci.",
      creation_date: "2000-08-12 02:34:26",
      is_confirmed: true
    },
    {
      comment_id: 165,
      post_id: 18,
      user_id: 6,
      comment: "Curabitur at ipsum ac tellus semper interdum.",
      creation_date: "2000-09-20 03:49:09",
      is_confirmed: true
    },
    {
      comment_id: 166,
      post_id: 18,
      user_id: 1,
      comment: "Nulla mollis molestie lorem. Quisque ut erat.",
      creation_date: "2014-04-09 14:14:30",
      is_confirmed: false
    },
    {
      comment_id: 167,
      post_id: 53,
      user_id: 5,
      comment: "Ut tellus.",
      creation_date: "2022-11-29 06:12:16",
      is_confirmed: true
    },
    {
      comment_id: 168,
      post_id: 51,
      user_id: 9,
      comment: "Duis ac nibh.",
      creation_date: "2016-05-17 22:15:47",
      is_confirmed: true
    },
    {
      comment_id: 169,
      post_id: 40,
      user_id: 7,
      comment: "Pellentesque eget nunc.",
      creation_date: "2017-05-26 06:14:20",
      is_confirmed: true
    },
    {
      comment_id: 170,
      post_id: 34,
      user_id: 5,
      comment: "In hac habitasse platea dictumst. Maecenas ut massa quis augue luctus tincidunt.",
      creation_date: "2005-04-19 10:45:22",
      is_confirmed: true
    },
    {
      comment_id: 171,
      post_id: 26,
      user_id: 6,
      comment: "Cras in purus eu magna vulputate luctus.",
      creation_date: "2007-11-03 20:49:13",
      is_confirmed: true
    },
    {
      comment_id: 172,
      post_id: 50,
      user_id: "NULL",
      comment: "Pellentesque at nulla. Suspendisse potenti.",
      creation_date: "2020-04-24 17:34:33",
      is_confirmed: false
    },
    {
      comment_id: 173,
      post_id: 36,
      user_id: 10,
      comment: "In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.",
      creation_date: "2017-01-20 16:00:12",
      is_confirmed: false
    },
    {
      comment_id: 174,
      post_id: 31,
      user_id: 9,
      comment: "Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.",
      creation_date: "2013-12-14 02:37:23",
      is_confirmed: false
    },
    {
      comment_id: 175,
      post_id: 17,
      user_id: 3,
      comment: "Nullam varius. Nulla facilisi.",
      creation_date: "2004-11-27 20:19:00",
      is_confirmed: false
    },
    {
      comment_id: 176,
      post_id: 1,
      user_id: 1,
      comment: "Donec ut mauris eget massa tempor convallis.",
      creation_date: "2017-10-01 15:16:37",
      is_confirmed: false
    },
    {
      comment_id: 177,
      post_id: 31,
      user_id: 5,
      comment: "Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla. Nunc purus.",
      creation_date: "2020-02-10 12:39:03",
      is_confirmed: false
    },
    {
      comment_id: 178,
      post_id: 55,
      user_id: 1,
      comment: "Nunc rhoncus dui vel sem. Sed sagittis.",
      creation_date: "2001-12-02 17:25:46",
      is_confirmed: false
    },
    {
      comment_id: 179,
      post_id: 25,
      user_id: 3,
      comment: "Nulla mollis molestie lorem.",
      creation_date: "2006-03-03 21:32:54",
      is_confirmed: false
    },
    {
      comment_id: 180,
      post_id: 13,
      user_id: 7,
      comment: "Morbi a ipsum. Integer a nibh.",
      creation_date: "2008-12-22 08:22:08",
      is_confirmed: false
    },
    {
      comment_id: 181,
      post_id: 28,
      user_id: 2,
      comment: "Integer ac leo. Pellentesque ultrices mattis odio.",
      creation_date: "2004-04-25 14:23:33",
      is_confirmed: false
    },
    {
      comment_id: 182,
      post_id: 13,
      user_id: 9,
      comment: "Donec dapibus. Duis at velit eu est congue elementum.",
      creation_date: "2004-09-26 00:45:28",
      is_confirmed: true
    },
    {
      comment_id: 183,
      post_id: 15,
      user_id: 1,
      comment: "Vivamus metus arcu, adipiscing molestie, hendrerit at, vulputate vitae, nisl. Aenean lectus.",
      creation_date: "2008-08-14 23:56:15",
      is_confirmed: false
    },
    {
      comment_id: 184,
      post_id: 35,
      user_id: 10,
      comment: "Maecenas pulvinar lobortis est. Phasellus sit amet erat.",
      creation_date: "2017-08-01 04:58:29",
      is_confirmed: false
    },
    {
      comment_id: 185,
      post_id: 20,
      user_id: "NULL",
      comment: "Integer ac neque.",
      creation_date: "2012-11-21 05:41:29",
      is_confirmed: false
    },
    {
      comment_id: 186,
      post_id: 35,
      user_id: 10,
      comment: "Lorem ipsum dolor sit amet, consectetuer adipiscing elit.",
      creation_date: "2013-10-14 13:32:06",
      is_confirmed: true
    },
    {
      comment_id: 187,
      post_id: 54,
      user_id: 5,
      comment: "Maecenas tincidunt lacus at velit. Vivamus vel nulla eget eros elementum pellentesque.",
      creation_date: "2015-10-19 23:47:42",
      is_confirmed: true
    },
    {
      comment_id: 188,
      post_id: 35,
      user_id: 1,
      comment: "Nunc purus.",
      creation_date: "2009-04-11 16:45:27",
      is_confirmed: true
    },
    {
      comment_id: 189,
      post_id: 23,
      user_id: 2,
      comment: "In tempor, turpis nec euismod scelerisque, quam turpis adipiscing lorem, vitae mattis nibh ligula nec sem.",
      creation_date: "2009-07-22 13:23:50",
      is_confirmed: true
    },
    {
      comment_id: 190,
      post_id: 33,
      user_id: 8,
      comment: "Sed accumsan felis. Ut at dolor quis odio consequat varius.",
      creation_date: "2003-08-01 08:14:19",
      is_confirmed: false
    },
    {
      comment_id: 191,
      post_id: 29,
      user_id: 3,
      comment: "In quis justo. Maecenas rhoncus aliquam lacus.",
      creation_date: "2018-10-02 19:55:00",
      is_confirmed: true
    },
    {
      comment_id: 192,
      post_id: 46,
      user_id: 8,
      comment: "Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros. Vestibulum ac est lacinia nisi venenatis tristique.",
      creation_date: "2005-06-15 04:00:19",
      is_confirmed: true
    },
    {
      comment_id: 193,
      post_id: 10,
      user_id: 2,
      comment: "Nam ultrices, libero non mattis pulvinar, nulla pede ullamcorper augue, a suscipit nulla elit ac nulla.",
      creation_date: "2020-03-15 15:20:12",
      is_confirmed: true
    },
    {
      comment_id: 194,
      post_id: 20,
      user_id: "NULL",
      comment: "Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa.",
      creation_date: "2011-09-05 16:03:37",
      is_confirmed: false
    },
    {
      comment_id: 195,
      post_id: 29,
      user_id: 3,
      comment: "Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus.",
      creation_date: "2002-11-18 01:05:30",
      is_confirmed: true
    },
    {
      comment_id: 196,
      post_id: 1,
      user_id: 5,
      comment: "Vestibulum ac est lacinia nisi venenatis tristique. Fusce congue, diam id ornare imperdiet, sapien urna pretium nisl, ut volutpat sapien arcu sed augue.",
      creation_date: "2006-08-05 17:59:18",
      is_confirmed: true
    },
    {
      comment_id: 197,
      post_id: 2,
      user_id: 10,
      comment: "Proin risus. Praesent lectus.",
      creation_date: "2011-06-01 16:39:10",
      is_confirmed: true
    },
    {
      comment_id: 198,
      post_id: 41,
      user_id: 7,
      comment: "Proin eu mi. Nulla ac enim.",
      creation_date: "2019-10-16 13:52:37",
      is_confirmed: false
    },
    {
      comment_id: 199,
      post_id: 42,
      user_id: 5,
      comment: "Donec dapibus.",
      creation_date: "2015-11-30 04:49:23",
      is_confirmed: false
    },
    {
      comment_id: 200,
      post_id: 3,
      user_id: 7,
      comment: "In blandit ultrices enim.",
      creation_date: "2012-06-12 01:04:03",
      is_confirmed: true
    },
    {
      comment_id: 201,
      post_id: 28,
      user_id: 6,
      comment: "Nulla nisl.",
      creation_date: "2019-02-03 15:13:01",
      is_confirmed: true
    },
    {
      comment_id: 202,
      post_id: 40,
      user_id: 1,
      comment: "Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus.",
      creation_date: "2009-07-01 22:41:07",
      is_confirmed: false
    },
    {
      comment_id: 203,
      post_id: 43,
      user_id: 5,
      comment: "Nulla mollis molestie lorem.",
      creation_date: "2008-08-26 18:12:13",
      is_confirmed: true
    },
    {
      comment_id: 204,
      post_id: 38,
      user_id: "NULL",
      comment: "Vivamus vel nulla eget eros elementum pellentesque. Quisque porta volutpat erat.",
      creation_date: "2023-02-28 04:33:52",
      is_confirmed: true
    },
    {
      comment_id: 205,
      post_id: 30,
      user_id: 8,
      comment: "Sed accumsan felis. Ut at dolor quis odio consequat varius.",
      creation_date: "2001-01-06 13:19:27",
      is_confirmed: true
    },
    {
      comment_id: 206,
      post_id: 41,
      user_id: 10,
      comment: "Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante.",
      creation_date: "2015-12-20 23:40:36",
      is_confirmed: false
    },
    {
      comment_id: 207,
      post_id: 7,
      user_id: 4,
      comment: "Integer non velit.",
      creation_date: "2007-01-07 17:35:20",
      is_confirmed: true
    },
    {
      comment_id: 208,
      post_id: 45,
      user_id: 6,
      comment: "Cras in purus eu magna vulputate luctus. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.",
      creation_date: "2015-05-06 08:55:06",
      is_confirmed: true
    },
    {
      comment_id: 209,
      post_id: 10,
      user_id: 5,
      comment: "Pellentesque ultrices mattis odio.",
      creation_date: "2018-08-27 06:21:36",
      is_confirmed: true
    },
    {
      comment_id: 210,
      post_id: 15,
      user_id: 5,
      comment: "Aenean auctor gravida sem. Praesent id massa id nisl venenatis lacinia.",
      creation_date: "2012-11-13 14:12:04",
      is_confirmed: true
    },
    {
      comment_id: 211,
      post_id: 34,
      user_id: 5,
      comment: "Quisque arcu libero, rutrum ac, lobortis vel, dapibus at, diam.",
      creation_date: "2003-03-01 20:54:42",
      is_confirmed: true
    },
    {
      comment_id: 212,
      post_id: 42,
      user_id: 7,
      comment: "Nam nulla. Integer pede justo, lacinia eget, tincidunt eget, tempus vel, pede.",
      creation_date: "2013-10-24 17:15:08",
      is_confirmed: false
    },
    {
      comment_id: 213,
      post_id: 50,
      user_id: 10,
      comment: "In hac habitasse platea dictumst. Morbi vestibulum, velit id pretium iaculis, diam erat fermentum justo, nec condimentum neque sapien placerat ante.",
      creation_date: "2013-10-26 05:25:44",
      is_confirmed: false
    },
    {
      comment_id: 214,
      post_id: 1,
      user_id: 1,
      comment: "Etiam justo.",
      creation_date: "2007-02-27 23:26:48",
      is_confirmed: false
    },
    {
      comment_id: 215,
      post_id: 26,
      user_id: 3,
      comment: "Curabitur in libero ut massa volutpat convallis.",
      creation_date: "2014-12-19 01:08:00",
      is_confirmed: false
    },
    {
      comment_id: 216,
      post_id: 8,
      user_id: 1,
      comment: "Nunc purus.",
      creation_date: "2006-05-30 06:06:09",
      is_confirmed: false
    },
    {
      comment_id: 217,
      post_id: 31,
      user_id: 8,
      comment: "Vivamus vel nulla eget eros elementum pellentesque.",
      creation_date: "2013-08-15 06:57:21",
      is_confirmed: false
    },
    {
      comment_id: 218,
      post_id: 21,
      user_id: 10,
      comment: "Nulla ac enim.",
      creation_date: "2001-11-12 07:45:03",
      is_confirmed: true
    },
    {
      comment_id: 219,
      post_id: 54,
      user_id: 3,
      comment: "Vivamus tortor. Duis mattis egestas metus.",
      creation_date: "2005-10-14 17:27:18",
      is_confirmed: false
    },
    {
      comment_id: 220,
      post_id: 39,
      user_id: 6,
      comment: "Integer tincidunt ante vel ipsum.",
      creation_date: "2020-04-25 06:44:04",
      is_confirmed: true
    },
    {
      comment_id: 221,
      post_id: 13,
      user_id: 2,
      comment: "Donec posuere metus vitae ipsum. Aliquam non mauris.",
      creation_date: "2007-10-01 05:46:43",
      is_confirmed: false
    },
    {
      comment_id: 222,
      post_id: 32,
      user_id: 10,
      comment: "Proin eu mi.",
      creation_date: "2016-10-30 18:08:06",
      is_confirmed: true
    },
    {
      comment_id: 223,
      post_id: 2,
      user_id: 8,
      comment: "Maecenas rhoncus aliquam lacus.",
      creation_date: "2006-09-10 04:41:21",
      is_confirmed: false
    },
    {
      comment_id: 224,
      post_id: 44,
      user_id: 6,
      comment: "Maecenas rhoncus aliquam lacus.",
      creation_date: "2008-05-19 00:38:10",
      is_confirmed: false
    },
    {
      comment_id: 225,
      post_id: 36,
      user_id: "NULL",
      comment: "Mauris lacinia sapien quis libero.",
      creation_date: "2020-06-27 18:17:21",
      is_confirmed: false
    },
    {
      comment_id: 226,
      post_id: 41,
      user_id: 3,
      comment: "Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo. Maecenas pulvinar lobortis est.",
      creation_date: "2000-11-10 02:29:34",
      is_confirmed: false
    },
    {
      comment_id: 227,
      post_id: 30,
      user_id: 3,
      comment: "In est risus, auctor sed, tristique in, tempus sit amet, sem. Fusce consequat.",
      creation_date: "2010-02-19 01:26:59",
      is_confirmed: true
    },
    {
      comment_id: 228,
      post_id: 12,
      user_id: 5,
      comment: "In hac habitasse platea dictumst.",
      creation_date: "2006-01-03 09:38:05",
      is_confirmed: false
    },
    {
      comment_id: 229,
      post_id: 4,
      user_id: 3,
      comment: "Nulla justo.",
      creation_date: "2016-09-14 00:23:51",
      is_confirmed: false
    },
    {
      comment_id: 230,
      post_id: 16,
      user_id: 10,
      comment: "Quisque porta volutpat erat. Quisque erat eros, viverra eget, congue eget, semper rutrum, nulla.",
      creation_date: "2007-01-06 23:59:20",
      is_confirmed: false
    },
    {
      comment_id: 231,
      post_id: 55,
      user_id: 4,
      comment: "Integer aliquet, massa id lobortis convallis, tortor risus dapibus augue, vel accumsan tellus nisi eu orci.",
      creation_date: "2001-06-02 11:24:33",
      is_confirmed: true
    },
    {
      comment_id: 232,
      post_id: 13,
      user_id: 1,
      comment: "Vivamus tortor.",
      creation_date: "2003-11-18 19:34:20",
      is_confirmed: true
    },
    {
      comment_id: 233,
      post_id: 8,
      user_id: 7,
      comment: "Suspendisse ornare consequat lectus. In est risus, auctor sed, tristique in, tempus sit amet, sem.",
      creation_date: "2003-12-13 12:21:22",
      is_confirmed: true
    },
    {
      comment_id: 234,
      post_id: 55,
      user_id: 6,
      comment: "Aliquam quis turpis eget elit sodales scelerisque.",
      creation_date: "2017-03-04 00:32:55",
      is_confirmed: true
    },
    {
      comment_id: 235,
      post_id: 31,
      user_id: "NULL",
      comment: "Phasellus sit amet erat.",
      creation_date: "2013-01-24 10:44:18",
      is_confirmed: true
    },
    {
      comment_id: 236,
      post_id: 8,
      user_id: 5,
      comment: "Morbi non quam nec dui luctus rutrum. Nulla tellus.",
      creation_date: "2022-10-08 03:28:02",
      is_confirmed: false
    },
    {
      comment_id: 237,
      post_id: 36,
      user_id: 4,
      comment: "Sed sagittis.",
      creation_date: "2022-05-08 12:43:51",
      is_confirmed: true
    },
    {
      comment_id: 238,
      post_id: 10,
      user_id: 7,
      comment: "Morbi porttitor lorem id ligula.",
      creation_date: "2014-05-11 21:46:12",
      is_confirmed: false
    },
    {
      comment_id: 239,
      post_id: 44,
      user_id: 1,
      comment: "Nulla mollis molestie lorem. Quisque ut erat.",
      creation_date: "2018-07-18 06:37:29",
      is_confirmed: false
    },
    {
      comment_id: 240,
      post_id: 23,
      user_id: "NULL",
      comment: "Donec posuere metus vitae ipsum.",
      creation_date: "2012-07-19 19:30:04",
      is_confirmed: false
    },
    {
      comment_id: 241,
      post_id: 32,
      user_id: 5,
      comment: "Vivamus tortor. Duis mattis egestas metus.",
      creation_date: "2019-08-30 19:11:38",
      is_confirmed: true
    },
    {
      comment_id: 242,
      post_id: 55,
      user_id: 6,
      comment: "Nulla facilisi.",
      creation_date: "2001-11-24 20:00:09",
      is_confirmed: false
    },
    {
      comment_id: 243,
      post_id: 45,
      user_id: 8,
      comment: "Suspendisse potenti.",
      creation_date: "2018-06-22 20:57:12",
      is_confirmed: true
    },
    {
      comment_id: 244,
      post_id: 17,
      user_id: 8,
      comment: "Curabitur at ipsum ac tellus semper interdum.",
      creation_date: "2016-10-26 11:56:22",
      is_confirmed: true
    },
    {
      comment_id: 245,
      post_id: 27,
      user_id: 2,
      comment: "Morbi porttitor lorem id ligula. Suspendisse ornare consequat lectus.",
      creation_date: "2014-05-28 16:50:18",
      is_confirmed: true
    },
    {
      comment_id: 246,
      post_id: 10,
      user_id: 8,
      comment: "In blandit ultrices enim. Lorem ipsum dolor sit amet, consectetuer adipiscing elit.",
      creation_date: "2015-08-20 20:32:34",
      is_confirmed: true
    },
    {
      comment_id: 247,
      post_id: 49,
      user_id: 4,
      comment: "Donec dapibus.",
      creation_date: "2020-10-29 17:30:29",
      is_confirmed: true
    },
    {
      comment_id: 248,
      post_id: 13,
      user_id: 4,
      comment: "Praesent id massa id nisl venenatis lacinia.",
      creation_date: "2016-01-11 21:32:45",
      is_confirmed: false
    },
    {
      comment_id: 249,
      post_id: 30,
      user_id: 9,
      comment: "Integer tincidunt ante vel ipsum.",
      creation_date: "2023-04-28 10:03:35",
      is_confirmed: true
    },
    {
      comment_id: 250,
      post_id: 20,
      user_id: 4,
      comment: "In quis justo.",
      creation_date: "2017-03-26 19:10:56",
      is_confirmed: false
    },
    {
      comment_id: 251,
      post_id: 19,
      user_id: "NULL",
      comment: "Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Nulla dapibus dolor vel est. Donec odio justo, sollicitudin ut, suscipit a, feugiat et, eros.",
      creation_date: "2009-07-25 16:02:12",
      is_confirmed: true
    },
    {
      comment_id: 252,
      post_id: 39,
      user_id: 10,
      comment: "Suspendisse potenti.",
      creation_date: "2013-09-12 22:50:36",
      is_confirmed: true
    },
    {
      comment_id: 253,
      post_id: 31,
      user_id: 2,
      comment: "Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem.",
      creation_date: "2003-12-05 10:06:26",
      is_confirmed: true
    },
    {
      comment_id: 254,
      post_id: 43,
      user_id: 2,
      comment: "Donec quis orci eget orci vehicula condimentum.",
      creation_date: "2022-05-29 06:21:36",
      is_confirmed: true
    },
    {
      comment_id: 255,
      post_id: 52,
      user_id: 10,
      comment: "Donec dapibus.",
      creation_date: "2019-05-13 13:37:40",
      is_confirmed: true
    }
  ]

  getComments() {
    return this.commentList;
  }
  
  getCommentsByPostId(postId: number): string[] {
    const postComments = this.commentList
      .filter(comment => comment.post_id === postId)
      .map(comment => comment.comment);
    return postComments;
  }

  

  addComment(postId: number, commentText: string): void {
    const newComment: Comments = {
      comment_id: this.generateCommentId(),
      post_id: postId,
      comment: commentText,
      user_id: 0, // Kullanıcı kimliğini burada belirleyebilirsiniz veya uygun bir değer atayabilirsiniz
      creation_date: new Date().toISOString(), // Yorumun oluşturulma tarihini burada belirleyebilirsiniz veya uygun bir değer atayabilirsiniz
      is_confirmed: false // Yorumun onay durumunu burada belirleyebilirsiniz veya uygun bir değer atayabilirsiniz
    };
    this.commentList.push(newComment);
  }

  generateCommentId(): number {
    let maxId = 0;
    for (const comment of this.commentList) {
      if (comment.comment_id > maxId) {
        maxId = comment.comment_id;
      }
    }
    return maxId + 1;
  }

  
  getUserIDByCommentID(commentID: number | null): any {
    const comment = this.commentList.find((comment) => comment.comment_id === commentID);
    return comment ? comment.user_id : null;
  }
  

  

}
