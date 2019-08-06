package online.b4b3.bukuislam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvBuku;
    private ArrayList<Buku> list = new ArrayList<>();
    private ListBukuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvBuku = findViewById(R.id.rv_buku);
        rvBuku.setHasFixedSize(true);

        list.addAll(DataBuku.getListData());
        showRecyclerList();

        //rvBuku.setOnClickListener(listener);
    }

    private void showRecyclerList() {
        rvBuku.setLayoutManager(new LinearLayoutManager(this));
        ListBukuAdapter listBukuAdapter = new ListBukuAdapter(list);
        rvBuku.setAdapter(listBukuAdapter);

        listBukuAdapter.setOnItemClickCallback(new ListBukuAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Buku data) {
                showSelectedBuku(data);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }
    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.about:
                showAbout();
                break;

        }
    }

    private void showAbout(){
        Intent aboutIntent = new Intent(MainActivity.this, AboutActivity.class);
        startActivity(aboutIntent);
    }

    private void showSelectedBuku(Buku buku) {
        Intent moveWithDataIntent = new Intent(MainActivity.this, DetailActivity.class);
        moveWithDataIntent.putExtra(DetailActivity.EXTRA_BUKU, buku.getJudul());
        moveWithDataIntent.putExtra(DetailActivity.EXTRA_GAMBAR, buku.getGambar());
        moveWithDataIntent.putExtra(DetailActivity.EXTRA_DESC, buku.getDeskripsi());
        moveWithDataIntent.putExtra(DetailActivity.EXTRA_PENGARANG, buku.getPengarang());
        moveWithDataIntent.putExtra(DetailActivity.EXTRA_PENERBIT, buku.getPenerbit());
        moveWithDataIntent.putExtra(DetailActivity.EXTRA_HARGA, buku.getHarga());
        startActivity(moveWithDataIntent);

        //Toast.makeText(this, "Kamu memilih " + buku.getJudul(), Toast.LENGTH_SHORT).show();
    }


}
