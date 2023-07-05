import { Injectable } from '@angular/core';
import * as users from '../../json/users.json';
import { Observable } from 'rxjs';
import { of } from 'rxjs';
import { Users } from './user-list/user';
@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor() { }



  private userList : Users [] = [
    {
      user_id: 1,
      username: "bgiurio0",
      email: "fhammell0@1688.com",
      creation_date: "2013-08-14 22:04:29",
      is_active: false
    },
    {
      user_id: 2,
      username: "cbewshire1",
      email: "lferriby1@ucoz.ru",
      creation_date: "2011-09-02 09:13:06",
      is_active: true
    },
    {
      user_id: 3,
      username: "okrause2",
      email: "ebernth2@i2i.jp",
      creation_date: "2019-06-15 11:34:54",
      is_active: false
    },
    {
      user_id: 4,
      username: "mschindler3",
      email: "acompford3@psu.edu",
      creation_date: "2020-03-23 11:05:34",
      is_active: true
    },
    {
      user_id: 5,
      username: "aravenhills4",
      email: "mpauwel4@imgur.com",
      creation_date: "2019-01-30 20:23:21",
      is_active: false
    },
    {
      user_id: 6,
      username: "pmakiver5",
      email: "jarnowicz5@apache.org",
      creation_date: "2005-11-19 00:45:32",
      is_active: true
    },
    {
      user_id: 7,
      username: "dhyland6",
      email: "vsigne6@shop-pro.jp",
      creation_date: "2017-02-02 10:07:00",
      is_active: false
    },
    {
      user_id: 8,
      username: "ksalvage7",
      email: "mmanketell7@reuters.com",
      creation_date: "2019-05-20 05:20:51",
      is_active: false
    },
    {
      user_id: 9,
      username: "ihalcro8",
      email: "gocorrigane8@clickbank.net",
      creation_date: "2009-02-04 09:09:27",
      is_active: true
    },
    {
      user_id: 10,
      username: "wdevany9",
      email: "tfrancesconi9@adobe.com",
      creation_date: "2022-06-19 19:04:08",
      is_active: true
    }
  ]


  getUsers()  {
    return this.userList;
 }

 getUserName(userId: number): string {
  const user = this.userList.find(user => user.user_id === userId);
  return user ? user.username : '';
}


}
