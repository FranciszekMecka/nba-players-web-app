import {Routes} from '@angular/router';
import {PlayerListComponent} from "./player/view/player-list/player-list.component";
import {OrganizationListComponent} from "./organization/view/organization-list/organization-list.component";
import {PlayerViewComponent} from "./player/view/player-view/player-view.component";
import {OrganizationViewComponent} from "./organization/view/organization-view/organization-view.component";
import {PlayerAddComponent} from "./player/view/player-add/player-add.component";
import {PlayerEditComponent} from "./player/view/player-edit/player-edit.component";
import {OrganizationAddComponent} from "./organization/view/organization-add/organization-add.component";
import {OrganizationEditComponent} from "./organization/view/organization-edit/organization-edit.component";

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
    component: PlayerEditComponent,
    path: "players/edit/:uuid"
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
    component: OrganizationAddComponent,
    path: "organizations/create"
  },
  {
    component: OrganizationEditComponent,
    path: "organizations/edit/:uuid"
  },
  {
    component: OrganizationViewComponent,
    path: "organizations/:uuid"
  },

];
