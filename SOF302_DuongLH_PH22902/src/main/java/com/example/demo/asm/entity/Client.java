package com.example.demo.asm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Table(name = "client")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "code")
    @NotBlank(message = "mã không được trống!")
    private String code;

    @Column(name = "client_name")
    @NotBlank(message = "tên không được trống!")
    private String name;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "phone_number")
    @Pattern(regexp = "[(0)+([0-9]{9})]+", message = "SDT phải 10 số và bắt đầu bằng 0!")
    private String phoneNumber;

    @Column(name = "client_address")
    @NotBlank(message = "địa chỉ không được trống!")
    private String address;

    @Column(name = "city")
    @NotBlank(message = "thành phố không được trống!")
    private String city;

    @Column(name = "nation")
    @NotBlank(message = "quốc gia không được trống!")
    private String nation;

    @Column(name = "client_password")
    @NotBlank(message = "password không được trống!")
    private String password;
}
