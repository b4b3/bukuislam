package online.b4b3.bukuislam;

import java.util.ArrayList;

public class DataBuku {
    static String[][] data = new String[][]{
            {"Ahmad Dahlan", "Pengarang.", "Penerbit", "50000", "Deskripsi","@drawable/gambar_1.jpg"},
            {"Ahmad Dahlan", "Pengarang.", "Penerbit", "50000", "Deskripsi","@drawable/poster_a_star"}
           };
    public static ArrayList<Buku> getListData(){
        ArrayList<Buku> list = new ArrayList<>();
        for (String[] aData : data) {
            Buku buku = new Buku();
            buku.setJudul(aData[0]);
            buku.setPengarang(aData[1]);
            buku.setPenerbit(aData[2]);
            buku.setHarga(aData[3]);
            buku.setDeskripsi(aData[4]);
            buku.setGambar(aData[5]);
            list.add(buku);
        }
        return list;
    }
}
