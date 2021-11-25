-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 19 Bulan Mei 2021 pada 13.08
-- Versi server: 10.4.18-MariaDB
-- Versi PHP: 7.3.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_sbdl`
--

DELIMITER $$
--
-- Prosedur
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `inserttrans` (`notrans` VARCHAR(13), `id_men` INT(11), `jml_men` INT(11), `tgl_trans` DATE)  BEGIN
INSERT INTO `transaksi`
VALUES(notrans, id_men,jml_men,tgl_trans);
END$$

--
-- Fungsi
--
CREATE DEFINER=`root`@`localhost` FUNCTION `gen_no_transaksi` () RETURNS VARCHAR(13) CHARSET latin1 BEGIN

RETURN(
SELECT IF(
(SELECT COUNT(nomer_nota) FROM transaksi WHERE nomer_nota LIKE (CONCAT((SELECT DATE_FORMAT(CURRENT_TIMESTAMP,'%d%m%Y')),'%')))=0,
(SELECT DATE_FORMAT(CURRENT_TIMESTAMP,'%d%m%Y')*10000+1),
(SELECT MAX(nomer_nota)+1 FROM transaksi WHERE nomer_nota LIKE (CONCAT((SELECT DATE_FORMAT(CURRENT_TIMESTAMP,'%d%m%Y')),'%')))
)
);
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `delete_history`
--

CREATE TABLE `delete_history` (
  `nomer_nota` varchar(13) NOT NULL,
  `id_menu` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `tgl_transaksi` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `delete_history`
--

INSERT INTO `delete_history` (`nomer_nota`, `id_menu`, `jumlah`, `tgl_transaksi`) VALUES
('190520210004', 5, 1, '2021-05-19');

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `tabel_history`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `tabel_history` (
`nomer_nota` varchar(13)
,`id_menu` int(11)
,`tgl_transaksi` date
,`nama_menu` varchar(80)
,`jumlah` int(11)
,`harga` int(50)
,`total` bigint(60)
);

-- --------------------------------------------------------

--
-- Stand-in struktur untuk tampilan `tabel_laporan`
-- (Lihat di bawah untuk tampilan aktual)
--
CREATE TABLE `tabel_laporan` (
`nomer_nota` varchar(13)
,`id_menu` int(11)
,`tgl_transaksi` date
,`nama_menu` varchar(80)
,`jumlah` int(11)
,`harga` int(50)
,`total` bigint(60)
);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tbl_produk`
--

CREATE TABLE `tbl_produk` (
  `id` int(11) NOT NULL,
  `nama_menu` varchar(80) NOT NULL,
  `jenis_menu` varchar(15) NOT NULL,
  `gambar_menu` varchar(10) NOT NULL,
  `harga` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tbl_produk`
--

INSERT INTO `tbl_produk` (`id`, `nama_menu`, `jenis_menu`, `gambar_menu`, `harga`) VALUES
(1, 'cookies filled with strawberry and apricot jam', 'Cookies', '1.jpg', 29000),
(2, 'Orange Juice', 'Juice', '2.jpg', 11000),
(3, 'Confetti Ice Cream', 'Ice Cream', '3.jpg', 20000),
(4, 'Onion Ring', 'Snack', '4.jpg', 15000),
(5, 'American Waffle', 'Waffel', '5.jpg', 25000),
(6, 'Hongkong Waffle', 'Waffel', '6.jpg', 40000),
(7, 'Scandinavian Waffle', 'Waffel', '7.jpg', 30000),
(8, 'Stroopwafels', 'Waffel', '8.jpg', 28000),
(9, 'Nachos', 'Snack', '9.jpg', 18000),
(10, 'Chicken Fingers', 'Snack', '10.jpg', 19000),
(11, 'Carrot and Apple Juice', 'Juice', '11.jpg', 15000),
(12, 'Strawberry Cheesecake Smoothie', 'Ice Cream', '12.jpg', 22000),
(13, 'Mint Choco Vanilla Milkshake', 'Ice Cream', '13.jpg', 22000),
(14, 'Butterbing Cookie', 'Cookies', '14.jpeg', 23000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi`
--

CREATE TABLE `transaksi` (
  `nomer_nota` varchar(13) NOT NULL,
  `id_menu` int(11) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `tgl_transaksi` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `transaksi`
--

INSERT INTO `transaksi` (`nomer_nota`, `id_menu`, `jumlah`, `tgl_transaksi`) VALUES
('180520210002', 1, 5, '2021-05-18'),
('190520210001', 10, 7, '2021-05-19'),
('190520210002', 1, 1, '2021-05-18'),
('190520210002', 2, 1, '2021-05-19'),
('190520210003', 5, 2, '2021-05-19'),
('190520210004', 1, 2, '2021-05-19');

--
-- Trigger `transaksi`
--
DELIMITER $$
CREATE TRIGGER `deletehistory` BEFORE DELETE ON `transaksi` FOR EACH ROW BEGIN
insert into delete_history
set `nomer_nota` = old.nomer_nota,
`id_menu` = old.id_menu,
`jumlah` = old.jumlah,
`tgl_transaksi` = old.tgl_transaksi;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Struktur untuk view `tabel_history`
--
DROP TABLE IF EXISTS `tabel_history`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `tabel_history`  AS   (select `delete_history`.`nomer_nota` AS `nomer_nota`,`delete_history`.`id_menu` AS `id_menu`,`delete_history`.`tgl_transaksi` AS `tgl_transaksi`,`tbl_produk`.`nama_menu` AS `nama_menu`,`delete_history`.`jumlah` AS `jumlah`,`tbl_produk`.`harga` AS `harga`,`delete_history`.`jumlah` * `tbl_produk`.`harga` AS `total` from (`delete_history` join `tbl_produk`) where `delete_history`.`id_menu` = `tbl_produk`.`id`)  ;

-- --------------------------------------------------------

--
-- Struktur untuk view `tabel_laporan`
--
DROP TABLE IF EXISTS `tabel_laporan`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `tabel_laporan`  AS   (select `transaksi`.`nomer_nota` AS `nomer_nota`,`transaksi`.`id_menu` AS `id_menu`,`transaksi`.`tgl_transaksi` AS `tgl_transaksi`,`tbl_produk`.`nama_menu` AS `nama_menu`,`transaksi`.`jumlah` AS `jumlah`,`tbl_produk`.`harga` AS `harga`,`transaksi`.`jumlah` * `tbl_produk`.`harga` AS `total` from (`transaksi` join `tbl_produk`) where `transaksi`.`id_menu` = `tbl_produk`.`id`)  ;

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `delete_history`
--
ALTER TABLE `delete_history`
  ADD PRIMARY KEY (`nomer_nota`,`id_menu`),
  ADD KEY `barang_ibfk_1` (`id_menu`);

--
-- Indeks untuk tabel `tbl_produk`
--
ALTER TABLE `tbl_produk`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`nomer_nota`,`id_menu`),
  ADD KEY `barang_ibfk_1` (`id_menu`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `barang_ibfk_1` FOREIGN KEY (`id_menu`) REFERENCES `tbl_produk` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
