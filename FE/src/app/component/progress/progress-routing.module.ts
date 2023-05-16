import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProgressDetailComponent} from './progress-detail/progress-detail.component';

import {DatePipe} from '@angular/common';
import {ProjectManagementComponent} from "./project-management/project-management.component";
import {ProgressReportComponent} from "./progress-report/progress-report.component";
import {ProgressReportHistoryComponent} from "./progress-report-history/progress-report-history.component";


const routes: Routes = [
  {path: 'progress-management', component: ProjectManagementComponent},
  {path: 'progress-detail/:id', component: ProgressDetailComponent},
  {
    path: 'report/:projectId/:stageId',
    component: ProgressReportComponent
  }, {
    path: 'history/:projectId/:stageId',
    component: ProgressReportHistoryComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  providers: [DatePipe]
})
export class ProgressRoutingModule { }
