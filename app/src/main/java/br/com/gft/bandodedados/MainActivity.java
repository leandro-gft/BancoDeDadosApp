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

            //Criar tabela
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas (nome VARCHAR, idade INT(3))");

//            //Deletando registros
//            bancoDados.execSQL("DELETE FROM pessoas WHERE nome='Leandro Sacchi'");
//            bancoDados.execSQL("DELETE FROM pessoas WHERE nome='Jamilton Damaesceno'");

            //Inserir dados
//            bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('João', 85)");
//            bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Claudia', 55)");

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

            String consulta =
                    "SELECT nome, idade FROM pessoas " +
                            "ORDER BY nome ASC LIMIT 3";

            Cursor cursor = bancoDados.rawQuery(consulta, null);

            //Indices da tabela
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");

            cursor.moveToFirst();
            while (cursor != null) {
                String nome = cursor.getString(indiceNome);
                String idade = cursor.getString(indiceIdade);
                Log.i("RESULTADO - nome ", nome + " - idade: "+ idade);
                cursor.moveToNext();
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
