import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AcercaDeNosotrosComponent } from './acerca-de-nosotros.component';

describe('AcercaDeNosotrosComponent', () => {
  let component: AcercaDeNosotrosComponent;
  let fixture: ComponentFixture<AcercaDeNosotrosComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AcercaDeNosotrosComponent]
    });
    fixture = TestBed.createComponent(AcercaDeNosotrosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
