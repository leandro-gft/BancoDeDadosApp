package br.com.gft.bandodedados;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            //Criar banco de dados
            SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);

            //Deletar tabela
//            bancoDados.execSQL("DROP TABLE pessoas");

            //Criar tabela
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas (id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, idade INT(3))");


            //Deletando registros
//            bancoDados.execSQL("DELETE FROM pessoas WHERE id=1");

            //Inserir dados
//            bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('João', 85)");
//            bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Claudia', 55)");
//            bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Jamilton', 30)");
//            bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Leandro', 31)");
//            bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Mariana', 19)");
//            bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Pedro', 50)");


            //Recuperar dados
//            String consulta = "SELECT nome, idade FROM pessoas " +
//                            "WHERE idade>30 or idade=30";

//            String consulta =
//                    "SELECT nome, idade FROM pessoas " +
//                            "WHERE nome ='Pedro'";

//            String consulta =
//                    "SELECT nome, idade FROM pessoas " +
//                            "WHERE idade IN(30,50)";

//            String consulta =
//                    "SELECT nome, idade FROM pessoas " +
//                            "WHERE idade BETWEEN 30 AND 50";
//            String filtro = "e";
//            String consulta =
//                    "SELECT nome, idade FROM pessoas " +
//                            "WHERE nome LIKE '%"+filtro+"%'";

//            String consulta =
//                    "SELECT nome, idade FROM pessoas " +
//                            "ORDER BY nome ASC LIMIT 3";


            String consulta =
                    "SELECT * FROM pessoas";

            //Atualizando registros
            bancoDados.execSQL("UPDATE pessoas SET nome='Leandro Sacchi' WHERE id=4");

            Cursor cursor = bancoDados.rawQuery(consulta, null);

            //Indices da tabela
            int indiceId = cursor.getColumnIndex("id");
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");

            cursor.moveToFirst();
            while (cursor != null) {
                String nome = cursor.getString(indiceNome);
                String idade = cursor.getString(indiceIdade);
                String id = cursor.getString(indiceId);
                Log.i("RESULTADO - id ", id + " - nome: "+ nome + " - idade: "+ idade);
                cursor.moveToNext();
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
