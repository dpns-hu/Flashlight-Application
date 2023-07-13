package com.example.willchangelater

import android.graphics.Camera
import android.hardware.camera2.CameraManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.willchangelater.databinding.ActivityMainBinding
lateinit var binding:ActivityMainBinding
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
     binding.button.setOnClickListener{
         if(binding.button.text.equals("Turn On")){
             binding.button.text = "Turn Off"
             binding.imageview.setImageResource(R.drawable.flashlight)
            changelightstate(true)

         }else{
             binding.button.text = "Turn On"
             binding.imageview.setImageResource(R.drawable.flashlisht_off)
             changelightstate(false)
         }
     }

    }

    private fun changelightstate(b: Boolean) {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            val cameramanager = getSystemService(CAMERA_SERVICE) as CameraManager
            var camId : String? = null
            camId = cameramanager.cameraIdList[0];
            cameramanager.setTorchMode(camId,b);
            if(b==true){
                Toast.makeText(this,"Torch turned on...",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"Torch turned off...",Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun onStart() {
        super.onStart()
        binding.button.setText("Turn On");
        binding.imageview.setImageResource(R.drawable.flashlisht_off)

    }
}