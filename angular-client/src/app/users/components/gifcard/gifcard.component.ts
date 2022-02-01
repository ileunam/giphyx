import {Component, OnInit, Input, Output, EventEmitter} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'gifcard',
  templateUrl: './gifcard.component.html',
  styleUrls: ['./gifcard.component.css']
})
export class GifcardComponent implements OnInit {
  public form!: FormGroup;
  @Input()  gifData: any = {};
  @Output() gifIdEvent = new EventEmitter<string>();

  cardDisplay: any = 'card-title d-none';

  constructor(
    private formBuilder: FormBuilder
  ) {
  }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      selectUser: ['', [
        Validators.required
      ]]
    });

  }

  handleInfoDisplayOn(): void {
    this.cardDisplay = 'card-title';
  }

  handleInfoDisplayOff(): void {
    this.cardDisplay = 'card-title d-none';
  }

  sendGifId() {
    this.gifIdEvent.emit(this.gifData.id);
  }

}
