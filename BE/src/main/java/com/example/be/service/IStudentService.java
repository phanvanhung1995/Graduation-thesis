package com.example.be.service;

import com.example.be.dto.IMailStudentDto;
import com.example.be.dto.IStudentDTO;
import com.example.be.dto.StudentDto1;
import com.example.be.dto.StudentInfo;
import com.example.be.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: find all student by name containing or code containing
     *
     * @Param: searchStr, pageable
     */
    Page<Student> findAllByNameOrStudentCode(String searchStr, Pageable pageable);

    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: find all student by team id
     *
     * @Param: teamId, pageable
     */
    Page<Student> findAllByTeamId(Long teamId, Pageable pageable);

    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: find student by id
     *
     * @Param: id
     */
    Student findById(Long id);

    List<Student> findAll();


    void addStudent(String studentName,
                    String studentCode,
                    String studentDateOfBirth,
                    String studentEmail,
                    String studentPhoneNumber,
                    boolean studentGender,
                    String studentAddress,
                    String studentImg,
                    Long clazzId);

    IStudentDTO findStudentsById(long studentId);

    void updateStudent(long studentId,Student student);
    Long maxIdStudent();

    /**
     * Create by : VinhLD
     * Date create 29/03/2023
     * Function: show list student
     *
     * @param pageable
     * @param nameSearch
     * @return json list student
     */
    Page<StudentDto1> getStudentList(Pageable pageable, String nameSearch);

    /**
     * Created by: NuongHT
     * Date create: 29/03/2023
     */
    List<IMailStudentDto> getInfomation(Long teamId);

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
    Page<StudentInfo> findAllStudent(Pageable pageable, String nameSearch, Long idTeacher);

    Student findStudentByEmail(String email);
}
