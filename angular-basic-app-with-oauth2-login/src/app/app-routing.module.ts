import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { PublicInfoComponent } from './public-info/public-info.component';
import { UserRestrictedInfoComponent } from './user-restricted-info/user-restricted-info.component';

const routes: Routes = [
  { path: 'public', component: PublicInfoComponent },
  { path: 'user-restricted', component: UserRestrictedInfoComponent },
  { path: '**', component: HomeComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

  get Routes() {
    return routes;
  }

}
