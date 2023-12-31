import {Component, OnInit} from '@angular/core';
import {OrganizationService} from "../../service/organization.service";
import {Organization} from "../../model/organization";
import {NgIf} from "@angular/common";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-organization-view',
  standalone: true,
  imports: [
    NgIf
  ],
  templateUrl: './organization-view.component.html',
  styleUrl: './organization-view.component.css'
})
export class OrganizationViewComponent implements OnInit {

  organization: Organization | undefined;


  constructor(private service: OrganizationService, private route: ActivatedRoute, private router: Router) {
  }
  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.service.getOrganization(params['uuid'])
        .subscribe(organization => {
          this.organization = organization;
        })
    });
  }
}
