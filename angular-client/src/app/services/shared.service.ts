import {Injectable} from '@angular/core';
import {Observable, Subject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class SharedService {
  private subject = new Subject<string>();

  constructor() {
  }

  sendSearchEvent(searchName: string) {
    this.subject.next(searchName);
  }

  getSearchEvent(): Observable<any> {
    return this.subject.asObservable();
  }
}
