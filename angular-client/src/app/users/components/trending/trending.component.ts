import {Component, OnInit} from '@angular/core';
import {GiphyApiService} from "../../../services/giphy-api.service";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-trending',
  templateUrl: './trending.component.html',
  styleUrls: ['./trending.component.css']
})
export class TrendingComponent implements OnInit {
  gifsData: any = [];
  limit: number = 20;
  offset: number = 0;
  sendSearchEvSubs!: Subscription;

  constructor(
    private giphy: GiphyApiService
  ) {

  }

  ngOnInit() {
    this.fetchFirstTrendingGifs();
  }

  //Scroll event
  onScroll() {
    this.offset += this.limit;
    this.fetchNewTrendingGifs();
  }

  //Load the first query of GIFs
  fetchFirstTrendingGifs() {
    this.giphy.getTrendingGifs(this.limit, this.offset)
      .subscribe((data: any) => {
        this.gifsData = data.data;
      });
  }

  //Load the new queries of GIFs, using offset and limit required by GiphyAPI
  fetchNewTrendingGifs() {
    this.giphy.getTrendingGifs(this.limit, this.offset)
      .subscribe((data: any) => {
        this.gifsData = this.gifsData.concat(data.data);
      });
  }

}
