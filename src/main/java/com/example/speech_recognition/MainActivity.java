package com.example.speech_recognition;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageButton imagestartButton;
    ImageButton imagestopButton;
    TextView    textView;
    TextView    textView1;
    TextView    textView2;
    TextView    textView3;

    SpeechRecognizer speechRecognizer;
//    AudioManager     audioManager;
//    AudioDeviceInfo  speakerDevice = null;


    @RequiresApi(api = Build.VERSION_CODES.S)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        imagestartButton = findViewById(R.id.btnStart);
        imagestopButton  = findViewById(R.id.btnStop);
        textView         = findViewById(R.id.textView);
        textView1        = findViewById(R.id.textView1);
        textView2        = findViewById(R.id.textView2);
        textView3        = findViewById(R.id.textView3);


//        audioManager = (AudioManager)getApplicationContext().getSystemService(AUDIO_SERVICE);
//        AudioManager audioManager = (AudioManager) getApplicationContext().getSystemService(AudioManager.class);
//        AudioManager audioManager = (AudioManager) getApplicationContext().getSystemService(AudioManager.class);
//        audioManager.setMode(AudioManager.MODE_IN_COMMUNICATION);
//
//        AudioDeviceInfo[] devices = audioManager.getDevices(AudioManager.GET_DEVICES_OUTPUTS);
////        List<AudioDeviceInfo> devices = audioManager.getAvailableCommunicationDevices();
//        for (AudioDeviceInfo device : devices) {
//            int devicetype = device.getType();
//            int speaker = AudioDeviceInfo.TYPE_BUILTIN_SPEAKER;
//            if (device.getType() == AudioDeviceInfo.TYPE_BUILTIN_SPEAKER) {
//                speakerDevice = device;
//                break;
//            }
//        }
//        if (speakerDevice != null){
//            audioManager.setSpeakerphoneOn(true);
//            textView3.setText("Speaker Status : on ");
//        }

        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
        final Intent speechRecognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);

//        audioManager.setCommunicationDevice(AudioDeviceInfo);
//        audioManager.setSpeakerphoneOn(true);

//        boolean speakerstatus = audioManager.isSpeakerphoneOn();
//        int mode = audioManager.getMode();
//        textView3.setText("Speaker Status : " + mode);

        imagestartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView1.setText("Start of Recording");
                speechRecognizer.startListening(speechRecognizerIntent);

            }
        });
        imagestopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView2.setText("STOP of Recording");
                speechRecognizer.stopListening();
            }
        });
        speechRecognizer.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle bundle) {

            }

            @Override
            public void onBeginningOfSpeech() {

            }

            @Override
            public void onRmsChanged(float v) {

            }

            @Override
            public void onBufferReceived(byte[] bytes) {

            }

            @Override
            public void onEndOfSpeech() {

            }

            @Override
            public void onError(int i) {

            }

            @Override
            public void onResults(Bundle bundle) {
                textView3.setText("Done - 000000");
                ArrayList<String> data = bundle.getStringArrayList(speechRecognizer.RESULTS_RECOGNITION);
                for (int i=0; i < 3; i++){
                    if (i==0) {
                        textView.setText(data.get(0));
                        }
                    else {
                        textView3.setText("Done");
                        }
                    }
            }

            @Override
            public void onPartialResults(Bundle bundle) {

            }

            @Override
            public void onEvent(int i, Bundle bundle) {

            }
        });
    }
}