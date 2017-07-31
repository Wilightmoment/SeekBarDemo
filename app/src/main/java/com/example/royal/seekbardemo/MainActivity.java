package com.example.royal.seekbardemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private TextView tvText;
    private SeekBar sbSize;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }
    private void findViews(){
        tvText=(TextView)findViewById(R.id.tv_Text);
        sbSize=(SeekBar)findViewById(R.id.sbSize);

        sbSize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            //當使用者手指在SeekBar元件上滑動時，會自動呼叫onProgressChanged()，並利用選取的值(progress)改變textview大小
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvText.setTextSize(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this,"start size= "+seekBar.getProgress(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this,"stop size= "+seekBar.getProgress(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
