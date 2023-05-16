import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ProgressDetail} from '../model/progress-detail';
import {ProgressDto} from "../dto/progress-dto";
import {ProgressStudentDto} from "../dto/progress-student-dto";

@Injectable({
  providedIn: 'root'
})
export class ProgressDetailService {
  private URI_API = 'http://localhost:8080/api/progress/';

  constructor(private http: HttpClient) {
  }

  findProgressProjectById(projectId: number): Observable<ProgressDto> {
    return this.http.get<ProgressDto>('http://localhost:8080/api/progress/' + projectId);
  }

  findStudentOfTeam(projectId: number): Observable<ProgressStudentDto[]> {
    return this.http.get<ProgressStudentDto[]>('http://localhost:8080/api/progress/progressStudent/' + projectId);
  }

  findAllProgressDetailByProjectId(projectId: number): Observable<ProgressDetail[]> {
    return this.http.get<ProgressDetail[]>('http://localhost:8080/api/progressDetail/list/' + projectId);
  }
}
