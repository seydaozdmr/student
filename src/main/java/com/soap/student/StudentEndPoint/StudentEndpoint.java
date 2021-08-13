package com.soap.student.StudentEndPoint;

import com.howtodoinjava.xml.school.StudentDetailsRequest;
import com.howtodoinjava.xml.school.StudentDetailsResponse;
import com.soap.student.StudentRepository.StudentRepository;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class StudentEndpoint {
    private static final String NAMESPACE_URI="http://www.howtodoinjava.com/xml/school";

    private StudentRepository studentRepository;

    public StudentEndpoint(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "StudentDetailsRequest")
    @ResponsePayload
    public StudentDetailsResponse getStudent(@RequestPayload StudentDetailsRequest request){
        StudentDetailsResponse response=new StudentDetailsResponse();
        response.setStudent(studentRepository.findStudent(request.getName()));
        return response;
    }


}
