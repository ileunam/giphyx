import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from "@angular/common/http";
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {NgxMasonryModule} from "ngx-masonry";
import {InfiniteScrollModule} from "ngx-infinite-scroll";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {ReactiveFormsModule} from "@angular/forms";
import {LayoutsModule} from "./layouts/layouts.module";

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    AppRoutingModule,
    NgxMasonryModule,
    InfiniteScrollModule,
    ReactiveFormsModule,
    LayoutsModule,
    BrowserModule,
    BrowserAnimationsModule
  ],
  providers: [],
  exports: [
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
