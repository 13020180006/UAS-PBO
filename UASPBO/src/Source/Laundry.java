/*
    Nama	: Paramadina Mulya Majid
    Stambuk	: 13020180006
    Hari/Tgl	: Jumat, 26 Juni 2020
    Waktu	: 21.58 WITA
*/
package Source;

import java.util.Objects;

public class Laundry {
    String no_pesanan; 
    String nama_pemesan; 
    String jenis_cuci;
    String harga_per_kilo;
    String berat;
    String total_harga;
    String bayar;
    
    public Laundry() { }
        public Laundry(String no_pesanan, String nama_pemesan, String jenis_cuci, String harga_per_kilo, String berat, String total_harga, String bayar) {
        this.no_pesanan = no_pesanan;
        this.nama_pemesan = nama_pemesan; 
        this.jenis_cuci = jenis_cuci;
        this.harga_per_kilo = harga_per_kilo;
        this.berat = berat;
        this.total_harga = total_harga;
        this.bayar = bayar;
        }
    public String getNoPesanan() { 
        return no_pesanan; 
    }
    public void setNoPesanan(String no_pesanan) { 
        this.no_pesanan = no_pesanan; 
    }
    
    public String getNamaPemesan() { 
        return nama_pemesan; 
    }
    public void setNamaPemesan(String nama_pemesan) { 
        this.nama_pemesan = nama_pemesan; 
    }
    
    public String getJenisCuci() { 
        return jenis_cuci; 
    } 
    public void setJenisCuci(String jenis_cuci) { 
        this.jenis_cuci = jenis_cuci; 
    }
    
     public String getHargaPerKilo() { 
        return harga_per_kilo; 
    } 
    public void setHargaPerKilo(String harga_per_kilo) { 
        this.harga_per_kilo = harga_per_kilo; 
    }
    
     public String getBerat() { 
        return berat; 
    } 
    public void setBerat(String berat) { 
        this.berat = berat; 
    }
    
     public String getTotalHarga() { 
        return total_harga; 
    } 
    public void setTotalHarga(String total_harga) { 
        this.total_harga = total_harga; 
    }
    
     public String getBayar() { 
        return bayar; 
    } 
    public void setBayar(String bayar) { 
        this.bayar = bayar; 
    }
    
    @Override 
    public String toString() { 
        return "Laundry{" + "no_pesanan=" + no_pesanan + ", nama_pemesan=" + nama_pemesan + ", jenis_cuci=" + jenis_cuci + ", "
                + "harga_per_kilo=" + harga_per_kilo + ", berat=" + berat + ", total_harga=" + total_harga +  ", bayar=" + bayar +'}'; 
    } 
    @Override 
    public int hashCode() { 
        int hash = 3; 
        hash = 89 * hash + Objects.hashCode(this.no_pesanan); 
        hash = 89 * hash + Objects.hashCode(this.nama_pemesan);
        hash = 89 * hash + Objects.hashCode(this.jenis_cuci);
        hash = 89 * hash + Objects.hashCode(this.harga_per_kilo);
        hash = 89 * hash + Objects.hashCode(this.berat);
        hash = 89 * hash + Objects.hashCode(this.total_harga);
        hash = 89 * hash + Objects.hashCode(this.bayar);
        return hash; 
    } 
    @Override 
    public boolean equals(Object obj) { 
        if (this == obj) { 
            return true; 
        } 
        if (obj == null) { 
            return false; 
        } 
        if (getClass() != obj.getClass()) { 
            return false; 
        } 
        final Laundry other = (Laundry) obj; 
        if(!Objects.equals(this.no_pesanan, other.no_pesanan)) { 
            return false; 
        } if (!Objects.equals(this.nama_pemesan, other.nama_pemesan)) { 
            return false; 
        } if (!Objects.equals(this.jenis_cuci, other.jenis_cuci)) { 
            return false; 
        } if (!Objects.equals(this.harga_per_kilo, other.harga_per_kilo)) { 
            return false; 
        } if (!Objects.equals(this.berat, other.berat)) { 
            return false; 
        } if (!Objects.equals(this.total_harga, other.total_harga)) { 
            return false; 
        } if (!Objects.equals(this.bayar, other.bayar)) { 
            return false; 
        } 
        return true; 
    }
}
