package com.yangyang.zhihu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by yy on 16/7/1.
 *
 */
public class SearchViewTest extends AppCompatActivity {
    private SearchView s1;
    private ListView l1;
    private final String[] mStrings={"aaaa","bbbb","ccccc"};
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchview);
        toolbar= (Toolbar) findViewById(R.id.toolbar2);
        s1= (SearchView) findViewById(R.id.sv1);
        l1= (ListView) findViewById(R.id.ls1);
        l1.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mStrings));
        s1.setQueryHint("搜索话题,问题或人");
        s1.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
                //搜索过程
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(TextUtils.isEmpty(newText)){
                    l1.clearTextFilter();
                }else{
                    l1.setFilterText(newText);
                }
                return false;
            }
        });
    }
}
