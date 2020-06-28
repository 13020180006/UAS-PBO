/*
    Nama	: Paramadina Mulya Majid
    Stambuk	: 13020180006
    Hari/Tgl	: Jumat, 26 Juni 2020
    Waktu	: 21.30 WITA
*/
create database laundry;
use laundry;

create table pesan(no_pesanan int primary key,
nama_pemesan varchar(30),
jenis_cuci enum("Cuci Basah", "Cuci Kering","Cuci Setrika"),
harga_per_kilo int,
berat int,
total_harga int,
bayar int);

desc pesan;
drop table pesan;
select * from pesan;
delete from pesan where no_pesanan="2020";