import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Player} from "../model/player";
import {Players} from "../model/players";
import {PlayerView} from "../model/player-view";
import {PlayerPutForm} from "../model/player-put-form";
import {PlayerPatchForm} from "../model/player-patch-form";

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  constructor(private http: HttpClient) { }

  getPlayers(): Observable<Players> {
    return this.http.get<Players>('api/players');
  }

  getOrganizationPlayers(uuid: string): Observable<Players> {
    return this.http.get<Players>('api/organizations/' + uuid + '/players');
  }

  getPlayer(uuid: string): Observable<PlayerView> {
    return this.http.get<PlayerView>('/api/players/' + uuid);
  }

  deletePlayer(uuid: string): Observable<any> {
    return this.http.delete('/api/players/' + uuid);
  }

  putPlayer(uuid: string, request: PlayerPutForm): Observable<any> {
    return this.http.put('/api/players/' + uuid, request);
  }

  patchPlayer(uuid: string, request: PlayerPatchForm): Observable<any> {
    return this.http.patch('/api/players/' + uuid, request);
  }
}
