import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Player} from "../model/player";
import {Players} from "../model/players";

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  constructor(private http: HttpClient) { }

  getPlayers(): Observable<Players> {
    return this.http.get<Players>('api/players');
  }

  deletePlayer(uuid: string): Observable<any> {
    return this.http.delete('/api/players/' + uuid);
  }
}
