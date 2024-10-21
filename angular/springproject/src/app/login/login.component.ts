import { Component } from '@angular/core';
import { User } from '../model/user.model';
import { AuthService } from '../service/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styles: [
  ]
})
export class LoginComponent {
  user = new User();
  err:number = 0;
  erreur=0;
  constructor(private authService : AuthService,
    private router: Router) { }
    onLoggedin()
    {
    this.authService.login(this.user).subscribe((data)=> {
    let jwToken = data.headers.get('Authorization') !;
    this.authService.saveToken(jwToken);
    this.router.navigate(['/']);
    },(erreur)=>{ this.err = 1;
    });
    }
}
