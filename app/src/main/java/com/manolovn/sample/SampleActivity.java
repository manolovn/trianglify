package com.manolovn.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.manolovn.colorbrewer.ColorBrewer;
import com.manolovn.sample.color.BrewerColorGenerator;
import com.manolovn.sample.exporter.ImageExporter;
import com.manolovn.trianglify.TrianglifyView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SampleActivity extends AppCompatActivity {

    @Bind(R.id.trianglify)
    TrianglifyView trianglifyView;
    @Bind(R.id.cellSizeControl)
    SeekBar cellSizeControl;
    @Bind(R.id.varianceControl)
    SeekBar varianceControl;
    @Bind(R.id.colorControl)
    Spinner colorControl;
    @Bind(R.id.controlsContainer)
    ViewGroup controlsContainer;

    private ImageExporter exporter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initCellSizeControl();
        initVarianceControl();
        initColorControl();

        trianglifyView.setDrawingCacheEnabled(true);
        exporter = new ImageExporter();
    }

    @OnClick(R.id.saveToGalleryButton)
    void saveToGallery() {
        exportViewToImage();
    }

    @OnClick(R.id.toggleFullscreen)
    void toggleFullScreen() {
        if (controlsContainer.getVisibility() == View.GONE) {
            controlsContainer.setVisibility(View.VISIBLE);
        } else if (controlsContainer.getVisibility() == View.VISIBLE) {
            controlsContainer.setVisibility(View.GONE);
        }
    }

    private void exportViewToImage() {
        try {
            exporter.exportFromView(this, trianglifyView);
            Toast.makeText(this, R.string.image_generated_success, Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(this, R.string.image_generated_failed, Toast.LENGTH_SHORT).show();
        }
    }

    private void initCellSizeControl() {
        cellSizeControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                this.progress = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (progress > 0) {
                    trianglifyView.setDrawingCacheEnabled(false);
                    trianglifyView.getDrawable().setCellSize(progress * 10);
                    trianglifyView.setDrawingCacheEnabled(true);
                }
            }
        });
    }

    private void initVarianceControl() {
        varianceControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                this.progress = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                trianglifyView.setDrawingCacheEnabled(false);
                trianglifyView.getDrawable().setVariance(progress + 2);
                trianglifyView.setDrawingCacheEnabled(true);
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
                trianglifyView.setDrawingCacheEnabled(false);
                trianglifyView.getDrawable()
                        .setColorGenerator(new BrewerColorGenerator(colors[position]));
                trianglifyView.setDrawingCacheEnabled(true);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
