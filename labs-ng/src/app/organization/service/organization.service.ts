import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {Organization} from "../model/organization";
import {HttpClient} from "@angular/common/http";
import {Organizations} from "../model/organizations";
import {PlayerPutForm} from "../../player/model/player-put-form";
import {OrganizationPutForm} from "../model/organization-put-form";
import {PlayerPatchForm} from "../../player/model/player-patch-form";
import {OrganizationPatchForm} from "../model/organization-patch-form";

@Injectable({
  providedIn: 'root'
})
export class OrganizationService {

  constructor(private http: HttpClient) { }

  putOrganization(uuid: string, request: OrganizationPutForm): Observable<any> {
    return this.http.put('/api/organizations/' + uuid, request);
  }

  getOrganizations(): Observable<Organizations> {
    return this.http.get<Organizations>('api/organizations');
  }

  getOrganization(uuid: string): Observable<Organization> {
    return this.http.get<Organization>('/api/organizations/' + uuid);
  }

  deleteOrganization(uuid: string): Observable<any> {
    return this.http.delete('/api/organizations/' + uuid);
  }

  patchOrganization(uuid: string, request: OrganizationPatchForm): Observable<any> {
    return this.http.patch('/api/organizations/' + uuid, request);
  }
}
