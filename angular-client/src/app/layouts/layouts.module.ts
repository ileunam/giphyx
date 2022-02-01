import { NgModule } from '@angular/core';
import {RouterModule} from "@angular/router";

import { LoginLayoutComponent } from './login-layout/login-layout.component';
import { UserLayoutComponent } from './user-layout/user-layout.component';

import {SharedModule} from "../shared/shared.module";


@NgModule({
  declarations: [
    LoginLayoutComponent,
    UserLayoutComponent
  ],
  imports: [
    RouterModule,
    SharedModule,
  ],
  exports: [
  ]
})
export class LayoutsModule {

}
