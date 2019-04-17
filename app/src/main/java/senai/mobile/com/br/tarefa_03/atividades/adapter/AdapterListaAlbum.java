package senai.mobile.com.br.tarefa_03.atividades.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import senai.mobile.com.br.tarefa_03.R;
import senai.mobile.com.br.tarefa_03.atividades.modelo.Album;

public class AdapterListaAlbum extends BaseAdapter {

    private Context context;
    //private List<Album> albums;
    private List<HashMap<String,String>> albums;

    public AdapterListaAlbum(Context context, List<HashMap<String,String>> albums) {
        this.context = context;
        this.albums = albums;
    }

    @Override
    public int getCount() {
        return this.albums.size();
    }

    @Override
    public Object getItem(int position) {
        return this.albums.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void removerProduto(int position) {
        this.albums.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.activity_list_view, parent, false);
        }

        // get current item to be displayed
        Album currentAlbum = (Album) getItem(position);

        // get the TextView for item name and item description
        TextView listViewIdAlbum = (TextView)
                convertView.findViewById(R.id.list_view_id_album);
        TextView listViewUserIdAlbum = (TextView)
                convertView.findViewById(R.id.list_view_user_id_album);
        TextView listViewTitleAlbum = (TextView)
                convertView.findViewById(R.id.list_view_title_album);

        //sets the text for item name and item description from the current item object
        listViewIdAlbum.setText(currentAlbum.getId());
        listViewUserIdAlbum.setText(currentAlbum.getUserId());
        listViewTitleAlbum.setText(currentAlbum.getTitle());

        // returns the view for the current row
        return convertView;

    }
}
