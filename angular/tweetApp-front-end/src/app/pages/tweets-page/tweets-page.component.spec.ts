import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TweetsPageComponent } from './tweets-page.component';

describe('TweetsPageComponent', () => {
  let component: TweetsPageComponent;
  let fixture: ComponentFixture<TweetsPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TweetsPageComponent]
    });
    fixture = TestBed.createComponent(TweetsPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
