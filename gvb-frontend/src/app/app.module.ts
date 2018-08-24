import { BrowserModule } from '@angular/platform-browser';
import {LOCALE_ID, NgModule} from '@angular/core';
import { FormsModule } from '@angular/forms';
import {routing} from './app.routing';
import { AppComponent } from './app.component';
import { MainComponent } from './main/main.component';
import { SidemenuComponent } from './sidemenu/sidemenu.component';
import { ContactComponent } from './contact/contact.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { DamageReportComponent } from './damage-report/damage-report.component';
import { LoginComponent } from './login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    SidemenuComponent,
    ContactComponent,
    PageNotFoundComponent,
    DamageReportComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    routing,
    FormsModule
  ],
  providers: [{ provide: LOCALE_ID, useValue: 'en' },
              { provide: LOCALE_ID, useValue: 'de' },
              { provide: LOCALE_ID, useValue: 'fr'}],
  bootstrap: [AppComponent]
})
export class AppModule { }
