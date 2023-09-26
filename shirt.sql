CREATE DATABASE FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041
USE FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041
GO
-- ChucVu
CREATE TABLE position(
id BIGINT IDENTITY(1,1) PRIMARY KEY ,
code VARCHAR(20) UNIQUE, -- mã
position_name NVARCHAR(50) DEFAULT NULL -- tên
)
GO
-- CuaHang
CREATE TABLE shop(
id BIGINT IDENTITY(1,1) PRIMARY KEY,
code VARCHAR(20) UNIQUE, -- mã
shop_name NVARCHAR(50) DEFAULT NULL, -- tên
shop_address NVARCHAR(100) DEFAULT NULL, -- địa chỉ
city NVARCHAR(50) DEFAULT NULL, -- thành phố
nation NVARCHAR(50) DEFAULT NULL -- quốc gia
)
GO
-- NhanVien
CREATE TABLE staff(
id BIGINT IDENTITY(1,1) PRIMARY KEY,
code VARCHAR(20) UNIQUE, -- mã
surname NVARCHAR(50) DEFAULT NULL, -- họ
middle_name NVARCHAR(50) DEFAULT NULL, -- tên đệm
staff_name NVARCHAR(50) DEFAULT NULL, -- tên
gender NVARCHAR(10) DEFAULT NULL, -- giới tính
date_of_birth DATE DEFAULT NULL, -- ngày sinh
staff_address NVARCHAR(100) DEFAULT NULL, -- địa chỉ
phone_number VARCHAR(30) DEFAULT NULL, -- sđt
staff_password VARCHAR(MAX) DEFAULT NULL, -- mật khẩu
id_position BIGINT , -- id chức vụ
id_shop BIGINT , -- id cửa hàng
staff_status INT DEFAULT 0 -- trạng thái
)
GO
-- KhachHang
CREATE TABLE client(
id BIGINT IDENTITY(1,1) PRIMARY KEY ,
code VARCHAR(20) UNIQUE, -- mã
client_name NVARCHAR(50) DEFAULT NULL, -- tên
date_of_birth DATE DEFAULT NULL, -- ngày sinh
phone_number VARCHAR(30) DEFAULT NULL, -- sdt
client_address NVARCHAR(100) DEFAULT NULL, -- địa chỉ
city NVARCHAR(50) DEFAULT NULL, -- thành phố
nation NVARCHAR(50) DEFAULT NULL, -- quốc gia
client_password VARCHAR(MAX) DEFAULT NULL, -- mật khẩu
id_rank_client BIGINT, -- id hạng khách hàng
)
GO
-- hangKhachHang
CREATE TABLE rank_client(
id BIGINT IDENTITY(1,1) PRIMARY KEY ,
code VARCHAR(20) UNIQUE, -- mã
minimum_score int DEFAULT NULL, -- điểm tối thiểu
staff_status INT DEFAULT 0 -- trạng thái
)
GO
--HoaDon
CREATE TABLE invoice(
id BIGINT IDENTITY(1,1) PRIMARY KEY ,
id_client BIGINT , -- id khách hàng
id_staff BIGINT , -- id nhân viên
code VARCHAR(20) UNIQUE, -- mã
date_created DATE DEFAULT NULL, -- ngày tạo
date_of_payment DATE DEFAULT NULL,-- ngày thanh toán
ship_date DATE DEFAULT NULL,-- ngày ship
received_date DATE DEFAULT NULL, -- ngày nhận
invoice_status INT DEFAULT 0, -- trạng thái
recipient NVARCHAR(50) DEFAULT NULL, -- tên người nhận
invoice_address NVARCHAR(100) DEFAULT NULL, -- địa chỉ
phone_number VARCHAR(30) DEFAULT NULL, -- sdt
)
GO
-- giỏ hàng
CREATE TABLE shopping_cart(
id BIGINT IDENTITY(1,1) PRIMARY KEY ,
id_client BIGINT ,-- id khách hàng
id_staff BIGINT , -- id nhân viên
code VARCHAR(20) UNIQUE, -- mã
date_created DATE DEFAULT NULL, -- ngày tạo
date_of_payment DATE DEFAULT NULL, -- ngày thanh toán
recipient NVARCHAR(50) DEFAULT NULL, -- tên người nhận
shopping_cart_address NVARCHAR(100) DEFAULT NULL, -- địa chỉ
phone_number VARCHAR(30) DEFAULT NULL, -- sdt
shopping_cart_status INT DEFAULT 0 -- trạng thái
)
GO
-- SanPham
CREATE TABLE product(
id BIGINT IDENTITY(1,1) PRIMARY KEY ,
code VARCHAR(20) UNIQUE,
product_name NVARCHAR(30)
)
GO
-- NSX
CREATE TABLE producer(
id BIGINT IDENTITY(1,1) PRIMARY KEY ,
code VARCHAR(20) UNIQUE,
producer_name NVARCHAR(30)
)
GO
-- MauSac
CREATE TABLE color(
id BIGINT IDENTITY(1,1) PRIMARY KEY ,
code VARCHAR(20) UNIQUE,
color_name NVARCHAR(30)
)
GO
-- DongSP
CREATE TABLE product_line(
id BIGINT IDENTITY(1,1) PRIMARY KEY ,
code VARCHAR(20) UNIQUE,
product_line_name NVARCHAR(30)
)
GO
-- ChiTietSP
CREATE TABLE product_details(
id BIGINT IDENTITY(1,1) PRIMARY KEY ,
id_product BIGINT , -- id sản phẩm
id_producer BIGINT , -- id nsx
id_color BIGINT , -- id màu sắc
id_product_line BIGINT , -- id dòng sản phẩm
warranty_year INT DEFAULT NULL, --năm bảo hành
describe NVARCHAR(50) DEFAULT NULL, -- mô tả
inventory INT, -- số lượng tồn
import_price DECIMAL(20,0) DEFAULT 0, -- giá nhập
price DECIMAL(20,0) DEFAULT 0, -- giá bán
)

