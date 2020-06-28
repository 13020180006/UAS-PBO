/*
    Nama	: Paramadina Mulya Majid
    Stambuk	: 13020180006
    Hari/Tgl	: Jumat, 26 Juni 2020
    Waktu	: 21.58 WITA
*/
package Source;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceLaundry {
    Laundry insert(Laundry o) throws SQLException;
    void update(Laundry o, String noPesanAwal) throws SQLException;
    void delete(String NoPesanan) throws SQLException;
    List getAll() throws SQLException;
}
