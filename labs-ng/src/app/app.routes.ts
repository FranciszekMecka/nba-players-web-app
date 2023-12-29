import { Routes } from '@angular/router';
import {PlayerListComponent} from "./player/view/player-list/player-list.component";
import {OrganizationListComponent} from "./organization/view/organization-list/organization-list.component";

export const routes: Routes = [
  {
    component: PlayerListComponent,
    path: 'players'
  },
  {
    component: OrganizationListComponent,
    path: 'organizations'
  },
];
