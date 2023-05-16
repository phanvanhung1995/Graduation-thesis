package com.example.be.service.Impl;

import com.example.be.dto.ITeacherDto;
import com.example.be.model.Teacher;
import com.example.be.repository.ITeacherRepository;
import com.example.be.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.be.dto.teacher.IEmailAndPhoneNumberDTO;
import com.example.be.dto.teacher.ITeacherDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService implements ITeacherService {


    @Autowired
    private ITeacherRepository iTeacherRepository;


    @Override
    public Optional<Teacher> findByID(Long id) {
        return iTeacherRepository.findById(id);
    }

    @Override
    public ITeacherDTO getTeacher(Long idTeacher) {
        return iTeacherRepository.getTeacher(idTeacher);
    }

    @Override
    public ITeacherDTO maxIdTeacher() {
        return iTeacherRepository.maxIdTeacher();
    }

    @Override
    public List<Teacher> findAll() {
        return iTeacherRepository.findAll();
    }

    @Override
    public void addTeacher(Teacher teacher) {
        iTeacherRepository.addTeacher(teacher.getTeacherName(), teacher.getTeacherDateOfBirth(), teacher.getDegree().getDegreeId(), teacher.getTeacherAddress(), teacher.isTeacherGender(), teacher.getTeacherPhoneNumber(), teacher.getFaculty().getFacultyId(), teacher.getTeacherEmail(), teacher.getTeacherCode(), teacher.getTeacherImg());
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        iTeacherRepository.updateTeacher(teacher.getTeacherName(), teacher.getTeacherDateOfBirth(), teacher.getDegree().getDegreeId(), teacher.getTeacherAddress(), teacher.isTeacherGender(), teacher.getTeacherPhoneNumber(), teacher.getFaculty().getFacultyId(), teacher.getTeacherEmail(), teacher.getTeacherImg(), teacher.getTeacherId());
    }

    @Override
    public List<IEmailAndPhoneNumberDTO> getAllPhoneNumberAndEmail() {
        return iTeacherRepository.getAllPhoneNumberAndEmail();
    }



    /**
     * create by : HungPV ,
     * Date Create : 29/03/2023
     * Function : show list has paging and search
     *
     * @param name
     * @param pageable
     * @return Page<ITeacherDto>
     */
    @Override
    public Page<Teacher> getAllTeacher1(String name, Pageable pageable) {
        return this.iTeacherRepository.findAllByTeacherNameContaining(name, pageable);
    }

    @Override
    public Page<ITeacherDto> getAllTeacher(String name, Pageable pageable) {
        return this.iTeacherRepository.getAllTeacher(name, pageable);
    }

    @Override
    public Optional<ITeacherDto> findTeacherById(Long id) {
        return iTeacherRepository.findTeacherById(id);
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return iTeacherRepository.findTeacherByTeacherId(id);
    }

    /**
     * create by : HungPV ,
     * Date Create : 29/03/2023
     * Function : get teacher by id
     *
     * @param id
     * @return Optional<ITeacherDto>
     */


    /**
     * create by : HungPV ,
     * Date Create : 29/03/2023
     * Function : delete teacher by id
     *
     * @param id
     * @return void
     */
    @Override
    public void deleteTeacherById(long id) {
        this.iTeacherRepository.deleteTeacherById(id);
    }

    @Override
    public Teacher findTeacherByEmail(String email) {
        return this.iTeacherRepository.findTeacherByEmail(email);
    }

    @Override
    public void updateTeacherRoleAdmin(Teacher teacher) {
        iTeacherRepository.updateTeacherRoleAdmin(teacher.getTeacherName(), teacher.getTeacherEmail(), teacher.getTeacherPhoneNumber(),
                teacher.getTeacherAddress(), teacher.getTeacherId());
    }
}

