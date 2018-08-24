import {RouterModule, Routes} from '@angular/router';
import {ContactComponent} from './contact/contact.component';
import {PageNotFoundComponent} from './page-not-found/page-not-found.component';
import {ModuleWithProviders} from '@angular/core';
import {MainComponent} from './main/main.component';
import {LoginComponent} from './login/login.component';

export const appRoutes: Routes = [
  { path: 'damage-report', component: ContactComponent },
  { path: 'main', component: MainComponent},
  { path: 'login', component: LoginComponent},
  { path: '',
    redirectTo: '/main',
    pathMatch: 'full'
  },
  { path: '**', component: PageNotFoundComponent }
];

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes, {useHash: false});
