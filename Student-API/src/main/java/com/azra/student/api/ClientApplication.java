package com.azra.student.api;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class ClientApplication {
   static RestTemplate restTemplate = new RestTemplate();
   static String baseURL = "http://localhost:8080/api/students";

    public static void main(String[] args) {
        System.out.println("What is the first name of the student? ");
        Scanner in = new Scanner(System.in);
        String firstName = in.nextLine();
        System.out.println("What is the last name of the student? ");
        in = new Scanner(System.in);
        String lastName = in.nextLine();
        System.out.println("What is the email of the student? ");
        in = new Scanner(System.in);
        String email = in.nextLine();

        System.out.println("What is the country of the student? ");
         in = new Scanner(System.in);
        String country = in.nextLine();
        System.out.println("What is the city  of the student? ");
        in = new Scanner(System.in);
        String city = in.nextLine();
        System.out.println("What is the post code of the student? ");
        in = new Scanner(System.in);
        String postCode = in.nextLine();
        System.out.println("What is a favorite subject of the student? ");
        in = new Scanner(System.in);
        String favoriteSubject = in.nextLine();
        System.out.println("What is the total cost of books for the student? ");
        in = new Scanner(System.in);
        BigDecimal totalCost = in.nextBigDecimal();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Student> postRequestEntity = new HttpEntity<>(new Student(firstName, lastName, email,Gender.FEMALE, new Address(country,city,postCode), List.of(favoriteSubject), totalCost), headers);
        ResponseEntity<Student> responseEntity = restTemplate.exchange(baseURL, HttpMethod.POST, postRequestEntity, Student.class);
        System.out.println("Status code is " + responseEntity.getStatusCode());
        Student student = responseEntity.getBody();
        System.out.println("Response body " + student);
        HttpEntity<Student> getRequestEntity = new HttpEntity<>(headers);
        ResponseEntity<String> getResponseEntity = restTemplate.exchange(baseURL + "/student/get/" + email , HttpMethod.GET, getRequestEntity, String.class );
        System.out.println("Status code is " + responseEntity.getStatusCode());
        String students = getResponseEntity.getBody();
        System.out.println("Response body " + students);

    }
}
