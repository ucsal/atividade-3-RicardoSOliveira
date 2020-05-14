package br.com.mariojp.exercise3;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.TwoLineListItem;

public class Tarefa2 extends BaseAdapter {
    private final List<Tarefa> tarefas;
    private final Activity act;

    public Tarefa2(List<Tarefa> tarefas, Activity act) {
        this.tarefas = tarefas;
        this.act = act;
    }

    @Override
    public int getCount() {
        return tarefas.size();
    }

    @Override
    public Object getItem(int position) {
        return tarefas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TwoLineListItem twoLineListItem;
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) act.getSystemService(act.LAYOUT_INFLATER_SERVICE);
            twoLineListItem = (TwoLineListItem) inflater.inflate(android.R.layout.simple_list_item_2, null);
        } else {
            twoLineListItem = (TwoLineListItem) convertView;
        }

        TextView text1 = twoLineListItem.getText1();
        TextView text2 = twoLineListItem.getText2();

        text1.setText(tarefas.get(position).getDescricao());
        text2.setText("Prioridade: "+tarefas.get(position).getPrioridade());

        return twoLineListItem;
    }

}