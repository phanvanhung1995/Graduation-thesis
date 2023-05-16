package com.example.be.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class ProgressReportDTO {
    private int progressReportDTOId;
    //    @NotEmpty(message = "Không được để trống !")
//    @Length(min =10,max = 200, message = "Ký tự không được nhỏ hơn 5 và vươt quá 200 ký tự")
    private String progressReportContent;
    //    @NotEmpty(message = "Không được để trống !")
    private String progressReportFile;
    //    @NotEmpty(message = "Không được để trống !")
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
//    @Pattern(regexp = "^[0-9]{4}/(0[1-9]|1[0-2])/(0[1-9]|[1-2][0-9]|3[0-1]) (2[0-3]|[01][0-9]):[0-5][0-9]:[0-5][0-9]$", message = "Định dạng ngày giời phải theo format yyyy/mm/dd hh/mm/ss")
    private String progressReportTime;
    //    @NotEmpty(message = "Không được để trống !")
//  @Length(min =10,max = 200, message = "Ký tự không được nhỏ hơn 5 và vươt quá 200 ký tự")
    private String progressReportName;

    private ProjectDTO project;
    private StageDTO stage;

    public ProgressReportDTO(String progressReportContent, String progressReportFile, String progressReportTime) {
        this.progressReportContent = progressReportContent;
        this.progressReportFile = progressReportFile;
        this.progressReportTime = progressReportTime;
    }


    public ProgressReportDTO() {
    }

    public String getProgressReportContent() {
        return progressReportContent;
    }

    public ProjectDTO getProjectDTO() {
        return project;
    }

    public void setProjectDTO(ProjectDTO projectDTO) {
        this.project = projectDTO;
    }

    public StageDTO getStage() {
        return stage;
    }

    public void setStage(StageDTO stage) {
        this.stage = stage;
    }

    public void setProgressReportContent(String progressReportContent) {
        this.progressReportContent = progressReportContent;
    }

    public String getProgressReportFile() {
        return progressReportFile;
    }

    public void setProgressReportFile(String progressReportFile) {
        this.progressReportFile = progressReportFile;
    }

    public String getProgressReportTime() {
        return progressReportTime;
    }

    public void setProgressReportTime(String progressReportTime) {
        this.progressReportTime = progressReportTime;
    }

}
