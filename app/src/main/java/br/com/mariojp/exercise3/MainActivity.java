package br.com.mariojp.exercise3;

import androidx.appcompat.app.AppCompatActivity;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Button buttonRemover;
    private Button buttonAdicionar;
    private EditText editTextDescricao;
    private EditText editTextPrioridade;
    private ListView listView;
    private List<Tarefa> tarefas = new ArrayList<Tarefa>();
    private Tarefa2 adapter = new Tarefa2(tarefas, this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdicionar = (Button)findViewById(R.id.buttonAdicionar);
        buttonRemover = (Button)findViewById(R.id.buttonRemover);
        editTextDescricao = (EditText)findViewById(R.id.editDescricao);
        editTextPrioridade = (EditText) findViewById(R.id.editPrioridade);
        listView = (ListView) findViewById(R.id.listView);

        buttonRemover.setEnabled(false);

        // Escutador do clique listView para exclui-lo
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tarefas.remove(position);
                adapter.notifyDataSetChanged();
            }
        });

        // Método  desabilitar o botão remover caso a lista esteja vazia
        adapter.registerDataSetObserver(new DataSetObserver() {
            @Override
            public void onChanged() {
                super.onChanged();
                if(listView.getAdapter().isEmpty()) {
                    buttonRemover.setEnabled(false);
                } else {
                    buttonRemover.setEnabled(true);
                }
            }
        });

    }
    //  botão adicionar
    public void clicouAdicionar(View v) {
        String descricao = editTextDescricao.getText().toString();
        Integer prioridade = Integer.parseInt(editTextPrioridade.getText().toString());

        // Validando dados
        if (prioridade < 1 || prioridade > 10) {
            Toast.makeText(getApplicationContext(), "A prioridade deve estar entre 1 e 10.", Toast.LENGTH_SHORT).show();
        } else {
            Tarefa tarefa = new Tarefa(descricao, prioridade);
            if (tarefas.contains(tarefa)) {
                Toast.makeText(getApplicationContext(), "Tarefa já cadastrada.", Toast.LENGTH_SHORT).show();
                editTextDescricao.setText("");
                editTextPrioridade.setText("");

            } else { // Se a descrição não existe
                tarefas.add(tarefa);
                Collections.sort(tarefas); // ordenando a lista
                editTextDescricao.setText("");
                editTextPrioridade.setText("");
                listView.setAdapter(adapter);
                buttonRemover.setEnabled(true);
            }
        }

    }
    //  botão remover
    public void clicouRemover (View v) {
        if(listView.getCount() == 0){
            Toast.makeText(getApplicationContext(),"Lista vazia.", Toast.LENGTH_SHORT).show();
        } else {
            tarefas.remove(0);
            adapter.notifyDataSetChanged();
        }
    }




    }
