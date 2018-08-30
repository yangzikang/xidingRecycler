package e.yzk.play;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);


        final List<Model> modelList=new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            modelList.add(new Model("1","Content:1_"+i,R.mipmap.ic_launcher_round));
        }
        for (int i = 0; i < 16; i++) {
            modelList.add(new Model("2","Content:2_"+i,R.mipmap.ic_launcher_round));
        }
        for (int i = 0; i < 14; i++) {
            modelList.add(new Model("3","Content:3_"+i,R.mipmap.ic_launcher_round));
        }
        for (int i = 0; i < 14; i++) {
            modelList.add(new Model("4","Content:4_"+i,R.mipmap.ic_launcher_round));
        }
        for (int i = 0; i < 14; i++) {
            modelList.add(new Model("5","Content:5_"+i,R.mipmap.ic_launcher_round));
        }
        for (int i = 0; i < 14; i++) {
            modelList.add(new Model("6","Content:6_"+i,R.mipmap.ic_launcher_round));
        }


        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        Adapter adapter = new Adapter(this,modelList);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new StickyItemDecoration(this, modelList));

        mRecyclerView.setAdapter(adapter);

    }
}
