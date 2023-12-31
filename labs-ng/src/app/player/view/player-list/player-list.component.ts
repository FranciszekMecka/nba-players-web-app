import {Component, OnInit} from '@angular/core';
import {PlayerService} from "../../service/player.service";
import {Players} from "../../model/players";
import {NgForOf, NgIf, NgStyle} from "@angular/common";
import {Player} from "../../model/player";
import {RouterLink} from "@angular/router";
import {PlayerAddComponent} from "../player-add/player-add.component";

@Component({
  selector: 'app-player-list',
  standalone: true,
  imports: [
    NgIf,
    NgForOf,
    NgStyle,
    RouterLink,
    PlayerAddComponent
  ],
  templateUrl: './player-list.component.html',
  styleUrl: './player-list.component.css'
})
export class PlayerListComponent implements OnInit {
  constructor(private service: PlayerService) {
  }

    players: Players | undefined;

    ngOnInit(): void {
      this.service.getPlayers().subscribe((players) => {
        this.players = players
      });
   }
  onDelete(player: Player): void {
    this.service.deletePlayer(player.id).subscribe(() => this.ngOnInit());
  }
}
