import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShipdetailsComponent } from './shipdetails.component';

describe('ShipdetailsComponent', () => {
  let component: ShipdetailsComponent;
  let fixture: ComponentFixture<ShipdetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShipdetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShipdetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
