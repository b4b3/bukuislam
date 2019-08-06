package online.b4b3.bukuislam;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_BUKU = "extra_buku";
    public static final String EXTRA_DESC = "DESCRIPTION";
    public static  final String EXTRA_GAMBAR = "ambar";
    public static final String EXTRA_PENGARANG = "extra_pengarang";
    public static final String EXTRA_PENERBIT = "extra_penerbit";
    public static final String EXTRA_HARGA = "extra_harga";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);



            ImageView imgGambar = findViewById(R.id.img_item_gambar);
            String url = getIntent().getStringExtra(EXTRA_GAMBAR);

            Glide.with(DetailActivity.this)
                .load(url)
                .apply(new RequestOptions().override(200,200))
                .into(imgGambar);

            TextView txtDeskripsi = findViewById(R.id.tv_item_deskripsi);
            String deskripsi = getIntent().getStringExtra(EXTRA_DESC);
            txtDeskripsi.setText(getString(R.string.detil_deskrpisi)+deskripsi);

            TextView txtJudul = findViewById(R.id.tv_item_judul);
            String judul = getIntent().getStringExtra(EXTRA_BUKU);
            txtJudul.setText(judul);

            TextView txtPengarang = findViewById(R.id.pengarang);
            String pengarang = getIntent().getStringExtra(EXTRA_PENGARANG);
            txtPengarang.setText(getString(R.string.detil_pengarang)+pengarang);

            TextView txtPenerbit = findViewById(R.id.tv_penerbit);
            String penerbit = getIntent().getStringExtra(EXTRA_PENERBIT);
            txtPenerbit.setText(getString(R.string.detail_penerbit)+penerbit);

            TextView txtHarga = findViewById(R.id.harga);
            String harga = getIntent().getStringExtra(EXTRA_HARGA);
            txtHarga.setText(getString(R.string.detil_harga)+harga);

    }
}
