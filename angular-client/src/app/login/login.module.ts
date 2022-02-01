import {NgModule} from '@angular/core';
import {LoginRoutingModule} from "./login-routing.module";
import {LoginHomeComponent} from "./login-home/login-home.component";
import {SharedModule} from "../shared/shared.module";

@NgModule({
  declarations: [
    LoginHomeComponent,
  ],
  exports: [
  ],
  imports: [
    LoginRoutingModule,
  ]
})

export class LoginModule {}

