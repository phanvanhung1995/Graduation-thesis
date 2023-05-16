package com.example.be.service.Impl;

import com.example.be.model.NotificationTeacher;
import com.example.be.repository.INotificationTeacherRepository;
import com.example.be.service.INotificationTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NotificationTeacherService implements INotificationTeacherService {
    @Autowired
    private INotificationTeacherRepository notificationTeacherRepository;

    /**
     * Created by: hoangNNH
     * Date created: 29/03/2023
     * Function: get notification teacher list
     *
     * @return notification list
     */
    @Override
    public List<NotificationTeacher> getAllNotificationTeacher() {
        return this.notificationTeacherRepository.getAllNotificationTeacher();
    }

    /**
     * Create by: TuanNDN
     * Date created: 29/03/2023
     * Function: show List NotificationTeacher
     *
     * @param 'notificationTeacherName'
     * @param 'notificationTeacherContent'
     */
    @Override
    public void addNotificationTeacher(String notificationTeacherTopic, String notificationTeacherContent) {
        notificationTeacherRepository.addNotificationTeacher(notificationTeacherTopic, notificationTeacherContent);
    }
}
