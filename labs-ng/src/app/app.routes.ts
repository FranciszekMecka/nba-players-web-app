import {Routes} from '@angular/router';
import {PlayerListComponent} from "./player/view/player-list/player-list.component";
import {OrganizationListComponent} from "./organization/view/organization-list/organization-list.component";
import {PlayerViewComponent} from "./player/view/player-view/player-view.component";
import {OrganizationViewComponent} from "./organization/view/organization-view/organization-view.component";
import {PlayerAddComponent} from "./player/view/player-add/player-add.component";

export const routes: Routes = [
  {
    component: PlayerListComponent,
    path: "players"
  },
  {
    component: PlayerAddComponent,
    path: "players/create"
  },
  {
    component: PlayerViewComponent,
    path: "players/:uuid"
  },
  {
    component: OrganizationListComponent,
    path: "organizations"
  },
  {
    component: OrganizationViewComponent,
    path: "organizations/:uuid"
  },
];
