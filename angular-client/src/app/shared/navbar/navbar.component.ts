import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {SharedService} from "../../services/shared.service";

@Component({
  selector: 'navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
  providers: []
})

export class NavbarComponent implements OnInit {

  ngOnInit(): void {

  }
  constructor(
    private router: Router,
    private sharedService: SharedService
  ) {
  }
  //Navigate to TrendingComponent
  navHome() {
    this.router.navigate(['trending']);
  }
  //Navigate to SearchComponent and sends the searchName to it
  searchGifs(searchName: string) {
    console.log('searchname 1 : '+searchName)
    this.router.navigate(['home/search'], { state: {searchName: searchName } });
    this.sharedService.sendSearchEvent(searchName);
  }
}
