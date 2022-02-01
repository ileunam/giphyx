import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginLayoutComponent} from "./layouts/login-layout/login-layout.component";
import {UserLayoutComponent} from "./layouts/user-layout/user-layout.component";

const routes: Routes = [
  //Login routes
  {
    path: '',
    component: LoginLayoutComponent,
    children: [
      {
        path: '',
        redirectTo: '/auth',
        pathMatch: 'full'
      },
      {
        path: 'auth',
        loadChildren: () => import('./login/login.module').then(module => module.LoginModule)
      }
    ]
  },

  //User routes
  {
    path: '',
    component: UserLayoutComponent,
    children: [
      {
        path: '',
        redirectTo: '/home',
        pathMatch: 'full'
      },
      {
        path: 'home',
        loadChildren: () => import('./users/users.module').then(module => module.UsersModule)
      }
    ]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
