import {Component, OnInit} from '@angular/core';
import {Organizations} from "../../model/organizations";
import {OrganizationService} from "../../service/organization.service";
import {NgForOf, NgIf} from "@angular/common";
import {Organization} from "../../model/organization";

@Component({
  selector: 'app-organization-list',
  standalone: true,
  imports: [
    NgForOf,
    NgIf
  ],
  templateUrl: './organization-list.component.html',
  styleUrl: './organization-list.component.css'
})
export class OrganizationListComponent implements OnInit{

  constructor(private service: OrganizationService) {
  }

  organizations: Organizations | undefined;

  ngOnInit(): void {
    this.service.getOrganizations().subscribe((organizations) => {
      this.organizations = organizations;
    });
  }

  onDelete(organization: Organization): void {
    this.service.deleteOrganization(organization.id).subscribe(() => this.ngOnInit());
  }
}
