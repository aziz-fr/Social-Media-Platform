import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TweetsByUserComponent } from './tweets-by-user.component';

describe('TweetsByUserComponent', () => {
  let component: TweetsByUserComponent;
  let fixture: ComponentFixture<TweetsByUserComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TweetsByUserComponent]
    });
    fixture = TestBed.createComponent(TweetsByUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
