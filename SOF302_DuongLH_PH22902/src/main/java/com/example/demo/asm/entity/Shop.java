package com.example.demo.asm.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "shop")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "code")
    @NotBlank(message = "mã không được trống!")
    private String code;

    @Column(name = "shop_name")
    @NotBlank(message = "tên không được trống!")
    private String name;

    @Column(name = "shop_address")
    @NotBlank(message = "địa chỉ không được trống!")
    private String address;

    @Column(name = "city")
    @NotBlank(message = "thành phố không được trống!")
    private String city;

    @Column(name = "nation")
    @NotBlank(message = "quốc gia không được trống!")
    private String nation;

}
