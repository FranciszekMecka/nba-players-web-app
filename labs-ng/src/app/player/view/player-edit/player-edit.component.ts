import {Component, OnInit} from '@angular/core';
import {PlayerPatchForm} from "../../model/player-patch-form";
import {Organizations} from "../../../organization/model/organizations";
import {ActivatedRoute, Router} from "@angular/router";
import {OrganizationService} from "../../../organization/service/organization.service";
import {PlayerService} from "../../service/player.service";
import {FormsModule} from "@angular/forms";
import {PlayerPutForm} from "../../model/player-put-form";
import {NgForOf, NgIf} from "@angular/common";

@Component({
  selector: 'app-player-edit',
  standalone: true,
  imports: [
    FormsModule,
    NgIf,
    NgForOf
  ],
  templateUrl: './player-edit.component.html',
  styleUrl: './player-edit.component.css'
})
export class PlayerEditComponent implements OnInit {

  uuid: string | undefined;

  player: PlayerPutForm = {
    firstName: '',
    lastName: '',
    nationality: '',
    jerseyNumber: 0,
    age: 0,
    height: 0,
    weight: 0,
    dateOfBirth: '',
    organization: ''
  };

  original!: PlayerPatchForm | undefined;

  organizations: Organizations | undefined;

  constructor(
    private playerService: PlayerService,
    private organizationService: OrganizationService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  };

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.organizationService.getOrganizations()
        .subscribe(organizations => this.organizations = organizations);

      this.playerService.getPlayer(params['uuid'])
        .subscribe(player => {
          this.uuid = player.id;
          this.player = {
            firstName: player.firstName,
            lastName: player.lastName,
            nationality: player.nationality,
            jerseyNumber: player.jerseyNumber,
            age: player.age,
            height: player.height,
            weight: player.weight,
            dateOfBirth: player.dateOfBirth,
            organization: player.organization.id,
          };
          this.original = {...this.player};
        });
    });
  }

  onSubmit(): void {
    this.playerService.patchPlayer(this.uuid!, this.player!)
      .subscribe(() => {
        this.router.navigate(['/players', this.uuid]);
      });
  }

}
