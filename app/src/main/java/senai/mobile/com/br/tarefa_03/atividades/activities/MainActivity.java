package senai.mobile.com.br.tarefa_03.atividades.activities;

import android.app.DownloadManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import senai.mobile.com.br.tarefa_03.R;
import senai.mobile.com.br.tarefa_03.atividades.adapter.AdapterListaAlbum;
import senai.mobile.com.br.tarefa_03.atividades.modelo.Album;
import senai.mobile.com.br.tarefa_03.atividades.retrofit.RetrofitConfig;

public class MainActivity extends DebugActivity {

    EditText txtIdAlbum;
    ListView simpleListView;
    private AdapterListaAlbum adapterListaAlbum;
    List<HashMap<String,String>> listAlbums = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listarAlbums(simpleListView);
    }

    public void exibir(Album album) {

        simpleListView=(ListView)findViewById(R.id.simpleListView);

        this.adapterListaAlbum = new AdapterListaAlbum(MainActivity.this, this.listAlbums);

        this.simpleListView.setAdapter(this.adapterListaAlbum);

    }

    public void listarAlbums(final View view) {

        Call<List<Album>> call = new RetrofitConfig().getAlbumService().list();
        call.enqueue(new Callback<List<Album>>() {

            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                List<Album> albums = response.body();
                for (Album album : albums) {
                    exibir(album);
                }

            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {
                Log.e("AlbumService   ", "Erro ao buscar o album:" + t.getMessage());
            }

        });
    }

    public void getAlbumById(View view) {

        Call<Album> call = new RetrofitConfig().getAlbumService().getAlbum(txtIdAlbum.getText().toString());
        call.enqueue(new Callback<Album>() {
            @Override
            public void onResponse(Call<Album> call, Response<Album> response) {
                Album album = response.body();
                exibir(album);
            }

            @Override
            public void onFailure(Call<Album> call, Throwable t) {
                Log.e("AlbumService   ", "Erro ao buscar o album:" + t.getMessage());
            }
        });

    }

}
