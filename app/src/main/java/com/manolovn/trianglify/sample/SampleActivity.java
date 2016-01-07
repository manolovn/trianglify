package com.manolovn.trianglify.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;

import com.manolovn.colorbrewer.ColorBrewer;
import com.manolovn.trianglify.TrianglifyView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SampleActivity extends AppCompatActivity {

    @Bind(R.id.trianglify)
    TrianglifyView trianglifyView;
    @Bind(R.id.cellSizeControl)
    SeekBar cellSizeControl;
    @Bind(R.id.varianceControl)
    SeekBar varianceControl;
    @Bind(R.id.colorControl)
    Spinner colorControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initCellSizeControl();
        initVarianceControl();
        initColorControl();
    }

    private void initCellSizeControl() {
        cellSizeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress > 0) {
                    trianglifyView.setCellSize(progress * 10);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void initVarianceControl() {
        varianceControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                trianglifyView.setVariance(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void initColorControl() {
        final List<String> list = new ArrayList<>(ColorBrewer.values().length);
        final ColorBrewer[] colors = ColorBrewer.values();
        for (ColorBrewer color : colors) {
            list.add(color.name());
        }

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        colorControl.setAdapter(adapter);

        colorControl.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                trianglifyView.setColor(colors[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
