import {Component, OnInit} from '@angular/core';
import {TokenStorageService} from "../../../service/token-storage.service";
import {ShareService} from "../../../service/share.service";
import {TeacherService} from "../../../service/teacher.service";
import {StudentService} from "../../../service/student/student.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  username?: string;
  img?: string;
  name?: string;
  role?: string;
  isLoggedIn = false;
  idProject?: number;
  idStage?: number;

  constructor(private tokenStorageService: TokenStorageService,
              private shareService: ShareService,
              private teacherService: TeacherService,
              private studentService: StudentService,) {
    this.shareService.getClickEvent().subscribe(() => {
      this.loadHeader();
    });
  }

  loadHeader(): void {
    if (this.tokenStorageService.getToken()) {
      this.role = this.tokenStorageService.getUser().roles[0];
      this.username = this.tokenStorageService.getUser().username;
    }
    this.isLoggedIn = this.username != null;
    this.findNameUser();
  }

  ngOnInit(): void {
    this.loadHeader();
  }

  findNameUser(): void {
    if (this.role === 'ROLE_ADMIN' || this.role === 'ROLE_TEACHER') {
      this.teacherService.findTeacherByEmail(this.username).subscribe(next => {
        this.name = next.teacherName;
        this.img = next.teacherImg;
      });
    } else {
      this.studentService.findStudentByEmail(this.username).subscribe(next => {
        this.name = next.studentName;
        this.img = next.studentImg;
      });
    }
  }


  logOut() {
    this.tokenStorageService.signOut();
    this.ngOnInit();
  }
}
