/*
    Nama	: Paramadina Mulya Majid
    Stambuk	: 13020180006
    Hari/Tgl	: Jumat, 26 Juni 2020
    Waktu	: 21.57 WITA
*/
package Source;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ImplementLaundry implements InterfaceLaundry{
     @Override
    public Laundry insert(Laundry o) throws SQLException {
        PreparedStatement st = KoneksiDatabase.getConnection().prepareStatement("insert into pesan values(?,?,?,?,?,?,?)");
        st.setString(1, o.getNoPesanan());
        st.setString(2, o.getNamaPemesan());
        st.setString(3, o.getJenisCuci());
        st.setString(4, o.getHargaPerKilo());
        st.setString(5, o.getBerat());
        st.setString(6, o.getTotalHarga());
        st.setString(7, o.getBayar());
        st.executeUpdate();
        return o;
    }
    @Override
    public void update(Laundry o, String NoPesanAwal) throws SQLException {
        PreparedStatement st = KoneksiDatabase.getConnection().prepareStatement("update pesan set nama_pemesan='"+o.getNamaPemesan()+"',jenis_cuci='"+o.getJenisCuci()+
                "', no_pesanan='"+o.getNoPesanan()+"',harga_per_kilo='"+o.getHargaPerKilo()+"', berat='"+o.getBerat()+"', total_harga='"+o.getTotalHarga() +"', bayar='"+o.getBayar() +"' where no_pesanan='"+NoPesanAwal+"'");
        st.executeUpdate();
    }
    @Override
    public void delete(String NoPesanan) throws SQLException {
        PreparedStatement st = KoneksiDatabase.getConnection().prepareStatement("delete from pesan where no_pesanan=?");
        st.setString(1, NoPesanan);
        st.executeUpdate();
    }
    @Override
    public List getAll() throws SQLException {
        Statement st = KoneksiDatabase.getConnection().createStatement();
        ResultSet rs = st.executeQuery("select * from pesan");
        List list = new ArrayList();
        while (rs.next()) {
            Laundry p = new Laundry();
            p.setNoPesanan(rs.getString("No_Pesanan"));
            p.setNamaPemesan(rs.getString("Nama_Pemesan"));
            p.setJenisCuci(rs.getString("Jenis_Cuci"));
            p.setHargaPerKilo(rs.getString("Harga_Per_Kilo"));
            p.setBerat(rs.getString("Berat"));
            p.setTotalHarga(rs.getString("Total_Harga"));
            p.setBayar(rs.getString("Bayar"));
            list.add(p);
        }
        return list;
    }
    
}
