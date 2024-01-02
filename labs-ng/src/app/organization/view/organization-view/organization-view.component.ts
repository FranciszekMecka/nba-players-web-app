import {Component, OnInit} from '@angular/core';
import {OrganizationService} from "../../service/organization.service";
import {Organization} from "../../model/organization";
import {NgForOf, NgIf} from "@angular/common";
import {ActivatedRoute, Router, RouterLink} from "@angular/router";
import {PlayerService} from "../../../player/service/player.service";
import {Players} from "../../../player/model/players";
import {Player} from "../../../player/model/player";

@Component({
  selector: 'app-organization-view',
  standalone: true,
  imports: [
    NgIf,
    NgForOf,
    RouterLink
  ],
  templateUrl: './organization-view.component.html',
  styleUrl: './organization-view.component.css'
})
export class OrganizationViewComponent implements OnInit {

  organization: Organization | undefined;
  players: Players | undefined

  constructor(private service: OrganizationService, private playerService: PlayerService,
              private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.service.getOrganization(params['uuid'])
        .subscribe(organization => {
          this.organization = organization;
          this.playerService.getOrganizationPlayers(organization.id).subscribe((players) => {
            this.players = players
          });
        });
    });
  }

  onDelete(player: Player): void {
    this.playerService.deletePlayer(player.id).subscribe(() => this.ngOnInit());
  }
}
