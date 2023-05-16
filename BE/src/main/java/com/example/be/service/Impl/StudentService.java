package com.example.be.service.Impl;

import com.example.be.dto.IMailStudentDto;
import com.example.be.dto.IStudentDTO;
import com.example.be.dto.StudentDto1;
import com.example.be.dto.StudentInfo;
import com.example.be.model.Project;
import com.example.be.model.Student;
import com.example.be.repository.IProjectRepository;
import com.example.be.repository.IStudentRepository;
import com.example.be.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private IProjectRepository iProjectRepository;

    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: find all student by name containing or code containing
     *
     * @return list page student if result is not error else return null
     * @Param: searchStr, pageable
     */
    @Override
    public Page<Student> findAllByNameOrStudentCode(String searchStr, Pageable pageable) {
        return this.studentRepository.findAllByNameOrStudentCode(searchStr, pageable);
    }

    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: find all student by team id
     *
     * @return list page student if result is not error else return null
     * @Param: teamId, pageable
     */
    @Override
    public Page<Student> findAllByTeamId(Long teamId, Pageable pageable) {
        return this.studentRepository.findAllByTeamId(teamId, pageable);
    }

    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: find student by id
     *
     * @return student if result is not null else return null
     * @Param: id
     */
    @Override
    public Student findById(Long id) {
        return this.studentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }


    @Override
    public void addStudent(String studentName, String studentCode,
                           String studentDateOfBirth, String studentEmail,
                           String studentPhoneNumber, boolean studentGender,
                           String studentAddress, String studentImg, Long clazzId) {
        studentRepository.addStudent(studentName,studentCode,studentDateOfBirth,studentEmail,studentPhoneNumber,studentGender,studentAddress,studentImg,clazzId);
    }

    @Override
    public IStudentDTO findStudentsById(long studentId) {
        return studentRepository.findStudentById(studentId);
    }

    @Override
    public void updateStudent(long studentId, Student student) {
        studentRepository.updateStudent(student.getStudentName(),student.getStudentCode(),
                student.getStudentDateOfBirth(),student.getStudentEmail(),
                student.getStudentPhoneNumber(),student.isStudentGender(),student.getStudentAddress(),
                student.getStudentImg(),student.getClazz().getClazzId(),studentId);
    }

    @Override
    public Long maxIdStudent() {
        return studentRepository.getStudentId();
    }

    /**
     * Create by : VinhLD
     * Date create 29/03/2023
     * Function: show list student
     *
     * @param pageable
     * @param nameSearch
     * @return json list student
     */
    @Override
    public Page<StudentDto1> getStudentList(Pageable pageable, String nameSearch) {
        return studentRepository.getStudentList(pageable, nameSearch);
    }

    @Override
    public List<IMailStudentDto> getInfomation(Long teamId) {
        return studentRepository.getInfomation(teamId);
    }

    /**
     * Created by: NuongHT
     * Date create: 29/03/2023
     */
    public String getTeam(long projectId) {
        // Thực hiện truy vấn cơ sở dữ liệu để lấy thông tin về đề tài
        Project project = iProjectRepository.findProById(projectId);
        if (project == null) {
            return "hi";
        } else {
            return project.getTeam().getTeamName();
        }
    }

    /**
     * Created by: NuongHT
     * Date create: 29/03/2023
     */
    public String getProjectTitle(long projectId) {
        // Thực hiện truy vấn cơ sở dữ liệu để lấy thông tin về đề tài
        Project project = iProjectRepository.findProById(projectId);
        if (project != null) {
            // Trả về tên của đề tài
            return project.getProjectName();
        } else {
            return null;
        }
    }

    /**
     * Created by: NuongHT
     * Date create: 29/03/2023
     */
    public void sendSimpleMessage(
            List<IMailStudentDto> mailList, String subject, String text, long projectId) {
        String[] arrayEmail = new String[mailList.size()];
        for (int i = 0; i < mailList.size(); i++) {
            arrayEmail[i] = mailList.get(i).getEmail();
        }
        String projectTitle = getProjectTitle(projectId);
        String teamName = getTeam(projectId);
        if (projectTitle != null) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("ngochann.1603@gmail.com");
            message.setTo(arrayEmail);
            message.setSubject(subject);
            message.setText("Xin chào các thành viên" + teamName
                    + "\nĐề tài " + projectTitle + "của các bạn"
                    + "\nquá ok được duyệt.");
            emailSender.send(message);
        }
    }

    /**
     * Created by: NuongHT
     * Date create: 29/03/2023
     */
    public void sendSimpleMessage2(
            List<IMailStudentDto> mailList, String subject, String text, long projectId) {
        String[] arrayEmail = new String[mailList.size()];
        for (int i = 0; i < mailList.size(); i++) {
            arrayEmail[i] = mailList.get(i).getEmail();
        }
        String projectTitle = getProjectTitle(projectId);
        String teamName = getTeam(projectId);
        if (projectTitle != null) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("ngochann.1603@gmail.com");
            message.setTo(arrayEmail);
            message.setSubject(subject);
            message.setText("Xin chào các thành viên " + teamName
                    + "\nĐề tài " + projectTitle +"của các bạn"
                    + "\nbị từ chối duyệt. ");
            emailSender.send(message);
        }
    }

    /**
     * Create by : VinhLD
     * Date create 29/03/2023
     * Function: show the instructor's list of students
     *
     * @param pageable
     * @param nameSearch
     * @param idTeacher
     * @return json the instructor's list of students
     */
    @Override
    public Page<StudentInfo> findAllStudent(Pageable pageable, String nameSearch, Long idTeacher) {
        return studentRepository.findAllStudent(pageable,nameSearch,idTeacher);
    }

    @Override
    public Student findStudentByEmail(String email) {
        return this.studentRepository.findStudentByEmail(email);
    }
}
