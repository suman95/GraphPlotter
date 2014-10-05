package calculator.suman.org.graphplotter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Activity_spirograph extends Activity {

    EditText valR1, valR2, valA2;
    Button btnPlotSpiro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spiro);

        valR1 = (EditText) findViewById(R.id.valR1);
        valR2 = (EditText) findViewById(R.id.valR2);
        valA2 = (EditText) findViewById(R.id.valA2);

        btnPlotSpiro = (Button) findViewById(R.id.btnPlotSpiro);

        btnPlotSpiro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Activity_spirograph2.class);
                intent.putExtra("valR1", Float.parseFloat(valR1.getText().toString()));
                intent.putExtra("valR2", Float.parseFloat(valR2.getText().toString()));
                intent.putExtra("valA2", Float.parseFloat(valA2.getText().toString()));
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.graph_generator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
