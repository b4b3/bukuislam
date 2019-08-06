package online.b4b3.bukuislam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        ImageView imgGambar = findViewById(R.id.imageView);
        String url = "https://www.dicoding.com/images/small/avatar/2019080514273879b78b22a49e78bc4ae0059fb776415c.jpg";

        Glide.with(AboutActivity.this)
                .load(url)
                .apply(new RequestOptions().override(200,200))
                .into(imgGambar);
    }
}

//