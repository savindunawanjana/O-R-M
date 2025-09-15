package edu.project.lernessschool.demo.Dto;

public class InstructorDto {

    private String instructorId;
    private String instructorName;
    private String instructorEmail;
    private String instructorSpeciality;
    private String instructorPhone;

    public InstructorDto(String instructorId, String instructorName, String instructorEmail, String instructorSpeciality, String instructorPhone) {
        this.instructorId = instructorId;
        this.instructorName = instructorName;
        this.instructorEmail = instructorEmail;
        this.instructorSpeciality = instructorSpeciality;
        this.instructorPhone = instructorPhone;
    }

    public InstructorDto() {
    }

    public String getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(String instructorId) {
        this.instructorId = instructorId;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getInstructorEmail() {
        return instructorEmail;
    }

    public void setInstructorEmail(String instructorEmail) {
        this.instructorEmail = instructorEmail;
    }

    public String getInstructorSpeciality() {
        return instructorSpeciality;
    }

    public void setInstructorSpeciality(String instructorSpeciality) {
        this.instructorSpeciality = instructorSpeciality;
    }

    public String getInstructorPhone() {
        return instructorPhone;
    }

    public void setInstructorPhone(String instructorPhone) {
        this.instructorPhone = instructorPhone;
    }

    @Override
    public String toString() {
        return "InstructorDto{" +
                "instructorId='" + instructorId + '\'' +
                ", instructorName='" + instructorName + '\'' +
                ", instructorEmail='" + instructorEmail + '\'' +
                ", instructorSpeciality='" + instructorSpeciality + '\'' +
                ", instructorPhone='" + instructorPhone + '\'' +
                '}';
    }
}
