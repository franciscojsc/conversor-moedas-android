package br.com.franciscochaves.conversormoedas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.editValue = (EditText)findViewById(R.id.edit_value);
        this.mViewHolder.textDollar = (TextView) findViewById(R.id.text_dollar);
        this.mViewHolder.textEuro = (TextView)findViewById(R.id.text_euro);
        this.mViewHolder.buttonCalculate = (Button) findViewById(R.id.button_calculate);

        this.mViewHolder.buttonCalculate.setOnClickListener(this);

        this.clearValues();

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id == R.id.button_calculate){
            //Lógica do botão
            try{
                Double value = Double.valueOf(this.mViewHolder.editValue.getText().toString());
                this.mViewHolder.textDollar.setText(String.format("%.2f", value * 3));
                this.mViewHolder.textEuro.setText(String.format("%.2f", value * 4));
            }catch (Exception ex){
                Toast.makeText(getApplicationContext(),"Utilize ponto no lugar da vírgula",
                        Toast.LENGTH_SHORT).show();
                this.clearValues();
            }

        }
    }

    private void clearValues() {
        this.mViewHolder.textEuro.setText("");
        this.mViewHolder.textDollar.setText("");
    }

    private static class ViewHolder {
        EditText editValue;
        TextView textDollar;
        TextView textEuro;
        Button buttonCalculate;
    }
}
