import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {UsersHomeComponent} from "./pages/users-home/users-home.component";
import {SearchComponent} from "./components/search/search.component";
import {CommonModule} from "@angular/common";

const routes: Routes = [
  {
    path: '',
    component: UsersHomeComponent,
    children: [
      {
        path: 'home',
        component: UsersHomeComponent
      },
    ]
  },
  {
    path: '',
    component: SearchComponent,
    children: [
      {
        path: 'search',
        component: SearchComponent
      },
    ]
  }

];

@NgModule({
  imports: [CommonModule, RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UsersRoutingModule {
}
