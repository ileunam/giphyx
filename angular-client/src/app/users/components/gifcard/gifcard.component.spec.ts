import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GifcardComponent } from './gifcard.component';

describe('GifcardComponent', () => {
  let component: GifcardComponent;
  let fixture: ComponentFixture<GifcardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GifcardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GifcardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
