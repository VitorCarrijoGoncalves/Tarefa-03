package senai.mobile.com.br.tarefa_03.atividades.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import senai.mobile.com.br.tarefa_03.atividades.service.AlbumService;

public class RetrofitConfig {

    private final Retrofit retrofit;

    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public AlbumService getAlbumService() {
        return this.retrofit.create(AlbumService.class);
    }

}
