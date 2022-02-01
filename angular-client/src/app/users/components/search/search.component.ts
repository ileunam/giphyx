import {Component, Input, OnInit} from '@angular/core';
import {Subscription} from "rxjs";
import {GiphyApiService} from "../../../services/giphy-api.service";
import {SharedService} from "../../../services/shared.service";
import {Router} from "@angular/router";

@Component({
  selector: 'search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  gifsData: any = [];
  selGifId: string = "";
  limit: number = 20;
  offset: number = 0;
  sendSearchEvSubs!: Subscription;
  searchName = "";

  constructor(
    private giphy: GiphyApiService,
    private sharedService: SharedService,
    private router: Router
  ) {
    //Gets the searchname
    // @ts-ignore
    this.searchName = this.router.getCurrentNavigation().extras.state.searchName;
    this.sendSearchEvSubs = this.sharedService.getSearchEvent()
      .subscribe((searchName: string) => {
        console.log('search: '+searchName);
        this.searchName = searchName;
        this.fetchFirstSearch();
        console.log(this.gifsData);
      })
  }

  ngOnInit() {
    this.fetchFirstSearch();
  }
  //Fetch new gifs using the offset and limit required on GiphyAPI
  onScroll() {
    console.log('scrolling');
    this.offset += this.limit;
    this.fetchNewGifs();
  }
  fetchFirstSearch(){
    this.giphy.searchGifs(this.searchName, this.limit, this.offset)
      .subscribe((data: any) => {
        this.gifsData = data.data;
      });
  }

  fetchNewGifs() {
    this.giphy.searchGifs(this.searchName, this.limit, this.offset)
      .subscribe((data: any) => {
        this.gifsData = this.gifsData.concat(data.data);
      })
  }

  getGifId(id: string) {
    this.selGifId = id;
  }


}
