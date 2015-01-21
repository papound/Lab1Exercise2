package th.ac.tu.siit.cholwich.lab1exercise2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    public void convert(View v){
        TextView tvOutput = (TextView)findViewById(R.id.tvOutput);
        EditText etInput = (EditText)findViewById(R.id.etInput);
        String s = etInput.getText().toString();
        Double val1 = Double.parseDouble(s);
        RadioGroup rgFrom = (RadioGroup)findViewById(R.id.rgFrom);
        RadioGroup rgTo = (RadioGroup)findViewById(R.id.rgTo);
        int selFrom = rgFrom.getCheckedRadioButtonId();
        int selTo = rgTo.getCheckedRadioButtonId();
        if (selFrom == R.id.rbFrmC) { //The user wants to convert from Celsius.
            if(selTo == R.id.rbToC){
                String val = String.format("%.2f",val1);
                 tvOutput.setText(val);

            }else if(selTo == R.id.rbToF){
                val1 = (val1 * (9/5)) + 32;
                String val = String.format("%.2f",val1);
                tvOutput.setText(val);

            }
            else if(selTo == R.id.rbToK){
                val1 = val1 + 273.15;
                String val = String.format("%.2f",val1);
                tvOutput.setText(val);

            }
        }else if (selFrom == R.id.rbFrmF) { //The user wants to convert from Celsius.
            if(selTo == R.id.rbToC){
                val1 = (val1 - 32) * 5/9;
                String val = String.format("%.2f",val1);
                tvOutput.setText(val);

            }else if(selTo == R.id.rbToF){

                String val = String.format("%.2f",val1);
                tvOutput.setText(val);

            }
            else if(selTo == R.id.rbToK){
                val1 = (((val1 - 32) * 5)/9) + 273.15;
                String val = String.format("%.2f",val1);
                tvOutput.setText(val);

            }
        }else if (selFrom == R.id.rbFrmK) { //The user wants to convert from Celsius.
            if(selTo == R.id.rbToC){
                val1 = val1 - 273.15;
                String val = String.format("%.2f",val1);
                tvOutput.setText(val);

            }else if(selTo == R.id.rbToF){
                val1 = (((val1 - 273.15) * 9)/5) + 32;
                String val = String.format("%.2f",val1);
                tvOutput.setText(val);

            }
            else if(selTo == R.id.rbToK){

                String val = String.format("%.2f",val1);
                tvOutput.setText(val);

            }
        }
    }
}
