package com.manolovn.trianglify.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.manolovn.colorbrewer.ColorBrewer;
import com.manolovn.trianglify.TrianglifyView;
import com.manolovn.trianglify.sample.exporter.ImageExporter;

import java.io.IOException;
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

    private ImageExporter exporter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initCellSizeControl();
        initVarianceControl();
        initColorControl();

        exporter = new ImageExporter();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_export_to_image:
                exportViewToImage();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void exportViewToImage() {
        try {
            exporter.exportFromView(this, trianglifyView);
            Toast.makeText(this, "Image generated succesfully", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this, "EXPORTING FAILED", Toast.LENGTH_SHORT).show();
        }
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
