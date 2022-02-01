import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})

export class GiphyApiService {
  private url: string = 'http://localhost:8090/api/gif/giphy/'
  constructor(private http: HttpClient) {
  }

  public getTrendingGifs(limit: number, offset: number): any {
    return this.http.get(`${this.url}trending?&limit=${limit}&offset=${offset}`);
  }

  public searchGifs(gifname: string, limit: number, offset: number): any {
    return this.http.get(`${this.url}search?q=${gifname}&limit=${limit}&offset=${offset}`);
  }

  /*public searchById(gifs_id: string[]): any {
    return this.http.get(`https://api.giphy.com/v1/gifs?ids=${gifs_id.join()}&api_key=${environment.giphyKey}&limit=50`);
  }*/
}
