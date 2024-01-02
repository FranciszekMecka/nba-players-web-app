import {Component} from '@angular/core';
import {OrganizationService} from "../../service/organization.service";
import {v4 as uuidv4} from "uuid";
import {OrganizationPutForm} from "../../model/organization-put-form";
import {ActivatedRoute, Router} from "@angular/router";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {NgForOf, NgIf} from "@angular/common";
import {Organization} from "../../model/organization";

@Component({
  selector: 'app-organization-add',
  standalone: true,
  imports: [
    FormsModule,
    NgForOf,
    NgIf,
    ReactiveFormsModule
  ],
  templateUrl: './organization-add.component.html',
  styleUrl: './organization-add.component.css'
})
export class OrganizationAddComponent {

  uuid: string = uuidv4();

  organization: OrganizationPutForm = {
    name: '',
    dateOfEstablishment: ''
  };

  constructor(private service: OrganizationService, private route: ActivatedRoute,
              private router: Router) {
  }

  onSubmit(): void {
    this.service.putOrganization(this.uuid, this.organization!)
      .subscribe(() => {
          this.router.navigate(['/organizations']);
        }
      );
  }
}
