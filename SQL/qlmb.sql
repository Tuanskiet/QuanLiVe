create database quanlimaybay
go 
use quanlimaybay
go 
create table Taikhoan(
MaKh Nvarchar(50) not null,
TenKH Nvarchar(50) not null,
SDT Nvarchar(12) not null,
Gioitinh varchar(5) not null,
Email Nvarchar(50) not null,
TenDangnhap Nvarchar(50) not null,
MatKhau Nvarchar(50) not null,
[role] varchar(10) not null,
nhoMK bit null
primary key (MaKh)
);
insert into taikhoan values
('KH001',N'Kiệt','012345678912','Nam','kietltps26049@fpt.edu.vn','Kiet123','123','NV', 1),
('KH002',N'Huy','126987523925','Nu','huyhnps26148@fpt.edu.vn','Huy123','123','KH', 1),
('KH010',N'Anh','126987523925','Nu','anhdt26061@fpt.edu.vn','anh123','123','KH', 0)
select * from Taikhoan where TenDangnhap ='Kiet123' and MatKhau = '123'

update  taikhoan set nhoMK = 0 where TenDangnhap = 'Huy123'
delete from Taikhoan