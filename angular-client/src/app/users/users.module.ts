import { NgModule } from '@angular/core';
import { UsersHomeComponent } from './pages/users-home/users-home.component';
import {TrendingComponent} from "./components/trending/trending.component";
import {UsersRoutingModule} from "./users-routing.module";
import {NgxMasonryModule} from "ngx-masonry";
import {InfiniteScrollModule} from "ngx-infinite-scroll";
import {ReactiveFormsModule} from "@angular/forms";
import {SharedModule} from "../shared/shared.module";
import {GifcardComponent} from "./components/gifcard/gifcard.component";
import {SearchComponent} from "./components/search/search.component";

@NgModule({
  declarations: [
    UsersHomeComponent,
    TrendingComponent,
    GifcardComponent,
    SearchComponent
  ],
  imports: [
    SharedModule,
    UsersRoutingModule,
    NgxMasonryModule,
    InfiniteScrollModule,
    ReactiveFormsModule
  ]
})
export class UsersModule { }
