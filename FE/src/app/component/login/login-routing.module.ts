import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {PasswordChangeComponent} from "./password-change/password-change.component";
import {AuthGuard} from "../security/auth.guard";


const routes: Routes = [
   {canActivate:[AuthGuard],
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'students/detail/change-password',
    component: PasswordChangeComponent
  },
  {
    path: 'teachers/admin-detail/change-password',
    component: PasswordChangeComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LoginRoutingModule { }
