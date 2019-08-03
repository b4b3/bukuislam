package online.b4b3.bukuislam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvBuku;
    private ArrayList<Buku> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvBuku = findViewById(R.id.rv_buku);
        rvBuku.setHasFixedSize(true);

        list.addAll(DataBuku.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvBuku.setLayoutManager(new LinearLayoutManager(this));
        ListBukuAdapter listBukuAdapter = new ListBukuAdapter(list);
        rvBuku.setAdapter(listBukuAdapter);
    }
}
