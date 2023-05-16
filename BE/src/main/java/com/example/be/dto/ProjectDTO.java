package com.example.be.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class ProjectDTO {
    private Long projectId;
    @Size(max = 250, message = "Tên đề tài không được dài quá 250 kí tự")
    @NotBlank(message = "Không được để trống")
    @NotNull(message = "Phải nhập trường này")
    @Pattern(regexp = "^[A-Z][\\p{L}\\d\\s]*$",
            message =
                    "Tên đề tài không được chứa kí tự đặc biệt, " +
                            "chữ cái đầu tiên phải viết hoa")
    private String projectName;
    @Size(max = 2000, message = "Nội dung miêu tả không được dài quá 2000 kí tự")
    @NotBlank(message = "Không được để trống")
    @NotNull(message = "Phải nhập trường này")
    private String projectContent;
    @NotBlank(message = "Không được để trống")
    @NotNull(message = "Phải nhập trường này")
    private String projectImg;
    @NotBlank(message = "Không được để trống")
    @NotNull(message = "Phải nhập trường này")
    private String projectDescription;
    private Long teamId;

    public ProjectDTO() {
    }



    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectContent() {
        return projectContent;
    }

    public void setProjectContent(String projectContent) {
        this.projectContent = projectContent;
    }

    public String getProjectImg() {
        return projectImg;
    }

    public void setProjectImg(String projectImg) {
        this.projectImg = projectImg;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }
}
