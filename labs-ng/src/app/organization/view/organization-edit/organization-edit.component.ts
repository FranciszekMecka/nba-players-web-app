import {Component, OnInit} from '@angular/core';
import {PlayerService} from "../../../player/service/player.service";
import {OrganizationService} from "../../service/organization.service";
import {ActivatedRoute, Router} from "@angular/router";
import {PlayerPutForm} from "../../../player/model/player-put-form";
import {OrganizationPatchForm} from "../../model/organization-patch-form";
import {Organization} from "../../model/organization";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";

@Component({
  selector: 'app-organization-edit',
  standalone: true,
  imports: [
    FormsModule,
    ReactiveFormsModule
  ],
  templateUrl: './organization-edit.component.html',
  styleUrl: './organization-edit.component.css'
})

export class OrganizationEditComponent implements OnInit {

  uuid: string | undefined;

  organization: OrganizationPatchForm = {
    name: '',
    dateOfEstablishment: ''
  };

  constructor(
    private service: OrganizationService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  };

  ngOnInit(): void {
    this.route.params.subscribe(
      params => {
        this.service.getOrganization(params['uuid'])
          .subscribe(organization => {
            this.uuid = organization.id;
            this.organization = {
              name: organization.name,
              dateOfEstablishment: organization.dateOfEstablishment
            };
          })
      }
    )
  }

  onSubmit(): void {
    this.service.patchOrganization(this.uuid!, this.organization!)
      .subscribe(() => {
        this.router.navigate(['/organizations', this.uuid]);
      });
  }
}
