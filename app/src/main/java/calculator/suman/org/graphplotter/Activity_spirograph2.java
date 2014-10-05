package calculator.suman.org.graphplotter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;


public class Activity_spirograph2 extends Activity {

    float valR1, valR2, valA2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spiro2);

        valR1 = getIntent().getFloatExtra("valR1",0.0f);
        valR2 = getIntent().getFloatExtra("valR2",0.0f);
        valA2 = getIntent().getFloatExtra("valA2",0.0f);

        float[] x = new float[18001];
        float[] y = new float[18001];
        double t=0.0;
        for(int i=0;i<18001;i++){
            x[i]= (float)((valR1-valR2)*Math.cos(t)+valA2*Math.cos(((valR1-valR2)/valR1)*t));
            y[i]= (float)((valR1-valR2)*Math.sin(t)-valA2*Math.sin(((valR1-valR2)/valR1)*t));
            t=t+0.1;
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
