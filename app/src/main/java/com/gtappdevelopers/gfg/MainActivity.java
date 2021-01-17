package com.gtappdevelopers.gfg;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.mukesh.image_processing.ImageProcessor;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    //creating a bitmap for our original image and all image filters.
    Bitmap bitmap;
    //creating a variable for image view.
    ImageView oneIV, twoIV, threeIV, fourIV, fiveIV, sixIV, sevenIV, eightIV, nineIV, tenIV, originalIV;
    Bitmap oneBitMap, twoBitMap, threeBitmap, fourBitMap, fiveBitMap, sixBitMap, sevenBitMap, eightBitMap, nineBitMap, tenBitMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //creating a variable for our image processor.
        ImageProcessor processor = new ImageProcessor();
        //initializing bitmap with our image resource.
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image);
        //initializing image views for our filters and original image on which we will be applying our filters.
        oneIV = findViewById(R.id.idIVOne);
        twoIV = findViewById(R.id.idIVTwo);
        threeIV = findViewById(R.id.idIVThree);
        fourIV = findViewById(R.id.idIVFour);
        fiveIV = findViewById(R.id.idIVFive);
        sixIV = findViewById(R.id.idIVSix);
        sevenIV = findViewById(R.id.idIVSeven);
        eightIV = findViewById(R.id.idIVEight);
        nineIV = findViewById(R.id.idIVNine);
        tenIV = findViewById(R.id.idIVTen);
        originalIV = findViewById(R.id.idIVOriginalImage);

        //below line is use to add tint effect to our original image bitmap and storing that in one bitmap.
        oneBitMap = processor.tintImage(bitmap, 90);
        //after storing it to one bitmap we are setting it to imageview.
        oneIV.setImageBitmap(oneBitMap);
        //below line is use to apply gaussian blur effect to our original image bitmap.
        twoBitMap = processor.applyGaussianBlur(bitmap);
        twoIV.setImageBitmap(twoBitMap);
        //below line is use to add sepia toing effect to our original image bitmap.
        threeBitmap = processor.createSepiaToningEffect(bitmap, 1, 2, 1, 5);
        threeIV.setImageBitmap(threeBitmap);
        //below line is use to apply saturation filter to our original image bitmap.
        fourBitMap = processor.applySaturationFilter(bitmap, 3);
        fourIV.setImageBitmap(fourBitMap);
        //below line is use to apply snow effect to our original image bitmap.
        fiveBitMap = processor.applySnowEffect(bitmap);
        fiveIV.setImageBitmap(fiveBitMap);
        //below line is use to add gray scale to our image view.
        sixBitMap = processor.doGreyScale(bitmap);
        sixIV.setImageBitmap(sixBitMap);
        //below line is use to add engrave effect to our image view.
        sevenBitMap = processor.engrave(bitmap);
        sevenIV.setImageBitmap(sevenBitMap);
        //below line is use to create a contrast effect to our image view.
        eightBitMap = processor.createContrast(bitmap, 1.5);
        eightIV.setImageBitmap(eightBitMap);
        //below line is use to add shadow effect to our original bitmap.
        nineBitMap = processor.createShadow(bitmap);
        nineIV.setImageBitmap(nineBitMap);
        //below line is use to add flea effect to our image view.
        tenBitMap = processor.applyFleaEffect(bitmap);
        tenIV.setImageBitmap(tenBitMap);
        //below line is use to call on click listner for our all image filters.
        initializeOnCLickListerns();
    }

    private void initializeOnCLickListerns() {

        oneIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //on clicking on each filter we are setting that filter to our original image.
                originalIV.setImageBitmap(oneBitMap);
            }
        });


        twoIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                originalIV.setImageBitmap(twoBitMap);
            }
        });

        threeIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                originalIV.setImageBitmap(threeBitmap);
            }
        });

        fourIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                originalIV.setImageBitmap(fourBitMap);
            }
        });

        fiveIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                originalIV.setImageBitmap(fiveBitMap);
            }
        });

        sixIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                originalIV.setImageBitmap(sixBitMap);
            }
        });

        sevenIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                originalIV.setImageBitmap(sevenBitMap);
            }
        });

        eightIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                originalIV.setImageBitmap(eightBitMap);
            }
        });

        nineIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                originalIV.setImageBitmap(nineBitMap);
            }
        });

        tenIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                originalIV.setImageBitmap(tenBitMap);
            }
        });


    }
}