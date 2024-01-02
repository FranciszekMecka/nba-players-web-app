import {Component, OnInit} from '@angular/core';
import {PlayerService} from "../../service/player.service";
import {OrganizationService} from "../../../organization/service/organization.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Organizations} from "../../../organization/model/organizations";
import {v4 as uuidv4} from 'uuid';
import {PlayerPutForm} from "../../model/player-put-form";
import {FormsModule} from "@angular/forms";
import {NgForOf, NgIf} from "@angular/common";
import {Organization} from "../../../organization/model/organization";

@Component({
  selector: 'app-player-add',
  standalone: true,
  imports: [
    FormsModule,
    NgIf,
    NgForOf
  ],
  templateUrl: './player-add.component.html',
  styleUrl: './player-add.component.css'
})
export class PlayerAddComponent implements OnInit {

  organizations: Organizations | undefined;

  // player!: PlayerPutForm;
  // text!: string;

  defaultOrganization: Organization = {
    id: '',
    name: '',
    dateOfEstablishment: ''
  };

  player: PlayerPutForm = {
    firstName: '',
    lastName: '',
    nationality: '',
    jerseyNumber: 0,
    age: 0,
    height: 0,
    weight: 0,
    dateOfBirth: '',
    organization: this.defaultOrganization.id
  };

  uuid: string = uuidv4();

  constructor(
    private playerService: PlayerService,
    private organizationService: OrganizationService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.organizationService.getOrganizations()
        .subscribe(organizations => this.organizations = organizations)
    })
  }

  onSubmit(): void {
    this.playerService.putPlayer(this.uuid, this.player!)
      .subscribe(() => {
          this.router.navigate(['/players']);
        }
      );
  }
}
