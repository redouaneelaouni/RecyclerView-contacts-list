package redouane.elaouni.iibdcc.listscontactsiibdcc;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<ItemModel> dataList=new ArrayList<>();
    LinearLayoutManager linearLayoutManager;
    MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Contacts List");

        try {
            JSONObject object=new JSONObject(readJson());
            JSONArray array=object.getJSONArray("contacts");

            for(int i=0;i<array.length();i++){
                JSONObject jsonObject = array.getJSONObject(i);
                String id=jsonObject.getString("id");
                String first_name=jsonObject.getString("first_name");
                String last_name=jsonObject.getString("last_name");
                String job=jsonObject.getString("job");
                String email=jsonObject.getString("email");
                String phone=jsonObject.getString("phone");
                Log.d("array", id);

                ItemModel item=new ItemModel();
                item.setId(id);
                item.setName(first_name+" "+last_name);
                item.setJob(job);
                item.setEmail(email);
                item.setPhone(phone);
                dataList.add(item);
            }



        } catch (JSONException e) {
            e.printStackTrace();
        }


        recyclerView=findViewById(R.id.recycler_view);

        //Initialize linear layout manager
        linearLayoutManager=new LinearLayoutManager(this);

        // Set layout manager
        recyclerView.setLayoutManager(linearLayoutManager);

        // Initialize adapter
        adapter=new MainAdapter(MainActivity.this,dataList);

        // set adapter

        recyclerView.setAdapter(adapter);

    }

    /*recuperer les donnes du fichier data.json
    et les convertir en chaine de caractere*/
    public  String readJson()  {
        String json=null;
        try {
            InputStream inputStream=getAssets().open("data.json");
            int size=inputStream.available();
            byte[] buffer=new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json=new String(buffer,"UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
            return json;
        }
        return json;
    }
}