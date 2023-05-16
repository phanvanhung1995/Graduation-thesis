import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {AccountModule} from './component/account/account.module';
import {DocumentModule} from './component/document/document.module';
import {NotificationModule} from './component/notification/notification.module';
import {ProgressModule} from './component/progress/progress.module';
import {ProjectModule} from './component/project/project.module';
import {SharedModule} from './component/shared/shared.module';
import {StudentModule} from './component/student/student.module';
import {TeacherModule} from './component/teacher/teacher.module';
import {TopicModule} from './component/topic/topic.module';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';

import {ReactiveFormsModule} from '@angular/forms';
import {environment} from '../environments/environment';
import {AngularFireModule} from '@angular/fire';
import {AngularFireStorageModule} from '@angular/fire/storage';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {AuthInterceptor} from "./component/security/auth.interceptor";
import {Http403Interceptor} from "./component/security/http403.interceptor";
import {CKEditorModule} from "ckeditor4-angular";


@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AccountModule,
    DocumentModule,
    NotificationModule,
    ProgressModule,
    ProjectModule,
    SharedModule,
    StudentModule,
    TeacherModule,
    TopicModule,
    HttpClientModule,
    ReactiveFormsModule,
    AngularFireStorageModule,
    AngularFireModule,
    AngularFireModule.initializeApp(environment.firebaseConfig),
    CKEditorModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    },
    {
      provide: HTTP_INTERCEPTORS,
      useClass: Http403Interceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
