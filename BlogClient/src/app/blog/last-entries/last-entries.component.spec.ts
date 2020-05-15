import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LastEntriesComponent } from './last-entries.component';

describe('LastEntriesComponent', () => {
  let component: LastEntriesComponent;
  let fixture: ComponentFixture<LastEntriesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LastEntriesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LastEntriesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