GO
-- HoaDonChiTiet
CREATE TABLE detailed_invoice(
id_invoice BIGINT ,-- id hoá dơn 
id_product_details BIGINT ,-- id chi tiết sản phẩm
quantity INT,-- số lượng
unit_price DECIMAL(20,0) DEFAULT 0, -- đơn giá
capital_sum DECIMAL(20,0), -- tổng tiền
CONSTRAINT PK_detailed_invoice PRIMARY KEY (id_invoice,id_product_details),
CONSTRAINT FK1 FOREIGN KEY(id_invoice) REFERENCES invoice(id),
CONSTRAINT FK2 FOREIGN KEY(id_product_details) REFERENCES product_details(id),
)
GO
CREATE TABLE detailed_shopping_cart(
id_shopping_cart BIGINT, -- id giỏ hàng
id_product_details BIGINT, -- id chi tiết sản phẩm
quantity INT, -- số lượng
unit_price DECIMAL(20,0) DEFAULT 0, -- đơn giá
capital_sum DECIMAL(20,0), -- tổng tiền
CONSTRAINT PK_detailed_shopping_cart PRIMARY KEY (id_shopping_cart,id_product_details),
CONSTRAINT FK1_id_shopping_cart FOREIGN KEY(id_shopping_cart) REFERENCES shopping_cart(id),
CONSTRAINT FK2_id_product_details FOREIGN KEY(id_product_details) REFERENCES product_details(id),
)
GO
--TẠO QUAN HỆ GIỮA CÁC BẢNG
--NhanVien - CuaHang
ALTER TABLE staff ADD FOREIGN KEY (id_shop) REFERENCES shop(id)
--NhanVien - ChucVu
ALTER TABLE staff ADD FOREIGN KEY (id_position) REFERENCES position(id)
-- HoaDon - KhachHang
ALTER TABLE invoice ADD FOREIGN KEY (id_client) REFERENCES client(id)
-- GioHang - KhachHang
ALTER TABLE shopping_cart ADD FOREIGN KEY (id_client) REFERENCES client(id)
-- HoaDon - NhanVien
ALTER TABLE invoice ADD FOREIGN KEY (id_staff) REFERENCES staff(id)
-- ChiTietSP - SanPham
ALTER TABLE product_details ADD FOREIGN KEY(id_product) REFERENCES product(id)
-- ChiTietSP - NSX
ALTER TABLE product_details ADD FOREIGN KEY(id_producer) REFERENCES producer(id)
-- ChiTietSP - MauSac
ALTER TABLE product_details ADD FOREIGN KEY(id_color) REFERENCES color(id)
-- ChiTietSP - DongSP
ALTER TABLE product_details ADD FOREIGN KEY(id_product_line) REFERENCES product_line(id)
--khachHang - hangKhachHang
ALTER TABLE client ADD FOREIGN KEY(id_rank_client) REFERENCES rank_client(id)

select *
from
staff
select *
from
shop
