import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponentComponent } from './component/login-component/login-component.component';
import { ViewEnrolledStudentsComponentComponent } from './component/view-enrolled-students-component/view-enrolled-students-component.component';
import { ChangeGradeComponentComponent } from './component/change-grade-component/change-grade-component.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponentComponent,
    ViewEnrolledStudentsComponentComponent,
    ChangeGradeComponentComponent
  ],
  imports: [
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
