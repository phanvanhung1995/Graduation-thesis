package com.example.be.service.Impl;

import com.example.be.dto.IQuestionDto;
import com.example.be.model.Question;
import com.example.be.repository.IQuestionRepository;
import com.example.be.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class QuestionService implements IQuestionService {
    @Autowired
    private IQuestionRepository iQuestionRepository;
    /**
     * Created by: LanTTN,
     * Date created : 30/03/2023
     * Function : find all question
     *
     * @param pageable
     */
    @Override
    public Page<IQuestionDto> findAll(Pageable pageable) {
        return iQuestionRepository.findAllBy(pageable);
    }

    /**
     * Created by: LanTTN,
     * Date created : 30/03/2023
     * Function : save question
     *
     * @param questionContent, questionTopic, dateTime, studentId
     * @param dateTime
     */
    @Override
    public void save(String questionContent, String questionTopic, LocalDateTime dateTime, Long studentId) {
        iQuestionRepository.save(questionContent, questionTopic, dateTime, studentId);
    }
}
