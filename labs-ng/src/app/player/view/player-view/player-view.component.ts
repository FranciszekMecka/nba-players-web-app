import {Component, OnInit} from '@angular/core';
import {PlayerService} from "../../service/player.service";
import {ActivatedRoute, Router} from "@angular/router";
import {PlayerView} from "../../model/player-view";
import {NgIf} from "@angular/common";

@Component({
  selector: 'app-player-view',
  standalone: true,
  imports: [
    NgIf
  ],
  templateUrl: './player-view.component.html',
  styleUrl: './player-view.component.css'
})
export class PlayerViewComponent implements OnInit{

  player: PlayerView | undefined;

  constructor(private service: PlayerService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getPlayer(params['uuid'])
        .subscribe(player => {
          this.player = player;
        })
    });
  }
}
