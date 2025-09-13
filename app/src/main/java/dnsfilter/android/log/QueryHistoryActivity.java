package dnsfilter.android.log;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import dnsfilter.log.QueryLogger;

public class QueryHistoryActivity extends Activity {
    private final QueryLogger logger = new QueryLogger();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView listView = new ListView(this);
        setContentView(listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
            this,
            android.R.layout.simple_list_item_1,
            logger.getHistory()
        );
        listView.setAdapter(adapter);
    }
}
