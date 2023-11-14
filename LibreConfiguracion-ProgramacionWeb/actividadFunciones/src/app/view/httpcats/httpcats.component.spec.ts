import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HttpcatsComponent } from './httpcats.component';

describe('HttpcatsComponent', () => {
  let component: HttpcatsComponent;
  let fixture: ComponentFixture<HttpcatsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HttpcatsComponent]
    });
    fixture = TestBed.createComponent(HttpcatsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
