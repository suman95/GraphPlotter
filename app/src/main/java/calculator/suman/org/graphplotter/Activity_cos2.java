package calculator.suman.org.graphplotter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;


public class Activity_cos2 extends Activity {

    float valM, valC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cos2);

        valM = getIntent().getFloatExtra("valM",0.0f);
        valC = getIntent().getFloatExtra("valC",0.0f);

        float[] x = new float[18001];
        float[] y = new float[18001];
        double t=-90.0;
        for(int i=0;i<18001;i++){
            x[i]= (float)t;
            y[i]= (valM*x[i]+valC);
            t=t+0.01;
        }

        plot2d graph = new plot2d(this,x,y,1);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        addContentView(graph, lp);
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
