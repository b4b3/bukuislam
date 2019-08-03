package online.b4b3.bukuislam;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListBukuAdapter extends RecyclerView.Adapter<ListBukuAdapter.ListViewHolder> {
    private ArrayList<Buku> listBuku;

    public ListBukuAdapter(ArrayList<Buku> list) {
        this.listBuku = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_buku, viewGroup, false );
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
    Buku buku = listBuku.get(position);


        Glide.with(holder.itemView.getContext())
                .load(buku.getGambar())
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgPhoto);
        holder.tvJudul.setText(buku.getJudul());
       // holder.tvPengarang.setText(buku.getPengarang());
       // holder.tvPenerbit.setText(buku.getPenerbit());
        holder.tvDeskripsi.setText(buku.getPengarang());
       // holder.tvHarga.setText(buku.getHarga());



    }

    @Override
    public int getItemCount() {
        return listBuku.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        TextView tvJudul, tvPengarang, tvPenerbit, tvDeskripsi, tvHarga;
         ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_gambar);
            tvJudul = itemView.findViewById(R.id.tv_item_judul);
            tvDeskripsi = itemView.findViewById(R.id.tv_item_deskripsi);
        }
    }
}
