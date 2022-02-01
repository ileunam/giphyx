import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule} from "@angular/router";
import {NavbarComponent} from "./navbar/navbar.component";
import {BrowserModule} from "@angular/platform-browser";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {HttpClientModule} from "@angular/common/http";



@NgModule({
  declarations: [NavbarComponent],
  exports: [
    CommonModule,
    NavbarComponent,
    RouterModule,
    HttpClientModule
  ],
  imports: [CommonModule, RouterModule
  ]
})
export class SharedModule { }
