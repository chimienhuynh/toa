package com.bluesky.toa.activities;

import android.os.Bundle;

import com.bluesky.toa.R;
import com.github.barteksc.pdfviewer.PDFView;

import androidx.appcompat.app.AppCompatActivity;

public class ResourceMaintenanceGuideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guidelines);


        PDFView pdfView = (PDFView) findViewById(R.id.guidelinesView);
        pdfView.fromAsset("maintenanceguide.pdf").load();

    }
}
