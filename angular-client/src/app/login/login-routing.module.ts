import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginHomeComponent} from "./login-home/login-home.component";
import {CommonModule} from "@angular/common";

const routes: Routes = [
  {
    path: '',
    component: LoginHomeComponent,
    children: [
      {
        path: 'auth',
        component: LoginHomeComponent
      }
    ]
  }
];

@NgModule({
  imports: [CommonModule, RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class LoginRoutingModule {
}
