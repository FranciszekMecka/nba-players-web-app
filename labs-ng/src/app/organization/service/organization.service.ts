import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Organization} from "../model/organization";
import {HttpClient} from "@angular/common/http";
import {Organizations} from "../model/organizations";

@Injectable({
  providedIn: 'root'
})
export class OrganizationService {

  constructor(private http: HttpClient) { }

  getOrganizations(): Observable<Organizations> {
    return this.http.get<Organizations>('api/organizations');
  }

  getOrganization(uuid: string): Observable<Organization> {
    return this.http.get<Organization>('/api/organizations/' + uuid);
  }

  deleteOrganization(uuid: string): Observable<any> {
    return this.http.delete('/api/organizations/' + uuid);
  }
}
