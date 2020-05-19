import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TopicsPhoneComponent } from './topics-phone.component';

describe('TopicsPhoneComponent', () => {
  let component: TopicsPhoneComponent;
  let fixture: ComponentFixture<TopicsPhoneComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TopicsPhoneComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TopicsPhoneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
