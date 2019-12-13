import { TestBed } from '@angular/core/testing';

import { FlightserviceService } from './flightservice.service';

describe('FlightserviceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FlightserviceService = TestBed.get(FlightserviceService);
    expect(service).toBeTruthy();
  });
});
