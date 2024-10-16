import { Component, OnInit } from '@angular/core';
import { AuthService } from './service/auth.service';
import {  Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  ngOnInit () {
    let isloggedin  : string | null ;
    let loggedUser:string | null;
    isloggedin  = localStorage.getItem('isloggedIn');
    loggedUser = localStorage.getItem('loggedUser');
    if (isloggedin!="true" || !loggedUser)
    this.router.navigate(['/login']);
    else
    this.authService.setLoggedUserFromLocalStorage(loggedUser);
    }

onLogout() {
this.authService.logout() ;
}
  title = 'springproject';
  constructor (public authService: AuthService, public router:Router) {}
}
