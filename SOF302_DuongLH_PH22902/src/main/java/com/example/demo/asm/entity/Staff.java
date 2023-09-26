package com.example.demo.asm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Table(name = "staff")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Staff {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "code")
    @NotBlank(message = "mã không được trống!")
    private String code;

    @Column(name = "surname")
    @NotBlank(message = "họ không được trống!")
    private String surname;

    @Column(name = "middle_name")
    @NotBlank(message = "tên đệm không được trống!")
    private String middleName;

    @Column(name = "staff_name")
    @NotBlank(message = "tên không được trống!")
    private String name;

    @Column(name = "gender")
    private Boolean gender;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "staff_address")
    @NotBlank(message = "địa chỉ không được trống!")
    private String address;

    @Column(name = "phone_number")
    @Pattern(regexp = "[(0)+([0-9]{9})]+", message = "SDT phải 10 số và bắt đầu bằng 0!")
    private String phoneNumber;

    @Column(name = "staff_password")
    @NotBlank(message = "password không được trống!")
    private String password;

    @Column(name = "staff_status")
    private Integer status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_position", referencedColumnName = "id")
    private Position position;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_shop", referencedColumnName = "id")
    private Shop shop;


}
