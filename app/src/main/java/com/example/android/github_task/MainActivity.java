package com.example.android.github_task;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ApiInterface apiService;
    Call<List<Example>> call;
    Example item;
//    TextView personName;
//    TextView commit;
//    TextView commitMessage;
    CommitsAdapter adapter;
    List<Example> commitDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Method: ", "onCreate");
        listView=(ListView)findViewById(R.id.listView);
        apiService =
                ApiClient.getClient().create(ApiInterface.class);
        call=apiService.getCommits("rails");
        call.enqueue(new Callback<List<Example>>() {
            @Override
            public void onResponse(Call<List<Example>> call, Response<List<Example>> response) {
                Log.i("Method: ", "onResponse");
                Log.i("Response", String.valueOf(response.body().get(0).getCommit().getCommitter().getName()));
                //commitDetails = response.body();
                Log.i("Size", String.valueOf(response.body().size()));

                //commitDetails.add(response.body().get(i));
//                for(int i =0;i<response.body().size();i++){
//                    commitDetails = response.
//                }
                commitDetails = response.body();
//                if (commitDetails == null) {
//                    Log.i("Null", "Null");
//                }
//                Log.i("SizeCommit", String.valueOf(commitDetails.size()));
                adapter = new CommitsAdapter(getApplicationContext(), commitDetails);
                listView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Example>> call, Throwable t) {
                Log.i("Error: ", t.toString());
            }
        });

    }
    public class CommitsAdapter extends ArrayAdapter<Example>{

        public CommitsAdapter(Context context, List<Example> result) {
            super(context, R.layout.list_item, result);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
             item =getItem(position);
            if(convertView == null){
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
            }
            Log.i("AuthorName", item.getCommit().getAuthor().getName());
            TextView personName = (TextView)convertView.findViewById(R.id.nameView);
            TextView commitMessage = (TextView)convertView.findViewById(R.id.messageView);
            TextView commit = (TextView)convertView.findViewById(R.id.commitView);
            personName.setText(item.getCommit().getAuthor().getName());
            commitMessage.setText(item.getCommit().getMessage().toString());
            commit.setText("Commit : "+item.getSha());
            return convertView;
        }
    }
}
