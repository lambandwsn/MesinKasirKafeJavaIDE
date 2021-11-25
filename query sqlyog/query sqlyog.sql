/*buat fungsi*/
DELIMITER $$
CREATE FUNCTION gen_no_transaksi() RETURNS VARCHAR(13) DETERMINISTIC
BEGIN
RETURN(
SELECT IF(
(SELECT COUNT(nomer_nota) FROM transaksi WHERE nomer_nota LIKE (CONCAT((SELECT DATE_FORMAT(CURRENT_TIMESTAMP,'%d%m%Y')),'%')))=0,
(SELECT DATE_FORMAT(CURRENT_TIMESTAMP,'%d%m%Y')*10000+1),
(SELECT MAX(nomer_nota)+1 FROM transaksi WHERE nomer_nota LIKE (CONCAT((SELECT DATE_FORMAT(CURRENT_TIMESTAMP,'%d%m%Y')),'%')))
)
);
END $$
DELIMITER ;

/*jalankan fungsi*/
SELECT gen_no_transaksi() AS nomor;

/*buat prosedur simpan*/
DELIMITER $$
CREATE PROCEDURE inserttrans
(notrans VARCHAR(13),id_men INT(11), jml_men INT(11),tgl_trans DATE)
BEGIN
INSERT INTO `transaksi`
VALUES(notrans, id_men,jml_men,tgl_trans);
END$$
DELIMITER ;

/*jalankan prosedur simpan*/
CALL inserttrans(180520210002,10,5,NOW());

/*buat view tabel laporan*/
CREATE OR REPLACE VIEW tabel_laporan AS 
(SELECT nomer_nota, id_menu, tgl_transaksi, nama_menu, jumlah, harga, (jumlah*harga) AS total FROM transaksi INNER JOIN tbl_produk WHERE transaksi.id_menu=tbl_produk.id);
SELECT * FROM tabel_laporan;
/*buat view tabel history hapus*/
CREATE OR REPLACE VIEW tabel_history AS 
(SELECT nomer_nota, id_menu, tgl_transaksi, nama_menu, jumlah, harga, (jumlah*harga) AS total FROM `delete_history` INNER JOIN tbl_produk WHERE delete_history.id_menu=tbl_produk.id);
SELECT * FROM tabel_history;

/*buat trigger history hapus, untuk memindahkan data yang
dihapus dari tabel_laporan ke tabel_history*/

DELIMITER $$
CREATE TRIGGER deletehistory
	BEFORE DELETE ON transaksi
	FOR EACH ROW
BEGIN
INSERT INTO delete_history
SET `nomer_nota` = old.nomer_nota,
`id_menu` = old.id_menu,
`jumlah` = old.jumlah,
`tgl_transaksi` = old.tgl_transaksi;
END$$
DELIMITER ;