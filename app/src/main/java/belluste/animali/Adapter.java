package belluste.animali;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {

    private ArrayList<Animale> elenco;
    private LayoutInflater inflater;

    private static class ViewHolder {
        private TextView nome;
    }

    Adapter(Context context, ArrayList<Animale> elenco) {
        inflater = LayoutInflater.from(context);
        this.elenco = elenco;
    }

    @Override
    public int getCount() {
        return elenco.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewholder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_animale, null);
            viewholder = new ViewHolder();
            viewholder.nome = convertView.findViewById(R.id.tvNome);
            convertView.setTag(viewholder);
        } else {
            viewholder = (ViewHolder) convertView.getTag();
        }

        viewholder.nome.setText(elenco.get(position).getNome());

        return convertView;
    }
}
