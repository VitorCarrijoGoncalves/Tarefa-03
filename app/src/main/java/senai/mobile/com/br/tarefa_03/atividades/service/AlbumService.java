package senai.mobile.com.br.tarefa_03.atividades.service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import senai.mobile.com.br.tarefa_03.atividades.modelo.Album;

public interface AlbumService {

    @GET("albums/{id}")
    Call<Album> getAlbum(@Path("id") String id);

    @GET("albums")
    Call<List<Album>> list();

    @POST
    Call<Album> save();

    @PUT
    Call<Album> update();

    @DELETE
    Call<Album> delete();

}
