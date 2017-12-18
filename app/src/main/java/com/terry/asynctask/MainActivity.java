package com.terry.asynctask;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void go1 (View V){
        new JobTalk().execute();

    }
    public void go2(View V){
        new JobTalk2().execute(3);
    }
    public void go3(View V){
        new JobTalk3().execute(6);
    }
    class JobTalk extends AsyncTask<Void,Void,Void>{


        @Override
        protected Void doInBackground(Void... voids) {
            try{
                 Thread.sleep(5000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            TextView info = findViewById(R.id.info);
            info.setText("DONE");
        }
    }
    class JobTalk2 extends AsyncTask<Integer,Void,Void>{
        @Override
        protected Void doInBackground(Integer... integers) {
            try{
                Thread.sleep(integers[0]*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            TextView info2 = findViewById(R.id.info);
            info2.setText("Hello");
        }
    }

    class  JobTalk3 extends AsyncTask<Integer,Integer,Void>{

        @Override
        protected Void doInBackground(Integer... integers) {
            for(int i=integers[0];i>0;i++){
                publishProgress(i);
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return null;

        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            TextView info3 = findViewById(R.id.info);
            info3.setText("LOVE");
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            TextView info4 =  findViewById(R.id.info);
            info4.setText(String.valueOf(values[0]));
        }



    }
}

