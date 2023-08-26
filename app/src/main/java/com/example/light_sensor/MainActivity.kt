package com.example.light_sensor

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() ,SensorEventListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sensorManager=getSystemService(Context.SENSOR_SERVICE) as SensorManager
        if(sensorManager!=null)
        {
            val lightsensor=sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)
            if(lightsensor!=null)
            {
                sensorManager.registerListener(this,lightsensor,SensorManager.SENSOR_DELAY_NORMAL)
            }
            else
            {
                Toast.makeText(this,"lightsensor not acceble ",Toast.LENGTH_SHORT).show()
            }
        }
        elsef
        {
            Toast.makeText(this,"sensormanger not acceble ",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onSensorChanged(event: SensorEvent?) {
        //TODO("Not yet implemented")
        if(event?.sensor?.type==Sensor.TYPE_LIGHT)
        {
            val textview=findViewById<TextView>(R.id.textview)
            textview.text="val= ${event.values[0]}"
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        //TODO("Not yet implemented")
        if(sensor?.type==Sensor.TYPE_LIGHT)
        {
            when(accuracy)
            {
                SensorManager.SENSOR_STATUS_ACCURACY_HIGH->{

                }
                SensorManager.SENSOR_STATUS_ACCURACY_MEDIUM->{

                }
                SensorManager.SENSOR_STATUS_ACCURACY_LOW->{

                }
                else->{

                }
            }
        }
    }
}