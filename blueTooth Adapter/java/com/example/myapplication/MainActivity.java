package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ComponentActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import java.util.Set;

public class MainActivity extends AppCompatActivity {


    Switch _switch;
    BluetoothAdapter bluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bluetoothAdapter=BluetoothAdapter.getDefaultAdapter();
        _switch=findViewById(R.id.switch1);
        _switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.BLUETOOTH_ADMIN,Manifest.permission.BLUETOOTH_CONNECT,Manifest.permission.BLUETOOTH},101);
                if(ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.BLUETOOTH_ADMIN)==PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.BLUETOOTH_CONNECT)==PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(MainActivity.this,Manifest.permission.BLUETOOTH)==PackageManager.PERMISSION_GRANTED)
                {
                    if(b)
                    {
                        bluetoothAdapter.enable();
                        Toast.makeText(MainActivity.this, "BlueTooth On", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        bluetoothAdapter.disable();
                        Toast.makeText(MainActivity.this, "BlueTooth Off", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    public void get_paired_devices(View view)
    {
        ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.BLUETOOTH},101);
        String str="";
        Set<BluetoothDevice> lst= bluetoothAdapter.getBondedDevices();
        for(BluetoothDevice device:lst)
        {
            str+=device.getName()+"\n";
        }
        Toast.makeText(this, str, Toast.LENGTH_LONG).show();
    }
}