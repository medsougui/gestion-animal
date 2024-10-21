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
    this.authService.loadToken();
    if (this.authService.getToken()==null ||
     this.authService.isTokenExpired())
    this.router.navigate(['/login']);
  }

onLogout() {
this.authService.logout() ;
}
  title = 'springproject';
  constructor (public authService: AuthService, public router:Router) {}
}
