import {Organization} from "../../organization/model/organization";

export interface PlayerView {
  id: string;
  firstName: string;
  lastName: string;
  nationality: string;
  jerseyNumber: number;
  age: number;
  height: number;
  weight: number;
  dateOfBirth: string;
  organization: Organization;
}
